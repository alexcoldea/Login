package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is responsible for loading entities such as artworks and profiles.
 * @author Christopher Lee
 * @version 1.0
 */

public class Load {
	//TODO load artworks, load profiles, 
	
	/**
	 * Method to read the file of artworks and returns a list of artworks. The method
	 * should exit the program if an error has occurred.
	 * @return The list of artworks in the file.
	 */
	public static ArrayList<Artwork> loadArtworks() {
		Scanner in = null;
		
		File file = new File("artwork.txt");
		try {
			in = new Scanner(file);
		} catch (Exception e) {
			System.out.println("Unable to open artwork.txt");
			System.exit(1);
		}
		
		return readArtworks(in);
	}
	
	/**
	 * Method to interpret information text file create a list of artworks.
	 * @param in The scanner to read the lines of text.
	 * @return A list of artworks on text file.
	 */
	private static ArrayList<Artwork> readArtworks(Scanner in) {
		ArrayList<Artwork> artworks = new ArrayList<>();
		String artworkType = "";
		String line = "";
		
		while (in.hasNextLine()) {
			try {
				artworkType = in.next();
			} catch (Exception e) {
				artworkType = "empty";
			}
			
			switch (artworkType) {
				case "painting":
					line = in.nextLine();
					artworks.add(createPainting(line));
					break;
				case "sculpture":
					line = in.nextLine();
					artworks.add(createSculpture(line));
					break;
				default:
					break;
			}
		}
		return artworks;
	}
	
	private static Painting createPainting(String line) {
		return null;
	}
	
	private static Sculpture createSculpture(String line) {
		return null;
	}
}
