package db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class SelectAllTest {

	public static void main(String[] args) {
		String id = "test";
		String pwd = "test";
		String address = 
		"jdbc:oracle:thin:@70.12.107.160:1521:XE";
		
		Connection con = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = 
			"SELECT * FROM TB_ITEM";
		
		// 1. Oracle JDBC Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
		}
		// 2. Connect to Oracle Database
		try {
			con = DriverManager.getConnection(address, 
					id, pwd);
		} catch (SQLException e) {
			System.out.println("접속 오류");
		}
		
		// 3. SQL Statement .. 
		try {
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e1) {
			System.out.println("SQL 오류");
		}
		// 4. Result
		
		try {
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int dbid = rset.getInt("ID");
				String dbname = rset.getString("NAME");
				int dbprice = rset.getInt("PRICE");
				double dbrate = rset.getDouble("RATE");
				Date dbregdate = rset.getDate("REGDATE");
				System.out.println(dbid+" "+dbname+" "
				+dbprice+" "+dbrate+" "+dbregdate);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("SQL 조회 오류");
		}
		
		
		
		// 5. Connection Close
		try {
			rset.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			
		}
	}

}




