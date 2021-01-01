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
	private int [] prices = {1000, 1000, 1000, 1000, 1000};
	
	public Store(GameObjHandler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		
		
	}
	public void render (Graphics g) {
		Font fnt = new Font("courier", 3, 50);
		Font fnt3 = new Font("courier", 1, 15);
		Font fnt4 = new Font("courier", 3, 15);
		
		g.setFont(fnt);
		g.setColor(Color.black);
		g.drawString("Store", 235, 65);
		
		g.setFont(fnt3);
		g.drawString("Click the buy button to purchase the corresponding item and", 45, 98);
		g.drawString("press space to go back. You have " + hud.getScore() + " score to spend.", 45, 110);
		
		//outline
		g.drawRect(44, 118, 530, 267);
		
		//Upgrade health
		g.drawRect(62, 140, 90, 223);
		g.setFont(fnt4);
		g.drawString("UPGRADE", 75, 150);
		g.drawString("HEALTH", 77, 160);
		g.setFont(fnt3);
		g.drawString("Costs", 83, 201);
		g.drawString("" + prices[0], 85, 216);
		g.drawString("Score", 83, 231);
		g.drawRect(74, 330, 66, 23);
		g.drawString("Buy", 94, 345);
		
		//Refill Health
		g.drawRect(163, 140, 90, 223);
		g.setFont(fnt4);
		g.drawString("REFILL", 180, 150);
		g.drawString("HEALTH", 178, 160);
		g.setFont(fnt3);
		g.drawString("Costs", 185, 201);
		g.drawString("" + prices[1], 189, 216);
		g.drawString("Score", 185, 231);
		g.drawRect(175, 330, 66, 23);
		g.drawString("Buy", 196, 345);
	
		//Upgrade speed
		g.drawRect(264, 140, 90, 223);
		g.setFont(fnt4);
		g.drawString("UPGRADE", 278, 150);
		g.drawString("SPEED", 283, 160);
		g.setFont(fnt3);
		g.drawString("Costs", 285, 201);
		g.drawString("" + prices[2], 289, 216);
		g.drawString("Score", 285, 231);
		g.drawRect(276, 330, 66, 23);
		g.drawString("Buy", 297, 345);

		//Decrease Intensity
		g.drawRect(365, 140, 90, 223);
		g.setFont(fnt4);
		g.drawString("DECREASE", 374, 150);
		g.drawString("INTENSITY", 370, 160);
		g.setFont(fnt3);
		g.drawString("Costs", 385, 201);
		g.drawString("" + prices[3], 389, 216);
		g.drawString("Score", 385, 231);
		g.drawRect(377, 330, 66, 23);
		g.drawString("Buy", 398, 345);
		
		
		//Increase Coin Reward
		g.drawRect(466, 140, 90, 223);	
		g.setFont(fnt4);
		g.drawString("INCREASE", 474, 150);
		g.drawString("COIN", 490, 160);
		g.drawString("REWARD", 482, 170);
		g.setFont(fnt3);
		g.drawString("Costs", 487, 201);
		g.drawString("" + prices[4], 492, 216);
		g.drawString("Score", 487, 231);
		g.drawRect(478, 330, 66, 23);
		g.drawString("Buy", 499, 345);
		
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
			if(mouseOver(mx, my, 74, 330, 66, 23)) {
				
				if(hud.getScore() >= prices[0]) {
					hud.setScore(hud.getScore() - prices[0]);
					prices[0] += 1000;
					hud.bounds += 20;
					HUD.HEALTH = (100 + (hud.bounds/2));
				}
				
				
			}

			if(mouseOver(mx, my, 175, 330, 66, 23)) {
				
				if(hud.getScore() >= prices[1]) {
					hud.setScore(hud.getScore() - prices[1]);
					HUD.HEALTH = (100 + (hud.bounds/2));
					}
				}
			
			if(mouseOver(mx, my, 276, 330, 66, 23)) {
				
				if(hud.getScore() >= prices[2]) {
					hud.setScore(hud.getScore() - prices[2]);
					prices[2] += 1000;
					handler.spd += 5;
				}
				
				
			}

				
				
		}
					
	}

	public void setPrice(int index, int price) {
		 prices[index] = price;
	}

	
}
