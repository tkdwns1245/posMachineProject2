package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

public class DatabaseModule {

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
	public static Connection conn = (Connection)new DatabaseModule(); 
	public static Statement st;
	public static ResultSet rs;


	
	public Connection DatabaseModule()
	{

		System.out.print("User Table ���� : "); 
		Connection con=null;
		try 
		{ 
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD); // ���Ӱ���� ����մϴ�.
			st=con.createStatement();
			
			if (con != null) {System.out.println("����");} 
			
			return con;

		} 
		
		catch (Exception e) 
		{ 
			System.out.println(e+"���� ����"); 
		}
		return con; 
	}
	
	
	
}
