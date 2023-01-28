package gov.edu.anm.presenter.domain.utils;

import java.awt.Component;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;

public class SwingUtils {
    
    public void limparTela(JPanel panel) {
        Component components[] = panel.getComponents();
        for (Component component : components) {
            if(component instanceof JTextField){
                ((JTextField) component).setText(null);
            }
            if(component instanceof JScrollPane){
                JViewport a = (JViewport) ((JScrollPane) component).getComponent(0);
                JList b = (JList)a.getComponent(0);
                DefaultListModel model = (DefaultListModel)b.getModel();
                model.removeAllElements();
                b.setModel(model);
            }
        }
    }
    
}
