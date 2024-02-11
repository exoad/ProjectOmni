package pkg.exoad.omni;
import java.util.logging.Level;
import pkg.exoad.omni.content.Omni;
import pkg.exoad.omni.engine.OmniEngine;
import pkg.exoad.omni.engine.ui.ContainerCloseOperation;
import pkg.exoad.omni.engine.ui.DiagnosticsBuilder;
import pkg.exoad.omni.engine.ui.Size;
import pkg.exoad.omni.engine.ui.UIContainer;
import pkg.exoad.omni.engine.ui.UIPanelDelegate;

public class OmniMain
{
    
    public static long startTime;
    
    static{
        startTime=System.currentTimeMillis();
        System.setProperty("java.util.logging.SimpleFormatter.format",
                           "[%1$tY.%1$tm.%1$td-%1$tH:%1$tM:%1$tS] [%4$s] %3$s | %5$s%6$s%n");
    }
    
    public static void main(String... args)
    {
        OmniEngine.initializeBase();
        OmniEngine.initializeUI();
        Omni.initializeLogger();
        Omni.LOG.log(Level.INFO,"Initialized in {0}ms",System.
                     currentTimeMillis()-startTime);
        OmniEngine.launchWindow(
                UIContainer.make().
                        withTitle("Project Omnipotent by exoad").
                        withSize(Size.make(1200,850)).
                        withWindowEventListener(DiagnosticsBuilder.
                                windowEventListener()).
                        withCloseOperation(ContainerCloseOperation.KILL).
                        withRootDelegate(UIPanelDelegate.
                                make("Omni_RootElement").withPainter((g2)->{
                                })));
        Runtime.getRuntime().
                addShutdownHook(new Thread(()->Omni.LOG.info(
                "Omni is shutting down...")));
    }
}
