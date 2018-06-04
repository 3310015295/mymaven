package com.luo.controller;

import com.luo.service.StudentService;

public class StudentController {

	private StudentService stuSer;
	
	public void add() {
		System.out.println("表现层");
		stuSer.save();
	}

	public StudentService getStuSer() {
		return stuSer;
	}

	public void setStuSer(StudentService stuSer) {
		this.stuSer = stuSer;
	}
	
	
}
