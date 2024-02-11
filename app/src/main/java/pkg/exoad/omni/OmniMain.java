package pkg.exoad.omni;
import java.util.logging.Level;
import pkg.exoad.omni.content.Omni;
import pkg.exoad.omni.content.SharedConstants;
import pkg.exoad.omni.engine.OmniEngine;
import pkg.exoad.omni.engine.ui.BorderAlignment;
import pkg.exoad.omni.engine.ui.ColorValue;
import pkg.exoad.omni.engine.ui.ContainerCloseOperation;
import pkg.exoad.omni.engine.ui.DiagnosticsBuilder;
import pkg.exoad.omni.engine.ui.Size;
import pkg.exoad.omni.engine.ui.UIContainer;
import pkg.exoad.omni.engine.ui.UIPanelDelegate;

public class OmniMain
{

    public static long startTime;

    static
    {
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
        pkg.exoad.omni.engine.SharedConstants.USE_DIAGNOSTICS=true;
        Omni.LOG.log(Level.INFO,"Initialized in {0}ms",System.
                currentTimeMillis()-startTime);
        OmniEngine.launchWindow(
                UIContainer.make().
                        withTitle(SharedConstants.WINDOW_TITLE).
                        withSize(Size.make(1200,850)).
                        /*
                         * withWindowEventListener(DiagnosticsBuilder.
                         * windowEventListener()).
                         */
                        withCloseOperation(ContainerCloseOperation.KILL).
                        withRootDelegate(UIPanelDelegate.
                                make("Omni_RootElement").
                                withBorderLayout(10,10).
                                withBorderDelegate(
                                        DiagnosticsBuilder.
                                                makeColorPanelDelegate(
                                                        "TopLayer",ColorValue.
                                                                make("#f5d742")),
                                        BorderAlignment.TOP).
                                withBorderDelegate(
                                        UIPanelDelegate.make("BottomLayer").
                                                withBorderLayout(0,10).
                                                withBorderDelegate(
                                                        DiagnosticsBuilder.
                                                                makeColorPanelDelegate(
                                                                        "BottomLEFT",
                                                                        ColorValue.
                                                                                make("#4298f5")),
                                                        BorderAlignment.LEFT
                                                ).
                                                withBorderDelegate(
                                                        DiagnosticsBuilder.
                                                                makeColorPanelDelegate(
                                                                        "BottomRIGHT",
                                                                        ColorValue.
                                                                                make("#cc1b7c")),
                                                        BorderAlignment.RIGHT),
                                        BorderAlignment.BOTTOM)
                        ));
    }
}
