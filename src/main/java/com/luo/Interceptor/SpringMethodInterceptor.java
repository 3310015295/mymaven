package com.luo.Interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;
/**
 * 方法拦截器
 * @author ljp
 *
 */
@Component
public class SpringMethodInterceptor implements MethodInterceptor{
    public Object invoke(MethodInvocation invo) throws Throwable {
          //(被代理对象类名)目标类名
          String targetName = invo.getThis().getClass().getName();
          
          //方法名
          String methodName = invo.getMethod().getName();
          
          //方法参数
          Object[] object = invo.getArguments();
          
          //方法注解
         Annotation[][] annotations = invo.getMethod().getParameterAnnotations();
          
          Method method = invo.getMethod();
          
              System.out.println("类名: "+targetName+";  方法名 methodName:--"+methodName
                              +"; 参数 args:--"+Arrays.asList(object).toString()+
                              " ;方法上的注解:--"+annotations);
             
              Object result = invo.proceed();//执行被代理方法，必须写；否则被代理类中的业务不会被执行
            
              System.out.println("方法返回值resutl:--"+result);
            
              return result;
          }
}

