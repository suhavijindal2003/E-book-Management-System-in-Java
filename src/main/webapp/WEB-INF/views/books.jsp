<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<%@ include file="adminheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book List</title>
    <link rel="stylesheet" type="text/css" href="static/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body style="background-color: #f0f2f2;">
    <div class="container mt-4">
        <h1 class="text-center">Available Books</h1>

        <table class="table table-bordered table-striped mt-3">
            <thead class="table-dark">
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Price</th>
                    <th>Category</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.price}</td>
                        <td>${book.category}</td>
                        <td>
                            <a href="/edit_book" class="btn btn-warning btn-sm">Edit</a>
                            <a href="/books/delete/${book.id}" class="btn btn-danger btn-sm" 
                               onclick="return confirm('Are you sure you want to delete this book?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="text-center m-6`p-5">
            <a href="/add_book" class="btn btn-primary">Add New Book</a>
        </div>
    </div>
</body>
</html>
<!-- <%@ include file="footer.jsp" %> -->