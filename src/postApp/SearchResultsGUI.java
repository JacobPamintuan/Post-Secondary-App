package postApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SearchResultsGUI implements ActionListener {

	public ProcessingInformation data;
	public BackupInformation backupData;

	public JFrame results = new JFrame();

	private JPanel[] showResults = new JPanel[6];

	private String searchResult;
	private String[] tagResults;

	private JButton[] addProgram = new JButton[6];
	private JButton[] moreInformation = new JButton[6];

	// For displaying the program Name and information
	private JLabel[] programName = new JLabel[6];
	private JLabel[] programSchool = new JLabel[6];

	// OUAC logo image
	private ImageIcon ouacImage = new ImageIcon();
	private JLabel image = new JLabel();

	// A constructor which is called by the search class when Basic Search is used
	public SearchResultsGUI(String searchResult) {
		super();
		this.searchResult = searchResult;
		System.out.println(searchResult);
		setResultLayout();
		displayResults();
	}

	// A constructor which is called by the search class when Search only using tags
	// is used
	public SearchResultsGUI(String[] tagResults) {
		super();
		this.tagResults = tagResults;
		setResultLayout();
		displayResults();
	}

	// combo Search
	public SearchResultsGUI(String searchResult, String[] tagResults) {
		super();
		this.searchResult = searchResult;
		this.tagResults = tagResults;
		setResultLayout();
		displayResults();
	}

	// A recursive method which sets the layout of the results of the search
	private void setResultLayout() {
		results.setSize(960, 568);
		results.setLayout(null);
		results.setTitle("Search Results");

		ouacImage = new ImageIcon("images/ouaclogo.png");
		image = new JLabel(ouacImage);
		image.setBounds(225, 0, 510, 80);
		results.add(image);

		results.getContentPane().setBackground(Color.lightGray);

		for (int x = 0; x < 3; x++) {
			showResults[x] = new JPanel(null, false);
			showResults[x].setBounds(0, 80 + (150 * x), 480, 150);

			addProgram[x] = new JButton("Add Program #" + (x + 1));
			addProgram[x].addActionListener(this);
			addProgram[x].setBounds(320, 100 + (150 * x), 130, 45);

			moreInformation[x] = new JButton("More Information");
			moreInformation[x].addActionListener(this);
			moreInformation[x].setBounds(310, 155 + (150 * x), 140, 45);

			programName[x] = new JLabel();
			programSchool[x] = new JLabel();
			programName[x].setBounds(20, (100 + (150 * x)), 130, 35);
			programSchool[x].setBounds(20, 140 + (150 * x), 130, 35);

			if (x == 0 || x == 2) {
				showResults[x].setBackground(Color.white);
			} else {
				showResults[x].setBackground(Color.lightGray);
			}
			results.getContentPane().add(showResults[x]);
			results.getContentPane().add(addProgram[x]);
			results.getContentPane().add(moreInformation[x]);
		}

		for (int x = 3; x < 6; x++) {
			showResults[x] = new JPanel(null, false);
			showResults[x].setBounds(480, 80 + (150 * (x - 3)), 480, 150);

			addProgram[x] = new JButton("Add Program #" + (x + 1));
			addProgram[x].addActionListener(this);
			addProgram[x].setBounds(800, 100 + (150 * (x - 3)), 130, 45);

			moreInformation[x] = new JButton("More Information");
			moreInformation[x].addActionListener(this);
			moreInformation[x].setBounds(790, 155 + (150 * (x - 3)), 140, 45);

			programName[x] = new JLabel();
			programSchool[x] = new JLabel();
			programName[x].setBounds(500, 100 + (150 * (x - 3)), 130, 35);
			programSchool[x].setBounds(500, 140 + (150 * (x - 3)), 130, 35);

			// moreInformation[x].setBackground(Color.cyan);
			// moreInformation[x].setForeground(Color.white);

			if (x == 4) {
				showResults[x].setBackground(Color.white);
			} else {
				showResults[x].setBackground(Color.lightGray);
			}

			results.getContentPane().add(showResults[x]);
			results.getContentPane().add(addProgram[x]);
			results.getContentPane().add(moreInformation[x]);
		}

		results.repaint();

		results.setVisible(true);
		results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void displayResults() {
		
		try {
			new ProcessingInformation();
			System.out.println(searchResult + "1");
			int i = 0;
			int j = 0;
			for (int x = 0; x < ProcessingInformation.programList.size(); x++) {
				if (ProcessingInformation.programList.get(x + 1).equals(searchResult + ProcessingInformation.universityList.get(x + 1)) == true) {
					programName[i] = new JLabel("Program #" + (x + 1) + " Name: " + searchResult);
					programSchool[i] = new JLabel("University: " + (ProcessingInformation.universityList.get(x)));
					System.out.println("yes");
					++j;
				} else if (x == 15) {
					break;
				} else if (j == 6) {
					break;
				} else if (!(ProcessingInformation.programList.get(x).equals(searchResult + ProcessingInformation.universityList.get(x)) == true)) {
					System.out.println("no");
				}
				System.out.println("bruh");
			}

			System.out.println(searchResult + "1");
			while (!(i == j)) {
				results.add(programSchool[i]);
				results.add(programName[i]);
			}

			results.repaint();

			for (int x = 0; x < 6; x++) {
				showResults[x].repaint();
			}
		} catch (Exception e) {
			new BackupInformation(searchResult);
			
			int i = 0;
			int j = 0;
			
			for (int x = 0; x < 8; x++) {
				if (backupData.programList[backupData.getIndex()][x].equals("") == true ) {
					break;
				} else {
					programName[x] = new JLabel("Program #" + (x + 1) + " Name: " + searchResult);
					programSchool[x] = new JLabel("University: " + (backupData.programList[backupData.getIndex()][x]));
					i++;
				}
				
			} 
			
			while (!(i == j)) {
				results.add(programSchool[i]);
				results.add(programName[i]);
				j++;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addProgram[0]) {
			addprogram(0);

		} else if (e.getSource() == addProgram[1]) {
			addprogram(1);

		} else if (e.getSource() == addProgram[2]) {
			addprogram(2);

		} else if (e.getSource() == addProgram[3]) {
			addprogram(3);

		} else if (e.getSource() == addProgram[4]) {
			addprogram(4);

		}
	}

	private void addprogram(int i) {

	}

}
