/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui.contexts;
import java.util.UUID;

/**
 *
 * @author Jack Meng (exoad)
 */
public class NavigatorContext
{

    public static NavigatorContext make(String id)
    {
        return new NavigatorContext(id);
    }
    private String id;
    private long hashUUID;

    private NavigatorContext(String id)
    {
        this.id=id;
        this.hashUUID=UUID.fromString(id).
                getMostSignificantBits();
    }

    public String rawID()
    {
        return id;
    }

    public long hash()
    {
        return hashUUID;
    }

    public String id()
    {
        return rawID()+hash();
    }
}
