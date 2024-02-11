/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui.contexts;
import javax.swing.JComponent;
import pkg.exoad.omni.engine.ui.Size;
import pkg.exoad.omni.engine.ui.UIDelegate;

/**
 *
 * @author Jack Meng (exoad)
 */
public final class DelegateContext<T extends JComponent>
        implements Context
{

    public static <A extends JComponent> DelegateContext<A> make(UIDelegate<A> e)
    {
        return new DelegateContext<>(e);
    }
    public final String id;
    public final Size size;
    public final Size prefSize;

    private DelegateContext(UIDelegate<T> e)
    {
        this.id=e.id();
        this.size=Size.make(e.exposeInternal().
                getSize());
        this.prefSize=Size.make(e.exposeInternal().
                getPreferredSize());
    }
}
