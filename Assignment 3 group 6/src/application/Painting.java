package application;

import java.util.*;

/**
 * This class creates painting objects that can be used on the Art-A-Tawe
 * system.
 * 
 * @author Matthew Denholm
 * @version 1.0
 */
public class Painting extends Artwork {

	/**
	 * Create a Painting object without a description.
	 * 
	 * @param uploader
	 *            The user who uploads the Painting.
	 * @param title
	 *            The title of the Painting.
	 * @param photoLocation
	 *            The path of where the Painting is saved.
	 * @param creatorName
	 *            The name of the artist who created the Painting.
	 * @param year
	 *            The year the Painting was created.
	 * @param reservePrice
	 *            The reserve price the Painting is set at.
	 * @param bidsAllowed
	 *            The number of bids allowed on the Painting.
	 * @param date
	 *            The date the Painting was uploaded onto the Art-A-Tawe system.
	 * @param height
	 *            The height dimension of the Painting.
	 * @param width
	 *            The width dimension of the Painting.
	 */
	public Painting(String uploader, String title, String photoLocation, String creatorName, String year,
			double reservePrice, int bidsAllowed, String date, double height, double width) {
		super(uploader, title, photoLocation, creatorName, year, reservePrice, bidsAllowed, date);
		this.height = height;
		this.width = width;
	}

	/**
	 * Create a Painting object with a description.
	 * 
	 * @param uploader
	 *            The user who uploads the Painting.
	 * @param title
	 *            The title of the Painting.
	 * @param photoLocation
	 *            The path of where the Painting is saved.
	 * @param creatorName
	 *            The name of the artist who created the Painting.
	 * @param year
	 *            The year the Painting was created.
	 * @param reservePrice
	 *            The reserve price the Painting is set at.
	 * @param bidsAllowed
	 *            The number of bids allowed on the Painting.
	 * @param date
	 *            The date the Painting was uploaded onto the Art-A-Tawe system.
	 * @param height
	 *            The height dimension of the Painting.
	 * @param width
	 *            The width dimension of the Painting.
	 * @param description
	 *            The description of the Painting.
	 */
	public Painting(String uploader, String title, String photoLocation, String creatorName, String year,
			double reservePrice, int bidsAllowed, String date, double height, double width, String description) {
		super(uploader, title, photoLocation, creatorName, year, reservePrice, bidsAllowed, date, description);
		this.height = height;
		this.width = width;
	}

	/**
	 * Gets the type of the Artwork.
	 * 
	 * @return Painting.
	 */
	public String getType(){
		return "Painting";
	}

	/**
	 * Get the information that will be saved to a file.
	 * 
	 * @return the result.
	 */
	public String getPaintingInformation() {
		String result = (getType() + "," + getUploader() + "," + getBidsAllowed() + "," + getPhotoLocation() + "," + getTitle() + ","
				+ getCreatorName() + "," + getYear() + "," + getReservePrice() + "," + getHeight() + "," + getWidth()
				+ "," + getDate() + ",");
		
		if (getDescription() == null) {
			return result + "empty";
		} else {
			return result + getDescription();
		}
	}

	/**
	 * Get the Painting information displayed in a String.
	 * 
	 * @return the result.
	 */
	public String toString() {
		String result = "";
		if (getDescription().equals("")) {
			result = "Title: " + getTitle() + ", Creator: " + getCreatorName() + ", Year Created: " + getYear() + "\n"
					+ "Reserve Price: �" + getReservePrice() + ", Bids Allowed: " + getBidsAllowed() + "\n" + "Height: "
					+ getHeight() + "m," + " Width: " + getWidth() + "m" + "\n" + "Date: " + getDate() + "\n";
		} else {
			result = "Title: " + getTitle() + ", Creator: " + getCreatorName() + ", Year Created: " + getYear() + "\n"
					+ "Reserve Price: �" + getReservePrice() + ", Bids Allowed: " + getBidsAllowed() + "\n" + "Height: "
					+ getHeight() + "m," + " Width: " + getWidth() + "m" + "\n" + "Date: " + getDate() + "\n"
					+ "Description: " + getDescription() + "\n";
		}
		return result;

	}
}
