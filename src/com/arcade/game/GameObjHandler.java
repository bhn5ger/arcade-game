package com.arcade.game;

import java.awt.Graphics;
import java.util.LinkedList;

public class GameObjHandler { 
	
	LinkedList<GameObj> object = new LinkedList<GameObj>();
	public int spd = 5;
	
	public void tick() {
		for(int i = 0; i<object.size(); i++) {
			GameObj tempObject = object.get(i);
			tempObject.tick();
		}
		
	}
	public void render(Graphics g){
		for(int i = 0; i<object.size(); i++) {
				GameObj tempObject = object.get(i);
				tempObject.render(g);
		}
	}
	
	public void clearEnemies() {
		for(int i = 0; i< object.size(); i++) {
				GameObj tempObject = object.get(i);
				if(tempObject.getId() == Type.Player) {
					object.clear();
					if(Game.gameState != Game.STATE.End) {
						addObject(new Player((int)tempObject.getXPos(),(int)tempObject.getYPos(), Type.Player, this ));
					}
			}
		}
	}
	
	
	public void addObject(GameObj object) {
		this.object.add(object);
	}
	public void removeObject(GameObj object) {
		this.object.remove(object);
		
	}
	public void setSpeed(int spd) {
		this.spd = spd;
		
	}

}