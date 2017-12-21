package db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

	public static void main(String[] args) {
		String id = "test";
		String pwd = "test";
		String address = 
		"jdbc:oracle:thin:@70.12.107.176:1521:XE";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = 
			"INSERT INTO TB_ITEM VALUES(?,?,?,?,SYSDATE)";
		
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
			pstmt.setInt(1, 200);
			pstmt.setString(2, "����");
			pstmt.setInt(3, 30000);
			pstmt.setDouble(4, 5.1);
		} catch (SQLException e1) {
			System.out.println("SQL ����");
		}
		// 4. Result
		int result = 0;
		try {
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("SQL �Է� ����");
		}
		System.out.println("�Է� ���:"+result);
		
		// 5. Connection Close
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			
		}
	}

}




