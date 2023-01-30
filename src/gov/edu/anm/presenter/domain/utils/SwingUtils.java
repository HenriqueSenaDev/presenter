package gov.edu.anm.presenter.domain.utils;

import java.awt.Component;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;

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
    
}
