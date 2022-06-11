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
    </head>
    <body>
        <h1>Welcome To Freshetables</h1>
        <form class="login_form" action="Login" method="POST">
            <label>Username: </label>
            <input name="username" type="text" id="username">
            <label>password: </label>
            <input name="password" type="password" id="password">
            <input name="submit" type="submit" value="login"> 
        </form>
    </body>
</html>
