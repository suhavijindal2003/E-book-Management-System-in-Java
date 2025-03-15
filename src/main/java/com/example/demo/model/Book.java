// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
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