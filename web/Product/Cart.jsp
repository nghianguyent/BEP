<%-- 
    Document   : Cart
    Created on : 15-06-2022, 17:43:29
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
        <jsp:include  page="/Component/Navbar.jsp"></jsp:include>

        <%
            String message = (String) session.getAttribute("message");
            if (message != null) {
                if (message.contains("Success".subSequence(0, 7))) {

        %>
        <jsp:include page="/Component/SuccessAdded.jsp"></jsp:include>
        <%            }
            if (message.contains("Fail".subSequence(0, 4))) {
        %>
        <jsp:include page="/Component/FailAdded.jsp"></jsp:include>
        <%
                }
                session.setAttribute("message", null);
            }

        %>
        <div class="row p-4 gap-4"> 
            <form action="Cart" method="POST" class="container col-8  gap-2 pr-2 h-50"  >
                <input class="d-none" id="checkout" name="method" value="DELETE">
                <input class="btn btn-primary float-end col-6 col-md-5 col-lg-3 col-xl-2" id="liveToastBtn" type="submit" value="Checkout">
            </form>
            <jsp:include page="./Component/CartItem.jsp"></jsp:include>
        </div>

    </body>
</html>