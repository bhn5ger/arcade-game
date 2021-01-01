package com.arcade.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.JFrame;




@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable{


	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	public static boolean paused = false;
	public int diff = 0;
	private Random r = new Random();
	private GameObjHandler handler;
	private HUD hud;
	private EnemySpawner spawner;
	private Menus menus;
	private Store store;
	private static Color gameColor = new Color(51,0,25);
	
	public enum STATE {
		Menu, Help, Game, Select, Shop, End
	};
	
	public static STATE gameState = STATE.Menu;
	
	public static void main(String [] args) {
		new Game();

	}
	
	class Window{

		public Window(int width, int height, String title, Game game) {
			JFrame frame = new JFrame(title);
			frame.setPreferredSize(new Dimension(width,height));
			frame.setMaximumSize(new Dimension(width,height));
			frame.setMinimumSize(new Dimension(width,height));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.add(game);
			frame.setVisible(true);
			game.start();
			
		}

	}
	
	public Game() {
		handler = new GameObjHandler(); 
		hud = new HUD();
		store = new Store(handler, hud); 
		spawner = new EnemySpawner(handler, hud, this);
		menus = new Menus(this, handler, hud, store, spawner); 
		new Window(WIDTH, HEIGHT, "Game", this);
		this.addKeyListener(new Input(handler));
		this.addMouseListener(menus);
		this.addMouseListener(store);
		spawnParticles();
		MusicPlayer.load();
		MusicPlayer.getMusic("track1").loop();
	}
	public void spawnParticles() {
		int spacing = 24;
		//Left side
		handler.addObject(new Enemy(0, 0, Type.Particle, handler));
		handler.addObject(new Enemy(spacing, 0, Type.Particle, handler));
		handler.addObject(new Enemy(spacing*2, 0, Type.Particle, handler));
		handler.addObject(new Enemy(spacing*3, 0, Type.Particle, handler));
		handler.addObject(new Enemy(spacing*4, 0, Type.Particle, handler));
		//Right side
		handler.addObject(new Enemy(600, 400, Type.Particle, handler));
		handler.addObject(new Enemy(600 - spacing, 400, Type.Particle, handler));
		handler.addObject(new Enemy(600 - 2 * spacing , 400, Type.Particle, handler));
		handler.addObject(new Enemy(600 - 3 * spacing, 400, Type.Particle, handler));
		handler.addObject(new Enemy(600 - 4 * spacing, 400, Type.Particle, handler));
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {//game loop
		this.requestFocus();
		long lastTime = System.nanoTime(), timer = System.currentTimeMillis();
		double amountOfTicks = 60.0, ns = 1000000000 / amountOfTicks, delta = 0;
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) 
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer >1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {

		if(gameState == STATE.Game) {
			if(!paused)
			{
				handler.tick();
				hud.tick();
				spawner.tick();	
				if(HUD.HEALTH <= 0) {
					HUD.HEALTH = 100;
					gameState = STATE.End;
					handler.clearEnemies();
					spawnParticles();
				}
			}
		}else if(gameState == STATE.Menu || gameState == STATE.End) {
			menus.tick();
			handler.tick();
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3); 
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(gameColor);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.red);
		if(paused) {
			g.drawString("PAUSED", 290, 225);
			
		}
		g.setColor(Color.black);
		if(gameState == STATE.Game) {
			hud.render(g);
			handler.render(g);
		}else if(gameState == STATE.Shop) {
			store.render(g);
		}else if(gameState == STATE.Help || gameState == STATE.Select) {
			menus.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.End) { 
			menus.render(g);
			handler.render(g);
		}
		g.dispose();
		bs.show();
		
	}
	public static float clamp(float var, float min, float max) {
		if(var >= max) return var = max;
		else if(var <= min) return var = min;
		else return var;
	}
	
	
	public static void setGameColor(Color c) {
		gameColor = c;
	}
	
}
