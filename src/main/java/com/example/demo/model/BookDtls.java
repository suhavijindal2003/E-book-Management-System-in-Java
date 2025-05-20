package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book_details")
public class BookDtls {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(name = "book_name")
    private String bookName;

    private String author;

    private String price;

    @Column(name = "book_category")
    private String bookCategory;

    private String status;

    @Column(name = "photo_name")
    private String photoName;

    private String email;

    public BookDtls() {
        super();
    }

    public BookDtls(String bookName, String author, String price, String bookCategory, String status, String photoName, String email) {
        super();
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.bookCategory = bookCategory;
        this.status = status;
        this.photoName = photoName;
        this.email = email;
    }

    // Getters and Setters

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "BookDtls{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", bookCategory='" + bookCategory + '\'' +
                ", status='" + status + '\'' +
                ", photoName='" + photoName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
