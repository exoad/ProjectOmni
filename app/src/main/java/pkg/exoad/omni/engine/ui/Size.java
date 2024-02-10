/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import java.awt.Dimension;

/**
 *
 * @author Jack Meng (exoad)
 */
public class Size
        implements SwingOperable<Dimension>
{

    public static Size make(double width,double height)
    {
        return new Size(width,height);
    }
    private double width;
    private double height;

    private Size(double width,double height)
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

    public double width()
    {
        return width;
    }

    public double height()
    {
        return height;
    }

    public int widthInt()
    {
        return (int)width();
    }

    public int widthHeight()
    {
        return (int)height();
    }

    @Override
    public Dimension convert()
    {
        return new Dimension((int)width,(int)height);
    }
}
