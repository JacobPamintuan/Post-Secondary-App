import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Information extends JFrame{
        
        public static JPanel TotalPanel = new JPanel();
        
        public Information(){
                
                setBounds(560, 200, 200, 200);
                setVisible(true);
                
                TotalPanel.setLayout(null);
                TotalPanel.setBounds(50, 50, 200, 30);
                TotalPanel.setBackground(Color.white);
                TotalPanel.setVisible(true);
                add(TotalPanel);
                
        }

}