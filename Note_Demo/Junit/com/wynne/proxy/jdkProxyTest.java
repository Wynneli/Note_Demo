package com.wynne.proxy;


import org.junit.Test;

public class jdkProxyTest {

	@Test
	public void test_staticProxy() {
		//目标对象
		Count target=new CountImpl();
		//创建代理
		jdkProxy jdkproxy=new jdkProxy(target);
		//代理面向接口
		Count proxy=(Count)jdkproxy.createProxy();
		
		//通过代对象执行方法
		proxy.queryCount();
		System.out.println("====================");
		proxy.updateCount();
	}
	@Test
	public void test_jdkProxy() {
		//目标对象
		BookingService target=new BookingServiceImpl();
		//创建代理
		jdkProxy jdkproxy=new jdkProxy(target);
		//代理面向接口
		BookingService proxy=(BookingService)jdkproxy.createProxy();
		
		//通过代对象执行方法
		proxy.add();
	}
}
