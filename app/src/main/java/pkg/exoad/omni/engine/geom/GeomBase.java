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
public interface GeomBase<T extends GeomBase<T>>
{

    float distanceTo(T other);

    float translate(Offset delta);

    float scale(Offset delta);

    float rotate(float theta,Offset center);

    float shear(Offset multiplier);
}
