/**
 * 
 */
package com.huawei.classroom.student.h11;

/**
 * @author Administrator
 *
 */
public class Test {

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Home11 util = new Home11();
		String content = "炸鸡,可乐,啤酒;薯片,啤酒,炸鸡;啤酒,雪碧,炸鸡;可乐,牙膏;可乐,面包;啤酒,面包;可乐,榨菜;啤酒,雪碧;洗手液";
		String fq = util.getFrequentItem(content);
		if ("啤酒,炸鸡".equals(fq) || "炸鸡,啤酒".equals(fq)) {
			System.out.println("做对了");
		}

//		String content = "2,3,1;1,5,7;7,4,2;3,1;2,1,8;1,2,9;6,2,1;1,2,4;9,4,1";
//		String fq = util.getFrequentItem(content);
//		if ("1,2".equals(fq) || "2,1".equals(fq)) {
//			System.out.println("做对了");
//		}
	}

}
