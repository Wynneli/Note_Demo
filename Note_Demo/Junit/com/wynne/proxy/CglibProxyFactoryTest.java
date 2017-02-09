package com.wynne.proxy;



import org.junit.Test;
import com.wynne.proxy.CustomerService;

public class CglibProxyFactoryTest {

	@Test
	public void testCglibProxy() {
		//目标
		CustomerService target=new CustomerService();
		//生成代理
		CglibProxyFactory factory=new CglibProxyFactory(target);
		CustomerService proxy=(CustomerService)factory.createProxy();
		//调用代理对象的方法
		proxy.save();
		proxy.update();
	}

}
