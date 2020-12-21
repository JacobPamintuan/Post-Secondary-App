package postApp;
//imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

//import audio.MusicPlayer;

public class MapGUI extends JFrame implements ActionListener {
	//gui stuff
	
	private JFrame frame = new JFrame();
	private JPanel screen = new JPanel();
	private JLabel mapScreen = new JLabel();
	private JButton mapButton = new JButton();
	private JButton playButton = new JButton();
	private JButton loadButton = new JButton();
	private String start;
	private String destination;
	private ArrayList<Programs> tmp = new ArrayList<Programs>();
	
	private JButton backButton;
	private JButton searchButton;
	private static int imageNum = 0; 

	// constructor method
	public MapGUI(String school,ArrayList<Programs> tmp) throws IOException {
		this.tmp= tmp;
		imageNum++;
		//address of the user's home
		start = String.format("%s+%s+%s+%s+%s", Initialize.user.getStreetNumber().replace(' ','+'),Initialize.user.getStreetName().replace(' ','+'),
				  Initialize.user.getCity().replace(' ','+'),Initialize.user.getProvince().replace(' ','+'),
				  Initialize.user.getCountry().replace(' ','+'));
		
		//address of the school
		destination = school.replace(' ','+');
		
//		System.out.println(start);
//		System.out.println(destination);
		
		
		frameSetup();
		panelDesign();
		
		frame.repaint();
		
	}

	//set up the frame
	private void frameSetup() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(Initialize.WIDTH,Initialize.HEIGHT); // sets the size of the frame
		frame.setTitle("Engineering Program Finder");
		frame.setBounds(0,0,Initialize.WIDTH+5,Initialize.HEIGHT+29);
		frame.add(screen);
		
		frame.repaint();
	}

	//set up the panel
	private void panelDesign() throws IOException {
		//add features for the screen
		screen.setBorder(null);
		screen.setBounds(0, 0, Initialize.WIDTH,Initialize.HEIGHT);
		screen.setLayout(null);
		
		
		
		
		//fancy image scaling no longer needed
//		BufferedImage bi = new BufferedImage(
//			    icon.getIconWidth(),
//			    icon.getIconHeight(),
//			    BufferedImage.TYPE_INT_RGB);
//			Graphics g = bi.createGraphics();
//			// paint the Icon to the BufferedImage.
//			icon.paintIcon(null, g, 0,0);
//			g.dispose();
//		image.setBounds(0,0,960,540);
//		image.setIcon(new ImageIcon(getScaledImage(bi, 960,540) ));
		
		mapButton = new JButton();
		mapButton.addActionListener(this);
		mapButton.setBounds(160, 85, 640, 360);
		mapButton.setIcon(generateMapIcon());
		mapButton.setOpaque(true); 
		screen.add(mapButton);
		
		backButton = new JButton();
		backButton.addActionListener(this);
		backButton.setBounds(190, 465, 100, 30);
		backButton.setOpaque(false); 
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		screen.add(backButton);

		// JButton Continue
		// Continues to the next sign up step if all entered information is valid
		searchButton = new JButton();
		searchButton.addActionListener(this);
		searchButton.setBounds(670, 465, 100, 30);
		searchButton.setOpaque(false); 
		searchButton.setContentAreaFilled(false);
		searchButton.setBorderPainted(false);
		screen.add(searchButton);
		
		
		mapScreen=new JLabel();
		mapScreen.setBounds(0, 0,Initialize.WIDTH,Initialize.HEIGHT);
		mapScreen.setIcon(LoadImages.mapGUIImages[0]);
		mapScreen.setVisible(true);
		screen.add(mapScreen);
		
		frame.repaint();

	}
	
	private ImageIcon generateMapIcon() {
		//using the url, access the Google Static Map API to get an image of the map
		try {
			String imageUrl = generateStaticMapURL();
			System.out.println(imageUrl);
            String destinationFile = String.format("Map/Image%d.jpg",imageNum);
            String str = destinationFile;
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            
            OutputStream os = new FileOutputStream(destinationFile,false);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
		
		ImageIcon icon = new ImageIcon((new ImageIcon( String.format("Map/Image%d.jpg",imageNum))).getImage());
		return icon;
	}
	
	
	private String generateStaticMapURL() {		
    	//url address
    	String url = "https://maps.googleapis.com/maps/api/staticmap?maptype=roadmap&size=640x360&";
    	
    	//for the chosen university add a red label with D for Destination on it
    	url+="markers=color:red%7Clabel:D%7C"; 
    	url+=destination;//add the name of the chosen universities
    	
    	//for the user's home, add a blue label with S for Start on it
    	url+="&markers=color:blue%7Clabel:S%7C"; 
    	url += start; //add the address of the user
    	
    	//add a blue, semi transparent line connecting S and D
    	url+= "&path=color:0x0000ff|weight:5|"; 
    	url+=start;
    	url+="|";
    	url+=destination;
    	url+="&key=";
    	url+=Initialize.googleAPIKey;
    	return url;
    	
    }
	
	private String generateGoogleMapURL() {
		
		//https://www.google.com/maps/dir/?api=1&origin=622+fred_+mclaren+blvd&destination=University+Of+Waterloo&travelmode=driving
		//url address
    	String url = "https://www.google.com/maps/dir/?api=1";
    	
    	//add the address of the user
    	url+="&origin=";
    	url += start; 
    	
    	url+="&destination=";
    	url+=destination;//add the name of the chosen universities
    	
    	url+="&travelmode=driving"; 
    	
    	return url;
		
		
	}
	
	
	
	
	//Better Image Scaling (Originally, the frame would only contain a single image of the map, thus good scaling was needed)
	//This is because the largest image google sends back is 640x640 so image scaling was needed
	//however later on, the map image would only be a small part of the frame so no enlargment was needed
	public BufferedImage getScaledImage(BufferedImage image, int width, int height) throws IOException {
	    int imageWidth  = image.getWidth();
	    int imageHeight = image.getHeight();

	    double scaleX = (double)width/imageWidth;
	    double scaleY = (double)height/imageHeight;
	    AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
	    AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

	    return bilinearScaleOp.filter(
	        image,
	        new BufferedImage(width, height, image.getType()));
	}
	
	
	private void openWebBrowser(String link) {//this method opens the link on the buttons
		if (Desktop.isDesktopSupported()) {
			try {
				//opens hyperlink
				Desktop.getDesktop().browse(new URI(link));
				//browser
			} catch (IOException e1) {
				e1.printStackTrace();//if there is an error
			} catch (URISyntaxException e1) {
				e1.printStackTrace();// if there is a syntax error
			}
		}
	}
	
	
	//carries out the actions for each of the buttons
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == backButton) { // If user clicked loginButton
			new SearchResultsGUI(tmp);
			frame.setVisible(false); // Make current screen (signup) invisible
		
			
			
		} 
		else if (event.getSource() == searchButton) { // if user clicked continueButton
			new MainGUI();
			frame.setVisible(false);

		}
		
		if(event.getSource()==mapButton) {
			System.out.println(generateGoogleMapURL());
			openWebBrowser(generateGoogleMapURL());
		}
		
		repaint();
	}
	
	
	
	
}