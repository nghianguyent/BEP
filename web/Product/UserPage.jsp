<%-- 
    Document   : UserPage
    Created on : 12-06-2022, 14:51:31
    Author     : tram nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mw-100" id="productContainer">
    <%
        String message = (String) session.getAttribute("message");
        if (message != null) {
            if (message.compareTo("success") == 0) {

    %>
    <jsp:include page="../Component/SuccessAdded.jsp"></jsp:include>
    <%            }
        if (message.contains("Fail".subSequence(0, 4))) {
    %>
    <jsp:include page="../Component/FailAdded.jsp"></jsp:include>
    <%
            }
            session.setAttribute("message", null);
        }

    %>
    <div class="row p-4 row-cols-2 row-cols-md-3  row-cols-lg-4 row-cols-xl-5 g-4 ">
        <jsp:include page="./Component/ProductCard.jsp"></jsp:include>
    </div>
    <!--    <div class="toast-container position-fixed bottom-0 end-0 p-3" >
            <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="toast-header">
                    <h2 class="text-success">Success</h2>
                    <button class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
                <div class="toast-body">
                    You added one product!
                </div>
            </div>
        </div>-->
</div>
