/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import pkg.exoad.omni.engine.VoidCallback;

/**
 *
 * @author Jack Meng (exoad)
 */
public class WindowEventListener
        implements SwingOperable<WindowListener>
{

    public static WindowEventListener make()
    {
        return new WindowEventListener();
    }
    private VoidCallback<WindowEvent> onOpened;
    private VoidCallback<WindowEvent> onClosing;
    private VoidCallback<WindowEvent> onClosed;
    private VoidCallback<WindowEvent> onIconified;
    private VoidCallback<WindowEvent> onDeiconified;
    private VoidCallback<WindowEvent> onActivated;
    private VoidCallback<WindowEvent> onDeactivated;
    static final VoidCallback<WindowEvent> EMPTY=(res)
            ->{
    };

    private WindowEventListener()
    {
        onOpened=EMPTY;
        onClosing=EMPTY;
        onClosed=EMPTY;
        onIconified=EMPTY;
        onDeiconified=EMPTY;
        onActivated=EMPTY;
        onDeactivated=EMPTY;
    }

    public WindowEventListener onOpened(VoidCallback<WindowEvent> ev)
    {
        this.onOpened=ev;
        return this;
    }

    public WindowEventListener onClosing(VoidCallback<WindowEvent> ev)
    {
        this.onClosing=ev;
        return this;
    }

    public WindowEventListener onClosed(VoidCallback<WindowEvent> ev)
    {
        this.onClosed=ev;
        return this;
    }

    public WindowEventListener onIconified(VoidCallback<WindowEvent> ev)
    {
        this.onIconified=ev;
        return this;
    }

    public WindowEventListener onDeiconified(VoidCallback<WindowEvent> ev)
    {
        this.onDeiconified=ev;
        return this;
    }

    public WindowEventListener onActivated(VoidCallback<WindowEvent> ev)
    {
        this.onActivated=ev;
        return this;
    }

    public WindowEventListener onDeactivated(VoidCallback<WindowEvent> ev)
    {
        this.onDeactivated=ev;
        return this;
    }

    @Override
    public WindowListener convert()
    {
        return new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {
                if(onOpened!=null)
                    onOpened.call(e);
            }

            @Override
            public void windowClosing(WindowEvent e)
            {
                if(onClosing!=null)
                    onClosing.call(e);
            }

            @Override
            public void windowClosed(WindowEvent e)
            {
                if(onClosed!=null)
                    onClosed.call(e);
            }

            @Override
            public void windowIconified(WindowEvent e)
            {
                if(onIconified!=null)
                    onIconified.call(e);
            }

            @Override
            public void windowDeiconified(WindowEvent e)
            {
                if(onDeiconified!=null)
                    onDeiconified.call(e);
            }

            @Override
            public void windowActivated(WindowEvent e)
            {
                if(onActivated!=null)
                    onActivated.call(e);
            }

            @Override
            public void windowDeactivated(WindowEvent e)
            {
                if(onDeactivated!=null)
                    onDeactivated.call(e);
            }
        };
    }
}
