package com.huawei.classroom.student.h10;

public class Pair implements Comparable<Pair> {
  private char content;
  private int index;
  private int frequency;

  public Pair(){}

  public Pair(char content, int frequency, int index) {
    this.content = content;
    this.frequency = frequency;
    this.index = index;
  }

  public int getFrequency() {
    return frequency;
  }

  public char getContent(){return  content;}

  public int getIndex(){return index;}

  @Override
  public int  compareTo(Pair o){
    if(o.getFrequency() == this.frequency && o.getIndex() == this.index) return 0;
    if(this.frequency > o.getFrequency() || (this.frequency == o.getFrequency() && this.index < o.getIndex()))
      return -1;
    return 1;
  }



}
