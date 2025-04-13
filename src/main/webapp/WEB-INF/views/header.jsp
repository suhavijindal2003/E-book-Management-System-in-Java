<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Navbar</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
        integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" type="text/css" href="./static/CSS/style.css">
</head>
<body>
    <div class="container-fluid p-4">
        <div class="row">
            <div class="col-md-3">
                <h3 class="fs-1 text-success fw-bold"> 
                    <i class="fa-solid fa-book p-1" style="color: #198811;"></i>BookHub
                </h3>
            </div>
            <div class="col-md-6">
                <form class="d-flex mt-2" role="search">
                    <input class="form-control" type="search" placeholder="Search" aria-label="Search" style="width:300px;">
                    <button class="btn btn-primary my-2 my-sm-0 rounded" type="submit">Search</button>
                </form>
            </div>
            <div class="col-md-3 mt-2">
                <a href="/login" class="btn btn-primary rounded">
                    <i class="fa-solid fa-user p-1" style="color: #ebeef4;"></i>Login
                </a>
                <a href="/register" class="btn btn-success rounded">
                    <i class="fa-solid fa-right-to-bracket p-1" style="color: #fcfcfc;"></i>Register
                </a>

                <a href="/admin" class="btn btn-warning rounded">
                    <i class="fa-solid fa-user-shield p-1" style="color: #000;"></i>Admin
                </a>
            </div>
        </div>
    </div>

   

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkm6pS9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>