package com.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.Item;

public class ItemDao extends Dao {

	public ItemDao() {
		super();
	}
	
	@Override
	public void insert(Object obj) throws Exception {
		Item item = (Item)obj;
		Connection con = getConnection();
		PreparedStatement pstmt = 
				con.prepareStatement(Sql.insertItem);
		pstmt.setInt(1, item.getId());
		pstmt.setString(2, item.getName());
		pstmt.setInt(3, item.getPrice());
		pstmt.setDouble(4, item.getRate());
		pstmt.executeUpdate();
		close(pstmt);
		close(con);
	}

	@Override
	public void delete(Object obj) throws Exception {
		Connection con = getConnection();
		PreparedStatement pstmt = 
				con.prepareStatement(Sql.deleteItem);
		pstmt.setString(1, obj.toString());
		pstmt.executeUpdate();
		close(pstmt);
		close(con);
	}

	@Override
	public void update(Object obj) throws Exception {
		Item item = (Item)obj;
		Connection con = getConnection();
		PreparedStatement pstmt = 
				con.prepareStatement(Sql.updateItem);
		pstmt.setString(1, item.getName());
		pstmt.setInt(2, item.getPrice());
		pstmt.setDouble(3, item.getRate());
		pstmt.setInt(4, item.getId());
		pstmt.executeUpdate();
		close(pstmt);
		close(con);
	}

	@Override
	public Object select(Object obj) throws Exception {
		// ID가 입력 됩니다.
		// User 객체를 만들어서 
		// User 리턴 해준다.
		Item item = null;
		Connection con = getConnection();
		PreparedStatement pstmt = 
				con.prepareStatement(Sql.selectItem);
		pstmt.setString(1, obj.toString());
		ResultSet rset = 
				pstmt.executeQuery();
		rset.next();
		int id = rset.getInt("ID");
		String name = rset.getString("NAME");
		int price = rset.getInt("PRICE");
		double rate = rset.getDouble("RATE");
		Date regdate = rset.getDate("REGDATE");
		item = new Item(id, name, price, rate, regdate);
		
		close(rset);
		close(pstmt);
		close(con);
		
		return item;
	}

	@Override
	public ArrayList<Object> select() throws Exception {
		// 전체 사용자 정보를 조회 한다.
		// ArrayList<Object> 담아서 리턴한다.
		ArrayList<Object> list = 
				new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement pstmt = 
				con.prepareStatement(Sql.selectAllItem);
		ResultSet rset = 
				pstmt.executeQuery();
		while(rset.next()) {
			Item item = null;
			
			int id = rset.getInt("ID");
			String name = rset.getString("NAME");
			int price = rset.getInt("PRICE");
			double rate = rset.getDouble("RATE");
			Date regdate = rset.getDate("REGDATE");
			item = new Item(id, name, price, rate, regdate);

			list.add(item);
		}
		
		close(rset);
		close(pstmt);
		close(con);
		return list;
	}

}








