<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="header.jsp" %>
        <%@ include file="navbar.jsp" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Settings</title>

                <!-- Bootstrap CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                    crossorigin="anonymous">

                <!-- FontAwesome -->
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
                    integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqB7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
                    crossorigin="anonymous" referrerpolicy="no-referrer" />
            </head>

            <body style="background-color: #f7f7f7;">

                <div class="container">
                    <h3 class="text-center">Hello, Pabitra</h3>
                    <div class="row p-5">
                        <div class="col-md-6">
                            <a href="sell-book.jsp">
                                <div class="card">
                                    <div class="card-body text-center">
                                        <div class="text-primary">
                                            <i class="fas fa-book-open fa-3x"></i>
                                        </div>
                                        <h3>Sell Old Book</h3>
                                    </div>
                                </div>
                            </a>
                        </div>


                        <div class="col-md-6">
                            <a href="edit_profile.jsp">
                                <div class="card">
                                    <div class="card-body text-center">
                                        <div class="text-primary">
                                            <i class="fas fa-edit fa-3x"></i>
                                        </div>
                                        <h3>Login and Security(Edit Profile)</h3>
                                    </div>
                                </div>
                            </a>
                        </div>

                        <div class="col-md-6 mt=3">
                            <a href="">
                                <div class="card">
                                    <div class="card-body text-center">
                                        <div class="text-warning">
                                            <i class="fas fa-map-marker-alt fa-3x"></i>
                                        </div>
                                        <h4>Your Address</h4>
                                        <p>Edit Address</p>
                                    </div>
                                </div>
                            </a>
                        </div>

                        <div class="col-md-6 mt=3">
                            <a href="">
                                <div class="card">
                                    <div class="card-body text-center">
                                        <div class="text-danger">
                                            <i class="fas fa-box-open fa-3x"></i>
                                        </div>
                                        <h4>My Order</h4>
                                        <p>Track Your Order</p>
                                    </div>
                                </div>
                            </a>
                        </div>


                        <div class="col-md-6 mt=3">
                            <a href="">
                                <div class="card">
                                    <div class="card-body text-center">
                                        <div class="text-primary">
                                            <i class="fas fa-user-circle fa-3x"></i>
                                        </div>
                                        <h4>Help Center</h4>
                                        <p>24*7 Service</p>
                                    </div>
                                </div>
                            </a>
                        </div>


                    </div>
                </div>

            </body>
              

            </html>
            <%@ include file="footer.jsp" %>