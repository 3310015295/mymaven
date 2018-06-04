package com.luo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luo.pojo.Student;

/**
 * 对请求数据的处理
 * @author ljp
 *
 */
@Controller
public class ReqController {

	//使用原生servlet接受参数
	@RequestMapping("/testApi")
	public String testApi(HttpServletRequest req) {
		
		return "success";
		
	}
	//使用pojo进行参数封装
	@RequestMapping("/testPojo")
	public String testPojo(Student stu) {
		System.out.println(stu.toString());
		return "success";
	}
	
	//对请求参数的接受
	@RequestMapping("/testReqParam")
	public String testParam(@RequestParam(value="name",defaultValue="",required=false) String name,
							@RequestParam(value="age",defaultValue="0",required=true) Integer age) {
		System.out.println("age="+age+"; name="+name);
		return "success";
	}
	
	//对cookie的接受
	@RequestMapping("/testCookie")
	public String testCookie(@CookieValue("JSESSIONID") String sessionId) {
		
		System.out.println("sessionID: "+sessionId);
		return "success";
	}
}
