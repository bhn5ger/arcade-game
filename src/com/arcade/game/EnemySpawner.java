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
			
			//Easy
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
						handler.addObject(new Enemy(r.nextInt(301) + 100, -120, Type.Cloud, handler));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				
				
			}
			//Normal
			else if(game.diff == 1) {
				
				if(levelKeep == 2) {
					for(int i = 0; i < intensityFactor + 1; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}
				}
				
				else if(levelKeep == 3) {
					for(int i = 0; i < intensityFactor + 1; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				else if(levelKeep == 4) {
					for(int i = 0; i < intensityFactor + 1; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				else if(levelKeep == 5) {
					for(int i = 0; i < intensityFactor + 1; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				else if(levelKeep == 6) {
					for(int i = 0; i < intensityFactor + 1; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				else if(levelKeep == 7) {
					for(int i = 0; i < intensityFactor + 1; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

					
				}
				else if(levelKeep == 8) {
					for(int i = 0; i < intensityFactor + 1; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

					
				}
				else if(levelKeep == 9) {
					for(int i = 0; i < intensityFactor + 1; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

					
				}
				else if(levelKeep == 10) {
					handler.clearEnemies(); 
					for(int i = 0; i < intensityFactor + 1; i++) {
						handler.addObject(new Enemy(r.nextInt(301) + 100, -120, Type.Cloud, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				
				
			}
			//Hard
			else if(game.diff == 2) {
				
				if(levelKeep == 2) {
					for(int i = 0; i < intensityFactor + 2; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}
				}
				
				else if(levelKeep == 3) {
					for(int i = 0; i < intensityFactor + 2; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				else if(levelKeep == 4) {
					for(int i = 0; i < intensityFactor + 2; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				else if(levelKeep == 5) {
					for(int i = 0; i < intensityFactor + 2; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Charger, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				else if(levelKeep == 6) {
					for(int i = 0; i < intensityFactor + 2; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

				}
				else if(levelKeep == 7) {
					for(int i = 0; i < intensityFactor + 2; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Zombie, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

					
				}
				else if(levelKeep == 8) {
					for(int i = 0; i < intensityFactor + 2; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

					
				}
				else if(levelKeep == 9) {
					for(int i = 0; i < intensityFactor + 2; i++) {
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
						handler.addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Villan, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

					
				}
				else if(levelKeep == 10) {
					handler.clearEnemies(); 
					for(int i = 0; i < intensityFactor + 2; i++) {
						handler.addObject(new Enemy(r.nextInt(301) + 100, -120, Type.Cloud, handler));
					}
					for(int i = 0; i < intensityFactor; i++) {
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
						handler.addObject(new Coin(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Coin, handler, hud));
					}

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
	public void setIntensityFactor(int x) {
		this.intensityFactor = x;
	}
	public int getIntensityFactor() {
		return this.intensityFactor;
	}
	
	
	
}