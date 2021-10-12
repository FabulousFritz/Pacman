package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle{
	private String ID; // normal, wall, speedUp or speedDown
	private int x; // x position on grid
	private int y; // y position on grid
	private boolean canOverlap = false; // for walls
	private Interaction inter; // for traps and powerups
	private boolean hasTrap; // does tile have trap on it (SPEEDDOWN IS PURPLE, will change later?)
	private boolean hasPowerUp; // does tile have powerup on it (SPEEDUP IS RED, will change later?)

	// ------------------------Constructors---------------------------
	/**
	 * creates a blank Tile object
	 */
	public Tile() {
		ID = "";
		x = 0;
		y = 0;
		hasTrap = false;
		hasPowerUp = false;
	}

	/**
	 * creates a normal Tile object
	 * 
	 * @param id: tile is blank
	 * @param X:  x position on the grid
	 * @param Y:  y position on the grid
	 */
	public Tile(String id, int X, int Y) {
		super(X, Y, 39, 39);
		if (id == "Player Spawn") {
			setFill(Color.rgb(0, 255, 0));
		} else if (id == "Enemy Spawn") {
			setFill(Color.rgb(255, 102, 0));
		} else if (id == "Wall") {
			setFill(Color.rgb(51, 26, 0));
		} else {
			setFill(Color.rgb(0, 102, 0));
		}
		ID = id;
		x = X;
		y = Y;
		hasTrap = false;
		hasPowerUp = false;
	}

	/**
	 * creates a Tile object with interaction
	 * 
	 * @param id:          tile has powerup
	 * @param X:           x position on the grid
	 * @param Y:           y position on the grid
	 * @param interaction: either trap or powerup
	 */
	public Tile(String id, int X, int Y, Interaction interaction) {
		super(X, Y, 39, 39);
		setFill(Color.rgb(0, 102, 0));
		ID = id;
		x = X;
		y = Y;
		inter = interaction;
	}

	// ------------------------Getters and Setters---------------------
	public String getID() {
		return ID;
	}

	public void setID(String id) {
		this.ID = id;
		if (id == "Player Spawn") {
			setFill(Color.rgb(0, 255, 0));
		} else if (id == "Enemy Spawn") {
			setFill(Color.rgb(255, 102, 0));
		} else if (id == "Wall") {
			setFill(Color.rgb(51, 26, 0));
		} else {
			setFill(Color.rgb(0, 102, 0));
		}
	}

	public int getGridX() {
		return x;
	}

	public void setGridX(int x) {
		this.x = x;
	}

	public int getGridY() {
		return y;
	}

	public void setGridY(int y) {
		this.y = y;
	}

	public int[] getPos() {
		int[] temp = new int[2];
		temp[0] = x;
		temp[1] = y;
		return temp;
	}

	public void setPos(int[] pos) {
		pos[0] = this.x;
		pos[1] = this.y;
	}
	
	public void setInteraction(Interaction interaction) {
		this.inter = interaction;
	}

	public boolean isHasTrap() {
		return hasTrap;
	}

	public void setHasTrap(boolean hasTrap) {
		this.hasTrap = hasTrap;
	}

	public boolean isHasPowerUp() {
		return hasPowerUp;
	}

	public void setHasPowerUp(boolean hasPowerUp) {
		this.hasPowerUp = hasPowerUp;
	}

	// ------------------------Other Functions-------------------------

	/**
	 * clears the trap/powerup from the tile
	 */
	public void clear() {
		this.setID("____");
		boolean hasTrap = false;
		boolean hasPowerUp = false;
	};

	/**
	 * prints representation of tile for print console
	 * 
	 * @return
	 */

	public String print() {
		// return "[" + x + "," + y + "]";
		return "[" + this.ID + "]";
	}

}
