/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;

/**
 *
 * @author Jack Meng (exoad)
 */
public interface SwingOperable<T>
{

    /**
     * A binding method that assures the programmer, whatever is returned here
     * is allowed and anticipated by the receiver.
     *
     * @return The converted element
     */
    public T convert();
}
