package application;

import java.util.Date;

import javafx.application.Application;
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
	Scene scene;
	Stage stage;
	Scene homeScene;
	Image image;
	TextField uploaderBox = new TextField();
	TextField titleBox = new TextField();
	TextField creatorNameBox = new TextField();
	TextField yearBox = new TextField();
	TextField reservePriceBox = new TextField();
	TextField bidsAllowedBox = new TextField();
	TextField heightBox = new TextField();
	TextField widthBox = new TextField();
	ImageView myImageView = new ImageView();

	String uploader;
	String title;
	String creatorName;
	String year;
	double reservePrice;
	int bidsAllowed;
	Date date;
	double height;
	double width;

	@Override
	public void start(Stage primaryStage) {
		try {
			this.stage = primaryStage;
			BorderPane root = new BorderPane();
			VBox left = new VBox();
			VBox right = new VBox();
			Label homePageLabel = new Label("Home Page");
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
		VBox left = new VBox();
		VBox right = new VBox();
		sellPage.setLeft(left);
		sellPage.setRight(right);
		Button paintingNavButton = new Button("Sell Painting");
		Button sculptureNavButton = new Button("Sell Sculpture");
		Button homeNavButton = new Button("Home");
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
		VBox left = new VBox();
		VBox right = new VBox();
		Button createPaintingButton = new Button("Create Artwork");
		Button homeNavButton = new Button("Home");
		paintingPage.setBottom(homeNavButton);

		createPaintingButton.setMaxWidth(Double.MAX_VALUE);
		Label paintingLabel = new Label("Painting");
		left.getChildren().addAll(createPaintingButton, paintingLabel, uploaderBox, titleBox, creatorNameBox, yearBox,
				reservePriceBox, bidsAllowedBox, heightBox, widthBox);

		createPaintingButton.setOnAction(event -> {
			createPainting();

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
		VBox left = new VBox();
		VBox right = new VBox();
		Button createSculpture = new Button("Create Sculpture");

		Button homeNavButton = new Button("Home");
		sculpturePage.setBottom(homeNavButton);

		homeNavButton.setOnAction(event -> {
			stage.setScene(homeScene);
		});

		left.getChildren().addAll(createSculpture);

		sculpturePage.setLeft(left);
		sculpturePage.setRight(right);
		return scene;
	}

	public void createPainting() {
		try {
			String uploader = uploaderBox.getText();
			title = titleBox.getText();
			String creatorName = creatorNameBox.getText();
			String year = yearBox.getText();
			double reservePrice = Double.parseDouble(reservePriceBox.getText());
			int bidsAllowed = Integer.parseInt(bidsAllowedBox.getText());
			Date date = new Date();
			double height = Double.parseDouble(heightBox.getText());
			double width = Double.parseDouble(widthBox.getText());

			Painting test = new Painting(uploader, title, image, creatorName, year, reservePrice, bidsAllowed, date,
					height, width);

			Artwork.artworkList.add(test);
		} catch (NumberFormatException e) {
			System.out.println("Error, Please do not leave a field empty");
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
