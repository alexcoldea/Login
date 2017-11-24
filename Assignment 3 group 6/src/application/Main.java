package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	final int PANE_SIZE_WIDTH = 1000;
	final int PANE_SIZE_HEIGHT = 1000;
	final int DISPLAY_IMAGE_WIDTH = 100;
	final int DISPLAY_IMAGE_HEIGHT = 100;

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			VBox left = new VBox();
			VBox right = new VBox();
			root.setLeft(left);
			root.setRight(right);
			Button browseNavButton = new Button("Browse");
			Button sellNavButton = new Button("Sell");
			
			
			browseNavButton.setMaxWidth(Double.MAX_VALUE);
			sellNavButton.setMaxWidth(Double.MAX_VALUE);
			
			left.getChildren().addAll(browseNavButton);
			right.getChildren().addAll(sellNavButton);
			
			
			
			Scene scene = new Scene(root,PANE_SIZE_WIDTH,PANE_SIZE_HEIGHT);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
