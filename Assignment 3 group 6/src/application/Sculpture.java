package application;
import java.util.*;

public class Sculpture extends Artwork {

	private double depth;
	private String material;
	public static ArrayList<Artwork> additionalPhotos = new ArrayList();

	// Sculpture without description or additional photos
	public Sculpture(String uploader, String title, String photoLocation, String creatorName, String year, double reservePrice,
			int bidsAllowed, Date date, double height, double width, double depth, String material) {
		super(uploader, title, photoLocation, creatorName, year, reservePrice, bidsAllowed, date);
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.material = material;
	}

	// sculpture with description but no additional photos
	public Sculpture(String uploader, String title, String photoLocation, String creatorName, String year, double reservePrice,
			int bidsAllowed, Date date, double height, double width, double depth, String material,
			String description) {
		super(uploader, title, photoLocation, creatorName, year, reservePrice, bidsAllowed, date, description);
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.material = material;
	}

	private double getHeight() {
		return height;
	}

	private double getWidth() {
		return width;
	}

	private double getDepth() {
		return depth;
	}

	private String getMaterial() {
		return material;
	}
	
	public String getSculptureInformation() {
		return (getUploader()+ "," + getBidsAllowed() + ","+ getPhotoLocation() + "," + getTitle() + "," 
				+ getCreatorName() + "," + getYear() + "," + getReservePrice() + "," + getHeight() + "," 
				+ getWidth() + "," + getDepth() + "," + getMaterial() + "," + getDate() + "," + getDescription());
	}

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
