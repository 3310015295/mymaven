package com.luo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luo.dao.StudentDao;

@Service
public class StudentService {

	@Autowired
	private StudentDao stuDao;
	
	/*public StudentDao getStuDao() {
		return stuDao;
	}

	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}*/

	public void save() {
		int i = 10/0;
		System.out.println("调用dao到保存");
		stuDao.save();
	}
}
