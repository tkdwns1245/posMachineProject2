package database; //占쌓쏙옙트 占쌍쇽옙 kukirun3

import java.sql.ResultSet;

import data.CategoryVO;
import data.MenuVO;
import data.ReceiptJoinedVO;
import data.TableOrderDetailVO;
import data.TableVO;
import data.UserVO;

public class VOFactory {
	public void setUserVO(UserVO userVO,ResultSet rs) {
		//占쌍쇽옙
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
	
	
	// DB�쓽 �뜲�씠�꽣 媛믪쓣 MenuVO�뿉 �꽭�똿
	public void setMenuVO(MenuVO menuVO,ResultSet rs) {
		try {
				menuVO.setMenuCategory(rs.getString(2));
				menuVO.setMenuName(rs.getString(3));
				menuVO.setMenuPrice(rs.getInt(4));
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setCategoryVO(CategoryVO categoryVO,ResultSet rs) {
		try {
				categoryVO.setCategoryName(rs.getString(2));
								
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
		public void setTableOrderDetailVO(TableOrderDetailVO tableOrderDetailVO,ResultSet rs) {
			try {
				tableOrderDetailVO.setTableNum(rs.getInt("tableNum"));
				tableOrderDetailVO.setOrderNum(rs.getInt("orderNum"));
				tableOrderDetailVO.setStatus(rs.getString("status"));
				tableOrderDetailVO.setDetailNum(rs.getInt("orderDetailNum"));
				tableOrderDetailVO.setNumOf(rs.getInt("num_of"));
				tableOrderDetailVO.setMenuNum(rs.getInt("menuNum"));
				tableOrderDetailVO.setMenuName(rs.getString("menu_name"));
				tableOrderDetailVO.setMenuPrice(rs.getInt("menu_price"));					
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
