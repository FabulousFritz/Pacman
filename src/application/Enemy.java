package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Enemy extends Rectangle{
	//-------------------------------------Initializing the necessary variables------------------------------------------
	private String name;
	private int speed;
	private int gridX;
	private int gridY;
	private Map map;
	Tile spawnTile;
	private int tileSize = 39;
	private int enemySize = 20;
	// TODO: path pattern

	//------------------------------------------------Constructors--------------------------------------------------------
	/**
	 * Create an Enemy with a specific name
	 * 
	 * @param name 
	 * @param map 
	 */
	public Enemy(String name, Map map) {
		super(375,375,20,20);
		//setWidth
		//setHeight
		setFill(Color.RED);
		setName(name);
		setSpeed(2);
		this.map = map;
		spawnTile = map.getEnemySpawn();
		setGridX((int)spawnTile.getLayoutX() + ((tileSize - enemySize)/ 2));
		setGridY((int)spawnTile.getLayoutY() + ((tileSize - enemySize)/ 2));
		setLayoutX(gridX);
		setLayoutY(gridY);
	}
	
	//--------------------------------------------Getters and Setters----------------------------------------------------
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getSpeed() {
			return speed;
		}

		public void setSpeed(int speed) {
			this.speed = speed;
		}

		public int getGridX() {
			return gridX;
		}

		public void setGridX(int x) {
			gridX = x;
		}

		public int getGridY() {
			return gridY;
		}

		public void setGridY(int y) {
			gridY = y;
		}
		
		public Map getMap() {
			return map;
		}
		
		public void setMap(Map map) {
			this.map = map;
		}
		
	//--------------------------------------------Other Functions----------------------------------------------------
		
		public void update() {
			move();
			
			//to add: things to change
			//change x and y coords
			//moving in a fixed route
			//attacking (later thing)
			
		}
		
		public void increaseSpeed() {
			
		}
		
		public void decreaseSpeed() {
			
		}
		
		public void move() {
			if (getLayoutX() > -370.0) {
				//System.out.println(getLayoutX());
				//gridX = (int)getLayoutX()/tileSize;
				moveX(-speed); // move enemy left
				//System.out.println("gridX is: " + gridX);
			} else if (getLayoutY() > -370.0) {
				moveY(-speed);
			}
			
			
			
			
			
			
			
			
			
			
		}
		
		public void moveX(int x) {
			setLayoutX(getLayoutX() + x);
		}
		
		public void moveY(int y) {
			setLayoutY(getLayoutY() + y);
		}
}
