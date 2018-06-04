package com.luo.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luo.mapper.StudentMapper;
import com.luo.pojo.Student;

public class MybatisTest {

	private static ApplicationContext ctx = null;
	
	static {
		ctx = new ClassPathXmlApplicationContext("spring_mybatis.xml");
	}
	
	@Test
	public void testParam() {
		StudentMapper studentMapper = ctx.getBean(StudentMapper.class);
		System.out.println("studentMapper类型："+studentMapper.getClass().getName());
		Student stu = studentMapper.selectStudent(2);
		System.out.println(stu);
	}
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());

	}
	
}
