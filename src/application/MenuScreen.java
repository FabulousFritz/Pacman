package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MenuScreen {
	/**
	 * Creates the initial screen users see with the option to start the game
	 * 
	 * @param stage Is the main window that displays the information
	 */
	public MenuScreen(Stage stage) {
		Scene startMenu;
		//Label title = new Label("Definitely Not Pac-Man");

		// creates all the buttons players can choose from
		Button startButton = new Button("Start New Game");
		Button aboutButton = new Button("About");
		Button closeGameButton = new Button("Exit Game");

		startButton.setPrefHeight(51);
		startButton.setPrefWidth(225);
		startButton.setFont(Font.font("Impact",FontWeight.EXTRA_BOLD,25));
		startButton.setOnAction(e -> Main.changeSceneTo(new Game()));

		aboutButton.setPrefHeight(51);
		aboutButton.setPrefWidth(225);
		aboutButton.setFont(Font.font("Impact",FontWeight.EXTRA_BOLD,25));
		//aboutButton.setOnAction(e -> new AboutScreen(stage));

		closeGameButton.setPrefHeight(51);
		closeGameButton.setPrefWidth(225);
		closeGameButton.setFont(Font.font("Impact",FontWeight.EXTRA_BOLD,25));
		closeGameButton.setOnAction(e -> stage.close());

		VBox layout = new VBox(4);
		layout.setAlignment(Pos.BOTTOM_CENTER);
		layout.getChildren().addAll(/*title,*/ startButton, aboutButton, closeGameButton);
		startMenu = new Scene(layout, 400, 400);

		startMenu.getStylesheets().add(getClass().getResource("StartBackground.css").toExternalForm());
		stage.setScene(startMenu);
	}
}
