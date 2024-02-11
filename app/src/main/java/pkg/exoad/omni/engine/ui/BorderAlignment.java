/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import java.awt.BorderLayout;

/**
 *
 * @author Jack Meng (exoad)
 */
public enum BorderAlignment
{
    CENTER(BorderLayout.CENTER),
    TOP(BorderLayout.NORTH),
    LEFT(BorderLayout.WEST),
    RIGHT(BorderLayout.EAST),
    BOTTOM(BorderLayout.SOUTH);
    final String axis;

    BorderAlignment(String axis)
    {
        this.axis=axis;
    }

    public String axis()
    {
        return axis;
    }
}
