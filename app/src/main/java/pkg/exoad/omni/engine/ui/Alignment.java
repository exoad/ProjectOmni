/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import java.awt.Component;

/**
 *
 * @author Jack Meng (exoad)
 */
public enum Alignment
{
    TOP(Component.TOP_ALIGNMENT), CENTER(Component.CENTER_ALIGNMENT), RIGHT(
            Component.RIGHT_ALIGNMENT), LEFT(Component.LEFT_ALIGNMENT);
    final float axis;

    Alignment(float x)
    {
        this.axis=x;
    }

    public float axis()
    {
        return axis;
    }
}
