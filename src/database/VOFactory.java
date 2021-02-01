package database;

import java.sql.ResultSet;

import data.UserVO;

public class VOFactory {
	public void setUserVO(UserVO userVO,ResultSet rs) {
		try {
				userVO.setIdNumber(rs.getInt(1));
				userVO.setId(rs.getString(2));
				userVO.setPass(rs.getString(3));
				userVO.setAuthority(rs.getInt(4));
				userVO.setRegDate(rs.getString(5));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
