package com.luo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

	public void save() {
		System.out.println("数据保存到数据库成功");
	}
}
