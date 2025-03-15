<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<%@ include file="adminheader.jsp" %>

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
<body style="background-color: #f0f2f2;">
 
    <div class="caontainer pt-5">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card">
                    <div class="card-body">
                        <h4 class="text-center">Add Books</h4>
                        <form action="./AdminAddBookServlet" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Book Name*</label>
                                <input name="bname" type="text" class="form-control" 
                                    id="exampleInputEmail1" aria-describedby="emailHelp">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Author Name*</label>
                                <input name="author" type="text" class="form-control" 
                                    id="exampleInputEmail1" aria-describedby="emailHelp">
                            </div>
                            <div class="form-group" >
                                <label for="exampleInputPassword1">Price*</1abe1> <input name="price" type="number" class="form-control" id="exampleInputPassword1" >
                            </div>

                            <div class="form-group">
                                <label for="inputState">Book Categories</label>
                                <select id="inputState" name="btype" class="form-control">
                                    <option selected>--select--</option>
                                    <option value="New">New Book</option>
                                </select>
                            </div>
                            
                            <div class="form-group">
                                <label for="inputState">Book Status</label>
                                <select id="inputState" name="bstatus" class="form-control">
                                    <option selected>--select--</option>
                                    <option value="Active">Active</option>
                                    <option value="Inactive">Inactive</option>
                                </select>
                            </div>
                            
                            <div class="form-group">
                                <label for="exampleFormControlFile1">Upload Photo</label>
                                <input name="bimg" type="file" class="form-control-file" id="exampleFormControlFile1">
                            </div>
                            
                            <button type="submit" class="btn btn-primary">Add</button>
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>
<%@ include file="footer.jsp" %>