package com.huawei.classroom.student.h17;


public class Barrack extends GameObject{


	public Barrack(int x,int y) {
		super(x, y);
	}
	
	public GameObject traing(EnumObjectType choices)
	{
		GameObject ob;
		switch(choices) 
		{
			case rifleSoldier:ob = new RifleSoldier();
							ob.playerName = playerName;
							ob.setHealth(BattleField.getProperty("rifleSoldier.health"));
							ob.setStrength(BattleField.getProperty("rifleSoldier.strength"));
							ob.setRange(BattleField.getProperty("rifleSoldier.range"));
							ob.setX(this.getX());
							ob.setY(this.getY());
							BattleField.gameObjects.add(ob);
							break;
			case RPGSoldier:ob = new RPGSoldier();
							ob.playerName = playerName;
							ob.setHealth(BattleField.getProperty("RPGSoldier.health"));
							ob.setStrength(BattleField.getProperty("RPGSoldier.strength"));
							ob.setRange(BattleField.getProperty("RPGSoldier.range"));
							ob.setX(this.getX());
							ob.setY(this.getY());
							BattleField.gameObjects.add(ob);
							break;
			case dog:ob = new Dog();
					ob.playerName = playerName;
					ob.setHealth(BattleField.getProperty("dog.health"));
					ob.setStrength(BattleField.getProperty("dog.strength"));
					ob.setRange(BattleField.getProperty("dog.range"));
					ob.setX(this.getX());
					ob.setY(this.getY());
					BattleField.gameObjects.add(ob);
					break;
			default:throw new Error();
			
		}
		return ob;
	}
}
