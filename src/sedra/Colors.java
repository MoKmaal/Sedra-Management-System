/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sedra;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author mohammed
 */
public class Colors {

    public static Color PANELS_COLOR = new Color(240, 255, 240);
    public static Color FIELDS_COLOR = PANELS_COLOR;
    public static Color HEAD_COLOR = new Color(0, 98, 143);
    public static Color HOVER_COLOR = new Color(0, 135, 197);
    public static Color SIDE_COLOR = new Color(00, 90, 131);
    public static Color LABELS_COLOR = SIDE_COLOR;

    public static Color TITLES_COLOR = new Color(255, 255, 255);

    public static void setColor(JPanel pane) {
        pane.setBackground(HOVER_COLOR);
    }

    public static void resetColor(JPanel pane) {
        pane.setBackground(SIDE_COLOR);

    }

}
