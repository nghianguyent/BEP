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
    </head>
    <body>
        <h1>Hello <%= session.getAttribute("username") %> </h1>
    </body>
</html>
