package com.huawei.classroom.student.h17;


public class Soldier extends GameObject{
	public Soldier() {

		livingSoldierCount++;
		// TODO Auto-generated constructor stub
	}

	public static int getLivingSoldierCount() {
		return livingSoldierCount;
	}

	public static int getDeadedSoldierCount() {
		return deadedSoldierCount;
	}

	
}
