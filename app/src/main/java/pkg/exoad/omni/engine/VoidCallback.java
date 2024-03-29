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
@FunctionalInterface
public interface VoidCallback<A>
{
    void call(A res);
}
