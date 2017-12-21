package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			"SELECT * FROM TB_USER";
		
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
		} catch (SQLException e1) {
			System.out.println("SQL ����");
		}
		// 4. Result
		
		try {
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String dbid = rset.getString("ID");
				String dbpwd = rset.getString("PWD");
				String dbname = rset.getString("NAME");
				System.out.println(dbid+" "+dbpwd+" "+dbname);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("SQL ��ȸ ����");
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




