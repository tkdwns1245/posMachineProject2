package database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.*;

public class VOFactory {
	public void setUserVO(UserVO userVO,ResultSet rs) {
		try {
				userVO.setIdNumber(rs.getInt(1));
				userVO.setId(rs.getString(2));
				userVO.setPass(rs.getString(3));
				userVO.setAuthority(rs.getInt(4));
				userVO.setRegDate(rs.getTimestamp(5));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setTableVO(TableVO tableVO,ResultSet rs) {
		try {
			tableVO.setTableNumber(rs.getInt(2));
			tableVO.setTableShow(rs.getString(3));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setCount(Integer count,ResultSet rs) {
		try {
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
