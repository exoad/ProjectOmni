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
public final class StructUtils
{

    public <A,B> Pair<A,B> pair(A first,B second)
    {
        return new Pair<>(first,second);
    }

    private StructUtils()
    {
    }
}
