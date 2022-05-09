package com.huawei.classroom.student.h11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Home11 {

  public Home11() {
    // TODO Auto-generated constructor stub
  }

  public Integer find(String f1, String f2, Map<Integer, List<String>> map) {
    Integer cnt = 0;
    for (Entry<Integer, List<String>> entry : map.entrySet()) {
      if (entry.getValue().contains(f1) && entry.getValue().contains(f2)) {
        cnt++;
      }
    }
    return cnt;
  }

  /**
   * 字符串content是一个超市的历次购物小票的合计，每次购物的明细之间用分号分割，每个商品之间用半角逗号分开 请找出   哪两个商品被同时购买的频率最高，将这2个商品名称返回，名称之间用逗号分隔
   * 测试的时候，商品名称可能增加新的商品，例如方便面、面包...
   *
   * @param content，历次购物的明细，例如：炸鸡,可乐,啤酒;薯片,啤酒,炸鸡;啤酒,雪碧,炸鸡
   * @return 哪两个商品被同时购买的频率最高，将这2个商品名称返回，名称之间用逗号分隔
   */
  public String getFrequentItem(String content) {
    //input
    //得到每次买的食物
    String[] everyTime = content.split(";");
    Map<Integer, List<String>> items = new HashMap<>();
    Set<String> food = new HashSet<>();
    int index = 0;
    for (String buy : everyTime) {
      String[] goods = buy.split(",");
      items.put(index++, Arrays.asList(goods));
    }

    //将所有食物加入set
    for (Entry<Integer, List<String>> entry : items.entrySet()) {
      food.addAll(entry.getValue());
    }

    //两两组合食物，查表 key:食物组合 value：购买次数
    Map<String, Integer> cnt = new HashMap<>();
    List<String> foodList = new ArrayList<>(food);
    for (int i = 0; i < foodList.size(); i++) {
      for (int j = i + 1; j < foodList.size(); j++) {
        String key = foodList.get(i) + "," + foodList.get(j);
        cnt.put(key, find(foodList.get(i), foodList.get(j), items));
      }
    }

    int max=0;
    String mostFrequent="";
    for(Entry<String,Integer>entry:cnt.entrySet()){
      if(entry.getValue()>max){
        mostFrequent=entry.getKey();
        max=entry.getValue();
      }
    }
    return mostFrequent;
  }
}
