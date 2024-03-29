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
public class Rect
        implements GeomBase<Rect>
{
    
    public static Rect make(Pt start,Pt end)
    {
        return new Rect(start,end);
    }
    public final Pt start;
    public final Pt end;
    
    private Rect(Pt start,Pt end)
    {
        this.start=start;
        this.end=end;
    }
    
    public float width()
    {
        return end.x-start.x;
    }
    
    public float height()
    {
        return end.y-start.y;
    }
    
    @Override
    public String toString()
    {
        return StrUtils.objectToString(this.getClass(),ClassField.make("Start",
                start.toString()),ClassField.make("End",end.toString()));
    }
    
    @Override
    public float distanceTo(Rect other)
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
