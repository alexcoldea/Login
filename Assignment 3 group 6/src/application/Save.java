package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class in responsible for saving entities such as artworks and profiles.
 * @author Christopher Lee
 * @version 1.0
 */
public class Save {
	//TODO: save artworks, edit artwork bids, save profiles
	
	public static void saveArtwork(Artwork artwork) {
		
	}
	
	public static void savePainting(Painting painting) {
		File file = new File("artworks.txt");
        FileWriter fw = null;
        
        // Method creates file if one doesn't exist.
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("yea i don't know");
            }
        }
        
        try {
            fw = new FileWriter(file, true);
            PrintWriter print = new PrintWriter(fw);
            
            print.write("painting,");
            print.write(painting.getPaintingInformation() + "\n");
            
            print.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }
	}
	
	public static void saveSculpture(Sculpture sculpture) {
		
	}
}
