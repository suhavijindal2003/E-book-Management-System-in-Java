package com.example.demo.comDAO;


import java.util.List;

import com.example.demo.model.Cart;

public interface BookOrderDAO {
    public boolean saveOrder(List<Cart> carts);
}