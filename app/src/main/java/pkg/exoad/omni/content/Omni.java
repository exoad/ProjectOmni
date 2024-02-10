/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can
 * found in the LICENSE file.
 */
package pkg.exoad.omni.content;
import java.util.logging.Logger;

/**
 *
 * @author Jack Meng (exoad)
 */
public final class Omni
{

    public static Logger LOG;

    public static void initializeLogger()
    {
        if(LOG==null)
            LOG=Logger.getLogger("OMNI  "); // this is just for padding purposes to look neat in the logging in similarity with the "ENGINE"
        LOG.info("Intialized the OMNI_CONTENT logger.");
    }

    private Omni()
    {
    }
}
