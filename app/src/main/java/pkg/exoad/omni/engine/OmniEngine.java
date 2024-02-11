/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.Timer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import pkg.exoad.omni.engine.ui.UIContainer;

/**
 *
 * @author Jack Meng (exoad)
 */
public final class OmniEngine
{

    public static Logger LOG;
    private static Timer PERIODIC_THREAD_POOL;

    public static Timer periodicThreadPool()
    {
        return PERIODIC_THREAD_POOL;
    }

    private OmniEngine()
    {
    }

    
    
    public static synchronized Future<Void> launchWindow(UIContainer container)
    {
        LOG.log(Level.INFO,"Launching a window UICONTAINER#{0}",container.
                hashCode());
        return CompletableFuture.runAsync(()->SwingUtilities.invokeLater(
                container));
    }

    public static void initializeBase()
    {
        if(LOG==null)
            LOG=Logger.getLogger("ENGINE");
        LOG.info("Initialized the logger for the OMNI_ENGINE");
        if(PERIODIC_THREAD_POOL==null)
            PERIODIC_THREAD_POOL=new Timer(
                    "pkg.exoad#Project_Omnipotent#PERIODIC_THREAD_POOL");
        LOG.info("Initialized the PERIODIC_THREAD_POOL");
    }

    public static void initializeUI()
    {
        try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
        }catch(UnsupportedLookAndFeelException ex){
            LOG.log(Level.SEVERE,null,ex);
        }
    }
}
