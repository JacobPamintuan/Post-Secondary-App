package postApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AwardViewAllGUI extends JFrame {

	public static JPanel TotalPanel = new JPanel();
	public JButton delete = new JButton("Delete");
	public static ArrayList<JTextField> AwardNameShowBox = new ArrayList<JTextField>();
	public static ArrayList<JTextField> AwardDescriptionShowBox = new ArrayList<JTextField>();
	public static ArrayList<JTextField> AwardDateShowBox = new ArrayList<JTextField>();

	public AwardViewAllGUI() {

		setBounds(20, 60, 340, 500);
		setVisible(true);

		TotalPanel.setLayout(null);
		TotalPanel.setBounds(50, 50, 200, 30);
		TotalPanel.setBackground(Color.white);
		TotalPanel.setVisible(true);
		add(TotalPanel);

		delete.setBounds(220, 430, 100, 30);

		TotalPanel.add(delete);

		for (int x = 0; x < ProfileGUIThree.AwardActionName.size(); x++) {

			AwardNameShowBox.add(new JTextField(25));
			AwardDescriptionShowBox.add(new JTextField(25));
			AwardDateShowBox.add(new JTextField(25));

			AwardNameShowBox.get(x).setBounds(20, 30 * (x + 1), 70, 30);
			AwardDescriptionShowBox.get(x).setBounds(90, 30 * (x + 1), 130, 30);
			AwardDateShowBox.get(x).setBounds(220, 30 * (x + 1), 50, 30);

			TotalPanel.add(AwardNameShowBox.get(x));
			TotalPanel.add(AwardDescriptionShowBox.get(x));
			TotalPanel.add(AwardDateShowBox.get(x));

			AwardNameShowBox.get(x).setText(ProfileGUIThree.AwardActionName.get(x));
			AwardDescriptionShowBox.get(x).setText(ProfileGUIThree.AwardDescription.get(x));
			AwardDateShowBox.get(x).setText(ProfileGUIThree.AwardDate.get(x));

		}

		setVisible(true);

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				if (ProfileGUIThree.AwardActionName.size() != 0 && AwardNameShowBox.size() != 0) {

					ProfileGUIThree.AwardActionName
							.remove(ProfileGUIThree.AwardActionName.size() - 1);
					AwardNameShowBox.get(ProfileGUIThree.AwardActionName.size()).setVisible(false);
					AwardNameShowBox.remove(ProfileGUIThree.AwardActionName.size());

					
					AwardDescriptionShowBox.get(ProfileGUIThree.AwardDescription.size() - 1)
							.setVisible(false);
					AwardDescriptionShowBox.remove(ProfileGUIThree.AwardDescription.size() - 1);
					ProfileGUIThree.AwardDescription
							.remove(ProfileGUIThree.AwardDescription.size() - 1);

					
					AwardDateShowBox.get(ProfileGUIThree.AwardDate.size() - 1).setVisible(false);
					AwardDateShowBox.remove(ProfileGUIThree.AwardDate.size() - 1);
					ProfileGUIThree.AwardDate.remove(ProfileGUIThree.AwardDate.size() - 1);

				}
				
			}

		});

	}

}
