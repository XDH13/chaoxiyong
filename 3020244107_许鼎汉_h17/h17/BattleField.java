package com.huawei.classroom.student.h17;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BattleField {
	public static List<Player> players = new ArrayList<Player>();
	public static HashMap<String,Integer> map = new HashMap<String,Integer>(); 
	public static List<GameObject> gameObjects = new ArrayList<GameObject>();
	public static GameBase createGameBase(Player player, int x, int y) {
		// TODO Auto-generated method stub
			GameBase gameBase = new GameBase();
			gameBase.playerName = new String(player.playerName);
			gameBase.setHealth(map.get("base.health"));
			gameBase.setY(x);
			gameBase.setY(y);
			gameBase.setRange(map.get("base.range"));
			gameBase.setStrength(map.get("base.strength"));
			gameObjects.add(gameBase);
			return gameBase;
		
	}

	public static void createPlayer(String name) {
		// TODO Auto-generated method stub
		Player player = new Player(name);
		players.add(player);
	}

	public static void init(String path) {
		// TODO Auto-generated method stub
		InputStream in = null;
		try {
			in = new FileInputStream(path);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		BufferedReader buff = new BufferedReader(new InputStreamReader(in));
		try {
		String line = buff.readLine();
		while(line != null) {
			if(line.length() > 5 && line.charAt(0) != '#') {
				int a = line.length();
				for(int i = line.indexOf("=")+1; i < line.length();++i) {
					if(line.charAt(i) < 48 || line.charAt(i) > 57) {
						a = i;
						break;
					}
				}
				map.put(line.substring(0,line.indexOf('=')), (Integer)Integer.valueOf(line.substring(line.indexOf("=")+1,a)));
			}
			line = buff.readLine();
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public static List<Player> getAllPlayer() {
		// TODO Auto-generated method stub
		return players;
	}

	public static int getProperty(String property) {
		// TODO Auto-generated method stub
		return map.get(property);
	}

}
