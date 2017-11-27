package view.fixed;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.ImageObject;

public class ChestImage extends ImageObject {

	// *************************************************
	// Fields

	// get screen's dimensions
	private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private double screenRatio = screenWidth / screenHeight;

	// set the image's dimensions
	private int imgWidth = 32;
	private int imgHeight = 32;

	private int frameCount = 2;
	private int picNum = 0;

	private BufferedImage[] pics = new BufferedImage[frameCount];

	public ChestImage() {
		int xLoc = 0;
		int yLoc = 0;
		super.setName("chest");

		// load in the image
		BufferedImage image = createImage("images/world/Chest.png");
		for (int i = 0; i < frameCount; i++) {
			pics[i] = image.getSubimage(xLoc, yLoc, imgWidth, imgHeight);
			xLoc = xLoc + 32;
		}

	}

	// *************************************************
	// Methods

	// The String imageFile is the input to the method, and is the file name
	private BufferedImage createImage(String imageFile) {
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File(imageFile));
			return bufferedImage;
		} catch (IOException e) {
			System.out.println("Error with file upload");
			e.printStackTrace();
		}
		return null;
	}

	// return the image
	public BufferedImage show(int direct) {
		return pics[picNum];
	}

	// setter
	public void nextImage(boolean canAnimate) {
		// check to see if the next index exists
		if (canAnimate) {
			picNum = 1;
		} else {
			picNum = 0;
		}
	}

	// *************************************************
	// Getters

	// getter for the image dimensions
	public int getWidth() {
		return imgWidth;
	}

	public int getHeight() {
		return imgHeight;
	}

}