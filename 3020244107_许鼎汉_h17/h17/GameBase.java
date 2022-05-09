package com.huawei.classroom.student.h17;


public class GameBase extends GameObject{

	
	
	
	public GameObject building(EnumObjectType choices,int x,int y)
	{
		GameObject ob=new GameObject() ;
		switch(choices) 
		{
			case barrack:ob = new Barrack(x, y);
						ob.playerName = playerName;
						ob.setHealth(BattleField.getProperty("barrack.health"));
						ob.setRange(BattleField.getProperty("barrack.range"));
						ob.setStrength(BattleField.getProperty("barrack.strength"));
						BattleField.gameObjects.add(ob);
						break;
			case warFactory:ob = new WarFactory(x,y);
							ob.playerName = playerName;
							ob.setHealth(BattleField.getProperty("warFactory.health"));
							ob.setRange(BattleField.getProperty("warFactory.range"));
							ob.setStrength(BattleField.getProperty("warFactory.strength"));
							BattleField.gameObjects.add(ob);
							break;
			default:throw new Error();
			
		}
		return ob;
	}

	

}
