package posMachineProejct.manager;

import posMachineProject.service.UserService;
import posMachineProject.serviceImpl.UserServiceImpl;

public class UserManager {
	UserService us = new UserServiceImpl();
	
	public boolean isLoginCheck(String id, String password) {
		return us.checkLogin(id, password);
	}
	public int joinUser(String id, String password) {
		return us.joinUser(id, password);
	}
}
