package daoImpl;

import dao.UserDao;
import data.UserVO;
import database.DatabaseUtil;
import database.VOFactory;

public class UserDaoImpl implements UserDao{
	final StringBuffer sql=new StringBuffer();
	final VOFactory voFactory = new VOFactory();
	
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public UserVO getUser(String userId) throws Exception {
		UserVO userVO = new UserVO();
		sql.append("SELECT * ");
		sql.append("FROM posmachine.USER WHERE id = ? ");
		
		new DatabaseUtil() {
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, userId);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					voFactory.setUserVO(userVO,rs);
				}
				
			}
		}.execute();
		return userVO;
	}
}
