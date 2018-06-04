package com.luo.test;

import org.hibernate.cfg.Configuration;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.luo.pojo.Student;

public class TestHibernate {
	
	@Test
	public void testsave() {

		// ①加载配置
		Configuration configuration = new Configuration();
		configuration.configure();
		
		////创建服务注册对象
		ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

		System.out.println(serviceRegistry);
		// ②创建SessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		//④创建事务对象
		Transaction tx = session.beginTransaction();
		 
		//⑤保存学生
		/*Student stu = new Student();
		stu.setSname("zhangsan");
		stu.setSbirth(new Date());*/
		Student stu = (Student) session.get(Student.class,1);
		Student stu2 = (Student) session.get(Student.class,1);
		stu.setSage(30);
		System.out.println(stu);
		System.out.println(stu2);
		System.out.println(stu==stu2);
	//	session.save(stu); //动态生成一条insert语句
		 
		//⑥提交事务
		tx.commit();

		System.out.println(sessionFactory);
		session.close();
		
		sessionFactory.close();
	}

	// 如果SessionFactory对象被创建，那么，加载配置文件时，通过hbm2ddl.auto表生成策略来创建表结构
	@Test
	public void testSessionFactory() {

		// ①加载配置
		Configuration configuration = new Configuration();
		configuration.configure();
		
		////创建服务注册对象
		ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

		System.out.println(serviceRegistry);
		// ②创建SessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		System.out.println(sessionFactory);

		sessionFactory.close();
	}

}
