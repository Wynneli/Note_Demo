package com.wynne.Unit;



import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.wynne.Service.BookingService;
import com.wynne.Service.BookingServiceimpl;
import com.wynne.scope.protoTypeBean;
import com.wynne.scope.singletonBean;

/**
 * 
 *<p>Title: </p>
 *<p>Description: 测试类</p>
 * @author liweining
 *@date 2017年2月13日 下午10:19:37
 */
public class BookingServiceimplTest {

	//通过传统方法的创建一个对象进行Service方法的调用
	@Test
	public void test() {
		BookingServiceimpl bookingServiceimpl=new BookingServiceimpl() ;
		bookingServiceimpl.update();	  
	}

	//使用依赖注入方式创建对象
	@Test
	public void test1() {
		String resource="appplication.xml";
		@SuppressWarnings("resource")
		ApplicationContext applicationContext=
		new ClassPathXmlApplicationContext(resource);
		BookingService bookingService=
				(BookingService) applicationContext.getBean("BookingService");
		bookingService.update();
	}


	//通过依赖注入的方式实现把Dao的兑现注入到Service中
	@Test
	public void test2() {
		String resource="appplication.xml";
		@SuppressWarnings("resource")
		ApplicationContext applicationContext=
		new ClassPathXmlApplicationContext(resource);
		BookingService bookingService=
				(BookingService) applicationContext.getBean("BookingService");
		bookingService.update();
	}


	//通过BeanFactory获取Service对象，BeanFactory是一个Spring工厂超级接口
	@SuppressWarnings("deprecation")
	@Test
	public void test3() {
		Resource resource= new ClassPathResource("appplication.xml");
		BeanFactory beanFactory=new XmlBeanFactory(resource);
		BookingService bookingService=
				(BookingService) beanFactory.getBean("BookingService");
		bookingService.update();
	}

	//通过静方法进行Bean对象的初始化
	@Test
	public void test4() {
		String resource="appplication.xml";
		@SuppressWarnings("resource")
		ApplicationContext applicationContext=
		new ClassPathXmlApplicationContext(resource);
		BookingService bookingService=
				(BookingService) applicationContext.getBean("BookingServiceFactory");
		bookingService.update();
	}

	//通过Bean实例化工厂方法实例化对象
	@Test
	public void test5() {
		String resource="appplication.xml";
		@SuppressWarnings("resource")
		ApplicationContext applicationContext=
		new ClassPathXmlApplicationContext(resource);
		BookingService bookingService=
				(BookingService) applicationContext.getBean("BookingService2");
		bookingService.update();
	}

	//测试单实例和多实例
	@Test
	public void test6() {
		String resource="appplication.xml";
		@SuppressWarnings("resource")
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(resource);
		singletonBean singletonBean=(singletonBean) applicationContext.getBean("SingletonBean");
		singletonBean singletonBean1=(singletonBean) applicationContext.getBean("SingletonBean");
		System.out.println(singletonBean);
		System.out.println(singletonBean1);
		
		protoTypeBean protoTypeBean=(protoTypeBean) applicationContext.getBean("protoType");
		protoTypeBean protoTypeBean1=(protoTypeBean) applicationContext.getBean("protoType");
		System.out.println(protoTypeBean);
		System.out.println(protoTypeBean1);
		
		
	}
}
