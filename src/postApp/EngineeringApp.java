package postApp;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class EngineeringApp { // Main Class
	
	JFrame frame;
	static Person user = new Person();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
