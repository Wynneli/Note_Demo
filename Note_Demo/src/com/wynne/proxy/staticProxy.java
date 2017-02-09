package com.wynne.proxy;

public class staticProxy implements Count{
	
	private CountImpl countimpl;

    //默认构造器
	public staticProxy(CountImpl countimpl){
		this.countimpl=countimpl;
	}

	public void queryCount(){
		System.out.println("事务处理之前!");
		 // 调用委托类的方法;
		countimpl.queryCount();
		System.out.println("事务处理之后!");
	}

	public void updateCount(){
		System.out.println("事务处理之前!");
		 // 调用委托类的方法;
		countimpl.updateCount();
		System.out.println("事务处理之后!");
	}

}
