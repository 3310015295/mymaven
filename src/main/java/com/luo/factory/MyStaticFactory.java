package com.luo.factory;

import java.util.HashMap;
import java.util.Map;

import com.luo.pojo.Student;

public class MyStaticFactory {

	private static Map<Integer, Student> map;
	
	static {
		map = new HashMap<Integer,Student>();
		Student stu1 = new Student();
		stu1.setSname("张三");
		Student stu2 = new Student();
		stu2.setSname("王五");
		
		map.put(1, stu1);
		map.put(2, stu2);
	}
	
	public static Student getStuFromFactory(Integer key) {
		return map.get(key);
	}
}
