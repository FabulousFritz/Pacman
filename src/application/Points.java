package application;

import javafx.scene.paint.Color;

public class Points extends Interaction{
	Points(Tile tile) {
		super(tile, 5);
		setFill(Color.YELLOW);
	}

	@Override
	public void trigger(Player player) {
		addPoints(player);

		
	}

}
