package com.arcade.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.arcade.game.Game.STATE;

public class Menus extends MouseAdapter{
	
	private Game game;
	private GameObjHandler handler;
	private Random r = new Random();
	private HUD hud;
	private Store store;
	
	public Menus(Game game, GameObjHandler handler, HUD hud, Store store) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		this.store = store;
	}
	
	
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if(Game.gameState == STATE.Menu) {
			if(mouseOver(mx, my, 210, 150, 200, 64)) { //Play

				Game.gameState = STATE.Select;
				return;
				
				
			}
			if(mouseOver(mx, my, 210, 250, 200, 64)) { //Help
				Game.gameState = STATE.Help;
				
			}			
			if(mouseOver(mx, my, 210, 350, 200, 64)) {//Quit
				System.exit(1);
				 
			}
			
			
		}
		
		if(Game.gameState == STATE.Select) {
			if(mouseOver(mx, my, 210, 150, 200, 64)) { //Normal
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, Type.Player, handler));
				handler.clearEnemies();
				handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Minion, handler));	
				
				game.diff = 0;
				
			}
			if(mouseOver(mx, my, 210, 250, 200, 64)) { //Hard
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, Type.Player, handler));
				handler.clearEnemies();
				handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Villan, handler));	
				
				game.diff = 1;
				
			}			
			if(mouseOver(mx, my, 210, 350, 200, 64)) {//Back
				Game.gameState = STATE.Menu;
				return;
				 
			}
			
			
		}
		
		
		if(Game.gameState == STATE.Help) { //Back 
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				Game.gameState = STATE.Menu;
				return;
			
			}
		}
		
		if(Game.gameState == STATE.End) { //Play again 
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				Game.gameState = STATE.Menu;
				hud.setLevel(1);
				hud.setScore(0);
				handler.setSpeed(10);
				hud.setBounds(0);
				store.setPrice(0, 1000);
				store.setPrice(1, 1000);
				store.setPrice(2, 1000);
			}
		}
		

		
		
	}
	public void mouseReleased(MouseEvent e) {
		
		
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
		
		
	}
	
	
	public void tick() {
		
		
	}
	public void render(Graphics g) {
		if(Game.gameState == STATE.Menu) {
			Font fnt = new Font("courier", 3, 50);
			Font fnt2 = new Font("courier", 1, 30);
			
		
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Collision!", 173, 70);
			
			
			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 270, 190);
			
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Help", 270, 290);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 270, 390);
			
			
		}else if (Game.gameState == STATE.Help) {
			Font fnt = new Font("courier", 3, 50);
			Font fnt2 = new Font("courier", 1, 30);
			Font fnt3 = new Font("courier", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 240, 70);
			
			g.setFont(fnt3);
			g.drawString("Press WASD or arrow keys to move; press P", 50, 125);
			g.drawString("to pause and space to use the store. Avoid", 50, 150);
			g.drawString("Collision!", 50, 175);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);
			
			
		}else if (Game.gameState == STATE.End) {
			Font fnt = new Font("courier", 3, 50);
			Font fnt2 = new Font("courier", 1, 30);
			Font fnt3 = new Font("courier", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over!", 165, 70);
			
			g.setFont(fnt3);
			g.drawString("You lost with a score of: " + hud.getScore(), 125, 200);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again", 230, 390);
			
			
		}else if(Game.gameState == STATE.Select) {
			Font fnt = new Font("courier", 3, 50);
			Font fnt2 = new Font("courier", 1, 30);
			
		
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Select Difficulty", 62, 70);
			
			
			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Normal", 258, 190);
			
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Hard", 270, 290);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);
			
			
		}
		
		
	}
	
	

}