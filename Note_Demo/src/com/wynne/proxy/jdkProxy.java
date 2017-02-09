package com.wynne.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class jdkProxy implements InvocationHandler{
	//被代理的目标对象
	private Object target;

    // 1、 构造器 ，传入目标对象
    public jdkProxy(Object target){
    	this.target=target;
    }

    // 2、提供创建代理对象的方法

   public Object createProxy(){
   	return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
   }
   // 3、编写回调函数，拦截目标对象所有方法，都会执行invoke方法
   public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{  
          System.out.println("记录日志"+method.getName()+"方法被执行！");
          return method.invoke(target,args);
   }
}
