package com.huawei.classroom.student.h17;


public class GameObject {
	int health=0;
	int strength,range;
	int x,y;
	public static int livingSoldierCount ;
	public static int deadedSoldierCount ;
	public String playerName;

	public GameObject() {
		
	}
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move(int x,int y) 
	{
		this.x+=x;
		this.y+=y;
	}
	
	public double Range(int x,int y)
	{
		double s=Math.pow((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y), 0.5);
		return s;
	}
	
	public int getHealth()
	{
		return health;
		
	}
	
	String judge(GameObject ob) {
		
		if(ob instanceof Barrack) {
			return "barrack";
		}
		else if(ob instanceof GameBase){
			return "base";
		}
		else if(ob instanceof HeavyTank) {
			return "heavyTank";
		}
		else if(ob instanceof MediumTank) {
			return "mediumTank";
		}
		else if(ob instanceof RifleSoldier) {
			return "rifleSoldier";
		}
		else if(ob instanceof RPGSoldier) {
			return "RPGSoldier";
		}
		else if(ob instanceof WarFactory) {
			return "warFactory";
		}
		else if(ob instanceof Dog) {
			return "dog";
		}
		else return " ";
	}
	

	
	public void attack() {
		double min = 999999999;
		GameObject gameob = new Dog();
		int flag = 0;
		for(int i = 0; i < BattleField.gameObjects.size(); ++i) {
			int dx = this.x - BattleField.gameObjects.get(i).getX();
			int dy = this.y - BattleField.gameObjects.get(i).getY();
			double dis = Math.pow(dx * dx + dy * dy, 0.5);
			if(!this.isDestroyed() && this.range >= dis && dis < min && !BattleField.gameObjects.get(i).isDestroyed() && !this.playerName.equals(BattleField.gameObjects.get(i).playerName)) {
				min = dis;
				gameob = BattleField.gameObjects.get(i);
				flag = 1;
			}
		}
		if(flag == 1) {
			attack(gameob);
			System.out.print("["+playerName+"." + judge(this) + " live="+!this.isDestroyed()+" x="+this.getX()+" y="+this.getY()+" health="+this.getHealth()+"]");
			System.out.print("攻击");
			System.out.print("["+gameob.playerName+"." + judge(gameob) + " live="+!gameob.isDestroyed()+" x="+gameob.getX()+" y="+gameob.getY()+" health="+gameob.getHealth()+"]");
			System.out.print("\n");
		}
		
	}
//	public void attack(RifleSoldier obj) 
//	{
//		if(this.Range(obj.x, obj.y)<=range)
//			if(!obj.isDestroyed())
//			{
//				obj.health-=strength;
//				if(obj.isDestroyed())
//				{
//					livingSoldierCount--;
//					deadedSoldierCount++;
//				}	
//			}
//	}
//	
//	public void attack(RPGSoldier obj) 
//	{
//		if(this.Range(obj.x, obj.y)<=range)
//			if(!obj.isDestroyed())
//			{
//				obj.health-=strength;
//				if(obj.isDestroyed())
//				{
//					livingSoldierCount--;
//					deadedSoldierCount++;
//				}	
//			}
//	}
//	
	public void attack(GameObject obj) 
	{
		if(this.Range(obj.x, obj.y)<=range)
			obj.health-=this.strength;
	}
	
	

	public boolean isDestroyed() {
		if(health <= 0) 
			return true;
		else 
			return false;
	}
	
	
	public int getRange() {
		return range;
	}
	public int getStrength() {
		return strength;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
