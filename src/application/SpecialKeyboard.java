package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SpecialKeyboard {
	public static ArrayList<KeyCode>activeLists;
	
	public static void init(Scene scene) {
		activeLists = new ArrayList<KeyCode>();
		scene.setOnKeyPressed(event -> onPress(event));
		scene.setOnKeyReleased(event -> onRelease(event));
	}
	
	public static boolean checkKey(KeyCode kc) {
		if(activeLists.contains(kc)) return true;
		return false;
	}
	
	private static void onPress(KeyEvent e) {
		if(!activeLists.contains(e.getCode())) activeLists.add(e.getCode());
	}
	
	private static void onRelease(KeyEvent e) {
		activeLists.remove(e.getCode());
		
	}

}
