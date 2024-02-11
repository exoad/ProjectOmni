/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Jack Meng (exoad)
 */
public class UIRowDelegate
        extends UIDelegate<JPanel>
{

    public static UIRowDelegate make(String id)
    {
        return new UIRowDelegate(id);
    }

    private UIRowDelegate(String id)
    {
        super(id);
        rootElement.setLayout(new BoxLayout(rootElement,BoxLayout.X_AXIS));
    }

    public UIRowDelegate withDelegate(UIRootComponent<? extends JComponent> e)
    {
        rootElement.add(e.exposeInternal());
        return this;
    }

    public UIRowDelegate withDelegates(UIRootComponent<? extends JComponent>[] e)
    {
        for(UIRootComponent<? extends JComponent> r:e)
            rootElement.add(r.exposeInternal());
        return this;
    }
}
