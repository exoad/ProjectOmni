/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui.exceptions;

/**
 *
 * @author Jack Meng (exoad)
 */
public class InvalidLayoutException
        extends RuntimeException
{

    private static final long serialVersionUID=3297493857347L;

    public InvalidLayoutException(String message)
    {
        super(message);
    }
}
