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
				//�̹� �����ϴ� ���̵��Դϴ�.
				return 0;
			}else
			{
				userVO.setId(id);
				userVO.setPass(password);
				userVO.setAuthority(1);
				userVO.setRegDate(new Timestamp(System.currentTimeMillis()));
				ud.insertUser(userVO);
				//ȸ�����Կ� �����Ͽ����ϴ�.
				return 1;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		//ȸ�����Կ� �����Ͽ����ϴ�.
		return 2;
	}
}
