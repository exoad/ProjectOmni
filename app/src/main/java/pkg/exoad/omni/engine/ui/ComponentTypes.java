/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

/**
 *
 * @author Jack Meng (exoad)
 */
public enum ComponentTypes
{
    Panel(JPanel.class), Label(JLabel.class), Button(JButton.class), TextField(
            JTextField.class), EditorField(JEditorPane.class), SplitPanel(
            JSplitPane.class), ScrollPane(JScrollPane.class);
    final Class<? extends JComponent> type;

    private ComponentTypes(Class<? extends JComponent> type)
    {
        this.type=type;
    }

    public Class<? extends JComponent> type()
    {
        return type;
    }

    public static <A extends JComponent> boolean isValid(Class<A> e)
    {
        // very shitty function for searching this 
        for(ComponentTypes r:values())
            if(r.type().
                    equals(e))
                return true;
        return false;
    }
}
