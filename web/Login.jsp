<%-- 
    Document   : Login
    Created on : 10-06-2022, 09:32:13
    Author     : tram nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form class="login_form" action="Login" method="GET">
            <label>Username: </label>
            <input name="username" type="text" id="username">
            <label>password: </label>
            <input name="password" type="password" id="password">
            <input name="submit" type="submit" value="login"> 
        </form>
    </body>
</html>
