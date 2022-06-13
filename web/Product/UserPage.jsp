<%-- 
    Document   : UserPage
    Created on : 12-06-2022, 14:51:31
    Author     : tram nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("list", request.getAttribute("productList"));
%>
<div class="container mw-100 p-4" id="productContainer">
    <div class="row row-cols-2 row-cols-md-3  row-cols-lg-5 g-4 ">
        <%
            DTO.ProductList list = (DTO.ProductList) request.getAttribute("productList");
            for (DTO.Product product : list) {
        %>
        <div class="col">
            <div class="card ">
                <img class="card-img-top" src="<%= product.getImgLink() %>"  alt="cucumber">
                <div class="card-body">
                    <h5 class="card-title">
                        <%= product.getName()%>
                        <%--<c:out value="${product}" />--%>
                    </h5>
                    <h6 class="card-text text-primary">Price: <span><%= product.getPrice()%></span></h6>
                    <h6 class="card-text text-primary">Remaining: <span><%= product.getVolumn() %></span>   <span>Unit</span></h6>
                    <p class="card-text"> <%= product.getDescription()%> </p>
                    <form class="row gap-2 p-2" >
                        <input class="col-3" type="number" name="volumn" value="0" id="productVolumn" step="1">
                        <input class="btn btn-primary col-2" id="liveToastBtn" type="submit" value="Add">
                    </form>
                </div>
            </div>  
        </div>
        <%
            }
        %>

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
