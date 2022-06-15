<%-- 
    Document   : navbar
    Created on : 15-06-2022, 17:54:31
    Author     : tram nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg bg-success">
    <div class="container-fluid">
        <a  href="/home" class="navbar-brand h1 text-success bg-white p-2" >Freshatables</a>
        <button 
            class="navbar-toggler bg-white" 
            type="button" 
            data-bs-toggle="collapse"
            data-bs-target="#navbarMenu" 
            aria-controls="navbarMenu" 
            aria-expanded="false" 
            aria-label="Toggle navigation"
            >
            <span class="navbar-toggler-icon "></span>
        </button>
        <div class="collapse active navbar-collapse" id="navbarMenu">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active text-white" aria-current="page" href="/home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active text-white" aria-current="page" href="/home">Account</a>
                </li>
            </ul>
            <a href="/Cart" class="link-success">
                <button class="btn bg-white btn-outline-success mr-2" type="button" >
                    <i class="fa-solid fa-cart-shopping"></i>
                </button>
            </a>
        </div>
    </div>
</nav>
