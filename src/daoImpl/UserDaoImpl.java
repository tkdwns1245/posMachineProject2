package daoImpl;

import dao.UserDao;
import data.UserVO;
import database.DatabaseUtil;
import database.VOFactory;

public class UserDaoImpl implements UserDao{
	final VOFactory voFactory = new VOFactory();
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public UserVO getUser(String userId) throws Exception {
		StringBuffer sql=new StringBuffer();
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
	@Override
	public void insertUser(UserVO vo) throws Exception {
		StringBuffer sql=new StringBuffer();
		sql.append("INSERT INTO posmachine.USER");
		sql.append("(id,pass,authority,regDate) ");
		sql.append("VALUES (?,?,?,?)");
		new DatabaseUtil() {
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPass());
				pstmt.setInt(3, vo.getAuthority());
				pstmt.setTimestamp(4, vo.getRegDate());
				pstmt.executeUpdate();
				
			}
		}.execute();
	}
}
