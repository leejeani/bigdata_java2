package db3;

public class Sql {
	public static String insertUser = 
		"INSERT INTO TB_USER VALUES(?,?,?)";
	public static String deleteUser = 
		"DELETE FROM TB_USER WHERE ID=?";
	public static String updateUser = 
		"UPDATE TB_USER SET PWD=?,NAME=? WHERE ID=?";
	public static String selectUser = 
		"SELECT * FROM TB_USER WHERE ID=?";
	public static String selectAllUser = 
		"SELECT * FROM TB_USER";
	
	public static String insertItem = 
		"INSERT INTO TB_ITEM VALUES(?,?,?,?,SYSDATE)";
	public static String deleteItem = 
		"DELETE FROM TB_ITEM WHERE ID=?";
	public static String updateItem = 
		"UPDATE TB_ITEM SET NAME=?,PRICE=?,RATE=? WHERE ID=?";
	public static String selectItem = 
		"SELECT * FROM TB_ITEM WHERE ID=?";
	public static String selectAllItem = 
		"SELECT * FROM TB_ITEM";
}





