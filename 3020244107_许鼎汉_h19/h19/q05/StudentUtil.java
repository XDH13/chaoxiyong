package com.huawei.classroom.student.h19.q05;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class StudentUtil {


  private List<String> readLines(String fsrc) throws IOException {

    try (InputStream in = new FileInputStream(fsrc);

        Reader reader = new InputStreamReader(in, "UTF-8");

        // LineNumberReader 必须在其他流基础上构建
        LineNumberReader lineReader = new LineNumberReader(reader);) {
      String line = lineReader.readLine();
      List<String> lines = new ArrayList<String>();
      while (line != null) {
        lines.add(line);
        line = lineReader.readLine();
      }
      return lines;
    }
  }
  
  private void setScores(List<String> lines, Map<String, MyStudent> map) {
    for (String line : lines) {

      line = line.replace(';', ',');
      String[] strs = line.split(",");
      String name = strs[0];
      String course = strs[1];
      String score = strs[2];
      MyStudent student = null;
      if (map.containsKey(name)) {
        student = map.get(name);
      } else {
        student = new MyStudent(name);
        map.put(name, student);
      }
      student.setScore(course, Integer.valueOf(score));
    }
  }

  private List<String> sortMap(Map<String, MyStudent> map) {
    TreeSet<MyStudent> set = new TreeSet<MyStudent>();
    Iterator<String> it = map.keySet().iterator();
    while (it.hasNext()) {
      String name = it.next();
      set.add(map.get(name));
    }
    List<String> names = new ArrayList<String>();
    Iterator<MyStudent> it2 = set.iterator();
    while (it2.hasNext()) {
      names.add(it2.next().getName());
    }
    return names;
  }

  public List<String> sort(String fileName) {
    try {
      List<String> lines = readLines(fileName);
      Map<String, MyStudent> map = new HashMap<>();
      setScores(lines, map);
      return sortMap(map);

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }

  }
}
