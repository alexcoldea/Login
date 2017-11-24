package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Main extends Application {

	final int PANE_SIZE_WIDTH = 1000;
	final int PANE_SIZE_HEIGHT = 1000;
	final int DISPLAY_IMAGE_WIDTH = 100;
	final int DISPLAY_IMAGE_HEIGHT = 100;
	private Scene scene;
	private Stage stage;
	private Scene homeScene;
	private Image image;
	private TextField uploaderBox = new TextField();
	private TextField titleBox = new TextField();
	private TextField creatorNameBox = new TextField();
	private TextField yearBox = new TextField();
	private TextField reservePriceBox = new TextField();
	private TextField bidsAllowedBox = new TextField();
	private TextField heightBox = new TextField();
	private TextField widthBox = new TextField();
	private TextField depthBox = new TextField();
	private TextField materialBox = new TextField();
	private ImageView imageViewer = new ImageView();
	private Button homeNavButton = new Button("Home");

	private String uploader;
	private String title;
	private String creatorName;
	private String year;
	private double reservePrice;
	private int bidsAllowed;
	private double height;
	private double width;
	private double depth;
	private String material;
	private Label errorLabel = new Label("");
	private BufferedImage bufferedImage;

	@Override
	public void start(Stage primaryStage) {
		try {
			this.stage = primaryStage;
			BorderPane root = new BorderPane();
			VBox left = new VBox();
			VBox right = new VBox();
			Label homePageLabel = new Label("Home Page (Place Holder)");
			root.setLeft(left);
			root.setRight(right);
			root.setCenter(homePageLabel);
			Button browseNavButton = new Button("Browse");
			Button sellNavButton = new Button("Sell");

			sellNavButton.setOnAction(event -> {
				stage.setScene(navigateSell());
			});

			browseNavButton.setMaxWidth(Double.MAX_VALUE);
			sellNavButton.setMaxWidth(Double.MAX_VALUE);

			left.getChildren().addAll(browseNavButton);
			right.getChildren().addAll(sellNavButton);

			scene = new Scene(root, PANE_SIZE_WIDTH, PANE_SIZE_HEIGHT);
			homeScene = scene;

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Scene navigateSell() {

		BorderPane sellPage = new BorderPane();
		Scene scene = new Scene(sellPage, PANE_SIZE_WIDTH, PANE_SIZE_HEIGHT);
		Label sellPageLabel = new Label("Sell Page (Place Holder)");
		sellPage.setCenter(sellPageLabel);
		VBox left = new VBox();
		VBox right = new VBox();
		sellPage.setLeft(left);
		sellPage.setRight(right);
		Button paintingNavButton = new Button("Sell Painting");
		Button sculptureNavButton = new Button("Sell Sculpture");
		sellPage.setBottom(homeNavButton);
		paintingNavButton.setMaxWidth(Double.MAX_VALUE);
		sculptureNavButton.setMaxWidth(Double.MAX_VALUE);

		paintingNavButton.setOnAction(event -> {
			stage.setScene(navigatePainting());

		});

		sculptureNavButton.setOnAction(event -> {
			stage.setScene(navigateSculpture());
		});

		homeNavButton.setOnAction(event -> {
			stage.setScene(homeScene);
		});

		left.getChildren().addAll(paintingNavButton);
		right.getChildren().addAll(sculptureNavButton);

		return scene;
	}

	public Scene navigatePainting() {
		BorderPane paintingPage = new BorderPane();
		Scene scene = new Scene(paintingPage, PANE_SIZE_WIDTH, PANE_SIZE_HEIGHT);
		paintingPage.setCenter(imageViewer);
		VBox left = new VBox();
		VBox right = new VBox();
		Button createPaintingButton = new Button("Create Painting");
		Button loadPaintingButton = new Button("Load Painting Image");
		Button loadImageTestButton = new Button("View test image");

		paintingPage.setBottom(homeNavButton);

		createPaintingButton.setMaxWidth(Double.MAX_VALUE);
		Label paintingLabel = new Label("Painting");
		left.getChildren().addAll(createPaintingButton, paintingLabel, uploaderBox, titleBox, creatorNameBox, yearBox,
				reservePriceBox, bidsAllowedBox, heightBox, widthBox, errorLabel);

		right.getChildren().addAll(loadPaintingButton, loadImageTestButton);
		createPaintingButton.setOnAction(event -> {
			createPainting();

		});

		loadImageTestButton.setOnAction(event -> {
			imageViewer.setImage(image);
			imageViewer.setFitWidth(DISPLAY_IMAGE_WIDTH);
			imageViewer.setFitHeight(DISPLAY_IMAGE_HEIGHT);

		});

		loadPaintingButton.setOnAction(event -> {
			imageLoader();

		});

		homeNavButton.setOnAction(event -> {
			stage.setScene(homeScene);
		});

		paintingPage.setLeft(left);
		paintingPage.setRight(right);
		return scene;

	}

	public Scene navigateSculpture() {

		BorderPane sculpturePage = new BorderPane();
		Scene scene = new Scene(sculpturePage, PANE_SIZE_WIDTH, PANE_SIZE_HEIGHT);
		sculpturePage.setCenter(imageViewer);
		VBox left = new VBox();
		VBox right = new VBox();
		Button createSculptureButton = new Button("Create Sculpture");
		Button loadSculptureButton = new Button("Load Sculpture Image");
		Button loadImageTestButton = new Button("View test image");
		sculpturePage.setBottom(homeNavButton);

		createSculptureButton.setMaxWidth(Double.MAX_VALUE);
		Label sculptureLabel = new Label("Sculpture");
		left.getChildren().addAll(createSculptureButton, sculptureLabel, uploaderBox, titleBox, creatorNameBox, yearBox,
				reservePriceBox, bidsAllowedBox, heightBox, widthBox, depthBox, materialBox, errorLabel);

		right.getChildren().addAll(loadSculptureButton, loadImageTestButton);
		createSculptureButton.setOnAction(event -> {
			createSculpture();

		});

		loadImageTestButton.setOnAction(event -> {
			imageViewer.setImage(image);
			imageViewer.setFitWidth(DISPLAY_IMAGE_WIDTH);
			imageViewer.setFitHeight(DISPLAY_IMAGE_HEIGHT);

		});
		
		loadSculptureButton.setOnAction(event -> {
			imageLoader();

		});

		homeNavButton.setOnAction(event -> {
			stage.setScene(homeScene);
		});

		sculpturePage.setLeft(left);
		sculpturePage.setRight(right);
		return scene;
	}

	public void createPainting() {
		try {
			uploader = uploaderBox.getText();
			title = titleBox.getText();
			creatorName = creatorNameBox.getText();
			year = yearBox.getText();
			reservePrice = Double.parseDouble(reservePriceBox.getText());
			bidsAllowed = Integer.parseInt(bidsAllowedBox.getText());
			Date date = new Date();
			height = Double.parseDouble(heightBox.getText());
			width = Double.parseDouble(widthBox.getText());

			Painting painting = new Painting(uploader, title, image, creatorName, year, reservePrice, bidsAllowed, date,
					height, width);

			Artwork.artworkList.add(painting);
		} catch (NumberFormatException e) {
			errorLabel.setText("Error, Please do not leave a field empty");
		}

	}

	public void createSculpture() {
		try {
			uploader = uploaderBox.getText();
			title = titleBox.getText();
			creatorName = creatorNameBox.getText();
			year = yearBox.getText();
			reservePrice = Double.parseDouble(reservePriceBox.getText());
			bidsAllowed = Integer.parseInt(bidsAllowedBox.getText());
			Date date = new Date();
			height = Double.parseDouble(heightBox.getText());
			width = Double.parseDouble(widthBox.getText());
			depth = Double.parseDouble(depthBox.getText());
			material = materialBox.getText();

			Sculpture sculpture = new Sculpture(uploader, title, image, creatorName, year, reservePrice, bidsAllowed,
					date, height, width, depth, material);

			Artwork.artworkList.add(sculpture);
		} catch (NumberFormatException e) {
			errorLabel.setText("Error, Please do not leave a field empty");
		}

	}

	public void imageLoader() {
		FileChooser imageFinder = new FileChooser();

		// Filters for extensions (PNGs and JPGs)
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
		imageFinder.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

		// Window Opener
		File file = imageFinder.showOpenDialog(null);

		try {
			bufferedImage = ImageIO.read(file);
			image = SwingFXUtils.toFXImage(bufferedImage, null);
		} catch (IOException e) {
			throw new IllegalArgumentException("Unable to load " + file, e);
		} catch (IllegalArgumentException e) {
			System.out.println("Error, No image selected");
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
