/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import javax.swing.JComponent;
/**
 *
 * @author Jack Meng (exoad)
 * @param <T> UI Component in Question
 */
public interface UIRootComponent<T extends JComponent>
{
    public T exposeInternal();
    
    default void refresh()
    {
        exposeInternal().repaint();
    }
    
    public default void hardRefresh()
    {
        exposeInternal().revalidate();
    }
}
