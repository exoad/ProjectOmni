/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Objects;
import java.util.logging.Level;
import pkg.exoad.omni.engine.OmniEngine;
import pkg.exoad.omni.engine.SharedConstants;
import pkg.exoad.omni.engine.geom.Rect;

/**
 *
 * @author Jack Meng (exoad)
 */
public class Painter
        implements SwingOperable<Graphics2D>
{

    private final Graphics2D g2;

    public Painter(Graphics2D g2)
    {
        this.g2=g2;
    }

    public void init(GraphicsAttributes... attributes)
    {
        Objects.requireNonNull(g2);
        for(GraphicsAttributes e:attributes)
            g2.setRenderingHint(e.key(),e.ref());
    }

    public void fillRect(Rect rect)
    {
        if(SharedConstants.USE_DIAGNOSTICS)
            OmniEngine.LOG.log(Level.INFO,"Painter#{0} draw {1}",new Object[]
            {
                this.hashCode(),rect.toString()
            });
        g2.fillRect(rect.start.x(),rect.start.y(),(int)rect.width(),(int)rect.
                height());
    }

    public void color(SwingOperable<Color> color)
    {
        if(SharedConstants.USE_DIAGNOSTICS)
            OmniEngine.LOG.log(Level.INFO,"Painter#{0} color {1}",new Object[]
            {
                this.hashCode(),color.toString()
            });
        g2.setColor(color.convert());
    }

    public void dispose()
    {
        g2.dispose();
    }

    @Override
    public Graphics2D convert()
    {
        return g2;
    }
}
