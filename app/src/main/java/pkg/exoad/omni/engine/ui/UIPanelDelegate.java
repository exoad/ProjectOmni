/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.text.MessageFormat;
import java.util.logging.Level;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import pkg.exoad.omni.engine.OmniEngine;
import pkg.exoad.omni.engine.ui.contexts.ContextCallback;
import pkg.exoad.omni.engine.ui.contexts.DelegateContext;
import pkg.exoad.omni.engine.ui.exceptions.InvalidLayoutException;

/**
 *
 * @author Jack Meng (exoad)
 */
public class UIPanelDelegate
        extends UIDelegate<JPanel>
{

    public static UIPanelDelegate make(String id)
    {
        return new UIPanelDelegate(id);
    }
    private ContextCallback<DelegateContext<JPanel>,Painter> earlyPainter;
    private ContextCallback<DelegateContext<JPanel>,Painter> latePainter;

    private UIPanelDelegate(String id)
    {
        super(id);
        rootElement=new JPanel()
        {
            @Override
            public void paintComponent(Graphics g)
            {
                if(earlyPainter!=null)
                    earlyPainter.
                            call(DelegateContext.make(UIPanelDelegate.this), // lowkey, most unintuitive part of java is this ref to outer class
                                    new Painter(
                                            (Graphics2D)g));
                super.paintComponent(g);
                if(latePainter!=null)
                    latePainter.call(DelegateContext.make(UIPanelDelegate.this),
                            new Painter(
                                    (Graphics2D)g));
            }
        };
    }

    public UIPanelDelegate withEarlyPainter(
            ContextCallback<DelegateContext<JPanel>,Painter> cb)
    {
        LOG(Level.INFO,
                MessageFormat.format(
                        "applied EarlyPainter#{0}",cb.hashCode()
                ));
        earlyPainter=cb;
        return this;
    }

    public UIPanelDelegate withLatePainter(
            ContextCallback<DelegateContext<JPanel>,Painter> cb)
    {
        LOG(Level.INFO,
                MessageFormat.format(
                        "applied LatePainter#{0}",cb.hashCode()
                ));
        latePainter=cb;
        return this;
    }

    public UIPanelDelegate withPainter(
            ContextCallback<DelegateContext<JPanel>,Painter> cb)
    {
        return withLatePainter(cb);
    }

    public UIPanelDelegate withBorderLayout(int vgap,int hgap)
    {
        LOG(Level.INFO,
                MessageFormat.format(
                        "set LAYOUT to BorderLayout[VGap={0},HGap={1}]",vgap,
                        hgap
                ));
        rootElement.setLayout(new BorderLayout(vgap,hgap));
        return this;
    }

    public UIPanelDelegate withBorderLayout()
    {
        return withBorderLayout(0,0);
    }

    public UIPanelDelegate withBorderDelegate(
            UIDelegate<? extends JComponent> e,BorderAlignment alignment)
    {
        OmniEngine.panicOn(!(rootElement.getLayout() instanceof BorderLayout),
                "The panel's 'rootElement' is not using a BorderLayout!",
                new InvalidLayoutException("LayoutManager="+rootElement.
                        getLayout().
                        getClass().
                        getCanonicalName()+" but expected "+BorderLayout.class.
                                getCanonicalName()));
        return withDelegate(e,alignment.axis());
    }

    public UIPanelDelegate withBoxLayout(Axis axis)
    {
        LOG(Level.INFO,MessageFormat.format("set LAYOUT to BoxLayout[Axis={0}]",
                axis.name()));
        rootElement.setLayout(new BoxLayout(this.exposeInternal(),
                axis==Axis.X?BoxLayout.X_AXIS:BoxLayout.Y_AXIS));
        return this;
    }

    public UIPanelDelegate withGridLayout(int rows,int columns)
    {
        // these conditions are probably already prechecked by GridLayout itself
        assert rows>=0;
        assert columns>=0;
        LOG(Level.INFO,MessageFormat.format(
                "set LAYOUT to GridLayout[Rows={0},Columns{1}]",rows,columns));
        rootElement.setLayout(new GridLayout(rows,columns));
        return this;
    }

    public UIPanelDelegate withDelegate(UIDelegate<? extends JComponent> e)
    {
        LOG(Level.INFO,MessageFormat.format(
                "add Delegate[Id={0},CanonicalType={1}]",e.id(),e.rootElement.
                getClass().
                getCanonicalName()));
        rootElement.add(e.exposeInternal());
        return this;
    }

    public UIPanelDelegate withDelegate(UIDelegate<? extends JComponent> e,
            Object constraints)
    {
        LOG(Level.INFO,MessageFormat.format(
                "add ConstrainedDelegate[Id={0},CanonicalType={1},Constraints={2}]",
                e.id(),e.rootElement.
                getClass().
                getCanonicalName(),constraints.toString()));
        rootElement.add(e.exposeInternal(),constraints);
        return this;
    }
}
