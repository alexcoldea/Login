
package application;

import java.util.*;

/**
 * This class creates artwork objects that can be used on the Art-A-Tawe system.
 * 
 * @author Matthew Denholm
 * @version 1.0
 */
public class Artwork {

	protected String title;
	protected String uploader;
	protected String photoLocation;
	protected String creatorName;
	protected String year;
	protected double reservePrice;
	protected int bidsAllowed;
	protected String description;
	protected Date date;
	protected double height;
	protected double width;
	public static ArrayList<Artwork> artworkList = new ArrayList<Artwork>();
	public static ArrayList<Artwork> usersArtworkList = new ArrayList<Artwork>();

	/**
	 * Create an Artwork object without a description.
	 * 
	 * @param uploader
	 *            The uploader of the Artwork.
	 * @param title
	 *            The title of the Artwork.
	 * @param photoLocation
	 *            The path of where the Artwork is saved.
	 * @param creatorName
	 *            The name of the Artist who created the Artwork.
	 * @param year
	 *            The year the Artwork was created.
	 * @param reservePrice
	 *            The reserve price the Artwork is set at.
	 * @param bidsAllowed
	 *            The number of bids allowed on the Artwork.
	 * @param date
	 *            The date the Artwork was uploaded onto the Art-A-Tawe system.
	 */
	public Artwork(String uploader, String title, String photoLocation, String creatorName, String year,
			double reservePrice, int bidsAllowed, Date date) {
		this.date = date;
		this.uploader = uploader;
		this.title = title;
		this.photoLocation = photoLocation;
		this.creatorName = creatorName;
		this.year = year;
		this.reservePrice = reservePrice;
		this.bidsAllowed = bidsAllowed;

	}

	/**
	 * Create an Artwork object with a description.
	 * 
	 * @param uploader
	 *            The uploader of the Artwork.
	 * @param title
	 *            The title of the Artwork.
	 * @param photoLocation
	 *            The path of where the Artwork is saved.
	 * @param creatorName
	 *            The name of the Artist who created the Artwork.
	 * @param year
	 *            The year the Artwork was created.
	 * @param reservePrice
	 *            The reserve price the Artwork is set at.
	 * @param bidsAllowed
	 *            The number of bids allowed on the Artwork.
	 * @param date
	 *            The date the Artwork was uploaded onto the Art-A-Tawe system.
	 * @param description
	 *            The description of the Artwork
	 */
	public Artwork(String uploader, String title, String photoLocation, String creatorName, String year,
			double reservePrice, int bidsAllowed, Date date, String description) {
		this.date = date;
		this.title = title;
		this.uploader = uploader;
		this.description = description;
		this.photoLocation = photoLocation;
		this.creatorName = creatorName;
		this.year = year;
		this.reservePrice = reservePrice;
		this.bidsAllowed = bidsAllowed;

	}

	/**
	 * Get the uploader of the Artwork.
	 * 
	 * @return the uploader.
	 */
	public String getUploader() {
		return uploader;
	}

	/**
	 * Get the location of where the artwork is stored.
	 * 
	 * @return the location of the photo.
	 */
	public String getPhotoLocation() {
		return photoLocation;
	}

	/**
	 * Get the description of the artwork.
	 * 
	 * @return the artwork description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Get the title of the artwork.
	 * 
	 * @return the artwork title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Get the creator's name of the artwork.
	 * 
	 * @return the name of the creator.
	 */
	public String getCreatorName() {
		return creatorName;
	}

	/**
	 * Get the year the artwork was created.
	 * 
	 * @return the year.
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Get the user defined reserve price of the artwork.
	 * 
	 * @return the reserve price.
	 */
	public double getReservePrice() {
		return reservePrice;
	}

	/**
	 * Get the user defined number of bids allowed on the artwork.
	 * 
	 * @return the number of bids allowed.
	 */
	public int getBidsAllowed() {
		return bidsAllowed;
	}

	/**
	 * Get the date of when the artwork was uploaded.
	 * 
	 * @return the date.
	 */
	public Date getDate() {
		return date;
	}

}