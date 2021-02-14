package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DatabaseUtil {
	
	//DB�α��� ����
	private static final String DB_URL = "jdbc:mysql://ssjdatabase.ceqqrjstuth3.ap-northeast-2.rds.amazonaws.com";
	private static final String USERNAME = "ssjdbadmin"; // DB ID 
	private static final String PASSWORD = "tkdwnsDBAdmin"; // DB Password 
	
	//���̺� ����
	private static final String USER_TABLE="posmachine.USER";
	private static final String MENU_TABLE="posmachine.MENU";
	private static final String ORDER_TABLE="posmachine.ORDER";
	private static final String RECEIPT_TABLE="posmachine.RECEIPT";
	private static final String TABLE_TABLE="posmachine.TABLE";
	private static final String ORDER_DETAIL_TABLE="posmachine.SALE_DETAILS";

	//DB���� ����
	public Connection con;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	
	public DatabaseUtil() {
		// TODO Auto-generated constructor stub
	}
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
