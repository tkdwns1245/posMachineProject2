package userTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	
	//DB�α��� ����
	private static final String DB_URL = "jdbc:mysql://ssjdatabase.ceqqrjstuth3.ap-northeast-2.rds.amazonaws.com";
	private static final String USERNAME = "ssjdbadmin"; // DB ID 
	private static final String PASSWORD = "tkdwnsDBAdmin"; // DB Password 
	
	//���̺� ����
	public static final String USER_TABLE="posmachine.USER";
	public static final String MENU_TABLE="posmachine.MENU";
	public static final String RECEIPT_TABLE="posmachine.RECEIPT";
	public static final String SALE_DETAILS_TABLE="posmachine.SALE_DETAILS";

	//DB���� ����
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public final void execute() {
		try {
			init();
			query();
			close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD); // ���Ӱ���� ����մϴ�.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public abstract void query() throws Exception;
	private void close() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
