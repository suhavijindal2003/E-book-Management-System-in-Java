package com.example.demo.model;

import jakarta.persistence.Entity;

@Entity
// public class Book {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String title;
//     private String author;
//     private double price;
//     private String category;
//     private String imagePath;

//     // Constructors, getters, and setters
//     public Book() {}

//     public Book(String title, String author, double price, String category, String imagePath) {
//         this.title = title;
//         this.author = author;
//         this.price = price;
//         this.category = category;
//         this.imagePath = imagePath;
//     }

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getTitle() { return title; }
//     public void setTitle(String title) { this.title = title; }

//     public String getAuthor() { return author; }
//     public void setAuthor(String author) { this.author = author; }

//     public double getPrice() { return price; }
//     public void setPrice(double price) { this.price = price; }

//     public String getCategory() { return category; }
//     public void setCategory(String category) { this.category = category; }

//     public String getImagePath() { return imagePath; }
//     public void setImagePath(String imagePath) { this.imagePath = imagePath; }
// }


public class Book {
    private int id;
    private String bookName;
    private String author;
    private String category;
    private String status;
    private String photo;
    private String email;
    private double price;

    // Constructors
    public Book() {}

    public Book(int id, String bookName, String author, String category, String status, String photo, String email, double price) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.status = status;
        this.photo = photo;
        this.email = email;
        this.price = price;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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
}