package application;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class DeadScreen extends Scene{
	private VBox pane;

	DeadScreen() {
		super(new VBox(), 400, 400);
		pane = (VBox) getRoot();
		pane.setSpacing(10);

		pane.setAlignment(Pos.CENTER);
		Label title = new Label("HA YOU DIED LOWOSER");
		title.setWrapText(true);
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFont(new Font("IMPACT",80));
		pane.getChildren().add(title);

		initButtons();
		
	}
	
	private void initButtons() {
		Button homeBtn = createButton("GO HOME");
		homeBtn.setOnAction(e -> Main.setMenuScreen());
		Button gameBtn = createButton("PLAY AGAIN");
		gameBtn.setOnAction(e -> Main.changeSceneTo(new Game()));
	
	}
	
	private Button createButton(String label) {
		Button btn = new Button(label);
		btn.setPrefHeight(51);
		btn.setPrefWidth(225);
		pane.getChildren().add(btn);
		return btn;
		
	}
	

}
