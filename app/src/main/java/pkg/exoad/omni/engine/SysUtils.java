/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine;
import java.util.logging.Level;

/**
 *
 * @author Jack Meng (exoad)
 */
public final class SysUtils
{

    public static void callGc()
    {
        Runtime.getRuntime().
                gc();
    }

    public static float freeMemInMB()
    {
        return Runtime.getRuntime().
                freeMemory()/1024F/1024F;
    }

    public static float maxMemInMB()
    {
        return Runtime.getRuntime().
                maxMemory()/1024F/1024F;
    }

    public static float totalMemInMB()
    {
        return Runtime.getRuntime().
                totalMemory()/1024F/1024F;
    }

    public static float usedMemInMB()
    {
        return totalMemInMB()-freeMemInMB();
    }

    public static void shutdownHook(Runnable r)
    {
        OmniEngine.LOG.
                log(Level.INFO,"Emplaced a new ShutdownHook Runnable#{0}",r.
                        hashCode());
        Runtime.getRuntime().
                addShutdownHook(new Thread(r));
    }

    private SysUtils()
    {
    }
}
