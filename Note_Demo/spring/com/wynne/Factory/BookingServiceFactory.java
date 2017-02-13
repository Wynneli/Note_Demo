package com.wynne.Factory;

import com.wynne.Service.BookingServiceimpl;

//静态方法实例化Bean
/**
 *<p>Title: </p>
 *
 *<p>Description: 使用实例工厂方法实例化对象</p>
 *
 * @author liweining
 * 
 *@date 2017年2月13日 下午10:52:08 
 */
public class BookingServiceFactory {
   public static BookingServiceimpl init(){
	   return new BookingServiceimpl();
   }
}
