package com.arcade.game;

import java.util.HashMap;
import java.util.Map;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class MusicPlayer {
	
	public static Map <String, Music> songs = new HashMap <String, Music>();
	
	public static void load() {
		try {
			songs.put("track1", new Music("res/Lil Uzi Vert - Futsal Shuffle 2020 [Official Audio].ogg"));
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public static Music getMusic(String key) {
		return songs.get(key);		
	}
	

	
	
}