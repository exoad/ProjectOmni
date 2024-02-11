/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import pkg.exoad.omni.engine.VoidCallback;

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
    private VoidCallback<Painter> earlyPainter;
    private VoidCallback<Painter> latePainter;

    private UIPanelDelegate(String id)
    {
        super(id);
        rootElement=new JPanel()
        {
            @Override
            public void paintComponent(Graphics g)
            {
                if(earlyPainter!=null)
                    earlyPainter.call(new Painter((Graphics2D)g));
                super.paintComponent(g);
                if(latePainter!=null)
                    latePainter.call(new Painter((Graphics2D)g));
            }
        };
    }

    public UIPanelDelegate withEarlyPainter(VoidCallback<Painter> cb)
    {
        earlyPainter=cb;
        return this;
    }

    public UIPanelDelegate withLatePainter(VoidCallback<Painter> cb)
    {
        latePainter=cb;
        return this;
    }

    public UIPanelDelegate withPainter(VoidCallback<Graphics2D> cb)
    {
        return withLatePainter(cb);
    }

    public UIPanelDelegate withBoxLayout(Axis axis)
    {
        rootElement.setLayout(new BoxLayout(this.exposeInternal(),
                                            axis==Axis.X?BoxLayout.X_AXIS:BoxLayout.Y_AXIS));
        return this;
    }

    public UIPanelDelegate withGridLayout(int rows,int columns)
    {
        // these conditions are probably already prechecked by GridLayout itself
        assert rows>=0;
        assert columns>=0;
        rootElement.setLayout(new GridLayout(rows,columns));
        return this;
    }

    public UIPanelDelegate withDelegate(UIRootComponent<? extends JComponent> e)
    {
        rootElement.add(e.exposeInternal());
        return this;
    }

    public UIPanelDelegate withDelegate(UIRootComponent<? extends JComponent> e,
            Object constraints)
    {
        rootElement.add(e.exposeInternal(),constraints);
        return this;
    }
}
