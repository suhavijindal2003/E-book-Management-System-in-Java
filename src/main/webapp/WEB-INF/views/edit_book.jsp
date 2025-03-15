<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<%@ include file="adminheader.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Book</title>
    <link rel="stylesheet" type="text/css" href="static/css/style.css">
</head>
<body style="background-color: #f0f2f2;">
    <div class="container pt-5">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card">
                    <div class="card-body">
                        <h4 class="text-center">Edit Book</h4>
                        <form action="/books/${book.id}" method="post">
                            <input type="hidden" name="id" value="${book.id}">

                            <div class="form-group">
                                <label for="title">Title:</label>
                                <input type="text" id="title" name="title" value="${book.title}" 
                                       class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label for="author">Author:</label>
                                <input type="text" id="author" name="author" value="${book.author}" 
                                       class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label for="price">Price:</label>
                                <input type="number" id="price" name="price" value="${book.price}" 
                                       class="form-control" step="0.01" required>
                            </div>

                            <div class="form-group">
                                <label for="category">Category:</label>
                                <input type="text" id="category" name="category" value="${book.category}" 
                                       class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label for="imagePath">Image Path:</label>
                                <input type="text" id="imagePath" name="imagePath" value="${book.imagePath}" 
                                       class="form-control" required>
                            </div>

                            <button type="submit" class="btn btn-primary btn-block">Update</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


</body>

</html>
<%@ include file="footer.jsp" %>