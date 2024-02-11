/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.geom;

/**
 *
 * @author Jack Meng (exoad)
 */
public final class Pt
        implements GeomBase<Pt>
{

    private float x;
    private float y;

    private Pt(float x,float y)
    {
        this.x=x;
        this.y=y;
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
