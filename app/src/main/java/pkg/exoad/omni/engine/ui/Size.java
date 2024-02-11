/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import java.awt.Dimension;
import pkg.exoad.omni.engine.StrUtils;
import pkg.exoad.omni.engine.lang.ClassField;

/**
 *
 * @author Jack Meng (exoad)
 */
public class Size
        implements SwingOperable<Dimension>
{

    public static Size make(float width,float height)
    {
        return new Size(width,height);
    }

    public static Size make(Dimension dim)
    {
        return new Size(dim.width,dim.height);
    }
    private float width;
    private float height;

    private Size(float width,float height)
    {
        this.width=width;
        this.height=height;
    }

    public Size transform(double width,double height)
    {
        this.width-=width;
        this.height-=height;
        return this;
    }

    public float width()
    {
        return width;
    }

    public float height()
    {
        return height;
    }

    public int widthInt()
    {
        return (int)width();
    }

    public int heightInt()
    {
        return (int)height();
    }

    @Override
    public Dimension convert()
    {
        return new Dimension((int)width,(int)height);
    }

    @Override
    public String toString()
    {
        return StrUtils.objectToString(this.getClass(),ClassField.make("Width",
                width),ClassField.make("Height",height));
    }
}
