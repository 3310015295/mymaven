package com.luo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luo.controller.StudentController;
import com.luo.factory.MyFactoryBean;
import com.luo.factory.MyStaticFactory;
import com.luo.pojo.Student;
import com.luo.service.StudentService;

public class MyTest {
	
	private static  ApplicationContext ioc;
	static {
		//ioc = new ClassPathXmlApplicationContext("spring.xml");
		ioc = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Test
	public void testaop() {
		StudentService stuSer = ioc.getBean(StudentService.class);
		System.out.println(stuSer.getClass().getName());
		stuSer.save();
	}
	@Test
	public void testAnnota() {
		StudentService stuSer = ioc.getBean(StudentService.class);
		stuSer = (StudentService) ioc.getBean("stuSer");
		stuSer.save();
	}
	@Test
	public void testAuto() {
		StudentService stuSer = (StudentService) ioc.getBean("stuSer2");
		stuSer.save();
	}
	@Test
	public void factory() {
		/*Student stu =  (Student) ioc.getBean("getStuFromFactory");
		System.out.println(stu);*/
		
		Student stu = (Student) ioc.getBean("myFactoryBean");
		System.out.println(stu);
	}
	
	@Test
	public void testxml() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
		//1.通过id获取
		/*StudentService stuSer = ioc.getBean(StudentService.class);
		stuSer.save();*/
		StudentController stuCon = ioc.getBean(StudentController.class);
		stuCon.add();
	}
	@Test
	public void testIoc() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
		//1.通过id获取
		Student stu = (Student) ioc.getBean("student");
		
		//2.通过class获取（class必须在配置文件xml中唯一）
		Student stu2 = (Student) ioc.getBean(Student.class);
		stu2.setSname("单例");
		System.out.println(stu2==stu);
		System.out.println(stu);
		Student stu3 = new Student();
		Student stu4 = new Student();
		System.out.println(stu3==stu4);
	}
}
