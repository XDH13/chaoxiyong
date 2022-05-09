
package com.huawei.classroom.student.h13;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * 在本包下增加合适的类和方法，使得Test类能够测试通过 
 * 
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class Analysis {
	private String[] chapters = null;
	private String content=null;

	/**
	 * @throws Exception
	 * 
	 */
	public Analysis(String filename) throws Exception {
		content=readFromTxt(filename);
		chapters=splitContentToChapter(content);
		content = content.replaceAll(" ", "");
		content = content.replaceAll(",", "");
		content = content.replaceAll("：", "");
		content = content.replaceAll("“", "");
		content = content.replaceAll("”", "");
		content = content.replaceAll("。", "");
		content = content.replaceAll("．", "");
		content = content.replaceAll("，", "");
		content = content.replaceAll("？", "");
		content = content.replaceAll("\"", "");
		content = content.replaceAll("\r\n", "");
	}

	/**
	 * 提示 ：将一个文本文件读取到一个字符串中返回
	 * 
	 * @param filename
	 *            红楼梦文本文件的全路径名
	 * @return 文本的内容
	 */
	private String readFromTxt(String filename) throws Exception {
		Reader reader = null;
		try {
			StringBuffer buf = new StringBuffer();
			char[] chars = new char[1024];
			// InputStream in=new FileInputStream(filename);

			reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
			int readed = reader.read(chars);
			while (readed != -1) {
				buf.append(chars, 0, readed);
				readed = reader.read(chars);
			}
			return buf.toString();
		} finally {
			close(reader);
		}
	}
	
	/**
	 * 返回红楼梦中出现频率最高的N个次，频率从高到低排列（所谓词就是两个相邻的汉字）
	 * @param n
	 * @return
	 */
	public List<String> getTopNWords(  int n){
		Map<String, Integer>map=new HashMap<String, Integer>();
		char[] c=content.toCharArray();
		for(int i=0;i<c.length-1;i++) {
			if(!map.containsKey(String.valueOf(c[i]).concat(String.valueOf(c[i+1]))))
				map.put(String.valueOf(c[i]).concat(String.valueOf(c[i+1])), 1);
			else map.put(String.valueOf(c[i]).concat(String.valueOf(c[i+1])), map.get(String.valueOf(c[i]).concat(String.valueOf(c[i+1])))+1);
		}
		Iterator<String>it=map.keySet().iterator();
		TreeSet<Word>set=new TreeSet<>();
		while(it.hasNext()) {
			String key=(String)it.next();
			int cnt=map.get(key);
			set.add(new Word(key, cnt));
		}
		Iterator<Word>itt=set.iterator();
		List<String>top=new ArrayList<>();
		while(top.size()<n) {
			Word w=itt.next();
			//System.out.println(w.getWord() + "=" + w.getCount());
			top.add(w.getWord());
		}
		return top;
	
	}
	
	

	/**
	 * 关闭输入输入流
	 * 
	 * @param inout
	 */
	private void close(Closeable inout) {
		if (inout != null) {
			try {
				inout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 提示 将红楼梦文本文件拆分为120个章节的方法
	 * 
	 * @param content
	 * @return 返回120个元素的字符串数组
	 */
	private String[] splitContentToChapter(String content) {
		// 提示 使用 content.split(" 第[一,二,三,四,五,六,七,八,九,十,零]{1,5}回 ");正则表达拆分
		// 百度一下正则表达式
		String contents[] = content.split(" 第[一,二,三,四,五,六,七,八,九,十,零]{1,5}回 ");
		return contents;
	}

	 
	/**
	 * 统计红楼梦章节字符串str出现的频率
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public int[] getStringFrequent(String str) throws Exception {
		int[] frequent=new int[chapters.length-1];
		for(int i=1;i<chapters.length;i++) {
			frequent[i-1]=getCount(chapters[i], str);
		}
		return frequent;
	}

	private int getCount(String content,String sub) {
		int count=0;
		int index=content.indexOf(sub);
		while(index>=0) {
			index=content.indexOf(sub,index+sub.length());
			count++;
		}
		return count;
	}
}
