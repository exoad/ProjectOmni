/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import java.awt.RenderingHints;

/**
 *
 * @author Jack Meng (exoad)
 */
public enum GraphicsAttributes
{
    // so much boilerplate, my pinky hurts ahhhhh
    ALPHA_INTERP_QUALITY(RenderingHints.KEY_ALPHA_INTERPOLATION,
            RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY),
    ALPHA_INTERP_SPEED(RenderingHints.KEY_ALPHA_INTERPOLATION,
            RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED),
    ANTIALIAS_ON(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON),
    ANTIALIAS_OFF(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_OFF),
    COLOR_RENDER_QUALITY(RenderingHints.KEY_COLOR_RENDERING,
            RenderingHints.VALUE_COLOR_RENDER_QUALITY),
    COLOR_RENDER_SPEED(RenderingHints.KEY_COLOR_RENDERING,
            RenderingHints.VALUE_COLOR_RENDER_SPEED),
    FRACTIONAL_METRICS_ON(RenderingHints.KEY_FRACTIONALMETRICS,
            RenderingHints.VALUE_FRACTIONALMETRICS_ON),
    FRACTIONAL_METRICS_OFF(RenderingHints.KEY_FRACTIONALMETRICS,
            RenderingHints.VALUE_FRACTIONALMETRICS_OFF),
    INTERP_BICUBIC(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BICUBIC),
    INTERP_BILINEAR(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR),
    INTERP_NN(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR),
    SPEEDY(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_SPEED),
    QUALITY(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY),
    NORM_STROKE(RenderingHints.KEY_STROKE_CONTROL,
            RenderingHints.VALUE_STROKE_NORMALIZE),
    PURE_STROKE(RenderingHints.KEY_STROKE_CONTROL,
            RenderingHints.VALUE_STROKE_PURE),
    TXT_AA_GASP(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_GASP),
    TXT_AA_OFF(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_OFF),
    TXT_AALCD_HBGR(RenderingHints.KEY_TEXT_LCD_CONTRAST,
            RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR),
    TXT_AALCD_VBGR(RenderingHints.KEY_TEXT_LCD_CONTRAST,
            RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VBGR),
    TXT_AALCD_VRGB(RenderingHints.KEY_TEXT_LCD_CONTRAST,
            RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VRGB),
    TXT_AA_ON(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON),
    DITHER_OFF(RenderingHints.KEY_DITHERING,RenderingHints.VALUE_DITHER_DISABLE),
    DITHER_ON(RenderingHints.KEY_DITHERING,RenderingHints.VALUE_DITHER_ENABLE);
    final Object ref;
    final RenderingHints.Key key;

    private GraphicsAttributes(RenderingHints.Key key,Object ref)
    {
        this.key=key;
        this.ref=ref;
    }

    public RenderingHints.Key key()
    {
        return key;
    }

    public Object ref()
    {
        return ref;
    }
}
