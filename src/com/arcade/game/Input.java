package com.arcade.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.arcade.game.Game.STATE;

public class Input extends KeyAdapter{
	
	private GameObjHandler handler;
	private boolean[] keyPressed = new boolean[4];
	
	
	public Input (GameObjHandler handler){
		this.handler = handler;
		keyPressed [0] = false;
		keyPressed [1] = false;
		keyPressed [2] = false;
		keyPressed [3] = false;
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_P) {
			if(Game.gameState == STATE.Game) {
				if(Game.paused) Game.paused = false;
				else Game.paused = true;
			}
		} 
		for(int i = 0; i<handler.object.size(); i++) {
			GameObj tempObject = handler.object.get(i);
			if(tempObject.getId() == Type.Player) {
				if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) { tempObject.setYVel(-handler.spd); keyPressed [0] = true; }
				if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) { tempObject.setYVel(handler.spd); keyPressed [1] = true; }
				if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) { tempObject.setXVel(handler.spd); keyPressed [2] = true; }
				if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) { tempObject.setXVel(-handler.spd); keyPressed [3] = true; }
			}
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		if(key == KeyEvent.VK_SPACE) {
			if(Game.gameState == STATE.Game) Game.gameState = STATE.Shop;
			else if(Game.gameState == STATE.Shop)Game.gameState = STATE.Game;
		}
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i<handler.object.size(); i++) {
			GameObj tempObject = handler.object.get(i);
			if(tempObject.getId() == Type.Player) {
				if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) keyPressed [0] = false; 
				if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) keyPressed [1] = false; 
				if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) keyPressed[2] = false; 
				if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) keyPressed [3] = false; 
				if(!keyPressed [0] && !keyPressed [1]) tempObject.setYVel(0);
				if(!keyPressed [2] && !keyPressed [3]) tempObject.setXVel(0);
			}
		}
	}
	
	
	
	
}