package com.wynne.proxy;

/** 
 * 被代理目标对象的接口的实现类
 *  
 * @author wynneli
 *  
 */
public class BookingServiceImpl implements BookingService{
	public void add(){
		System.out.println("增加订票信息");
	}
}
