package db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {

	public static void main(String[] args) {
		String id = "test";
		String pwd = "test";
		String address = 
		"jdbc:oracle:thin:@70.12.107.160:1521:XE";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = 
			"UPDATE TB_ITEM SET NAME=?,PRICE=?,RATE=? WHERE ID=?";
		
		// 1. Oracle JDBC Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver�� �����ϴ�.");
		}
		// 2. Connect to Oracle Database
		try {
			con = DriverManager.getConnection(address, 
					id, pwd);
		} catch (SQLException e) {
			System.out.println("���� ����");
		}
		
		// 3. SQL Statement .. 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "����2");
			pstmt.setInt(2, 30000);
			pstmt.setDouble(3, 3.4);
			pstmt.setInt(4, 200);
		} catch (SQLException e1) {
			System.out.println("SQL ����");
		}
		// 4. Result
		int result = 0;
		try {
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("SQL ���� ����");
		}
		System.out.println("���� ���:"+result);
		
		// 5. Connection Close
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			
		}
	}

}




