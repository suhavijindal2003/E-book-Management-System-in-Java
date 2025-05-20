package com.example.demo.comDAO;


import java.util.List;

import com.example.demo.model.Book;

public interface BookOrderDAO {
      public boolean saveOrder(List<Book> b);
    
    public List<Book> getBook(String email);
    
    public List<Book> getAllOrder();
}