package service;

public interface UserService {
	public boolean checkLogin(String id, String password);
	public int joinUser(String id, String password);
}
