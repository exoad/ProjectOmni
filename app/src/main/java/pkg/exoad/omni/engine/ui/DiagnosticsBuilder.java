/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import java.util.logging.Level;
import pkg.exoad.omni.engine.OmniEngine;

/**
 *
 * @author Jack Meng (exoad)
 */
public final class DiagnosticsBuilder
{

    public static WindowEventListener windowEventListener()
    {
        return WindowEventListener.make().
                onActivated(ev->OmniEngine.LOG.log(Level.INFO,
                                                   "Window_OnActivate->{0}",ev.
                                                           toString())).
                onClosed(ev->OmniEngine.LOG.log(Level.INFO,
                                                "Window_OnClose->{0}",ev.
                                                        toString())).
                onClosing(ev->OmniEngine.LOG.log(Level.INFO,
                                                 "Window_OnClosing->{0}",ev.
                                                         toString())).
                onDeactivated(ev->OmniEngine.LOG.log(Level.INFO,
                                                     "Window_OnDeactivated->{0}",
                                                     ev.
                                                             toString())).
                onIconified(ev->OmniEngine.LOG.log(Level.INFO,
                                                   "Window_OnIconified->{0}",ev.
                                                           toString())).
                onDeiconified(ev->OmniEngine.LOG.log(Level.INFO,
                                                     "Window_OnDeiconified->{0}",
                                                     ev.
                                                             toString())).
                onOpened(ev->OmniEngine.LOG.log(Level.INFO,
                                                "Window_OnOpened->{0}",ev.
                                                        toString()));
    }

    private DiagnosticsBuilder()
    {
    }
}
