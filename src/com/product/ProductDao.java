package com.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.Product;
import com.vo.User;

public class ProductDao<K,V> extends Dao<K, V> {

	@Override
	public void insert(Connection con, K obj) throws Exception {
		PreparedStatement pstmt = null;
		Product p = (Product)obj;
		try {
			pstmt = 
			con.prepareStatement(Sql.insertProduct);
			pstmt.setInt(1, p.getId());
			pstmt.setString(2, p.getName());
			pstmt.setInt(3, p.getPrice());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}
	}

	@Override
	public void delete(Connection con, V id) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = 
			con.prepareStatement(Sql.deleteProduct);
			pstmt.setInt(1, 
					Integer.valueOf(id.toString()));
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}			
	}

	@Override
	public void update(Connection con, K obj) throws Exception {
		PreparedStatement pstmt = null;
		Product p = (Product)obj;
		try {
			pstmt = 
			con.prepareStatement(Sql.updateProduct);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getPrice());
			pstmt.setInt(3, p.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public K select(Connection con, V id) throws Exception {
		Product p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = 
			con.prepareStatement(Sql.selectProduct);
			pstmt.setInt(1, (int)id);
			rset = pstmt.executeQuery();
			rset.next();
			int dbid = rset.getInt("ID");
			String name = rset.getString("NAME");
			int price = rset.getInt("PRICE");
			Date regdate = rset.getDate("REGDATE");
			p = new Product(dbid, name, price, regdate);
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
			close(rset);
		}					
		return (K)p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<K> select(Connection con) throws Exception {
		ArrayList<Product> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = 
			con.prepareStatement(Sql.selectallProduct);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product p = null;
				int dbid = rset.getInt("ID");
				String name = rset.getString("NAME");
				int price = rset.getInt("PRICE");
				Date regdate = rset.getDate("REGDATE");
				p = new Product(dbid, name, price, regdate);
				list.add(p);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
			close(rset);
		}					
		return (ArrayList<K>)list;
	}

}








