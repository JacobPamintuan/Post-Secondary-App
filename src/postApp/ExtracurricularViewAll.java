package postApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExtracurricularViewAll extends JFrame {

	public static JPanel TotalPanel = new JPanel();
	public JButton delete = new JButton("Delete");

	public static ArrayList<JTextField> ExtracurricularActionTypeShowBox = new ArrayList<JTextField>();
	public static ArrayList<JTextField> ExtracurricularDescriptionShowBox = new ArrayList<JTextField>();
	public static ArrayList<JTextField> ExtracurricularStarDateShowBox = new ArrayList<JTextField>();
	public static ArrayList<JTextField> ExtracurricularEndDateShowBox = new ArrayList<JTextField>();

	public ExtracurricularViewAll() {


		setBounds(20, 60, 340, 500);
		setVisible(true);

		TotalPanel.setLayout(null);
		TotalPanel.setBounds(50, 50, 200, 30);
		TotalPanel.setBackground(Color.white);
		TotalPanel.setVisible(true);
		add(TotalPanel);

		delete.setBounds(220, 430, 100, 30);

		TotalPanel.add(delete);

		for (int x = 0; x < ProfileScreenGUIScreenTwo.ExtracurricularActionType.size(); x++) {

			ExtracurricularActionTypeShowBox.add(new JTextField(25));
			ExtracurricularDescriptionShowBox.add(new JTextField(25));
			ExtracurricularStarDateShowBox.add(new JTextField(25));
			ExtracurricularEndDateShowBox.add(new JTextField(25));

			ExtracurricularActionTypeShowBox.get(x).setBounds(20, 30 * (x + 1), 70, 30);
			ExtracurricularDescriptionShowBox.get(x).setBounds(90, 30 * (x + 1), 130, 30);
			ExtracurricularStarDateShowBox.get(x).setBounds(220, 30 * (x + 1), 50, 30);
			ExtracurricularEndDateShowBox.get(x).setBounds(270, 30 * (x + 1), 50, 30);

			TotalPanel.add(ExtracurricularActionTypeShowBox.get(x));
			TotalPanel.add(ExtracurricularDescriptionShowBox.get(x));
			TotalPanel.add(ExtracurricularStarDateShowBox.get(x));
			TotalPanel.add(ExtracurricularEndDateShowBox.get(x));

			ExtracurricularActionTypeShowBox.get(x).setText(ProfileScreenGUIScreenTwo.ExtracurricularActionType.get(x));
			ExtracurricularDescriptionShowBox.get(x).setText(ProfileScreenGUIScreenTwo.ExtracurricularDescription.get(x));
			ExtracurricularStarDateShowBox.get(x).setText(ProfileScreenGUIScreenTwo.ExtracurricularStarDate.get(x));
			ExtracurricularEndDateShowBox.get(x).setText(ProfileScreenGUIScreenTwo.ExtracurricularEndDate.get(x));
		}

		setVisible(true);

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				if (ProfileScreenGUIScreenTwo.ExtracurricularActionType.size() != 0&&ExtracurricularActionTypeShowBox.size()!=0)
				{
					ExtracurricularActionTypeShowBox.get(ProfileScreenGUIScreenTwo.ExtracurricularActionType.size() - 1)
							.setVisible(false);
					ProfileScreenGUIScreenTwo.ExtracurricularActionType
							.remove(ProfileScreenGUIScreenTwo.ExtracurricularActionType.size() - 1);
					ExtracurricularActionTypeShowBox.remove(ProfileScreenGUIScreenTwo.ExtracurricularActionType.size());
					

					ExtracurricularDescriptionShowBox.get(ProfileScreenGUIScreenTwo.ExtracurricularDescription.size() - 1)
							.setVisible(false);
					ProfileScreenGUIScreenTwo.ExtracurricularDescription
							.remove(ProfileScreenGUIScreenTwo.ExtracurricularDescription.size() - 1);
					ExtracurricularDescriptionShowBox.remove(ProfileScreenGUIScreenTwo.ExtracurricularDescription.size());

					
					ExtracurricularStarDateShowBox.get(ProfileScreenGUIScreenTwo.ExtracurricularStarDate.size() - 1)
							.setVisible(false);
					ProfileScreenGUIScreenTwo.ExtracurricularStarDate
							.remove(ProfileScreenGUIScreenTwo.ExtracurricularStarDate.size() - 1);
					ExtracurricularStarDateShowBox.remove(ProfileScreenGUIScreenTwo.ExtracurricularStarDate.size());


					
					ExtracurricularEndDateShowBox.get(ProfileScreenGUIScreenTwo.ExtracurricularEndDate.size() - 1)
							.setVisible(false);
					
					ProfileScreenGUIScreenTwo.ExtracurricularEndDate
							.remove(ProfileScreenGUIScreenTwo.ExtracurricularEndDate.size() - 1);
					ExtracurricularEndDateShowBox.remove(ProfileScreenGUIScreenTwo.ExtracurricularEndDate.size());

				}
			}

		});

	}

}
