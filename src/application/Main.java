
package application;

import java.util.Timer;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	public static Stage root;
	
	public void start(Stage primaryStage) {
		try {
			Main.root = primaryStage;
			new MenuScreen(primaryStage);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			Main.changeSceneTo(new DeadScreen());
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changeSceneTo(Scene s) {
		root.setScene(s);
		
	}
	
	public static void setMenuScreen() {
		MenuScreen scene = new MenuScreen(root);		
	};

	public static void main(String[] args) {
		testJunk();
		launch(args);

	}

	public static void testJunk() {
		//Map test = new Map(10, 10);
		//test.levelOne();
	}
}
