package com.luo.controller;

import javax.websocket.server.PathParam;
import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author ljp
 *注 @RequestMapping，则方法处标记的 URL 相对于 WEB 应用的根目录
作用：DispatcherServlet 截获请求后，
就通过控制器上 @RequestMapping 提供的映射信息确定请求所对应的处理方法。
 */
@Controller
public class FirstController {
	
	
	//pathVarivable占位符
	@RequestMapping(value="/testPathVarivable/{id}")
	public String testPath(@PathVariable("id") Integer id) {
		System.out.println("通过pathvarivable获取url中的展位符id："+id);
		return "success";
	}
	
	//通过参数、method等对映射进行精细化
	@RequestMapping(value="/testReq",params={"age=10"})
	public String testReque() {
		System.out.println("对特定的映射进行反应");
		return "success";
	}
	
	@RequestMapping("/index")
	public String showIndex() {
		System.out.println("kkll");
		
		return "index";
	}

}
