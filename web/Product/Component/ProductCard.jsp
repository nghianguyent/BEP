<%-- 
    Document   : ProductCard
    Created on : 12-06-2022, 14:53:02
    Author     : tram nguyen
--%>
<%
    DTO.ProductList list = (DTO.ProductList) request.getAttribute("productList");
    
   // check if the list has no card, display to notify         
    if (list.size() == 0) {
%>
<div class="col">
    <div class="card">
        <div class="card-body">
            <p class="text-primary">There are no product yet</p>
        </div>
    </div>
</div>
<%
        return;
    }
    // render card list to view
    for (DTO.Product product : list) {
%>
<div class="col">
    <div class="card ">
        <img class="card-img-top" style="height: 235px" src="<%= product.getImgLink()%>"  alt="cucumber">
        <div class="card-body">
            <h5 class="card-title">
                <%= product.getName()%>
                <%--<c:out value="${product}" />--%>
            </h5>
            <h6 class="card-text text-primary">Price: <span><%= (int)product.getPrice()%> VND / Unit</span></h6>
            <h6 class="card-text text-primary">Remaining: <span><%= product.getVolumn()%></span>   <span>Unit</span></h6>
            <p class="card-text"> <%= product.getDescription()%> </p>
            <form class="row gap-2 p-2"  action="Cart" method="POST">
                <input class="col-5 col-sm-3 col-md-4" type="number" name="volumn" value="0" min="0" id="productVolumn" step="1">
                <input class="d-none" type="String" name="productId" value="<%= product.getId()%>" id="productId">
                <input class="btn btn-primary col-4" id="liveToastBtn" type="submit" value="Add">
            </form>
        </div>
    </div>  
</div>
<%
    }
%>
