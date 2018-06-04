package com.luo.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * 环绕通知
 * @author ljp
 *
 */
@Component
@Aspect
@Order(2)
public  class TransAspect {

	@Around(value="execution(* com.luo.service.StudentService.*(..))")
	public Object aroundLog(ProceedingJoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();//被代理对象执行的方法名
		Object[] args = joinPoint.getArgs();//参数被代理对象传入的参数
		Object target = joinPoint.getTarget();//被代理对象
		Object result = null;
		
		try {
			//1.前置通知
			System.out.println(target.getClass().getName()+"的:"+methodName+"方法开始执行; 参数为："+Arrays.toString(args));
			result = joinPoint.proceed();//执行代理方法
			//2.方法返回通知
			System.out.println("==========方法返回通知=======");
		} catch (Throwable e) {
			// TODO: handle exception
			System.out.println("==========异常通知======="+e.getMessage());
		}finally {
			//4.后置通知
			System.out.println("======后置通知======");
			return result;
		}
	}
}
