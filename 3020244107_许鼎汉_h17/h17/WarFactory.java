package com.huawei.classroom.student.h17;


public class WarFactory extends GameObject{

	
	public WarFactory(int x,int y)
	{
		super(x, y);
	}
	
	public GameObject building(EnumObjectType choices)
	{
		Tank ob=new Tank();
		switch(choices) 
		{
			case mediumTank:ob = new MediumTank();
							ob.playerName = playerName;
							ob.setX(this.getX());
							ob.setY(this.getY());
							ob.setRange(BattleField.getProperty("mediumTank.range"));
							ob.setStrength(BattleField.getProperty("mediumTank.strength"));
							ob.setHealth(BattleField.getProperty("mediumTank.health"));
							BattleField.gameObjects.add(ob);
							break;
			case heavyTank:ob = new HeavyTank();
							ob.playerName = playerName;
							ob.setX(this.getX());
							ob.setY(this.getY());
							ob.setRange(BattleField.getProperty("heavyTank.range"));
							ob.setStrength(BattleField.getProperty("heavyTank.strength"));
							ob.setHealth(BattleField.getProperty("heavyTank.health"));
							BattleField.gameObjects.add(ob);
							break;
			default:throw new Error();
			
		}
		return ob;
	}
}
