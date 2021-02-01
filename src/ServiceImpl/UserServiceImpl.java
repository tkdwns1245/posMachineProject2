package ServiceImpl;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import data.UserVO;
import service.UserService;

public class UserServiceImpl implements UserService{
	UserDao ud = new UserDaoImpl();
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean checkLogin(String id, String password) {
		UserVO userVO;
		try {
			userVO = ud.getUser(id);
			if(password.equals(userVO.getPass()))
			{
				return true;
			}else
			{
				return false;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
