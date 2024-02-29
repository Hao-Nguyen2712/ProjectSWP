<%-- 
    Document   : thanks
    Created on : Feb 29, 2024, 9:01:49 AM
    Author     : thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://kit.fontawesome.com/ae360af17e.js" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="/Front/assets/image/logo/z4705695345706_20ca59964f9ad379fcebb44ceaad6cd4-removebg-preview.png"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="../Header/Header.jsp" %>

        <div class="d-flex align-items-center justify-content-center vh-100">
            <div class="text-center">
                <h1 class="display-1 fw-bold">Thank you!</h1>
                <p class="fs-3"> Đặt hàng thành công. Đơn hàng sẽ nhanh chóng được chuyển đến bạn trong vài ngày tới <i class="fa-solid fa-check" style="color: #00fa1d;"></i> `</p>
                <p class="fs-3"> Cảm ơn bạn rất nhiều <i class="fa-solid fa-heart" style="color: #e23e2c;"></i></p>
                <a href="/" class="btn btn-primary">Go Home</a>
            </div>
        </div>
        <%@include file="../Footer/Footer.jsp" %>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
