import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfileScreenGUIScreenTwo extends JFrame {
	
	public static JPanel TotalPanel = new JPanel();
	public static JLabel Title = new JLabel("Personal information");
	public static JLabel EarlyAccpetance = new JLabel("2.Early Acceptance");
	public static JLabel EarlyAccpetanceQuestion = new JLabel("Are you considering the early offer?");
	public static JLabel Yes= new JLabel("Yes");
	public static JLabel No= new JLabel("No");
	public static JButton choiceYes= new JButton();
	public static JButton choiceNo= new JButton(); 
	public static JLabel Extracurricular= new JLabel("3.Extracurricular");
	public static JLabel ActionType= new JLabel("Action type");
	public static JLabel Description= new JLabel("Description/title");
	
	public ProfileScreenGUIScreenTwo() {

		setBounds(360, 60, 600, 500);
		setVisible(true);
	
		TotalPanel.setLayout(null);
		TotalPanel.setBounds(50, 50, 200, 30);
		TotalPanel.setBackground(Color.white);
		TotalPanel.setVisible(true);
		add(TotalPanel);
		
		EarlyAccpetance.setFont(new Font("Serif", Font.PLAIN, 16));
		EarlyAccpetance.setBounds(40, 45, 200, 30);
		EarlyAccpetanceQuestion.setFont(new Font("Serif", Font.BOLD, 16));
		EarlyAccpetanceQuestion.setBounds(157, 73, 300, 30);
		Title.setFont(new Font("Serif", Font.PLAIN, 20));
		Title.setBounds(20, 10, 200, 30);
		Yes.setFont(new Font("Serif", Font.PLAIN, 16));
		Yes.setBounds(200, 100, 200, 30);
		No.setFont(new Font("Serif", Font.PLAIN, 16));
		No.setBounds(300, 100, 200, 30);
		No.setFont(new Font("Serif", Font.PLAIN, 16));
		No.setBounds(300, 100, 200, 30);
		Extracurricular.setFont(new Font("Serif", Font.PLAIN, 16));
		Extracurricular.setBounds(40, 130, 200, 30);
		ActionType.setFont(new Font("Serif", Font.PLAIN, 10));
		ActionType.setBounds(70, 160, 200, 30);
		Description.setFont(new Font("Serif", Font.PLAIN, 10));
		Description.setBounds(250, 160, 200, 30);
		
		choiceYes.setBounds(230,110,12,15);
		choiceYes.setIcon(new ImageIcon("images/choice.png"));
		choiceYes.setBorderPainted(false);
		choiceYes.setVisible(true);
		
		choiceNo.setBounds(330,110,12,15);
		choiceNo.setIcon(new ImageIcon("images/choice.png"));
		choiceNo.setBorderPainted(false);
		choiceNo.setVisible(true);
		
		
		TotalPanel.add(Title);
		TotalPanel.add(EarlyAccpetance);
		TotalPanel.add(EarlyAccpetanceQuestion);
		TotalPanel.add(Yes);
		TotalPanel.add(No);
		TotalPanel.add(choiceYes);
		TotalPanel.add(choiceNo);
		TotalPanel.add(Extracurricular);
		TotalPanel.add(ActionType);
		TotalPanel.add(Description);
		
	}
}
