<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<%@ include file="adminheader.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
        integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" type="text/css" href="./static/CSS/style.css">
</head>

<body>


    <div class="container text-center mt-4 ">
        <h2>Admin Dashboard</h2>
        <div class="row mt-4 pb-5">
            <div class="col-md-3">
                <a href="/add_book" class="text-decoration-none">
                    <div class="dashboard-card bg-light">
                        <i class="fas fa-plus-square text-primary"></i>
                        <h5>Add Book</h5>
                    </div>
                </a>
            </div>
            <div class="col-md-3">
                <a href="/books" class="text-decoration-none">
                    <div class="dashboard-card bg-light">
                        <i class="fas fa-book text-danger"></i>
                        <h5>All Books</h5>
                    </div>
                </a>
            </div>
            <div class="col-md-3">
                <a href="/orderlist" class="text-decoration-none">
                    <div class="dashboard-card bg-light">
                        <i class="fas fa-box text-warning"></i>
                        <h5>OrderList</h5>
                    </div>
                </a>
            </div>
            <div class="col-md-3">
                <a href="javascript:void(0);" class="text-decoration-none" onclick="confirmLogout();">
                    <div class="dashboard-card bg-light">
                        <i class="fas fa-sign-out-alt text-primary"></i>
                        <h5>Logout</h5>
                    </div>
                </a>
            </div>
        </div>
    </div>
</body>
<script>
    function confirmLogout() {
        if (confirm("Are you sure you want to log out?")) {
            window.location.href = "/main"; // Redirect to logout servlet
        }
    }
</script>
</html>

<!-- <%@ include file="footer.jsp" %> -->
