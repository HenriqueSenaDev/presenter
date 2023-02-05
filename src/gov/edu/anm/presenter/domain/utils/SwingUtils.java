package gov.edu.anm.presenter.domain.utils;

import java.awt.*;
import javax.swing.*;

public class SwingUtils {
    
    public static void cleanPanelRecordFields(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if(component instanceof JTextField){
                ((JTextField) component).setText(null);
            }
            if(component instanceof JScrollPane){
                JViewport a = (JViewport) ((JScrollPane) component).getComponent(0);
                JList<String> b = (JList<String>) a.getComponent(0);
                DefaultListModel<String> model = (DefaultListModel<String>) b.getModel();
                model.removeAllElements();
                b.setModel(model);
            }
        }
    }

    public static void setRedCountdown(JLabel whiteCircle, JLabel redCircle, JLabel timerLabel) {
        whiteCircle.setVisible(false);
        redCircle.setVisible(true);
        timerLabel.setForeground(new Color(255, 0, 25));
    }

    public static void setWhiteCountdown(JLabel whiteCircle, JLabel redCircle, JLabel timerLabel) {
        whiteCircle.setVisible(true);
        redCircle.setVisible(false);
        timerLabel.setForeground(new Color(255, 255, 255));
    }
    
}
