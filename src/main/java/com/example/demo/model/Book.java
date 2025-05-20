package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book_order")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "user_name")
    private String userName;

    private String email;

    private String phno;

    @Column(name = "full_address")
    private String fulladd;

    @Column(name = "book_name")
    private String bookName;

    private String author;

    private String price;

    @Column(name = "payment_type")
    private String paymentType;

    public Book() {
        super();
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getFulladd() {
        return fulladd;
    }

    public void setFulladd(String fulladd) {
        this.fulladd = fulladd;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phno='" + phno + '\'' +
                ", fulladd='" + fulladd + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
