<%-- 
    Document   : Home
    Created on : 10-06-2022, 21:37:42
    Author     : tram nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/js/all.min.js" integrity="sha512-6PM0qYu5KExuNcKt5bURAoT6KCThUmHRewN3zUFNaoI6Di7XJPTMoT6K0nsagZKk2OB4L7E3q1uQKHNHd4stIQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            Cookie[] cookies = request.getCookies();
            String username = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().compareTo("username") == 0) {
                    username = cookie.getValue();
                }
            }
        %>
        <!--<h1>Hello  <%= username%> </h1>-->
        <nav class="navbar navbar-expand-lg bg-success">
            <div class="container-fluid">
                <a  href="/home" class="navbar-brand h1 text-success bg-white p-2" >Freshatables</a>
                <button 
                    class="navbar-toggler bg-white" 
                    type="button" 
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarMenu" 
                    aria-controls="navbarMenu" 
                    aria-expanded="false" 
                    aria-label="Toggle navigation"
                    >
                    <span class="navbar-toggler-icon "></span>
                </button>
                <div class="collapse active navbar-collapse" id="navbarMenu">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active text-white" aria-current="page" href="/home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active text-white" aria-current="page" href="/home">Account</a>
                        </li>
                    </ul>
                    <button class="btn bg-white btn-outline-success mr-2" type="button" >
                        <a href="/home" class="link-success">
                            <i class="fa-solid fa-cart-shopping"></i>
                        </a>
                    </button>
                </div>
            </div>
        </nav>
        <jsp:include page="/Product/UserPage.jsp"></jsp:include>
    </body>
</html>
