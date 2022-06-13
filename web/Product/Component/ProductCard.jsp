<%-- 
    Document   : ProductCard
    Created on : 12-06-2022, 14:53:02
    Author     : tram nguyen
--%>
<div class="col">
    <div class="card ">
        <img class="card-img-top" src="https://cdn.caythuocdangian.com/2019/11/qua-dua-leo.jpg "  alt="cucumber">
        <div class="card-body">
            <h5 class="card-title">Cucumber</h5>
            <h6 class="card-text text-primary">Price: <span>100</span></h6>
            <h6 class="card-text text-primary">Remaining: <span>100</span> <span>item</span></h6>
            <p class="card-text">Some description</p>
            <form class="row gap-2 p-2" >
                <input class="col-3" type="number" name="volumn" value="0" id="productVolumn" step="1">
                <input class="btn btn-primary col-2" id="liveToastBtn" type="submit" value="Add">
            </form>
            <jsp:include page="./Notification.jsp"></jsp:include>
        </div>
    </div>
</div>