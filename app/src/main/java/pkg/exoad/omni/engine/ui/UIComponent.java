/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import javax.swing.JComponent;
import pkg.exoad.omni.engine.ui.contexts.NavigatorContext;

/**
 *
 * @author Jack Meng (exoad)
 */
public class UIComponent<T extends JComponent>
{

    protected final NavigatorContext navigator;
    protected final T rootElement;

    public UIComponent(String id,T rootElement)
    {
        assert id!=null&&rootElement!=null;
        this.navigator=NavigatorContext.make(id);
        this.rootElement=rootElement;
    }

    public T rootElement()
    {
        return rootElement;
    }

    public NavigatorContext navigatorContext()
    {
        return navigator;
    }
}
