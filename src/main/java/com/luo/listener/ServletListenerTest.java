package com.luo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.luo.pojo.Student;

public class ServletListenerTest implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("应用关闭");
		
	}

	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		WebApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		Student bean = ioc.getBean(Student.class);
		System.out.println("通过servletContext获取spring的ioc容器对注入对象进行操作"+bean);
	}

}
