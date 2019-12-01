package dad.javafx.app;

import dad.javafx.mvc.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	Controller controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new Controller();
		
		Scene scene = new Scene(controller.getRootView(), 320, 200);
		
		primaryStage.setTitle("Inicio sesión");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
