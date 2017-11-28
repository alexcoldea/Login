package application;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		in.useDelimiter(",");
		
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
	
	/**
	 * Method interprets a line of data and creates a painting from that data.
	 * @param line A string of data relating to a painting.
	 * @return A painting specified in the line.
	 * @throws ParseException 
	 */
	private static Painting createPainting(String line){
		Scanner in = new Scanner(line);
		in.useDelimiter(",");
		
		String uploader = in.next();
		int bids = in.nextInt();
		String photo = in.next();
		String title = in.next();
		String creator = in.next();
		String year = in.next();
		double price = in.nextDouble();
		double height = in.nextDouble();
		double width = in.nextDouble();
		
		// Converts String to Date
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		Date date;
		try {
			date = df.parse(in.next());
		} catch (ParseException e) {
			date = null;
			System.out.println("Date could not be loaded");
			e.printStackTrace();
		}
		
		String desc = in.next();
		
		in.close();
		
		if (desc == null) {
			return new Painting(uploader, title, photo, creator, year, price, bids, date, height, width);
		} else {
			return new Painting(uploader, title, photo, creator, year, price, bids, date, height, width, desc);
		}
	}
	
	
	private static Sculpture createSculpture(String line) {
		return null;
	}
}
