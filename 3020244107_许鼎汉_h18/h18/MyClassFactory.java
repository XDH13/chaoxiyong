package com.huawei.classroom.student.h18;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MyClassFactory {
    public static List<String> classList = new ArrayList<>();
    public static HashMap<String, String> map = new HashMap<>();

    public MyClassFactory(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty() || line.charAt(0) == '#')
                continue;
            String className = line.substring(0, line.lastIndexOf('.'));
            if (!classList.contains(className))
                classList.add(className);
            String K = line.substring(0, line.indexOf('='));
            String V = line.substring(line.indexOf('=') + 1);
            map.put(K, V);
        }

//        System.out.println(classList);
//        System.out.println(map);
    }

    public <T> T createInstance(Class<T> className) {
        String class1 = className.toString();
        class1 = class1.substring(class1.indexOf(' ') + 1);
        Object obj = null;
//        System.out.println(class1);
        try {
            obj = Class.forName(class1).newInstance();
            for (String key : map.keySet()) {
                if (key.contains(class1)) {
                    String attr = key.substring(key.lastIndexOf('.') + 1);
                    String method = "set" + attr.substring(0, 1).toUpperCase() + attr.substring(1);
                    String val = map.get(key);
                    if (val.startsWith("\"")) {
                        val = val.substring(1, val.length() - 1);
                        dynamicInvokeMethod(obj, method, val);
                    } else {
                        Integer num = Integer.parseInt(val);
                        dynamicInvokeMethod(obj, method, num);
                    }
//                    System.out.println(method);
//                    System.out.println(val);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return ((Class<T>) className).cast(obj);
    }


    public static Object dynamicInvokeMethod(Object obj, String methodName, Object... values)
            throws IllegalAccessException, IllegalArgumentException, NoSuchMethodException,
            SecurityException, InvocationTargetException {
        Class[] classes = new Class[values.length];
        for (int i = 0; i < values.length; i++) {
            classes[i] = values[i].getClass();
        }
        Method method = obj.getClass().getMethod(methodName, classes);
        return method.invoke(obj, values);
    }
}
