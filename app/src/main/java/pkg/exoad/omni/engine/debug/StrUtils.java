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
public final class StrUtils
{

    /**
     * For use with Object#toString()
     *
     * @param name    The class to mention from
     * @param objects The parameters important to the message
     *
     * @return The produced toString message
     */
    public static String objectToString(Class<?> name,
            ClassField... fields)
    {
        StringBuilder sb=new StringBuilder();
        sb.append(name.getSimpleName()).
                append("[");
        int i=0;
        for(ClassField entry:fields)
        {
            sb.append(entry.name).
                    append("=").
                    append(entry.value.
                            toString());
            if(i!=fields.length-1)
                sb.append(",");
            i++;
        }
        return sb.append("]").
                toString();
    }

    private StrUtils()
    {
    }
}
