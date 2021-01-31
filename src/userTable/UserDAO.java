package userTable;

public interface UserDAO {
	
	
	public void insert(UserVO vo) throws Exception;
	public UserVO select(int idNumber) throws Exception;
	public void update(UserVO vo) throws Exception;
	public void delete(int idNumber) throws Exception;
	

	
}
