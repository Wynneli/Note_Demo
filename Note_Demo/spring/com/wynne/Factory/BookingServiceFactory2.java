package com.wynne.Factory;

import com.wynne.Service.BookingServiceimpl;

//静态方法实例化Bean
/**
 *<p>Title: </p>
 *
 *<p>Description: 使用静态方法实例化对象</p>
 *
 * @author liweining
 * 
 *@date 2017年2月13日 下午10:52:08 
 */
public class BookingServiceFactory2 {
   public  BookingServiceimpl init(){
	   return new BookingServiceimpl();
   }
}
