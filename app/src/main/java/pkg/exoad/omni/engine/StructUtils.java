/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jack Meng (exoad)
 */
public final class StructUtils
{

    public static <A,B> Pair<A,B> pair(A first,B second)
    {
        return new Pair<>(first,second);
    }

    public static <A> ArrayList<A> listOf(A[] e)
    {
        ArrayList<A> r=new ArrayList<>(e.length);
        Collections.addAll(r,e);
        return r;
    }

    @SuppressWarnings("unchecked")
    public static <A,B> Map<A,B> mapOf(Object[]... objects)
    {
        HashMap<A,B> r=new HashMap<>();
        for(Object[] t:objects)
            r.put((A)t[0],(B)t[1]);
        return r;
    }

    public static <A,B> Map<A,B> mapOf(List<Pair<A,B>> objects)
    {
        HashMap<A,B> r=new HashMap<>();
        for(Pair<A,B> v:objects)
            r.put(v.first,v.second);
        return r;
    }

    private StructUtils()
    {
    }
}
