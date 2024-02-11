/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.lang;

/**
 *
 * @author Jack Meng (exoad)
 */
public final class ClassField
{

    public static ClassField make(String name,Object value)
    {
        return new ClassField(name,value);
    }
    public final String name;
    public final Object value;

    private ClassField(String name,Object value)
    {
        this.name=name;
        this.value=value;
    }

    @Override
    public String toString()
    {
        // shld be the only hard coded bit of toString magic
        return "ClassField[Name="+name+",Value="+value.toString()+"]";
    }
}
