package com.luo.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggerAspect {

	@Before(value="execution(* com.luo.service.StudentService.*(..))")
	public void startLog(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		Object target = joinPoint.getTarget();
		System.out.println("日志记录仪====：方法名："+name+"\t"+"参数："+Arrays.toString(args)+"\t"+target);
	}
}
