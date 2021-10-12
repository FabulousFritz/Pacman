package application;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Game extends Scene {
	final public static int WIDTH = 400;
	final public static int HEIGHT = 400;
	final public static int GRID_X = 10;
	final public static int GRID_Y = 10;
	
	private AnimationTimer at;
	private LiveCounter lc;
	private Map map;
	private Player player;
	private Enemy enemy;
	private Pane root;
	private ArrayList<Interaction> inters;

	Game() {
		super(new Pane(), WIDTH, HEIGHT);
		root = (Pane) getRoot();

		initAnimationTimer();

		init();
		initGUI();

		at.start();
		SpecialKeyboard.init(this);
	}
	
	private void initGUI() {
		lc = new LiveCounter(player.getLives());
		root.getChildren().add(lc);
	};
	
	private void updateLiveCounter() {
		lc.update(player);
		int diff = player.getLives() - lc.getTotal();
		if(diff > 0) {
			lc.gainLife();
		}else if(diff < 0) {
			lc.loseLife();
		}
	}
	


	private void init() {
		int level1[][] = { { 2, 0, 0, 0, 0, 1, 1, 0, 0, 4 }, { 0, 1, 1, 1, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 1, 0, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 1, 0, 1, 0, 0 }, { 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 }, { 0, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 0, 1, 1, 1, 1, 0 }, { 5, 0, 0, 0, 0, 0, 0, 0, 0, 3 } };

		map = new Map(level1);
		player = new Player("bob", map);
		enemy = new Enemy("Jack-e", map);
		root.getChildren().add(map);
		initInteractions();
		root.getChildren().add(player);
		root.getChildren().add(enemy);

	}

	private void initInteractions() {
		inters = map.getInters();
		root.getChildren().addAll(inters);
	}

	private void initAnimationTimer() {
		at = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				update();

			}
		};
	}

	private void checkInteractions() {
		int size = Map.tileSize;
		int gridX = (int) player.getLayoutX() / size;
		int gridY = (int) player.getLayoutY() / size;
		try {
			for (Interaction i : inters) {
//				int tileX = (int) i.getX() / size;
//				int tileY = (int) i.getY() / size;
//				if (tileX == gridX && tileY == gridY) {
//					
				if(player.getBoundsInParent().intersects(i.getBoundsInParent())) {
				i.trigger(player);
					i.clear();
					inters.remove(i);
				}
			}
		} catch (java.util.ConcurrentModificationException e) {
		}
	}

	public void update() {
		enemy.update();
		player.update(enemy);
		updateLiveCounter();
		checkInteractions();
		isGameOver();
	}
	
	private void isGameOver() {
		if(!player.isAlive()) {
			at.stop();
			Main.changeSceneTo(new DeadScreen());
		}
	}

}
