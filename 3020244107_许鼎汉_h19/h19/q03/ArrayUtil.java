package com.huawei.classroom.student.h19.q03;

public class ArrayUtil {

  public int getMin(int[]array){
    int min=array[0];
    for(int i=1; i<array.length; i++){
      if(min>array[i]){
        min=array[i];
      }
    }
    return min;
  }

}
