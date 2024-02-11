/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine;

/**
 *
 * @author Jack Meng (exoad)
 */
public final class NumUtils
{

    public static float clampFloat(float value,float min,float max)
    {
        return value<min?min:value>max?max:value;
    }

    private NumUtils()
    {
    }
}
