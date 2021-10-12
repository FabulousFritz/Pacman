package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Interaction extends Rectangle{
	//asdasdasdasdasd
	protected String ID;
	private int value;
	private Tile tile;
	Interaction(Tile tile, int value){
		double w = Game.WIDTH/Game.GRID_X * 0.3;
		double h = Game.HEIGHT/Game.GRID_Y * 0.3;
		double x = (tile.getWidth()-w)/2 + tile.getX();
		double y = (tile.getHeight()-h)/2 + tile.getY();
		setWidth(w);
		setHeight(h);
		setX(x);
		setY(y);
		this.tile = tile;
		this.value = value;
		tile.setInteraction(this);
	}
	
	public void clear() {
		tile.clear();
		setVisible(false);
	}
	
	protected void addPoints(Player player) {
		player.setScore(player.getScore()+value);
		System.out.println("points: " + value + ", total: " + player.getScore());
		
	}
	public abstract void trigger(Player player);
	

}
