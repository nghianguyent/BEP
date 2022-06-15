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
                <div class="row col-8 col-xl-4">
                    <div class="col-6">
                        <image src="<%= product.getProductImgLink()%>" class="img-fluid" ></image>
                    </div>
                    <div class="col-6">
                        <p class="text-primary">
                            Volumn: <span> <%=product.getVolumn() %> </span>
                        </p>
                        <p class="text-primary bottom-0">
                            Total price: <span> <%= product.getPrice() %> VND </span>
                        </p>
                    </div>
                </div>
                <form class="row col-4 col-lg-3  gap-2 pr-2 h-50 justify-content-end"  action="Cart" method="PUT">
                    <input class="col-4 col-sm-3 col-md-4" type="number" name="volumn" value="0" min="0" id="productVolumn" step="1">
                    <input class="d-none" type="String" name="productId" value="" id="productId">
                    <input class="btn btn-primary col-7" id="liveToastBtn" type="submit" value="Update">
                </form>
            </div>
        </div>
    </div>
</div>

<%
    }
%>