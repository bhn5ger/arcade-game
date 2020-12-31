package com.arcade.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends GameObj{
	private GameObjHandler handler;
	private GameObj player;
	Random r = new Random();
	private int timer = 10;
	private int timer2 = 50;
	private Color col;

	public Enemy(int x, int y, Type id, GameObjHandler handler) {
		super(x, y, id);
		this.handler = handler;
		if(id == Type.Minion) {
			xVel = 5;
			yVel = 5;
		}
		else if(id == Type.Charger) {
			xVel = 2;
			yVel = 9;
		}
		else if(id == Type.Zombie) {
			for(int i = 0; i < handler.object.size(); i++) {
				if(handler.object.get(i).getId() == Type.Player) player = handler.object.get(i);
			}
		}
		else if(id == Type.Boss) {
			xVel = 0;
			yVel = 2;
		}
		else if(id == Type.Bullet) {
			xVel = (r.nextInt(5 - -5) + -5);
			yVel = 5;
		}
		else if(id == Type.Particle) {
			xVel = 0;
			yVel = 7;
			col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		}
		else if(id == Type.Villan) {
			xVel = 5;
			yVel = 5;
		}
		
		
	}

	public Rectangle getBounds() {
		if(id == Type.Boss) {
			return new Rectangle((int)xPos, (int)yPos, 96, 96); 
		}
		else{
			return new Rectangle((int)xPos, (int)yPos, 16, 16); 
		}
	}

	public void tick() {
		xPos += xVel;
		yPos += yVel;
		
		if(id == Type.Minion) {
			if(yPos <= 0 || yPos >= Game.HEIGHT - 32) yVel *= -1;
			if(xPos <= 0 || xPos >= Game.WIDTH - 16) xVel *= -1;
			handler.addObject(new FadeEffect(xPos, yPos, Type.FadeEffect, Color.red, 16, 16, 0.02f, handler));
		}
		else if(id == Type.Charger) {
			if(yPos <= 0 || yPos >= Game.HEIGHT - 32) yVel *= -1;
			if(xPos <= 0 || xPos >= Game.WIDTH - 16) xVel *= -1;
			handler.addObject(new FadeEffect(xPos, yPos, Type.FadeEffect, Color.CYAN, 16, 16, 0.02f, handler));
			
		}
		else if(id == Type.Zombie) {
			float diffX = xPos - player.getXPos() - 16;
			float diffY = yPos - player.getYPos() - 16;
			float distance = (float )Math.sqrt((xPos-player.getXPos())*(xPos-player.getXPos()) + (yPos-player.getYPos())*(yPos-player.getYPos()));
			xVel = ((-1/distance) * diffX);
			yVel = ((-1/distance) * diffY);
			handler.addObject(new FadeEffect(xPos, yPos, Type.FadeEffect, Color.green, 16, 16, 0.02f, handler));
		}
		else if(id == Type.Boss) {
			if(timer <= 0) yVel = 0;
			else timer--;
			if(timer <= 0) timer2--;
			if(timer2 <= 0) {
				if(xVel == 0) xVel = 2;
				int spawn = r.nextInt(5);
				if(spawn == 0) handler.addObject(new Enemy((int)xPos+48, (int)yPos+48, Type.Bullet, handler));	
			}
			if(xPos <= 0 || xPos >= Game.WIDTH - 96) xVel *= -1;
		}
		else if(id == Type.Bullet) {
			if(yPos>= Game.HEIGHT) handler.removeObject(this);
			handler.addObject(new FadeEffect(xPos, yPos, Type.FadeEffect, Color.red, 16, 16, 0.02f, handler));
		}
		else if(id == Type.Particle) {
			if(yPos <= 0 || yPos >= Game.HEIGHT - 32) yVel *= -1;
			if(xPos <= 0 || xPos >= Game.WIDTH - 16) xVel *= -1;
			handler.addObject(new FadeEffect(xPos, yPos, Type.FadeEffect, col, 16, 16, 0.05f, handler));
		}
		else if(id == Type.Villan) {
			if(yPos <= 0 || yPos >= Game.HEIGHT - 32) { 
				if(yVel<0) yVel = -(r.nextInt(7)+1) * -1;
				else yVel = (r.nextInt(7)+1) * -1;
			}
			if(xPos <= 0 || xPos >= Game.WIDTH - 16) {
				if(xVel<0) xVel = -(r.nextInt(7)+1) * -1;
				else xVel = (r.nextInt(7)+1) * -1;
			}
			handler.addObject(new FadeEffect(xPos, yPos, Type.FadeEffect, Color.yellow, 16, 16, 0.02f, handler));
		}

	}


	public void render(Graphics g) {
		
		if(id == Type.Minion) {
			g.setColor(Color.red);
		}
		else if(id == Type.Charger) {
			g.setColor(Color.CYAN);
		}
		else if(id == Type.Zombie) {
			g.setColor(Color.green);
		}
		else if(id == Type.Boss) {
			g.setColor(Color.red);
		}
		else if(id == Type.Bullet) {
			g.setColor(Color.red);
		}
		else if(id == Type.Particle) {
			g.setColor(col);
		}
		else if(id == Type.Villan) {
			g.setColor(Color.yellow);
		}
		
		
		if(id == Type.Boss) {
			g.fillRect((int)xPos,(int)yPos, 96,96);
		}
		else {
			g.fillRect((int)xPos,(int)yPos, 16,16);
		}
		

	
		
	}


 

}