package com.huawei.classroom.student.h19.q04;

import com.huawei.classroom.student.h19.q05.MyStudent;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StrUtil {
  public String removeDulpicatedChar(String ori){

    char[]str=ori.toCharArray();
    StringBuilder target= new StringBuilder();
    Set<Character> set= new HashSet<>();
    for(char c : str){
      set.add(c);
    }
  for(Character c:set){
    target.append(c.toString());
  }
//    Iterator<Character> it2 = set.iterator();
//    while (it2.hasNext()) {
//      target.append(it2.next().toString());
//    }
return target.toString();

  }

}
