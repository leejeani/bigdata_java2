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

	@Override
    public void insert(Connection con, Object obj) throws Exception {
        Item item = (Item)obj;
        PreparedStatement pstmt = null;
        try{
            pstmt = con.prepareStatement(Sql.insertItem);
            pstmt.setString(1, item.getId());
            pstmt.setString(2, item.getName());
            pstmt.setInt(3, item.getPrice());
            pstmt.executeUpdate();
        }catch(Exception e) {
            throw e;
        }finally {
            close(pstmt);
        }
    }
 
    @Override
    public void delete(Connection con, Object obj) throws Exception {
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(Sql.deleteItem);
            pstmt.setString(1, (String)obj);
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally {
            close(pstmt);
        }
    }
 
    @Override
    public void update(Connection con, Object obj) throws Exception {
        Item item = (Item)obj;
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(Sql.updateItem);
            pstmt.setString(1, item.getName());
            pstmt.setInt(2, item.getPrice());
            pstmt.setString(3, item.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally {
            close(pstmt);
        }
    }
 
    @Override
    public Object select(Connection con, Object obj) throws Exception {
        Item item= null;
        PreparedStatement pstmt = null;
        ResultSet rSet = null;
        
        try {
            pstmt = con.prepareStatement(Sql.selectItem);
            pstmt.setString(1, (String)obj);
            rSet=pstmt.executeQuery();
            if(rSet.next()) {
                String id = rSet.getString("ID");
                String name = rSet.getString("NAME");
                int price = rSet.getInt("PRICE");
                Date regdate = rSet.getDate("REGDATE");
                item = new Item(id,name,price,regdate);                
            }
//            item.setId(rSet.getString("ID"));
//            item.setName(rSet.getString("NAME"));
//            item.setPrice(rSet.getInt("PRICE"));
        } catch (Exception e) {
            throw e;
        }finally {
            close(pstmt);
            close(rSet);
        }
        return item;
    }
 
    @Override
    public ArrayList<Object> select(Connection con) throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rSet= null;
        
        try {
            pstmt = con.prepareStatement(Sql.selectAllItem);
            rSet = pstmt.executeQuery();
            while(rSet.next()) {
                Item item = null;
                String id = rSet.getString("ID");
                String name = rSet.getString("NAME");
                int price = rSet.getInt("PRICE");
                Date regdate = rSet.getDate("REGDATE");
                item = new Item(id, name, price, regdate);
                list.add(item);
            }
        } catch (Exception e) {
            throw e;
        }finally {
            close(pstmt);
            close(rSet);
        }
        
        return list;
    }
}
