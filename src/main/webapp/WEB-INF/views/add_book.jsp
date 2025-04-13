<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="adminheader.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Books</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" type="text/css" href="./static/CSS/style.css">
</head>
<body style="background-color: #f0f2f2;">
    
    <div class="container pt-5">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card">
                    <div class="card-body">
                        <h4 class="text-center">Add Books</h4>

                        <!-- Display messages -->
                        <%
                            String succMsg = (String) session.getAttribute("succMsg");
                            String failMsg = (String) session.getAttribute("failMsg");
                            if (succMsg != null) {
                        %>
                            <div class="alert alert-success" role="alert"><%= succMsg %></div>
                        <%
                                session.removeAttribute("succMsg");
                            }
                            if (failMsg != null) {
                        %>
                            <div class="alert alert-danger" role="alert"><%= failMsg %></div>
                        <%
                                session.removeAttribute("failMsg");
                            }
                        %>

                        <form action="AdminAddBookServlet" method="post" enctype="multipart/form-data">
                            <div class="form-group mb-3">
                                <label>Book Name*</label>
                                <input name="bname" type="text" class="form-control" required>
                            </div>

                            <div class="form-group mb-3">
                                <label>Author Name*</label>
                                <input name="author" type="text" class="form-control" required>
                            </div>

                            <div class="form-group mb-3">
                                <label>Price*</label>
                                <input name="price" type="number" step="0.01" class="form-control" required>
                            </div>

                            <div class="form-group mb-3">
                                <label>Book Category</label>
                                <select name="btype" class="form-control" required>
                                    <option value="">--select--</option>
                                    <option value="New">New Book</option>
                                    <option value="Old">Old Book</option>
                                </select>
                            </div>

                            <div class="form-group mb-3">
                                <label>Book Status</label>
                                <select name="bstatus" class="form-control" required>
                                    <option value="">--select--</option>
                                    <option value="Active">Active</option>
                                    <option value="Inactive">Inactive</option>
                                </select>
                            </div>

                            <div class="form-group mb-3">
                                <label>Upload Book Image</label>
                                <input name="bimg" type="file" class="form-control" accept="image/*" required>
                            </div>

                            <button type="submit" class="btn btn-primary w-100">Add Book</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>

<%@ include file="footer.jsp" %>
