package com.luo.factory;

import org.springframework.beans.factory.FactoryBean;

import com.luo.pojo.Student;

public class MyFactoryBean implements FactoryBean<Student> {
	

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getObject() throws Exception {
		Student stu = new Student();
		stu.setSname(name);
		System.out.println("创建对象");
		return stu;
	}

	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Student.class;
	}

	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
