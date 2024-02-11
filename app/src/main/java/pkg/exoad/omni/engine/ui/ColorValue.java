/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import java.awt.Color;
import pkg.exoad.omni.engine.NumUtils;

/**
 *
 * @author Jack Meng (exoad)
 */
public class ColorValue
        implements SwingOperable<Color>
{

    public static ColorValue make(int r,int g,int b,int a)
    {
        return make(r/255F,g/255F,b/255F,a/255F);
    }

    public static ColorValue make(int r,int g,int b)
    {
        return make(r/255F,g/255F,b/255F,1F);
    }

    public static ColorValue make(int r,int g)
    {
        return make(r/255F,g/255F,1F);
    }

    public static ColorValue make(int r)
    {
        return make(r/255F,1F);
    }

    public static ColorValue make(float r,float g,float b,float a)
    {
        return new ColorValue(r,g,b,a);
    }

    public static ColorValue make(float r,float g,float b)
    {
        return make(r,g,b,1F);
    }

    public static ColorValue make(float r,float g)
    {
        return make(r,g,1F);
    }

    public static ColorValue make(float r)
    {
        return make(r,1F);
    }

    public static ColorValue make(String hex)
    {
        // #123456 & #123456789
        return hex.length()==7?make(Integer.parseInt(hex.substring(1,3))/255F,
                                    Integer.parseInt(
                                            hex.substring(3,5))/255F,Integer.
                                    parseInt(hex.substring(5,7),16)):make(
               Integer.parseInt(hex.substring(1,3))/255F,Integer.parseInt(
               hex.substring(3,5))/255F,Integer.
               parseInt(hex.substring(5,7),16),Integer.
               parseInt(hex.substring(7,9),16));
    }
    private float r;
    private float g;
    private float b;
    private float a;

    private ColorValue(float r,float g,float b,float a)
    {
        this.r=r;
        this.g=g;
        this.b=b;
        this.a=a;
    }

    public ColorValue add(float v)
    {
        return addRed(v).
                addGreen(v).
                addBlue(v).
                addAlpha(v);
    }

    public ColorValue addRed(float r)
    {
        this.r=NumUtils.clampFloat(this.r+r,0F,1F);
        return this;
    }

    public ColorValue addGreen(float g)
    {
        this.g=NumUtils.clampFloat(this.g+g,0F,1F);
        return this;
    }

    public ColorValue addBlue(float b)
    {
        this.b=NumUtils.clampFloat(this.b+b,0F,1F);
        return this;
    }

    public ColorValue addAlpha(float a)
    {
        this.a=NumUtils.clampFloat(this.a+a,0F,1F);
        return this;
    }

    @Override
    public String toString()
    {
        return "ColorValue[Red="+r+",Green="+g+",Blue="+b+",Alpha="+a+"]";
    }

    @Override
    public Color convert()
    {
        return new Color(r,g,b,a);
    }
}
