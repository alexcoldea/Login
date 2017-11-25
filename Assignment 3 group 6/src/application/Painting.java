package application;
import java.util.*;

import javafx.scene.image.Image;

public class Painting extends Artwork {

	// Painting without description
	public Painting(String uploader, String title, Image photo, String creatorName, String year, double reservePrice,
			int bidsAllowed, Date date, double height, double width) {
		super(uploader, title, photo, creatorName, year, reservePrice, bidsAllowed, date);
		this.height = height;
		this.width = width;
	}

	// Painting with description
	public Painting(String uploader, String title, Image photo, String creatorName, String year, double reservePrice,
			int bidsAllowed, Date date, double height, double width, String description) {
		super(uploader, title, photo, creatorName, year, reservePrice, bidsAllowed, date, description);
		this.height = height;
		this.width = width;
	}

	private double getHeight() {
		return height;
	}

	private double getWidth() {
		return width;
	}
	
	public String getPaintingInformation() {
		return (getUploader() + "," + getTitle() + "," + getCreatorName() + "," + getYear() + "," + getReservePrice() 
				+ "," + getBidsAllowed() + "," + getHeight() + "," + getWidth() + "," + getDate() + ","
				+ getDescription());
	}

	public String toString() {
		String result = "";
		if (getDescription() == null) {
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
