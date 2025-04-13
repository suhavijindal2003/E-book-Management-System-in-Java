package com.example.demo.comDAO;
import java.util.List;

import com.example.demo.model.Cart;

public interface cartdao {
    public boolean addToCart(Cart cart);
    public List<Cart> getBooksByUser(int userId);
    public boolean removeBook(int bookId, int userId, int cartId);
}