package com.arcade.game;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObj {
	
	protected float xPos, yPos, xVel, yVel;
	protected Type id;
	
	public void setXPos(int x) {
		this.xPos = x;	
	}
	public void setYPos(int y) {
		this.yPos = y;
	}
	public float getXPos() {
		return xPos;
	}
	public float getYPos() {
		return yPos;
	}
	public void setId(Type id) {
		this.id = id;
	}
	public Type getId() {
		return id;
	}
	public float getXVel() {
		return xVel;
	}
	public void setXVel(int velX) {
		this.xVel = velX;
	}
	public float getYVel() {
		return yVel;
	}
	public void setYVel(int velY) {
		this.yVel = velY;
	}
	
	public GameObj(float x, float y, Type id) {
		this.xPos = x;
		this.yPos = y;
		this.id = id;
	}
	
	public abstract void tick(); 
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	

}
