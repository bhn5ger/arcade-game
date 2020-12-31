package com.arcade.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObj{

	Random r = new Random();
	GameObjHandler handler;
	

	public Player(int x, int y, Type id, GameObjHandler handler) {
		super(x, y, id);
		this.handler = handler;

		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)xPos, (int)yPos, 32, 32); 
	}

	public void tick() {
		xPos += xVel;
		yPos += yVel;
		
		xPos = Game.clamp(xPos, 0, Game.WIDTH-38);
		yPos = Game.clamp(yPos, 0, Game.HEIGHT-61);
		
		handler.addObject(new FadeEffect(xPos, yPos, Type.FadeEffect, Color.black, 32, 32, 0.1f, handler));
		collision();
		
	} 


	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObj tempObject = handler.object.get(i);
			 
		
			if(tempObject.getId() == Type.Minion && getBounds().intersects(tempObject.getBounds())) {                             
				HUD.HEALTH -=1;
			}
			if(tempObject.getId() == Type.Zombie && getBounds().intersects(tempObject.getBounds())) {
				HUD.HEALTH -=1;
			}
			if(tempObject.getId() == Type.Bullet && getBounds().intersects(tempObject.getBounds())) {
				HUD.HEALTH -=1;
			}
			if(tempObject.getId() == Type.Charger && getBounds().intersects(tempObject.getBounds())) {
				HUD.HEALTH -=2;
			}
			if(tempObject.getId() == Type.Villan && getBounds().intersects(tempObject.getBounds())) {
				HUD.HEALTH -=3;
			}
			if(tempObject.getId() == Type.Boss && getBounds().intersects(tempObject.getBounds())) {
				HUD.HEALTH -=50;
			}
				 
			
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int)xPos,(int)yPos,32,32);
	
		
	}

}
