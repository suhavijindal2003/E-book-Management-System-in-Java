<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recent Books</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="./static/CSS/style.css">
</head>

<body>
    <div class="container">
        <h2 class="fs-1 fw-bold text-center pt-4">Recent Books</h2>
        <div class="row">
            <!-- Example Book 1 -->
            <div class="col-md-3">
                <div class="card crd-ho">
                    <div class="card-body text-center">
                        <img src="./static/images/java.jpg" style="width: 150px; height: 200px;">
                        <p class="fs-4">Java Programming</p>
                        <p class="fs-4">Balguruswamy</p>
                        <p class="fs-4">Category: New</p>
                        <a href="#" class="btn btn-danger btn-sm"><i class="fa-solid fa-cart-shopping"></i> Add Cart</a>
                        <a href="#" class="btn btn-success btn-sm">View Details</a>
                        <a href="#" class="btn btn-danger btn-sm"><i class="fa-solid fa-indian-rupee-sign"></i> 299</a>
                    </div>
                </div>
            </div>
            <!-- Add more books dynamically using Java -->
        </div>
    </div>
</body>

</html>
<%@ include file="footer.jsp" %>
