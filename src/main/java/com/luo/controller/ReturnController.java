package com.luo.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.luo.pojo.Student;

/**
 * 
 * @author ljp
 *
	* ModelAndView: 处理方法返回值类型为 ModelAndView 时 , 方法体即可通过该对象添加模型数据
	* Map 及 Model: 入参为 org.springframework.ui.Model、org.springframework.ui.ModelMap 或 java.uti.Map 时，处理方法返回时， Map 中的数据会自动添加到模型中。
	* @SessionAttributes: 将模型中的某个属性暂存到 HttpSession 中，以便多个请求之间可以共享这个属性
	* @ModelAttribute: 方法入参标注该注解后, 入参的对象就会放到数据模型中
 */
@Controller
public class ReturnController {

	//如果返回的字符串中带 forward: 或 redirect: 前缀时，SpringMVC 会对他们进行特殊处理：
	@RequestMapping("/testFor")
	public String testFor(Model model) {
		model.addAttribute("message", "请求转发");
		return "success";// 拼接视图
		//return "forward:/success"; 转发url为 项目名/success 的请求
		//return "forward:/success.jsp";转发到项目下success.jsp页面
		
		//return "redirect:/success";重定向url为 项目名/success 的请求
		//return "redirect:/success.jsp";重定向到到项目下success.jsp页面
	}
	
	@RequestMapping("/success")
	public String testsuccess(Model model,HttpServletRequest req) {
		String message = (String) req.getAttribute("message");
		System.out.println("消息为："+message);
		model.addAttribute("message","转发控制器");
		return "success";
	}
	//responseBody会将请求作为ajax处理
	@RequestMapping(value="/testAjax",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String testAjax(Student stu) {
		String str = JSONObject.toJSONString(stu);
		System.out.println(str);
		return str;
	}
	
	@RequestMapping("/testRetMap")
	public Map<String,Object> retMap(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("key1","ddd");
		
		return map;
		
	}
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("success");
		modelAndView.addObject("time", new Date().toLocaleString());
		
		return modelAndView;
	}
	
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		System.out.println(map.getClass().getName());
		map.put("names", Arrays.asList("green","tom","jim"));
		return "success";
	}
}
