

package application;

import java.util.*;

/** @author Matthew Denholm
* 	@version
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

	public Artwork(String uploader, String title, String photoLocation, String creatorName, String year, double reservePrice, int bidsAllowed,
			Date date) {
		this.date = date;
		this.uploader = uploader;
		this.title = title;
		this.photoLocation = photoLocation;
		this.creatorName = creatorName;
		this.year = year;
		this.reservePrice = reservePrice;
		this.bidsAllowed = bidsAllowed;
		
	}

	public Artwork(String uploader, String title, String photoLocation, String creatorName, String year, double reservePrice, int bidsAllowed,
			Date date, String description) {
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

	public String getUploader() {
		return uploader;
	}

	public String getPhotoLocation() {
		return photoLocation;
	}

	public String getDescription() {
		return description;
	}

	public String getTitle() {
		return title;
	}


	public String getCreatorName() {
		return creatorName;
	}

	public String getYear() {
		return year;
	}

	public double getReservePrice() {
		return reservePrice;
	}

	public int getBidsAllowed() {
		return bidsAllowed;
	}

	public Date getDate() {
		return date;
	}

}