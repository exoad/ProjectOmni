/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Jack Meng (exoad)
 */
public final class OmniEngine
{

    public static Logger LOG;

    private OmniEngine()
    {
    }

    public static void initializeLogging()
    {
        if(LOG==null)
            LOG=Logger.getLogger(OmniEngine.class.getCanonicalName());
        LOG.info("Initialized the logger for the OMNI_ENGINE");
    }

    public static void initializeUI()
    {
        try
        {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        }catch(UnsupportedLookAndFeelException ex)
        {
            LOG.log(Level.SEVERE,null,ex);
        }
    }
}
