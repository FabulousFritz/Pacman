package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LiveCounter extends HBox {
	private int total;

	public LiveCounter(int amount) {
		setStyle("-fx-padding: 2;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 2;" + "-fx-border-radius: 2;" + "-fx-border-color: black;");

		setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		setAlignment(Pos.CENTER);
		total = amount;
		setSpacing(10);
		for (int i = 0; i < amount; i++) {
			createLifeCounter();
		}
	}

	public void createLifeCounter() {
		Rectangle life = new Rectangle(0, 0, 10, 10);
		life.setFill(Color.HOTPINK);
		getChildren().add(life);

	}

	public void loseLife() {
		if (total > 0) {
			total--;
			getChildren().remove(0);
		}
	}

	public void gainLife() {
		total++;
		createLifeCounter();

	}

	public void update(Player player) {
		setLayoutX(player.getLayoutX() - (getWidth() - player.getWidth() - 10) / 2);
		setLayoutY(player.getLayoutY() - 25);
		if(player.getLayoutY() - 25 <= 0) {
			setLayoutY(player.getLayoutY() + 30);
		}
		
	}

	public int getTotal() {
		return total;
	}

}
