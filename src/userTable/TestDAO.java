package userTable;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class TestDAO {
	
	private UserDAO userDao=new UserDAOimpl();

	
	public void testInsert() {
		UserVO vo=new UserVO();
		
		try {
			vo.setId("admin");
			vo.setPass("admin");
			vo.setAuthority(1);
			vo.setRegDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));

			
			userDao.insert(vo);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testSelect() {
		UserVO vo1=new UserVO();
		
		try {			
			
			System.out.println();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestDAO test=new TestDAO();
		test.testInsert();
		
	}
	
	

}
