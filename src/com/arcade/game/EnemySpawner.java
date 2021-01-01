package com.arcade.game;

import java.util.Random;

public class EnemySpawner {
	
	private GameObjHandler handler;
	private HUD hud;
	private Game game;
	private int scoreKeep = 0;
	private int levelKeep = 1;
	private int intensityFactor = 1;
	private Random r = new Random();
	
	public EnemySpawner(GameObjHandler handler, HUD hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
		
	}
	/* Spawn bank:
	 * handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
	 * handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
	 * handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
	 * handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
	 * 
	 * handler.clearEnemies(); 
	 * handler.addObject(new Enemy(275, -120, Type.Boss, handler));
	 * 
	 * handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
	 * 
	 * */
	public void tick() {
		scoreKeep++;
		if(scoreKeep >= 100 && levelKeep < 20) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);	
			levelKeep++;
			
			if(game.diff == 0) {
				
				if(levelKeep == 2) {
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				
				else if(levelKeep == 3) {
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				else if(levelKeep == 4) {
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				else if(levelKeep == 5) {
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				else if(levelKeep == 6) {
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				else if(levelKeep == 7) {
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

					
				}
				else if(levelKeep == 8) {
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

					
				}
				else if(levelKeep == 9) {
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

					
				}
				else if(levelKeep == 10) {
					handler.clearEnemies(); 
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Enemy(275, -120, Type.Cloud, handler));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				
				
			}
			else if(game.diff == 1) {
				
				if(levelKeep == 2) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
				}
				
				else if(levelKeep == 3) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
				}
				else if(levelKeep == 4) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
				}
				else if(levelKeep == 5) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
				}
				else if(levelKeep == 6) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
				}
				else if(levelKeep == 7) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
					
				}
				else if(levelKeep == 8) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
					
				}
				else if(levelKeep == 9) {
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
					handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
					
				}
				else if(levelKeep == 10) {
					handler.clearEnemies(); 
					handler.addObject(new Enemy(275, -120, Type.Cloud, handler));

				}
			}
			
			if(levelKeep == 19) {
				intensityFactor++;
				levelKeep = 0;
				handler.clearEnemies(); 
			} 
			
			
		}
		
		
	}
	
	public void resetScoreKeep() {
		this.scoreKeep = 0;
	}
	public void resetLevelKeep() {
		this.levelKeep = 1;
	}
	public void resetIntensityFactor() {
		this.intensityFactor = 1;
	}
}