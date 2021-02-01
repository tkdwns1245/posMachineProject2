package ssz.manager;

import ServiceImpl.UserServiceImpl;
import service.UserService;

public class UserManager {
	UserService us = new UserServiceImpl();
	
	public boolean isLoginCheck(String id, String password) {
		return us.checkLogin(id, password);
	}
}
