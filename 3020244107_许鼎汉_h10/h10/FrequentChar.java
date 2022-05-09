package com.huawei.classroom.student.h10;

public class FrequentChar {
  int times;
  int index;


  public FrequentChar(int id){
    index=id;
    times=0;
  }
  public void addTimes(){
    times++;
  }
  public int getTimes(){
    return times;
  }
  public  int getIndex(){return  index;}

}
