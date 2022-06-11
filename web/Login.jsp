<%-- 
    Document   : Login.jsp
    Created on : 11-06-2022, 08:19:07
    Author     : tram nguyen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </head>
    <body class="vh-100 overflow-hidden">
        <div class="container h-100">
            <div class="row justify-content-center align-items-center h-100">
                <div class="card col-8 col-lg-4 h-50">
                    <div class="card-header" style="background: white" >
                        <h4>Welcome To </h4>
                        <h2 class="text-success">Freshetables</h2>
                    </div>
                    <form class="card-body" action="Login" method="POST">
                        <div class="mb-4">
                            <label for="username" class="form-label">Username: </label>
                            <input name="username" class="form-control" type="text" id="username">
                        </div>
                        <div class="mb-4">
                            <label for="password" class="form-label">Password: </label>
                            <input name="password" class="form-control" type="password" id="password">
                        </div>
                        <input name="submit" class="btn btn-outline-primary" type="submit" value="login"> 
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
