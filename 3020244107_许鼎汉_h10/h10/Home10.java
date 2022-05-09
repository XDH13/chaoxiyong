package com.huawei.classroom.student.h10;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;


/**
 * 把你作业的代码写到这个类里面
 * 不可以修改类的名字、包名、和固有的几个方法名以及方法的可见性
 * 可以增加其他方法、属性、类
 * 可以引用jdk的类
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class Home10 {
	public Home10() {
	} 
	/**
	 * 将一个字符串中字符按出现频率的高到低排序返回，如果两个字符出现的频率一样，则将最先出现的字符排在前面
	 * 例如：orderChar(“abcdefg”)返回 “abcdefg” 
	 * orderChar(“abcdefgg”)返回 “gabcdef”
	 * orderChar(“abcdefgge”)返回 “egabcdf”
	 * orderChar(“天津大学软件学院”)返回 “学天津大软件院”
	 * @param content
	 * @return
	 */
	public String orderChar(String content) {
		//得到出现次数，排序（第一）
		//存储原顺序 id（第二）
		HashMap<Character, FrequentChar> map = new HashMap<>();
		for(int i=0;i<content.length();i++) {
			char key = content.charAt(i);
			if(map.containsKey(key)){
				FrequentChar fc=map.get(key);
				fc.addTimes();
				map.replace(content.charAt(i),fc);
			}else{
				map.put(content.charAt(i),new FrequentChar(i));
			}
		}
		ArrayList<Pair> pairs= new ArrayList<>();
		for(Entry<Character,FrequentChar>entry:map.entrySet()){
			Pair p =new Pair(entry.getKey(),entry.getValue().getTimes(),entry.getValue().getIndex());
			pairs.add(p);
		}
		Collections.sort(pairs);

		StringBuilder sb = new StringBuilder();
		for(Pair p:pairs){
			sb.append(p.getContent());
		}
//key:hashmap 顺序输出
		//Collections.sort(map);


		return sb.toString();
	}
	
}
