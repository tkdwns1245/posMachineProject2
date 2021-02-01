package dao;

import data.UserVO;

public interface UserDao {
	public UserVO getUser(String userId) throws Exception;
}
