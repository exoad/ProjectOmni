/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine;
import pkg.exoad.omni.engine.lang.ClassField;

/**
 *
 * @author Jack Meng (exoad)
 */
public class Pair<A,B>
{
    
    public A first;
    public B second;
    
    public Pair(A first,B second)
    {
        this.first=first;
        this.second=second;
    }
    
    @Override
    public String toString()
    {
        return StrUtils.objectToString(this.getClass(),ClassField.make("First",
                first),ClassField.make("Second",second));
    }
}
