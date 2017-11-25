package application;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;

/**
 * This class in responsible for saving entities such as artworks and profiles.
 * @author Christopher Lee
 * @version 1.0
 */
public class Save {
	//TODO: save artworks, edit artwork bids, save profiles
	
	public static void saveArtwork(Artwork artwork) {
		
	}
	
	/**
	 * Saves a specified painting into a text file.
	 * @param painting The specified painting.
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
	
	// I DON'T KNOW IF IT WORKS.
	@SuppressWarnings("unused")
	public static void saveImage(String title, BufferedImage photo) {
		String imagePath = System.getProperty("user.dir") + "/Artwork Photos" + "/" + title + ".jpg";
		Main.photoLocation = imagePath;
		File file = new File(imagePath);
		// Creates file if it doesn't exist.
		if (!file.exists()) {
			try {
				//file.createNewFile();
				ImageIO.write(photo, "jpg", file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Image already exists");
			return;
		}
		
		/*// Saves image onto a file.
		try {
			ImageIO.write((RenderedImage) photo, "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
	}
}
