package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
			
			
			
			scene = new Scene(root,PANE_SIZE_WIDTH,PANE_SIZE_HEIGHT);
			homeScene = scene;
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Scene navigateSell(){
		
		
		BorderPane sellPage = new BorderPane();
		Scene scene = new Scene(sellPage,PANE_SIZE_WIDTH,PANE_SIZE_HEIGHT);
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
			navigatePainting();
			
		});
		
		sculptureNavButton.setOnAction(event -> {
			navigateSculpture();
		});
		
		homeNavButton.setOnAction(event -> {
			stage.setScene(homeScene);
		});
		
		left.getChildren().addAll(paintingNavButton);
		right.getChildren().addAll(sculptureNavButton);
		
		return scene;
	}
	
	public void navigateSculpture(){
		
	}
	
	
	public void navigatePainting(){
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
