package com.wynne.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/** 
 * 编写 CglibProxyFactory 工具类 ，对目标对象进行cglib代理
 *  工具类，对目标进行cglib代理
 * @author wynneli
 *  
 */

public class CglibProxyFactory implements MethodInterceptor{

	//被代理的目标对象
	private Object target;

	//1,通过构造器传入被代理目标对象
    public CglibProxyFactory(Object target){
    	this.target=target;
    }

    //2,提供生成代理对象的方法
    public Object createProxy(){
    	//用于生成代理API
    	Enhancer enhancer=new Enhancer();

    	//设置目标类，根据类生成子类代理
    	enhancer.setSuperclass(target.getClass());

    	//设置回调函数
    	enhancer.setCallback(this);
    	//生成代理返回
    	return enhancer.create();
    }

    //编写回调拦截函数，拦截目标对象的所有方法
    public Object intercept(Object proxy,Method method,Object[] args,
    	MethodProxy methodproxy) throws Throwable{
    	System.out.println("记录日志"+method.getName()+"方法被调用");

    	return methodproxy.invokeSuper(proxy,args);//调用父类（真是对象）的方法
    }

}
