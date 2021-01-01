package com.arcade.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.arcade.game.Game.STATE;

public class Store extends MouseAdapter{
	
	GameObjHandler handler;
	HUD hud;
	private int [] prices = {1000, 1000, 1000};
	
	public Store(GameObjHandler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		
		
	}
	public void render (Graphics g) {
		Font fnt = new Font("courier", 3, 50);
		Font fnt2 = new Font("courier", 1, 30);
		Font fnt3 = new Font("courier", 1, 15);
		Font fnt4 = new Font("courier", 3, 15);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Store", 235, 65);
		
		g.setFont(fnt2);
		g.drawString("Press Space to Go Back", 120, 413);
		
		
		g.setFont(fnt3);
		g.drawString("Click on a box to purchase the corresponding item. You", 45, 98);
		g.drawString("currently have " + hud.getScore() + " score to spend.", 45, 110);
		
		g.drawRect(44, 118, 535, 44);
		g.setFont(fnt4);
		g.drawString("UPGRADE HEALTH", 50, 134);
		g.setFont(fnt3);
		g.drawString("Cost: " + prices[0], 50, 145);
	
		g.drawRect(44, 162, 135, 223);
		g.setFont(fnt4);
		g.drawString("UPGRADE SPEED", 50, 176);
		g.setFont(fnt3);
		g.drawString("Cost: " + prices[1], 50, 187);

	
		g.drawRect(179, 162, 400, 223);
		g.setFont(fnt4);
		g.drawString("REFILL HEALTH", 185, 176);
		g.setFont(fnt3);
		g.drawString("Cost: " + prices[2], 185, 187);
		
			
	
		
	}
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
		
		
	}
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if(Game.gameState == STATE.Shop) {
			if(mouseOver(mx, my, 44, 118, 535, 44)) {
				
				if(hud.getScore() >= prices[0]) {
					hud.setScore(hud.getScore() - prices[0]);
					prices[0] += 1000;
					hud.bounds += 20;
					HUD.HEALTH = (100 + (hud.bounds/2));
				}
				
				
			}

			if(mouseOver(mx, my, 44, 162, 135, 223)) {
				
				if(hud.getScore() >= prices[1]) {
					hud.setScore(hud.getScore() - prices[1]);
					prices[1] += 1000;
					handler.spd += 5;
				}
				
				
			}

			if(mouseOver(mx, my, 179, 162, 400, 223)) {
				
				if(hud.getScore() >= prices[2]) {
					hud.setScore(hud.getScore() - prices[2]);
					HUD.HEALTH = (100 + (hud.bounds/2));
					}
				}
				
				
		}
					
	}

	public void setPrice(int index, int price) {
		 prices[index] = price;
	}

	
}
