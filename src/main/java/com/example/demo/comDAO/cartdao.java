package com.example.demo.comDAO;
import java.util.List;

import com.example.demo.model.Cart;

public interface cartdao {
    public boolean addCart(Cart c);
    
    public List<Cart> getBookByUser(int userId);
    
    public boolean deleteBook(int bid,int uid, int cid);
}