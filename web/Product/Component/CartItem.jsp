<%-- 
    Document   : CartItem
    Created on : 15-06-2022, 19:55:48
    Author     : tram nguyen
--%>
<%
    DTO.CartProductList list = (DTO.CartProductList) request.getAttribute("carts");

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
    for (DTO.CartPoduct product : list) {
%>
<div class="container col-8">
    <div class="card">
        <div class="card-header h4"><%= product.getProductName()%></div>
        <div class="card-body">
            <div class="row p-2 justify-content-between align-items-end ">
                <div class="row col-8 col-lg-6">
                    <div class="col-5 h-50">
                        <image src="<%= product.getProductImgLink()%>" class="img-fluid" ></image>
                    </div>
                    <div class="col-7">
<!--                        <p class="text-primary">
                            Volumn: <span> <%=product.getVolumn() %> </span>
                        </p>-->
                        <p class="text-primary bottom-0">
                            Total price: <span> <%= product.getPrice() %> VND </span>
                        </p>
                    </div>
                </div>
                <form action="Cart" method="GET" class="row col-4 col-lg-6  gap-2 pr-2 h-50 justify-content-end"  >
                    <input class="col-6 col-lg-3 col-xl-2" type="number" name="volumn" value="<%= product.getVolumn() %>" min="0" id="productVolumn" step="1">
                    <input class="d-none" type="String" name="productId" value="<%= product.getProductId()%>" id="productId">
                    <input class="d-none" type="String" name="method" value="PUT" id="method">
                    <input class="btn btn-primary col-6 col-md-5 col-lg-3 col-xl-2" id="liveToastBtn" type="submit" value="Update">
                </form>
            </div>
        </div>
    </div>
</div>

<%
    }
%>