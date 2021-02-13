package database; //테스트 주석 kukirun3

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.*;

public class VOFactory {
	public void setUserVO(UserVO userVO,ResultSet rs) {
		//주석
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
	
	public ReceiptJoinedVO setReceiptJoinedVO(ReceiptJoinedVO rjVO,ResultSet rs) {
		
		try {
			
			rjVO.setRcNumber(rs.getInt("rcNumber"));
			rjVO.setSumPrice(rs.getInt("sumPrice"));
			rjVO.setPayType(rs.getString("payType"));
			rjVO.setRegTime(rs.getTimestamp("regTime"));
			rjVO.setStatus(rs.getString("status"));
			rjVO.setMenu_Category(rs.getString("menu_Category"));
			rjVO.setMenu_Name(rs.getString("menu_Name"));
			rjVO.setMenu_Price(rs.getInt("menu_Price"));
			rjVO.setNumberOf(rs.getInt("numberOf"));
			rjVO.setRowSum(rs.getInt("rowSum"));
			rjVO.setRowCount(rs.getInt("rowCount"));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rjVO;
		
	}

}
