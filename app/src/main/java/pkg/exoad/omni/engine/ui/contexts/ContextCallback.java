/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui.contexts;

/**
 *
 * @author Jack Meng (exoad)
 */
@FunctionalInterface
public interface ContextCallback<A extends Context,B>
{

    void call(A context,B payload);
}
