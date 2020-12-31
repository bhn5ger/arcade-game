package com.arcade.game;

import java.util.Random;

public class EnemySpawner {
	
	private GameObjHandler handler;
	private HUD hud;
	private Game game;
	private int scoreKeep = 0;
	private Random r = new Random();
	
	public EnemySpawner(GameObjHandler handler, HUD hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
		
	}
	/*Spawn bank:
	 * handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
	 * handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
	 * handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
	 * handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
	 * 
	 * handler.clearEnemies(); 
	 * handler.addObject(new Enemy(275, -120, Type.Boss, handler));
	 * */
	public void tick() {
		scoreKeep++;
		if(scoreKeep >= 100) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);	
			
			
			if(game.diff == 0) {
				
				if(hud.getLevel() == 2) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
				}
				
				else if(hud.getLevel() == 3) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
				}
				else if(hud.getLevel() == 4) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
				}
				else if(hud.getLevel() == 5) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
				}
				else if(hud.getLevel() == 6) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
				}
				else if(hud.getLevel() == 7) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
					
				}
				else if(hud.getLevel() == 8) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
					
				}
				else if(hud.getLevel() == 9) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
					
				}
				else if(hud.getLevel() == 10) {
					handler.clearEnemies(); 
					handler.addObject(new Enemy(275, -120, Type.Boss, handler));

				}
			}
			else if(game.diff == 1) {
				
				if(hud.getLevel() == 2) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
				}
				
				else if(hud.getLevel() == 3) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
				}
				else if(hud.getLevel() == 4) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
				}
				else if(hud.getLevel() == 5) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
				}
				else if(hud.getLevel() == 6) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
				}
				else if(hud.getLevel() == 7) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
					
				}
				else if(hud.getLevel() == 8) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
					
				}
				else if(hud.getLevel() == 9) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
					
				}
				else if(hud.getLevel() == 10) {
					handler.clearEnemies(); 
					handler.addObject(new Enemy(275, -120, Type.Boss, handler));

				}
			}
			
			
			
			
		}
		
		
	}
	

}