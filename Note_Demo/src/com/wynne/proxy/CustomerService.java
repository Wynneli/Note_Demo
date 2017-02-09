package com.wynne.proxy;

/** 
 * 被代理的对象
 *  
 * @author wynneli
 *  
 */

public class CustomerService{
	public void save(){
		System.out.println("保存用户信息！");
	}
	public void update(){
		System.out.println("更新用户信息！");
	}
}
