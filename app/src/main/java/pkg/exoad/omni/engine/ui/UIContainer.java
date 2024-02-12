/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import java.awt.Dimension;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author Jack Meng (exoad)
 */
public class UIContainer
        implements Runnable
{    
    public static UIContainer make()
    {
        return new UIContainer();
    }
    private final JFrame internal;

    private UIContainer()
    {
        internal=new JFrame();
    }

    public UIContainer withTitle(String title)
    {
        internal.setTitle(title);
        return this;
    }

    public UIContainer withWindowEventListener(SwingOperable<WindowListener> e)
    {
        internal.addWindowListener(e.convert());
        return this;
    }

    public UIContainer withCloseOperation(ContainerCloseOperation op)
    {
        internal.setDefaultCloseOperation(op.op());
        return this;
    }

    public UIContainer withSize(SwingOperable<Dimension> size)
    {
        internal.setSize(size.convert());
        internal.setPreferredSize(size.convert());
        return this;
    }

    public UIContainer withPinned(boolean v)
    {
        internal.setAlwaysOnTop(v);
        return this;
    }

    public UIContainer withMinSize(SwingOperable<Dimension> size)
    {
        internal.setMinimumSize(size.convert());
        return this;
    }

    public UIContainer withMaxSize(SwingOperable<Dimension> size)
    {
        internal.setMaximumSize(size.convert());
        return this;
    }

    public UIContainer withRootDelegate(UIRootComponent<?> delegate)
    {
        internal.setContentPane(delegate.exposeInternal());
        return this;
    }

    @Override
    public void run()
    {
        internal.pack();
        internal.setLocationRelativeTo(null);
        internal.setVisible(true);
        internal.setAlwaysOnTop(true);
        internal.setAlwaysOnTop(false);
    }
}
