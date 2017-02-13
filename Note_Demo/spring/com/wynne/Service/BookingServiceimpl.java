package com.wynne.Service;

import com.wynne.Dao.UserDao;

public class BookingServiceimpl implements BookingService{
	
	UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void update(){
    	 System.out.println("BookingService 进行更新！");
    	 userDao.findUserById();
     }
}
