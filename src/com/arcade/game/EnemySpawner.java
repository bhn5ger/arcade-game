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
	
	public void tick() {
		scoreKeep++;
		if(scoreKeep >= 100) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);	
			
			
			if(game.diff == 0) {
				
				if(hud.getLevel() == 2) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Minion, handler));
				}
				
				if(hud.getLevel() == 3) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Minion, handler));
				}
				else if(hud.getLevel() == 4) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Charger, handler));
				}
				else if(hud.getLevel() == 5) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Zombie, handler));
				}
				else if(hud.getLevel() == 6) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Zombie, handler));
				}
				else if(hud.getLevel() == 7) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Zombie, handler));
				}
				else if(hud.getLevel() == 10) {
					handler.clearEnemies(); 
					handler.addObject(new Enemy(275, -120, Type.Boss, handler));
				}
			}
			else if(game.diff == 1) {
				
				if(hud.getLevel() == 2) {
					int enemies = 25;
					while(enemies > 0) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Villan, handler));
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Zombie, handler));
						enemies--;
					}
				}
				
				if(hud.getLevel() == 3) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Villan, handler));
				}
				else if(hud.getLevel() == 4) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Charger, handler));
				}
				else if(hud.getLevel() == 5) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Charger, handler));
				}
				else if(hud.getLevel() == 6) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Charger, handler));
				}
				else if(hud.getLevel() == 7) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH) - 50, r.nextInt(Game.HEIGHT) - 50, Type.Zombie, handler));
				}
				else if(hud.getLevel() == 10) {
					handler.clearEnemies(); 
					handler.addObject(new Enemy(275, -120, Type.Boss, handler));
				}
			}
			
			
			
			
		}
		
		
	}
	

}