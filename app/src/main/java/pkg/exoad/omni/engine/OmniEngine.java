/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine;
import com.formdev.flatlaf.intellijthemes.FlatSpacegrayIJTheme;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import pkg.exoad.omni.engine.env.PlatformUtils;
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

    public static <A extends RuntimeException> void panicOn(boolean condition,
            String message,A cause)
    { // very naive
        if(condition)
        {
            LOG.log(Level.SEVERE,message,cause);
            if(cause!=null)
                throw cause;
            System.exit(1);
        }
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
        LOG.log(Level.INFO,"My Environment: {0}",PlatformUtils.export());
        if(PlatformUtils.isArchSupported()&&PlatformUtils.isPlatformSupported())
        {
            LOG.info("OK. Platform & Architecture are supported.");
            if(PERIODIC_THREAD_POOL==null)
                PERIODIC_THREAD_POOL=new Timer(
                        "pkg.exoad#Project_Omnipotent#PERIODIC_THREAD_POOL");
            LOG.info("Initialized the PERIODIC_THREAD_POOL");
            Runtime.getRuntime().
                    addShutdownHook(new Thread(()->LOG.info(
                    "Going down for shutdown...Bye")));
        }else
        {
            LOG.log(Level.SEVERE,
                    "Your platform and/or architecture is not supported...Stopping...",
                    new UnsupportedOperationException());
            System.exit(1);
        }
    }

    public static void initializeUI()
    {
        try
        {
            UIManager.setLookAndFeel(new FlatSpacegrayIJTheme());
        }catch(UnsupportedLookAndFeelException ex)
        {
            LOG.log(Level.SEVERE,null,ex);
        }
        Toolkit.getDefaultToolkit().
                setDynamicLayout(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        JFrame.setDefaultLookAndFeelDecorated(true);
        if(PlatformUtils.isMacos())
            System.setProperty("apple.awt.application.appearance","system");
    }
}
