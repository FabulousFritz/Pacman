package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.paint.Color;

public class SpeedUp extends Interaction {
	private int speedBuff = 1; //speed
	private int duration = 3000;

	SpeedUp(Tile tile) {
		super(tile, 10);
		setFill(Color.rgb(255, 0, 0));
	}

	@Override
	public void trigger(Player player) {
		addPoints(player);

		Timer buff = new Timer();
		int temp = player.getSpeed();
		player.setSpeed(temp+speedBuff);
		System.out.println("Gotta go kinda quick! " + player.getSpeed());
		
		buff.schedule(new TimerTask() {

			@Override
			public void run() {
				player.setSpeed(temp);
				System.out.println("hold on there buddy " + player.getSpeed());

			}
		}, duration);

	}

}
