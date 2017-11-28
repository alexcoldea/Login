package application;

import java.util.*;

/**
 * This class creates sculpture objects that can be used on the Art-A-Tawe
 * system.
 * 
 * @author Matthew Denholm
 * @version 1.0
 */
public class Sculpture extends Artwork {

	private double depth;
	private String material;
	public static ArrayList<Artwork> additionalPhotos = new ArrayList();

	/**
	 * Create a Sculpture object without a description.
	 * 
	 * @param uploader
	 *            The user who uploads the Sculpture.
	 * @param title
	 *            The title of the Sculpture.
	 * @param photoLocation
	 *            The path of where the Sculpture is saved.
	 * @param creatorName
	 *            The name of the artist who created the Sculpture.
	 * @param year
	 *            The year the Sculpture was created.
	 * @param reservePrice
	 *            The reserve price the Sculpture is set at.
	 * @param bidsAllowed
	 *            The number of bids allowed on the Sculpture.
	 * @param date
	 *            The date the Sculpture was uploaded onto the Art-A-Tawe
	 *            system.
	 * @param height
	 *            The height dimension of the Sculpture.
	 * @param width
	 *            The width dimension of the Sculpture.
	 * @param depth
	 *            The depth dimension of the Sculpture.
	 * @param material
	 *            The material the Sculpture is made out of.
	 */
	public Sculpture(String uploader, String title, String photoLocation, String creatorName, String year,
			double reservePrice, int bidsAllowed, String date, double height, double width, double depth,
			String material) {
		super(uploader, title, photoLocation, creatorName, year, reservePrice, bidsAllowed, date);
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.material = material;
	}

	/**
	 * Create a Sculpture object with a description.
	 * 
	 * @param uploader
	 *            The user who uploads the Sculpture.
	 * @param title
	 *            The title of the Sculpture.
	 * @param photoLocation
	 *            The path of where the Sculpture is saved.
	 * @param creatorName
	 *            The name of the artist who created the Sculpture.
	 * @param year
	 *            The year the Sculpture was created.
	 * @param reservePrice
	 *            The reserve price the Sculpture is set at.
	 * @param bidsAllowed
	 *            The number of bids allowed on the Sculpture.
	 * @param date
	 *            The date the Sculpture was uploaded onto the Art-A-Tawe
	 *            system.
	 * @param height
	 *            The height dimension of the Sculpture.
	 * @param width
	 *            The width dimension of the Sculpture.
	 * @param depth
	 *            The depth dimension of the Sculpture.
	 * @param material
	 *            The material the Sculpture is made out of.
	 * @param description
	 *            The description of the Sculpture.
	 */
	public Sculpture(String uploader, String title, String photoLocation, String creatorName, String year,
			double reservePrice, int bidsAllowed, String date, double height, double width, double depth, String material,
			String description) {
		super(uploader, title, photoLocation, creatorName, year, reservePrice, bidsAllowed, date, description);
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.material = material;
	}
	
	
	/**
	 * Gets the type of the Artwork.
	 * 
	 * @return Sculpture.
	 */
	public String getType(){
		return "Sculpture";
	}

	/**
	 * Get the depth of the Sculpture.
	 * 
	 * @return the depth.
	 */
	private double getDepth() {
		return depth;
	}

	/**
	 * Get the material of the Sculpture.
	 * 
	 * @return the material.
	 */
	private String getMaterial() {
		return material;
	}

	/**
	 * Get the information that will be saved to a file.
	 * 
	 * @return the result.
	 */
	public String getSculptureInformation() {
		String result = (getType() + "," + getUploader() + "," + getBidsAllowed() + "," + getPhotoLocation() + "," + getTitle() + ","
				+ getCreatorName() + "," + getYear() + "," + getReservePrice() + "," + getHeight() + "," + getWidth()
				+ "," + getDepth() + "," + getMaterial() + "," + getDate() + ",");
		
		if (getDescription().equals(null)) {
			return result + "empty";
		} else {
			return result + getDescription();
		}
	}

	/**
	 * Get the Sculpture information displayed in a String.
	 * 
	 * @return the result.
	 */
	public String toString() {
		String result = "";
		if (getDescription() == null) {
			result = "Title: " + getTitle() + ", Creator: " + getCreatorName() + ", Year Created: " + getYear() + "\n"
					+ "Reserve Price: �" + getReservePrice() + ", Bids Allowed: " + getBidsAllowed() + "\n" + "Height: "
					+ getHeight() + "m," + " Width: " + getWidth() + "m," + " Depth: " + getDepth() + "m,"
					+ " Material: " + getMaterial() + "\n" + "Date: " + getDate() + "\n";
		} else {
			result = "Title: " + getTitle() + ", Creator: " + getCreatorName() + ", Year Created: " + getYear() + "\n"
					+ "Reserve Price: �" + getReservePrice() + ", Bids Allowed: " + getBidsAllowed() + "\n" + "Height: "
					+ getHeight() + "m," + " Width: " + getWidth() + "m," + " Depth: " + getDepth() + "m,"
					+ " Material: " + getMaterial() + "\n" + "Date: " + getDate() + "\n" + "Description: "
					+ getDescription() + "\n";
		}
		return result;
	}

}
