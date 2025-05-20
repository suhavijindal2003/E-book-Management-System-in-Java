package com.example.demo.comDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Book;


public class BookOrderImpl implements BookOrderDAO {

    private Connection conn;

    public BookOrderImpl(Connection conn) {
        super();
        this.conn = conn;

    }

    public boolean saveOrder(List<Book> blist) {

        boolean f = false;
        try {

            String sql = "insert into Book(order_id,user_name,email,address,phno,book_name,author,price,payment) values(?,?,?,?,?,?,?,?,?)";

            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);

            for (Book b : blist) {
                ps.setString(1, b.getOrderId());
                ps.setString(2, b.getUserName());
                ps.setString(3, b.getEmail());
                ps.setString(4, b.getFulladd());
                ps.setString(5, b.getPhno());
                ps.setString(6, b.getBookName());
                ps.setString(7, b.getAuthor());
                ps.setString(8, b.getPrice());
                ps.setString(9, b.getPaymentType());
                ps.addBatch();

            }

            int[] count = ps.executeBatch();
            conn.commit();
            f = true;
            conn.setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;

    }

    public List<Book> getBook(String email) {

        List<Book> list = new ArrayList<Book>();

        Book o = null;
        
        

        try {
            String sql="select * from Book where email=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
                    {
                        o=new Book();
                        o.setId(rs.getInt(1));
                        o.setOrderId(rs.getString(2));
                        o.setUserName(rs.getString(3));
                        o.setEmail(rs.getString(4));
                        o.setFulladd(rs.getString(5));
                        o.setPhno(rs.getString(6));
                        o.setBookName(rs.getString(7));
                        o.setAuthor(rs.getString(8));
                        o.setPrice(rs.getString(9));
                        o.setPaymentType(rs.getString(10));
                        list.add(o);       
                        
                    }
        
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }


    public List<Book> getAllOrder() {
        
        
    List<Book> list = new ArrayList<Book>();

        Book o = null;
        
        

        try {
            String sql="select * from Book";
            PreparedStatement ps=conn.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
                    {
                        o=new Book();
                        o.setId(rs.getInt(1));
                        o.setOrderId(rs.getString(2));
                        o.setUserName(rs.getString(3));
                        o.setEmail(rs.getString(4));
                        o.setFulladd(rs.getString(5));
                        o.setPhno(rs.getString(6));
                        o.setBookName(rs.getString(7));
                        o.setAuthor(rs.getString(8));
                        o.setPrice(rs.getString(9));
                        o.setPaymentType(rs.getString(10));
                        list.add(o);       
                        
                    }
        
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}