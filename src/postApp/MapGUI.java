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
import java.net.URL;

//import audio.MusicPlayer;

public class MapGUI extends JFrame implements ActionListener {
	//gui stuff
	JPanel mapScreen = new JPanel();
	JLabel image = new JLabel();
	JButton playButton = new JButton();
	JButton loadButton = new JButton();

	// constructor method
	public MapGUI() throws IOException {
//		MusicPlayer.playAudio("Music - Route 2.wav");
		frameSetup();
		panelDesign();
	}

	//set up the frame
	private void frameSetup() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(1200,600);
		setLayout(null);
		add(mapScreen);
		setVisible(true);
		setResizable(false);
	}

	//set up the panel
	private void panelDesign() throws IOException {
		//add features for the screen
		mapScreen.setBorder(null);
		mapScreen.setBounds(0, 0, 960,540);
		mapScreen.setLayout(null);
		
		
		try {
            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=Angus+Glen+Community+Center&zoom=13&size=640x320&maptype=roadmap&&key=AIzaSyB_yQfDw3ers-hQDc43gsaK-ssvfCwzVho";
            String destinationFile = "Map/image.jpg";
            String str = destinationFile;
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

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
		
		ImageIcon icon = new ImageIcon((new ImageIcon("Map/image.jpg")).getImage());
		BufferedImage bi = new BufferedImage(
			    icon.getIconWidth(),
			    icon.getIconHeight(),
			    BufferedImage.TYPE_INT_RGB);
			Graphics g = bi.createGraphics();
			// paint the Icon to the BufferedImage.
			icon.paintIcon(null, g, 0,0);
			g.dispose();
		
		
		image.setBounds(0,0,960,540);
		image.setIcon(new ImageIcon(getScaledImage(bi, 960,540) ));
//		image.setIcon(new ImageIcon((new ImageIcon("Map/image.jpg")).getImage().getScaledInstance(1920, 1080, 0)));
		mapScreen.add(image);
		repaint();

	}
	
	//carries out the actions for each of the buttons
	public void actionPerformed(ActionEvent event) {

	}
	
	public static BufferedImage getScaledImage(BufferedImage image, int width, int height) throws IOException {
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
	
}