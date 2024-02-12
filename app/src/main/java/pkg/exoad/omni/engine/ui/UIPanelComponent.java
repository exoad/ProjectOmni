/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import javax.swing.JPanel;
/**
 *
 * @author Jack Meng (exoad)
 */
public class UIPanelComponent
        extends UIComponent<JPanel>
{
    public UIPanelComponent(String id)
    {
        super(id,new JPanel());
    }
}
