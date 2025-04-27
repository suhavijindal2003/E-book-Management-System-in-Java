package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;
    private String author;
    private String category;
    private String status;
    private String photo;
    private String email;
    private double price;

    // Default constructor (Required by Hibernate)
    public Book() {}

    // Constructor with all fields (excluding id)
    public Book(String bookName, String author, String category, String status, String photo, String email, double price) {
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.status = status;
        this.photo = photo;
        this.email = email;
        this.price = price;
    }

    // Constructor with id (for updating existing book in DB)
    public Book(Long id, String bookName, String author, String category, String status, String photo, String email, double price) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.status = status;
        this.photo = photo;
        this.email = email;
        this.price = price;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author +
               ", category=" + category + ", status=" + status + ", photo=" + photo + 
               ", email=" + email + ", price=" + price + "]";
    }
}
