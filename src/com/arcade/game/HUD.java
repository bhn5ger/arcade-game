package com.arcade.game;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	public int bounds = 0; 
	public static float HEALTH = 100;
	private float greenValue = 255;
	private int score = 0;
	private int level = 1;
	
	
	
	public void tick() {
		
		HEALTH = Game.clamp(HEALTH, 0, 100 + (bounds/2));
		greenValue = HEALTH * 2;
		greenValue = Game.clamp(greenValue, 0, 255);
		score+=10;
		
	}
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 400, 200 + bounds, 16);
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(15, 400, (int)HEALTH * 2, 16);
		g.setColor(Color.black);
		g.drawRect(15, 400, 200 + bounds, 16);
		
		g.setColor(Color.white);
		g.drawString("Score : " + score, 15, 362);
		g.drawString("Level : " + level, 15, 377);
		g.drawString("Space for Shop", 15, 392); 
		
		
	}
	public void setScore(int score) {
		this.score = score;
		
	}
	public int getScore() {
		return score;
		
	}
	public int getLevel() {
		return level;
		
	}
	public void setLevel(int level) {
		this.level = level;
		
	}
	public void setBounds(int bounds) {
		this.bounds = bounds;
		
		
	}
	
	
}
