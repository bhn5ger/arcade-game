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
		g.setColor(Color.white);
		g.setFont(new Font("arial", 0, 48));
		g.drawString("SHOP", Game.WIDTH/2 - 100, 50);
		//box 1
		g.setFont(new Font("arial", 0, 12));
		g.drawString("Upgrade Health", 110, 120);
		g.drawString("Cost: " + prices[0], 110, 140);
		g.drawRect(100, 100, 100, 80);
		//box 2
		g.drawString("Upgrade Speed", 260, 120);
		g.drawString("Cost: " + prices[1], 260, 140);
		g.drawRect(250, 100, 100, 80);
		//box 3
		g.drawString("Refill Health", 410, 120);
		g.drawString("Cost: " + prices[2], 410, 140);
		g.drawRect(400, 100, 100, 80);
		
		
		
		g.drawString("SCORE: " + hud.getScore(), Game.WIDTH/2-50, 300);
		g.drawString("Press space to go back", Game.WIDTH/2-50, 330);
		
	}
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if(Game.gameState == STATE.Shop) {
			//Box 1
			if(mx >= 100 && mx <= 200) {
				if(my >= 100 && my <= 180) {
					if(hud.getScore() >= prices[0]) {
						hud.setScore(hud.getScore() - prices[0]);
						prices[0] += 1000;
						hud.bounds += 20;
						HUD.HEALTH = (100 + (hud.bounds/2));
					}
					
				}
			}
			//Box 2
			if(mx >= 250 && mx <= 350) {
				if(my >= 100 && my <= 180) {
					if(hud.getScore() >= prices[1]) {
						hud.setScore(hud.getScore() - prices[1]);
						prices[1] += 1000;
						handler.spd += 5;
					}
									
					
				}
			}
			//Box 3
			if(mx >= 400 && mx <= 500) {
				if(my >= 100 && my <= 180) {
					if(hud.getScore() >= prices[2]) {
						hud.setScore(hud.getScore() - prices[2]);
						HUD.HEALTH = (100 + (hud.bounds/2));
					}
				}
			}
		}
	
	}

	public void setPrice(int index, int price) {
		 prices[index] = price;
	}

	
}
