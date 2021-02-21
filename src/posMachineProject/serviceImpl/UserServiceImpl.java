package posMachineProject.serviceImpl;

import java.sql.Timestamp;

import data.UserVO;
import posMachineProject.dao.UserDao;
import posMachineProject.daoImpl.UserDaoImpl;
import posMachineProject.service.UserService;

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
	@Override
	public int joinUser(String id, String password) {
		UserVO userVO = new UserVO();
		
		try {
			if(ud.getUser(id).getId() != null)
			{
				//이미 존재하는 아이디입니다.
				return 0;
			}else
			{
				userVO.setId(id);
				userVO.setPass(password);
				userVO.setAuthority(1);
				userVO.setRegDate(new Timestamp(System.currentTimeMillis()));
				ud.insertUser(userVO);
				//회원가입에 성공하였습니다.
				return 1;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		//회원가입에 실패하였습니다.
		return 2;
	}
}
