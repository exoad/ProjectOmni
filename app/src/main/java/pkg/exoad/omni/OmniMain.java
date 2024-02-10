package pkg.exoad.omni;
import pkg.exoad.omni.content.Omni;
import pkg.exoad.omni.engine.OmniEngine;

public class OmniMain
{
    
    public static long startTime;
    
    static
    {
        startTime=System.currentTimeMillis();
        System.setProperty("java.util.logging.SimpleFormatter.format",
                           "[%1$tY.%1$tm.%1$td-%1$tH:%1$tM:%1$tS] [%4$s] | %5$s%6$s%n");
    }
    
    public static void main(String... args)
    {
        OmniEngine.initializeLogging();
        OmniEngine.initializeUI();
        Omni.initializeLogger();
        Omni.LOG.info(
                "Initialized in "+(System.currentTimeMillis()-startTime)+"ms");
        
        Runtime.getRuntime().
                addShutdownHook(new Thread(()->Omni.LOG.info(
                "Omni is shutting down...")));
        
    }
}
