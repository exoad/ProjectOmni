/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import javax.swing.JComponent;
import pkg.exoad.omni.engine.SupplierCallback;

/**
 *
 * @author Jack Meng (exoad)
 */
public class UIComposedDelegate<T extends JComponent>
        extends UIDelegate<T>
{

    public static <B extends JComponent> UIComposedDelegate<B> make(String id,
            SupplierCallback<? extends UIRootComponent<B>> e)
    {
        return new UIComposedDelegate<>(id,e);
    }
    private final SupplierCallback<? extends UIRootComponent<T>> builder;

    private UIComposedDelegate(String id,
            SupplierCallback<? extends UIRootComponent<T>> builder)
    {
        super(id);
        this.builder=builder;
    }

    @Override
    public T exposeInternal()
    {
        return builder.call().
                exposeInternal();
    }
}
