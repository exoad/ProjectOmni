package pkg.exoad.omni;
import java.util.logging.Level;
import pkg.exoad.omni.content.Omni;
import pkg.exoad.omni.engine.OmniEngine;
import pkg.exoad.omni.engine.geom.Pt;
import pkg.exoad.omni.engine.geom.Rect;
import pkg.exoad.omni.engine.ui.ColorValue;
import pkg.exoad.omni.engine.ui.ContainerCloseOperation;
import pkg.exoad.omni.engine.ui.DiagnosticsBuilder;
import pkg.exoad.omni.engine.ui.GraphicsAttributes;
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
        System.setProperty("sun.java2d.opengl","True");
    }
    
    public static void main(String... args)
    {
        StringBuilder sb=new StringBuilder();
        System.getProperties().
                forEach(((b,u)->sb.append(b).
                append("=").
                append(u).
                append("\n")));
        System.out.println(sb.toString());
        System.out.println("\n\n");
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
                                make("Omni_RootElement").
                                withPainter((context,painter)->{
                                    painter.init(
                                            GraphicsAttributes.COLOR_RENDER_SPEED);
                                    painter.color(ColorValue.make("#171615"));
                                    painter.fillRect(Rect.make(Pt.make(30,30),
                                            Pt.
                                                    make(context.size.width()-30,
                                                            context.size.
                                                                    height()-30)));
                                    painter.dispose();
                                })));
    }
}
