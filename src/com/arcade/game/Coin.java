package com.arcade.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Coin extends GameObj{

	private GameObjHandler handler;
	private HUD hud;
	
	public Coin(int x, int y, Type id, GameObjHandler handler, HUD hud) {
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)xPos, (int)yPos, 16, 16); 
	}

	public void tick() {
		
		collision();
		
	} 


	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObj tempObject = handler.object.get(i);

			if(tempObject.getId() == Type.Player && getBounds().intersects(tempObject.getBounds())) {                             
				hud.setScore(hud.getScore() + 500);
				handler.removeObject(this);
			}
		}
	}



	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)xPos,(int)yPos, 16, 16);

		
	}

}