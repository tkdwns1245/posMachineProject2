package ssz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import data.TableVO;

public class DatabaseUtil {
		VOFactory voFactory = new VOFactory();
		//DB로그인 정보
		private static final String DB_URL = "jdbc:mysql://ssjdatabase.ceqqrjstuth3.ap-northeast-2.rds.amazonaws.com";
		private static final String USERNAME = "ssjdbadmin"; // DB ID 
		private static final String PASSWORD = "tkdwnsDBAdmin"; // DB Password 
		
		//테이블 정의
		public static final String USER_TABLE="posmachine.USER";
		public static final String MENU_TABLE="posmachine.MENU";
		public static final String ORDER_TABLE="posmachine.ORDER";
		public static final String RECEIPT_TABLE="posmachine.RECEIPT";
		public static final String TABLE_TABLE="posmachine.TABLE";
		public static final String ORDER_DETAIL_TABLE="posmachine.SALE_DETAILS";

		//DB연결 변수
		public static Connection conn = null; 
		public static Statement st;

		public static ResultSet rs;


		
		public DatabaseUtil()
		{

			System.out.print("User Table 접속 : "); 
			try 
			{ 
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD); // 접속결과를 출력합니다.
				st=conn.createStatement();
				
				if (conn != null) {System.out.println("성공");} 

			} 
			
			catch (Exception e) 
			{ 
				System.out.println(e+"접속 실패"); 
			} 
		}
		public List<TableVO> selectList(String query)
		{
			List<TableVO> tmpVOList = new ArrayList<TableVO>();
			try 
			{ 
				DecimalFormat df=new DecimalFormat("00");
				String sql="SELECT * FROM "+TABLE_TABLE; 
				rs=st.executeQuery(sql); //쿼리문 실행
				
				if(rs.next()) {
					System.out.println(voFactory.createVO("table",rs));
				}

			} 
			
			catch (Exception e) 
			{ 
				System.out.println(e+"접속 실패"); 
			}
			return tmpVOList; 
		}
}
