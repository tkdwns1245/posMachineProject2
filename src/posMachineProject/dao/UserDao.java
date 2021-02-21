package posMachineProject.dao;

import data.UserVO;

public interface UserDao {
	public UserVO getUser(String userId) throws Exception;
	public void insertUser(UserVO vo) throws Exception;
}
