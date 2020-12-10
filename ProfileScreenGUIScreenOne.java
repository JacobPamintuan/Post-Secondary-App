import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfileScreenGUIScreenOne extends JFrame {

	public static JPanel TitlePanel = new JPanel();
	public static JLabel Title = new JLabel("Personal codeInformation");
	public static JLabel QuestionTitle = new JLabel("1.Mark");
	public static JLabel CourseCode = new JLabel("Course code");
	public static JLabel CourseMark = new JLabel("Course mark");
	private JTextField CodeEnter = new JTextField(10);
	private JTextField MarkEnter = new JTextField(10);
	private JTextField[] Code = new JTextField[6];
	private JTextField[] Mark = new JTextField[6];
	public JButton save = new JButton("save");
	public JButton delete = new JButton("Delete");
	public JButton next = new JButton("Next");
	public JButton codeInformation= new JButton();
	public JButton markInformation = new JButton(); 
	public JButton deleteInformation = new JButton();
	
	public ProfileScreenGUIScreenOne() {

		setBounds(360, 60, 600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		TitlePanel.setLayout(null);
		TitlePanel.setBounds(50, 50, 200, 30);
		TitlePanel.setBackground(Color.white);
		TitlePanel.setVisible(true);
		add(TitlePanel);

		Title.setFont(new Font("Serif", Font.PLAIN, 20));
		Title.setBounds(20, 10, 300, 30);

		QuestionTitle.setFont(new Font("Serif", Font.BOLD, 16));
		QuestionTitle.setBounds(40, 60, 200, 30);
		CourseCode.setFont(new Font("Serif", Font.PLAIN, 15));
		CourseCode.setBounds(120, 100, 200, 30);
		CourseMark.setFont(new Font("Serif", Font.PLAIN, 15));
		CourseMark.setBounds(380, 100, 200, 30);
		CodeEnter.setBounds(100, 130, 130, 20);
		MarkEnter.setBounds(360, 130, 130, 20);
		save.setBounds(245, 150, 100, 30);
		delete.setBounds(170,330,100,30);
		next.setBounds(460,420,100,30);
		
		codeInformation.setBounds(210,103,25,25);
		codeInformation.setIcon(new ImageIcon("images/kk.png"));
		codeInformation.setBorderPainted(false);
		codeInformation.setVisible(true);
		
		markInformation.setBounds(470,103,25,25);
		markInformation.setIcon(new ImageIcon("images/kk.png"));
		markInformation.setBorderPainted(false);
		markInformation.setVisible(true);
		
		deleteInformation.setBounds(280,333,25,25);
		deleteInformation.setIcon(new ImageIcon("images/kk.png"));
		deleteInformation.setBorderPainted(false);
		deleteInformation.setVisible(true);

		for (int y = 0; y < 6; y++) {
			
			Code[y]= new JTextField(25);
			Code[y].setBounds(170, 200 + 20 * y, 130, 20);
		}
		for (int x = 0; x < 6; x++) {
			
			Mark[x]= new JTextField(25);
			Mark[x].setBounds(300, 200 + 20 * x, 130, 20);

		}
		TitlePanel.add(CodeEnter);
		TitlePanel.add(Title);
		TitlePanel.add(CourseMark);
		TitlePanel.add(QuestionTitle);
		TitlePanel.add(CourseCode);
		TitlePanel.add(save);
		TitlePanel.add(delete);
		TitlePanel.add(next);
		TitlePanel.add(codeInformation);
		TitlePanel.add(markInformation);
		TitlePanel.add(deleteInformation);

		for (int y = 0; y < 6; y++)
			TitlePanel.add(Code[y]);

		TitlePanel.add(MarkEnter);
		
		for(int x=0;x<6;x++)
		TitlePanel.add(Mark[x]);
		
		setVisible(true);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String code = CodeEnter.getText();
				String mark = MarkEnter.getText();
				//Code.setText(code);
				//Mark.setText(mark);

			}

		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				dispose();
				new ProfileScreenGUIScreenTwo();
				

			}

		});
		codeInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				new Information();
				
			}
			
		});
		markInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				new Information();
				
			}
			
		});
		deleteInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				new Information();
				
			}
			
		});
	}

}
