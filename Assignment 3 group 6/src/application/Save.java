package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

/**
 * This class in responsible for saving entities such as artworks and profiles.
 * 
 * @author Christopher Lee
 * @version 1.0
 */
public class Save {

	public static void saveProfile() {

	}

	public static void saveArtwork(Artwork artwork) {

	}

	/**
	 * Saves a specified painting into a text file.
	 * 
	 * @param painting
	 *            The specified painting.
	 */
	public static void savePainting(Painting painting) {
		File file = new File("artworks.txt");
		FileWriter fw = null;

		// Method creates file if one doesn't exist.
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			// Allows the file to be appendable.
			fw = new FileWriter(file, true);

			PrintWriter print = new PrintWriter(fw);

			// Adds painting in front of the line.
			print.write("painting,");
			print.write(painting.getPaintingInformation() + "\n");

			print.close();
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}

	/**
	 * Saves a specified sculpture onto a text file.
	 * @param sculpture The specified sculpture.
	 */
	public static void saveSculpture(Sculpture sculpture) {
		File file = new File("artworks.txt");
		FileWriter fw = null;

		// Method creates file if one doesn't exist.
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			// Allows the file to be appendable.
			fw = new FileWriter(file, true);

			PrintWriter print = new PrintWriter(fw);

			// Adds painting in front of the line.
			print.write("sculpture,");
			print.write(sculpture.getSculptureInformation() + "\n");

			print.close();
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}

	public static void saveImage(File file, BufferedImage photo) {

		try {

			ImageIO.write(photo, "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void saveAdditionalImage(File file, BufferedImage photo) {

		try {

			ImageIO.write(photo, "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}