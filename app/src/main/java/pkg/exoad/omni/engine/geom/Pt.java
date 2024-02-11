/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.geom;
import pkg.exoad.omni.engine.StrUtils;
import pkg.exoad.omni.engine.lang.ClassField;

/**
 *
 * @author Jack Meng (exoad)
 */
public final class Pt
        implements GeomBase<Pt>
{

    public static final Pt ZERO_ZERO=Pt.make(0,0);

    public static Pt make(float x,float y)
    {
        return new Pt(x,y);
    }

    public static Pt make(int x,int y)
    {
        return new Pt(x,y);
    }
    public float x;
    public float y;

    private Pt(float x,float y)
    {
        this.x=x;
        this.y=y;
    }

    public int x()
    {
        return (int)x;
    }

    public int y()
    {
        return (int)y;
    }

    @Override
    public String toString()
    {
        return StrUtils.objectToString(this.getClass(),ClassField.make("X",x),
                ClassField.make("Y",y));
    }

    @Override
    public float distanceTo(Pt other)
    {
        return (float)Math.sqrt(
                ((other.x-x)*(other.x-x))+((other.y-other.y)*(other.y-y)));
    }

    @Override
    public float translate(Offset delta)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float scale(Offset delta)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float rotate(float theta,Offset center)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float shear(Offset multiplier)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
