package com.arcade.game;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.arcade.game.Game.STATE;

public class GameTest {
	//The height of the frame is 640 and the width is 480.
	//This test ensures that all game objects are within those bounds when they spawn and move around the frame.
	@Test
	public void boundsTest() {
		Game.gameState = STATE.Game;
		Game game = new Game();
		Random r = new Random();
		game.getHandler().addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, Type.Player, game.getHandler()));
		game.getHandler().clearEnemies();
		game.getHandler().addObject(new Enemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Type.Minion, game.getHandler()));			
		game.diff = 0;
		
		try {
			Thread.sleep(10000);
			game.getHud().HEALTH = 100;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		game.paused = true;
		int numberOfObjectsPresent = 0;
		for(int i = 0; i< game.getHandler().object.size(); i++) {
			GameObj temp = game.getHandler().object.get(i);
			if (temp != null && temp.getId() != Type.CircleFadeEffect && temp.getId() != Type.FadeEffect) {
				numberOfObjectsPresent++;
			}
		}
		System.out.println("There is a total number of " + numberOfObjectsPresent + " objects that need to be checked that they are within the frame");
		
		for(int i = 0; i< game.getHandler().object.size(); i++) {
			GameObj temp = game.getHandler().object.get(i);
			if (temp != null && temp.getId() != Type.CircleFadeEffect && temp.getId() != Type.FadeEffect) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				assertTrue("Object " + numberOfObjectsPresent + " " + temp.getId() + " is not in an x position within the frame, because it is located at x = " + temp.xPos ,temp.xPos > 0 && temp.xPos < 640);
				assertTrue("Object " + numberOfObjectsPresent + " " + temp.getId() + " is not in a y position within the frame, because it is located at y = " + temp.yPos ,temp.yPos > 0 && temp.yPos < 480);
				//game.getHandler().object.remove(temp);
				numberOfObjectsPresent--;
				System.out.println("Object " + (numberOfObjectsPresent + 1) + " of type " + temp.getId() +" is within the frame at position (" + temp.xPos + " , " + temp.yPos + "). There are " + numberOfObjectsPresent + " objects left being checked for being within the frame");
			} 
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

}
