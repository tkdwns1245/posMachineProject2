package ssz.database;

import java.sql.ResultSet;

import data.TableVO;

public class VOFactory {
	public Object createVO(String type,ResultSet rs) {
		try {
			if(type == "table")
			{
				TableVO tableVO = new TableVO();
				tableVO.setNum(rs.getInt(1));
				tableVO.setTableNumber(rs.getInt(2));
				return tableVO;
			}else
				return null;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
