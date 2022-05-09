package com.huawei.classroom.student.h14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.print.DocFlavor.INPUT_STREAM;
/**
 * 在本包下增加合适的类和方法， 本程序不但要测试通过，还需要写适当的注释
 * 
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
public class MyTools {

	/**
	 * 
	 * @param studentListFile  存放学生名单的文件名
	 * @param picDir 图片存放的目录（不会包含子目录）
	 */
	public MyTools( ) {
		// TODO Auto-generated constructor stub
	}

	private LinkedHashMap<String, String>id_name=new LinkedHashMap<>();
	private LinkedHashMap<String, String>id_class=new LinkedHashMap<>();
	private LinkedHashMap<String, String>handin_id_name=new LinkedHashMap<>();
	private LinkedHashSet<String> nohandin_id_name=new LinkedHashSet<>();
	
	//Reader读取字符,FileReader读取节点流,从students.txt读取每一行
	public static LinkedList<String>readLine(String file) throws IOException{
		try(Reader reader=new FileReader(file) ;
				LineNumberReader linereader=new LineNumberReader(reader);) {
			String line="";
			LinkedList<String>lines=new LinkedList<>();//读取每一行
			while(line!=null) {
				line=linereader.readLine();
				if(line==null)break;
				lines.add(line);
			}
			return lines;
		}
	}
	//从students.txt获取全部学生信息
	public void getAllStudent(String fileline) {
		try {
			LinkedList<String>lines=readLine(fileline);
			for(String line:lines) {
				String stu[]=line.split("\t");
				if(!id_name.containsKey(stu[0]))id_name.put(stu[0], stu[1]);
				if(!id_class.containsKey(stu[0]))id_class.put(stu[0], stu[2]);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: "+e);
		}
	}
	
	//在目标目录下每个班级建立一个字目录，把上交的同学的照片方式拷贝到各自班级目录下
	public void mkdirAndMove(String srcDir,String target) {
		File tar=new File(target);
		if(!tar.exists()) {
			tar.mkdir();
		}
		//创建班级目录
		for(String key:id_class.keySet()) {
			File file=new File(tar.toPath()+"\\\\"+id_class.get(key));
			if(!file.exists())file.mkdir();
		}
		addAndSearch(srcDir, tar);
	}
	
	//找出那些同学的照片没有交照片,把上交的同学的照片统一按 学号_姓名.jpg 方式拷贝到各自班级目录下
	public void addAndSearch(String srcDir,File target) {
		File src=new File(srcDir);
		if(!src.exists()||!src.isDirectory())return;
		File [] files=src.listFiles();
		for(File file:files) {
			if(file.isDirectory())addAndSearch(file.toString(), target);
			else {
				String name=file.getName();
				
				//System.out.println(name);
				String[] word=name.split("\\u002E");
				if(id_name.containsKey(word[0])&&!handin_id_name.containsKey(word[0])&&word[1].equals("jpg"))
					handin_id_name.put(word[0], id_name.get(word[0]));
				try {
					String path=target.toString()+"\\\\"+id_class.get(word[0])+"\\\\"+word[0]+"_"+id_name.get(word[0])+".jpg";
					//System.out.println(path);

					copyPic(file, new File(path));		
								
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
		for(String id:id_name.keySet()) {
			if(!handin_id_name.containsKey(id))
				nohandin_id_name.add(id);
		}
	}
	
	//用流进行照片拷贝
	public static void copyPic(File source,File dest) throws IOException{
		InputStream input=null;
		OutputStream ouput=null;
		try {
			input=new FileInputStream(source);
			ouput=new FileOutputStream(dest);
			byte[] buf=new byte[1024];
			int len=input.read(buf);
			while(len>0) {
				ouput.write(buf, 0, len);
				len=input.read(buf);
			}
		}
		finally {
			input.close();
			ouput.close();
		}
	}
	
	public Set<String> copyToTargetDirAndReturnNoExist(String studentListFile,String srcDir,String target) throws Exception {
		getAllStudent(studentListFile);
		mkdirAndMove(srcDir, target);
		return nohandin_id_name;
	}
 

}
