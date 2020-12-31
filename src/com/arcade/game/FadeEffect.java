package com.arcade.game;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class FadeEffect extends GameObj{
	private float alpha = 1;
	private GameObjHandler handler;
	private Color color;
	private int width, height;
	private float life;
	
	
	public FadeEffect(float x, float y, Type id, Color color, int width, int height, float life, GameObjHandler handler) {
		super(x,y,id);
		this.handler = handler;
		this.color = color;
		this.height = height;
		this.width = width;
		this.life = life;
	}


	public void tick() {
		if(alpha > life) {
			alpha -= life - 0.0001f;
		}else handler.removeObject(this);
		
	}


	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect((int)xPos, (int)yPos, width, height);
		g2d.setComposite(makeTransparent(1));
		
	}

	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type, alpha));
		
	}
	public Rectangle getBounds() {
	
		return null;
	}
	
	

}