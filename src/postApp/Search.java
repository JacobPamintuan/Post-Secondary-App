/*
 * Dev Punjabi
 */

package postApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Search implements ActionListener, KeyListener {
	
	// Fields
	//program Object
	private Program program;
	
	//frame for the search
	private JFrame programSearch = new JFrame();
	
	//Nessesary buttons
	private JButton[] addProgram = new JButton[6];
	private JButton[] moreInformation = new JButton[6];
	private JButton submit = new JButton();
	private JLabel systemMessage = new JLabel("System Message: ");
	
	//All different search types
	private JButton basicSearch = new JButton();
	private JButton comboSearch = new JButton();
	private JButton altSearch = new JButton();
	private JButton schoolSearch = new JButton();
	private JButton showProgramList = new JButton();
	public int searchtype = 1;
	private JButton[] schoolList = new JButton[19];
	
	//For displaying the program Name and information
	private JLabel[] programName = new JLabel[6];
	private JLabel[] programSchool = new JLabel[6];
	
	//Text fields and their results
	private JTextField[] tags = new JTextField[3];
	private JLabel[] tagsCaption = new JLabel[3];
	private JTextField searchText = new JTextField();
	private String searchResult = "";
	private String[] tagResult;
	
	//OUAC logo image
	private ImageIcon ouacImage = new ImageIcon(); //need to add ouac image
	private JLabel image = new JLabel();

	/*
	 * Constructor 
	 * Pre: None 
	 * Post: GUI is created
	 */
	public Search() {
		programSearch.setSize(1920, 1080);
		programSearch.setLayout(null);
		programSearch.setTitle("Program Search");

		// Adds the buttons, text boxes, and base Labels
		setSearchLayout();
		//program.setupBinarySearch("gold");
		
		ouacImage = new ImageIcon("images/ouaclogo.png");
		image = new JLabel(ouacImage);
		image.setBounds(705, 10, 510, 80);
		programSearch.add(image);
		
		programSearch.setVisible(true);
		programSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Search();
	}
	
	private void setSearchLayout() {
				// Adds all the buttons, text fields and Labels and the first search screen
				// adds the search text field and caption
				searchText.setBounds(800, 400, 400, 35);
				JLabel searchTextCaption = new JLabel("Program Name: ");
				searchTextCaption.setBounds(690, 400, 100, 25);
				searchText.addKeyListener(this);
				programSearch.add(searchText);
				programSearch.add(searchTextCaption);

				// sets background colour
				// https://stackoverflow.com/questions/1081486/setting-background-color-for-a-jframe
				programSearch.getContentPane().setBackground(Color.lightGray);

				// submit/search button
				submit = new JButton("Search");
				submit.setBounds(1220, 400, 75, 35);
				submit.addActionListener(this);
				submit.setBackground(Color.red);
				submit.setForeground(Color.white);
				programSearch.add(submit);
				
				//setting up search types
				//Basic Search, only using program searching
				basicSearch = new JButton("Basic Search");
				basicSearch.setBounds(10, 850, 364, 110);
				basicSearch.addActionListener(this);
				basicSearch.setBackground(Color.green);
				basicSearch.setForeground(Color.white);
				programSearch.add(basicSearch);
				
				// Search using tags instead -- will disable the program search main
				altSearch = new JButton("Search ONLY Using Tags");
				altSearch.setBounds(384, 850, 364, 110);
				altSearch.addActionListener(this);
				altSearch.setBackground(Color.white);
				altSearch.setForeground(Color.ORANGE);
				programSearch.add(altSearch);
				
				//Combo search, where they search using tags and program search
				comboSearch = new JButton("Searching using Tags and Basic Search");
				comboSearch.setBounds(758, 850, 364, 110);
				comboSearch.addActionListener(this);
				comboSearch.setBackground(Color.white);
				comboSearch.setForeground(Color.ORANGE);
				programSearch.add(comboSearch);
				
				//Search by School, when clicked shows a button of each school and you pick the one you want to see
				schoolSearch = new JButton("Search by School");
				schoolSearch.setBounds(1132, 850, 364, 110);
				schoolSearch.addActionListener(this);
				schoolSearch.setBackground(Color.white);
				schoolSearch.setForeground(Color.ORANGE);
				programSearch.add(schoolSearch);
				
				//Show Program List
				showProgramList = new JButton("Program Results");
				showProgramList.setBounds(1506, 850, 364, 110);
				showProgramList.addActionListener(this);
				showProgramList.setBackground(Color.white);
				showProgramList.setForeground(Color.ORANGE);
				programSearch.add(showProgramList);
				
				for (int n = 0; n < 3; n++) {
					tags[n] = new JTextField();
					tags[n].setBounds(950, 480 + (30 * n), 250, 25);
					tagsCaption[n] = new JLabel("Tag #" + (n + 1) + ": ");
					tagsCaption[n].setBounds(900, 480 + (30 * n), 50, 25);
					tags[n].setEditable(false);
					programSearch.add(tags[n]);
					programSearch.add(tagsCaption[n]);
				}
				
				
		}

	// A recursive method which sets the layout of the results of the search
	private int setResultLayout(int n) {
		if (!(n == 6)) {
			if (n == 0) {
				// Adds all the other buttons and Labels and the first addProgram
				// buttons
				
				// adds the search text field and caption
				searchText.setBounds(250, 100, 200, 25);
				JLabel searchTextCaption = new JLabel("Program Name: ");
				searchTextCaption.setBounds(150, 100, 100, 25);
				programSearch.add(searchText);
				programSearch.add(searchTextCaption);
				
				// adds the first Tag and caption
				tags[0] = new JTextField();
				tags[0].setBounds(300, 150, 150, 25);
				JLabel tagsCaption = new JLabel("Tag #1: ");
				tagsCaption.setBounds(250, 150, 50, 25);
				programSearch.add(tags[0]);
				programSearch.add(tagsCaption);

				// sets and add first the program name
				programName[0] = new JLabel("Program #1: ");
				programName[0].setBounds(10, 425, 100, 100);
				programSearch.add(programName[0]);

				// First addProgram button
				addProgram[0] = new JButton("Add Program");
				addProgram[0].setBounds(600, 450, 190, 40);
				addProgram[0].addActionListener(this);
				programSearch.add(addProgram[0]);
				
				//Program Description
				
				// sets background colour
				// https://stackoverflow.com/questions/1081486/setting-background-color-for-a-jframe
				programSearch.getContentPane().setBackground(new Color(194, 231, 245));

				// submit/search button
				submit = new JButton("Search");
				submit.setBounds(600, 180, 190, 40);
				submit.addActionListener(this);
				submit.setBackground(Color.red);
				programSearch.add(submit);
				
				// Search using tags instead -- will disable the program search main
				altSearch = new JButton("Search ONLY Using Tags");
				altSearch.setBounds(600, 130, 190, 40);
				altSearch.addActionListener(this);
				altSearch.setBackground(Color.lightGray);
				programSearch.add(altSearch);

			} else {
				if (n == 1 || n == 2) {
					// Adding the addProgram second and third Buttons
					addProgram[n] = new JButton("Add Program");
					addProgram[n].setBounds(600, (450 + (200 * n)), 190, 40);
					addProgram[n].addActionListener(this);
					programSearch.add(addProgram[n]);

					// Adding the second and third program name and description labels
					
					//adding the second and third tag and caption
					tags[n] = new JTextField();
					tags[n].setBounds(300, 150 + (30 * n), 150, 25);
					JLabel tagsCaption = new JLabel("Tag #" + (n + 1) + ": ");
					tagsCaption.setBounds(250, 150 + (30 * n), 50, 25);
					programSearch.add(tags[n]);
					programSearch.add(tagsCaption);
					

				} else if (n > 2) {
					// Adding the forth to eighth addPrograms Buttons
					addProgram[n] = new JButton("Add Program");
					addProgram[n].setBounds(1400, (50 + (200 * n) - 600), 190, 40);
					addProgram[n].addActionListener(this);
					programSearch.add(addProgram[n]);
				}
			}
			return setResultLayout(n + 1);

		} else {
			return -1;
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

		} else if (e.getSource() == submit) {
			displayPrograms();
			
		} else if (e.getSource() == basicSearch) {
			for (int n = 0; n < 3; n++) {
				tags[n].setEditable(false);
			}
			searchText.setEditable(true);
			basicSearch.setBackground(Color.green);
			basicSearch.setForeground(Color.white);
			altSearch.setBackground(Color.white);
			altSearch.setForeground(Color.ORANGE);
			schoolSearch.setBackground(Color.white);
			schoolSearch.setForeground(Color.ORANGE);
			comboSearch.setBackground(Color.white);
			comboSearch.setForeground(Color.ORANGE);
			
		} else if (e.getSource() == altSearch) {
			for (int n = 0; n < 3; n++) {
				tags[n].setEditable(true);
			}
			searchText.setEditable(false);
			basicSearch.setBackground(Color.white);
			basicSearch.setForeground(Color.orange);
			altSearch.setBackground(Color.green);
			altSearch.setForeground(Color.white);
			schoolSearch.setBackground(Color.white);
			schoolSearch.setForeground(Color.ORANGE);
			comboSearch.setBackground(Color.white);
			comboSearch.setForeground(Color.ORANGE);
			
		} else if (e.getSource() == schoolSearch) {
			setSchoolSearch();
		} else if (e.getSource() == comboSearch) {
			
		}
		
		programSearch.repaint();
	}


	private void displayPrograms() {
		int c = 0;
		
		while (!(program.setupBinarySearch(searchResult).equals("final"))) {
			programName[c] = new JLabel("Program #1: " + searchResult);
			programSchool[c] = new JLabel("School: " + program.setupBinarySearch(searchResult));
		}
		setResultLayout(0);
	}

	private void addprogram(int i) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		searchResult = searchText.getText();
		tagResult[0] = tags[0].getText();
		tagResult[1] = tags[1].getText();
		tagResult[2] = tags[2].getText();
		//System.out.println(searchResult);
		
		if (searchResult.equals("")) {
			systemMessage = new JLabel("System Message: Cannot Search with an empty field.");
			systemMessage.setForeground(Color.red);
			systemMessage.setBounds(910, 430, 100, 30);
			programSearch.add(systemMessage);
		}
	}

}
