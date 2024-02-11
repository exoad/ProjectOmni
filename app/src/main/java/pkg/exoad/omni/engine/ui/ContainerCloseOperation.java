/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import javax.swing.WindowConstants;

/**
 *
 * @author Jack Meng (exoad)
 */
public enum ContainerCloseOperation
{
    KILL(WindowConstants.EXIT_ON_CLOSE), NOTHING(
            WindowConstants.DO_NOTHING_ON_CLOSE), DISPOSE(
            WindowConstants.DISPOSE_ON_CLOSE), HIDE(
            WindowConstants.HIDE_ON_CLOSE);
    final int op;

    private ContainerCloseOperation(int op)
    {
        this.op=op;
    }

    public int op()
    {
        return op;
    }
}
