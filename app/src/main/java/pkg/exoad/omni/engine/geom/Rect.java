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
public record Rect(Pt start,Pt end)
        implements GeomBase<Rect>
        {
    
    public float width()
    {
        return end.x()-start.x();
    }
    
    public float height()
    {
        return end.y()-start.y();
    }
    
    @Override
    public float distanceTo(Rect other)
    {
        
    }
}
