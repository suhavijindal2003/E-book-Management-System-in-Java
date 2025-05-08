<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- FontAwesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
</head>

<body>
    <div class="container py-3">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card">
                    <div class="card-body">
                        <h3 class="text-center fw-bold text-dark p-2 rounded">Registration</h3>

                        <!-- ✅ Show Success/Failure Message -->
                        <%
                            String succMsg = (String) session.getAttribute("succMsg");
                            String failMsg = (String) session.getAttribute("failMsg");
                            if (succMsg != null) {
                        %>
                            <div class="alert alert-success" role="alert"><%= succMsg %></div>
                        <%
                                session.removeAttribute("succMsg");
                            } else if (failMsg != null) {
                        %>
                            <div class="alert alert-danger" role="alert"><%= failMsg %></div>
                        <%
                                session.removeAttribute("failMsg");
                            }
                        %>

                        <!-- ✅ Registration Form -->
                        <form action="register" method="post">
                            <div class="mb-3">
                                <label for="name" class="form-label">Full Name</label>
                                <input type="text" class="form-control" id="name" name="name" required>
                            </div>

                            <div class="mb-3">
                                <label for="phone" class="form-label">Phone Number</label>
                                <input type="tel" class="form-control" id="phone" name="phone" required>
                            </div>

                            <div class="mb-3">
                                <label for="email" class="form-label">Email address</label>
                                <input type="email" class="form-control" id="email" name="email" required>
                            </div>

                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>

                            <div class="mb-3">
                                <label for="address" class="form-label">Address</label>
                                <textarea class="form-control" id="address" name="address" rows="2" required></textarea>
                            </div>

                            <button type="submit" class="btn btn-primary w-100">Register</button>
                        </form>

                        <div class="text-center mt-3">
                            <a href="login.jsp">Already have an account? Login</a>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>

<%@ include file="footer.jsp" %>
