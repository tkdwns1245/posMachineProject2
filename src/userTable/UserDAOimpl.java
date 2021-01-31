package userTable;


public class UserDAOimpl implements UserDAO{
	
	final StringBuffer sql=new StringBuffer();
	final UserVO uservo=new UserVO();
	
	@Override
	public void insert(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.append("INSERT INTO "+AbstractDAO.USER_TABLE);
		sql.append("(id,pass,authority,regDate) ");
		sql.append("VALUES (?,?,?,?)");
		
		new AbstractDAO() {
			
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPass());
				pstmt.setInt(3, vo.getAuthority());
				pstmt.setString(4, vo.getRegDate());	

				System.out.println(pstmt.toString());
				pstmt.executeUpdate();
				
			}
		}.execute();
		
	}
	
	@Override
	public UserVO select(int idNumber) throws Exception {
		// TODO Auto-generated method stub
//		sql.append(" SELECT ");
//		sql.append(" idNumber,id,pass,authority,regDate ");
//		sql.append(" FROM USER WHERE idNumber=? ");
		
		sql.append("SELECT * ");
		sql.append("FROM posmachine.USER ");
		
		new AbstractDAO() {
			
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setInt(1, idNumber);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					uservo.setIdNumber(rs.getInt(1));
					uservo.setId(rs.getString(2));
					uservo.setPass(rs.getString(3));
					uservo.setAuthority(rs.getInt(4));
					uservo.setRegDate(rs.getString(5));
					
					
				}
				
			}
		}.execute();
		
		
		return uservo;
		
		
	}
	
	@Override
	public void update(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.append(" UPDATE USER SET ");
		sql.append(" id=?,pass=?,authority=?,regDate=? ");
		sql.append(" WHERE idNumber=? ");
		
		new AbstractDAO() {
			
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPass());
				pstmt.setInt(3, vo.getAuthority());
				pstmt.setString(4, "now()");
				pstmt.setInt(5, vo.getIdNumber());
				pstmt.executeQuery();
				
			}
		}.execute();
		
	}
	@Override
	public void delete(final int idNumber) throws Exception {
		// TODO Auto-generated method stub
		
		sql.append(" DELETE FROM USER ");
		sql.append(" WHERE idNumber=? ");
		
		new AbstractDAO() {
			
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setInt(1, idNumber);
				pstmt.executeQuery();
				
			}
		}.execute();
		
		
	}
	
	

}
