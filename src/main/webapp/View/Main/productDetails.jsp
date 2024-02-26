
<%@page import="Models.Earphone"%>
<%@page import="Models.Mouse"%>
<%@page import="DAOs.ProductDAO"%>
<%@page import="Models.Switch"%>
<%@page import="Models.Kit"%>
<%@page import="Models.Keycap"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="DAOs.KeyboardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Keyboard"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Nghien Nhua</title>
        <link rel="shortcut icon" href="/Front/assets/image/logo/z4705695345706_20ca59964f9ad379fcebb44ceaad6cd4-removebg-preview.png"/>
        <!-- link boostrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <!-- link font awesome-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <!-- Link css slick slider -->
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
        <!-- link to css -->        
        <link rel="stylesheet" href="./../../Root/Css/productDetail.css"/>

        <title>JSP Page</title>

    </head>
    <body style="z-index: 1200">
        <ul class="notifications"></ul>
        <%@include file="../Header/Header.jsp" %>
        <%            String type = (String) session.getAttribute("typeNow");
            if (type.equals("Keyboard")) {

                Keyboard key = (Keyboard) session.getAttribute("getProduct");
                String[] image = (String[]) session.getAttribute("listImage");
                KeyboardDAO keyDAO = new KeyboardDAO();
        %>

        <section class="py-2" style="margin-top: 120px">
            <div class="container-xxl">
                <div class="row">
                    <div class="col-md-3 ">
                        <div class="row">
                            <div class="aside-left">
                                <div class="product-list">
                                    <ul>
                                        <li><a href="/ProductController/Keyboard">Keyboard</a></li>
                                        <li><a href="/ProductController/Kit-ban-phim">Kit Bàn Phím</a></li>
                                        <li><a href="/ProductController/Key-cap">Keycap</a></li>
                                        <li><a href="/ProductController/Switch">Switch</a></li>
                                        <li><a href="/ProductController/Mouse">Mouse</a></li>
                                        <li><a href="/ProductController/Earphone">Earphone</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-9 border-start mb-5">
                        <div class="row gx-5 pb-5 px-3">
                            <aside class="col-md-6">

                                <div class="galleryImage">
                                    <div class="discontContainer">

                                    </div>

                                    <div class="topGallery" id="topGallery">
                                        <%                                            int count = 0;
                                            while (count != image.length) {
                                                if (count == 0) {

                                        %>
                                        <div class="imageItems" onmouseover="hovertopGallery()">
                                            <img class="itemsImg" src="../../Root/Images/Product/<%= image[count]%>" alt="">
                                        </div>
                                        <%                                            count++;
                                        } else {
                                        %>
                                        <div class="imageItems">
                                            <img class="itemsImg" src="../../Root/Images/Product/<%= image[count]%>" alt="">
                                        </div>
                                        <%
                                                    count++;
                                                }
                                            }
                                        %>
                                        <a class="prev btnGallery" onclick="plusSlides(-1)">&#10094;</a>
                                        <a class="next btnGallery" onclick="plusSlides(1)">&#10095;</a>
                                    </div>
                                    <div class="thumbPhoto" onmouseover="hovertopGallery()">
                                        <%
                                            count = 1;
                                            while (count != image.length + 1) {
                                        %>
                                        <div onclick="currentSlide(<%= count%>)" class="thumbImage"><img class="itemsImg thumbImage_Items"
                                                                                                         src="../../Root/Images/Product/<%= image[count - 1]%>" alt="">
                                        </div>
                                        <%
                                                count++;
                                            }
                                        %>

                                    </div>
                                </div>


                                <!-- thumbs-wrap.// -->
                                <!-- gallery-wrap .end// -->
                            </aside>
                            <main class="col-md-6">
                                <div class="ps-lg-3">
                                    <a class="title text-muted text-uppercase text-decoration-none" href="#!">Trang Chủ</a> / <a
                                        class="title text-muted text-uppercase text-decoration-none" href="#!"><%=type%></a>
                                    <h4 class="titleProduct"> <%= key.getPro_id().getPro_name()%> </h4>
                                    <div class="d-flex">
                                        <div class="vr my-3" style="width: 50px; height: 2px; background-color: #e5e5e5;"></div>
                                    </div>
                                    <div class="mb-3">
                                        <%
                                            if (key.getPro_id().getPro_discount() != "0") {
                                        %>
                                        <span class="h5 text-decoration-line-through text-muted fs-4 text">
                                            <p class="d-inline text">₫<%=  keyDAO.converterNumber(keyDAO.getPriceBeforeDiscount(Integer.parseInt(key.getPro_id().getPro_discount()), Integer.parseInt(key.getPro_id().getPro_price())))%> </p>
                                        </span>
                                        <%
                                            }
                                        %>
                                        <span class="h5 ms-2  fs-4 text">
                                            <p class="d-inline text">₫<%=  keyDAO.converterNumber(Integer.parseInt(key.getPro_id().getPro_price()))%></p>
                                        </span>
                                    </div>

                                    <div>
                                        <h5 class="text-danger bg-light d-inline">Khuyến Mãi:</h4>
                                            <ul>
                                                <li class="my-2">Freeship toàn quốc khi đặt hàng tại Nghiennghua.vn</li>
                                                <li class="my-2">Chế độ bảo hành 1 đổi 1 trong suốt thời gian bảo hành</li>
                                                <li class="my-2">Chi nhánh bảo hành 3 miền: Bắc – Trung – Nam</li>
                                            </ul>
                                    </div>
                                    <hr />

                                    <form method="post" action="ProductController">
                                        <div class="row mb-4">
                                            <!-- col.// -->
                                            <div class="col-md-4 col-6 mb-3">
                                                <label class="mb-2 d-block">Số lượng</label>
                                                <div class="input-group mb-1" style="width: 170px;">
                                                    <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon1"
                                                            data-mdb-ripple-color="dark">
                                                        <i class="fas fa-minus"></i>
                                                    </button>
                                                    <!-- <input type="text" class="form-control text-center border border-secondary" placeholder="14"
                                                      aria-label="Example text with button addon" aria-describedby="button-addon1" /> -->
                                                    <input type="number" name="txtQuantity" class="form-control text-center border border-secondary" value="1"
                                                           placeholder="1" aria-label="Example text with button addon" aria-describedby="button-addon1"
                                                           id="quantityInput" readonly/>
                                                    <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon2"
                                                            data-mdb-ripple-color="dark">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                        <!--<i class="me-1 fa fa-shopping-basket"></i>-->
                                        <input type="submit" name="btnAddCart" class="btn btn-primary shadow-0" value="Thêm vào giỏ hàng"/>  


                                    </form>
                                </div>
                            </main>
                        </div>
                        <div class="row gx-4">
                            <div class="col-lg-8 mb-4">
                                <div class="border rounded-2 px-3 py-2 bg-white">
                                    <!-- Pills navs -->
                                    <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                                        <li class="nav-item d-flex" role="presentation">
                                            <a class="nav-link d-flex align-items-center justify-content-center w-100 active" id="ex1-tab-1"
                                               data-mdb-toggle="pill" href="#ex1-pills-1" role="tab" aria-controls="ex1-pills-1"
                                               aria-selected="true">Mô Tả</a>
                                        </li>
                                    </ul>
                                    <!-- Pills navs -->

                                    <!-- Pills content -->
                                    <div class="tab-content" id="ex1-content">
                                        <div class="tab-pane fade show active" id="ex1-pills-1" role="tabpanel" aria-labelledby="ex1-tab-1">
                                            <p>
                                                <%= key.getPro_id().getPro_description()%>
                                            </p>

                                            <table class="table border mt-3 mb-2">
                                                <tr>
                                                    <th class="py-2">Led:</th>
                                                    <td class="py-2"><%= key.getLed()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Mode:</th>
                                                    <td class="py-2"><%= key.getMode()%> Mode</td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Switch:</th>
                                                    <td class="py-2"><%= key.getSwitch()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Keycap:</th>
                                                    <td class="py-2"><%= key.getKeycap()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Plate:</th>
                                                    <td class="py-2"><%= key.getPlate()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Case:</th>
                                                    <td class="py-2"><%= key.getCase()%></td>
                                                </tr>

                                            </table>
                                        </div>
                                    </div>
                                    <!-- Pills content -->
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="px-0 border rounded-2 shadow-0">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">Sản Phẩm Tương Tự</h5>
                                            <%
                                                ProductDAO pDAO = new ProductDAO();
                                                ResultSet rs = pDAO.getSimilarProduct(type, key.getPro_id().getPro_id());
                                                int dem = 0;
                                                while (rs.next()) {
                                                    if (dem == 2) {
                                                        break;
                                                    }

                                                    String[] listImage = rs.getString("pro_image").split("&");
                                            %>
                                            <div class="d-flex mb-3">
                                                <a href="/ProductController/Keyboard/<%= rs.getInt("pro_id")%>" class="me-3">
                                                    <img src="../../Root/Images/Product/<%= listImage[0]%>"
                                                         style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                                </a>
                                                <div class="infoo">
                                                    <a href="/ProductController/Keyboard/<%= rs.getInt("pro_id")%>" class="nav-link mb-1">
                                                        <%= rs.getString("pro_name")%> 
                                                    </a>
                                                    <strong class="text-dark"> ₫<%= keyDAO.converterNumber(rs.getInt("pro_price"))%></strong>
                                                </div>
                                            </div>
                                            <%
                                                    dem++;

                                                }
                                            %>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>

            </div>
        </section>

        <%            }
        %>
        <%
            if (type.equals("Kit-ban-phim")) {

                Kit kit = (Kit) session.getAttribute("getProduct");
                String[] image = (String[]) session.getAttribute("listImage");
                KeyboardDAO keyDAO = new KeyboardDAO();
        %>
        <section class="py-2" style="margin-top: 120px">
            <div class="container-xxl">
                <div class="row">
                    <div class="col-md-3 ">
                        <div class="row">
                            <div class="aside-left">
                                <div class="product-list">
                                    <ul>
                                        <li><a href="/ProductController/Keyboard">Keyboard</a></li>
                                        <li><a href="/ProductController/Kit-ban-phim">Kit Bàn Phím</a></li>
                                        <li><a href="/ProductController/Key-cap">Keycap</a></li>
                                        <li><a href="/ProductController/Switch">Switch</a></li>
                                        <li><a href="/ProductController/Mouse">Mouse</a></li>
                                        <li><a href="/ProductController/Earphone">Earphone</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-9 border-start mb-5">
                        <div class="row gx-5 pb-5 px-3">
                            <aside class="col-md-6">

                                <div class="galleryImage">
                                    <div class="discontContainer">

                                    </div>

                                    <div class="topGallery" id="topGallery">
                                        <%                                            int count = 0;
                                            while (count != image.length) {
                                                if (count == 0) {

                                        %>
                                        <div class="imageItems" onmouseover="hovertopGallery()">
                                            <img class="itemsImg" src="../../Root/Images/Product/<%= image[count]%>" alt="">
                                        </div>
                                        <%
                                            count++;
                                        } else {
                                        %>
                                        <div class="imageItems">
                                            <img class="itemsImg" src="../../Root/Images/Product/<%= image[count]%>" alt="">
                                        </div>
                                        <%
                                                    count++;
                                                }
                                            }
                                        %>
                                        <a class="prev btnGallery" onclick="plusSlides(-1)">&#10094;</a>
                                        <a class="next btnGallery" onclick="plusSlides(1)">&#10095;</a>
                                    </div>
                                    <div class="thumbPhoto" onmouseover="hovertopGallery()">
                                        <%
                                            count = 1;
                                            while (count != image.length + 1) {
                                        %>
                                        <div onclick="currentSlide(<%= count%>)" class="thumbImage"><img class="itemsImg thumbImage_Items"
                                                                                                         src="../../Root/Images/Product/<%= image[count - 1]%>" alt="">
                                        </div>
                                        <%
                                                count++;
                                            }
                                        %>

                                    </div>
                                </div>


                                <!-- thumbs-wrap.// -->
                                <!-- gallery-wrap .end// -->
                            </aside>
                            <main class="col-md-6">
                                <div class="ps-lg-3">
                                    <a class="title text-muted text-uppercase text-decoration-none" href="#!">Trang Chủ</a> / <a
                                        class="title text-muted text-uppercase text-decoration-none" href="#!"><%=type%></a>
                                    <h4 class="titleProduct"> <%= kit.getPro_id().getPro_name()%> </h4>
                                    <div class="d-flex">
                                        <div class="vr my-3" style="width: 50px; height: 2px; background-color: #e5e5e5;"></div>
                                    </div>
                                    <div class="mb-3">
                                        <%
                                            if (kit.getPro_id().getPro_discount() != "0") {
                                        %>
                                        <span class="h5 text-decoration-line-through text-muted fs-4 text">
                                            <p class="d-inline text">₫<%=  keyDAO.converterNumber(keyDAO.getPriceBeforeDiscount(Integer.parseInt(kit.getPro_id().getPro_discount()), Integer.parseInt(kit.getPro_id().getPro_price())))%> </p>
                                        </span>
                                        <%
                                            }
                                        %>
                                        <span class="h5 ms-2  fs-4 text">
                                            <p class="d-inline text">₫<%=  keyDAO.converterNumber(Integer.parseInt(kit.getPro_id().getPro_price()))%></p>
                                        </span>
                                    </div>

                                    <div>
                                        <h5 class="text-danger bg-light d-inline">Khuyến Mãi:</h4>
                                            <ul>
                                                <li class="my-2">Freeship toàn quốc khi đặt hàng tại Nghiennghua.vn</li>
                                                <li class="my-2">Chế độ bảo hành 1 đổi 1 trong suốt thời gian bảo hành</li>
                                                <li class="my-2">Chi nhánh bảo hành 3 miền: Bắc – Trung – Nam</li>
                                            </ul>
                                    </div>
                                    <hr />

                                    <form method="post" action="ProductController">
                                        <div class="row mb-4">
                                            <!-- col.// -->
                                            <div class="col-md-4 col-6 mb-3">
                                                <label class="mb-2 d-block">Số lượng</label>
                                                <div class="input-group mb-1" style="width: 170px;">
                                                    <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon1"
                                                            data-mdb-ripple-color="dark">
                                                        <i class="fas fa-minus"></i>
                                                    </button>
                                                    <!-- <input type="text" class="form-control text-center border border-secondary" placeholder="14"
                                                      aria-label="Example text with button addon" aria-describedby="button-addon1" /> -->
                                                    <input type="number" name="txtQuantity" class="form-control text-center border border-secondary" value="1"
                                                           placeholder="1" aria-label="Example text with button addon" aria-describedby="button-addon1"
                                                           id="quantityInput" readonly/>
                                                    <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon2"
                                                            data-mdb-ripple-color="dark">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                        <!--<i class="me-1 fa fa-shopping-basket"></i>-->
                                        <input type="submit" name="btnAddCart" class="btn btn-primary shadow-0" value="Thêm vào giỏ hàng"/>  


                                    </form>
                                </div>
                            </main>
                        </div>
                        <div class="row gx-4">
                            <div class="col-lg-8 mb-4">
                                <div class="border rounded-2 px-3 py-2 bg-white">
                                    <!-- Pills navs -->
                                    <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                                        <li class="nav-item d-flex" role="presentation">
                                            <a class="nav-link d-flex align-items-center justify-content-center w-100 active" id="ex1-tab-1"
                                               data-mdb-toggle="pill" href="#ex1-pills-1" role="tab" aria-controls="ex1-pills-1"
                                               aria-selected="true">Mô Tả</a>
                                        </li>
                                    </ul>
                                    <!-- Pills navs -->

                                    <!-- Pills content -->
                                    <div class="tab-content" id="ex1-content">
                                        <div class="tab-pane fade show active" id="ex1-pills-1" role="tabpanel" aria-labelledby="ex1-tab-1">
                                            <p>
                                                <%= kit.getPro_id().getPro_description()%>
                                            </p>

                                            <table class="table border mt-3 mb-2">
                                                <tr>
                                                    <th class="py-2">Layout:</th>
                                                    <td class="py-2"><%= kit.getLayout()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Mạch:</th>
                                                    <td class="py-2"><%= kit.getCurcuit()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Plate:</th>
                                                    <td class="py-2"><%= kit.getPlate()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Mode:</th>
                                                    <td class="py-2"><%= kit.getMode()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Case:</th>
                                                    <td class="py-2"><%= kit.getCase()%></td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                    <!-- Pills content -->
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="px-0 border rounded-2 shadow-0">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">Sản Phẩm Tương Tự</h5>
                                            <%
                                                ProductDAO pDAO = new ProductDAO();
                                                ResultSet rs = pDAO.getSimilarProduct("Kit", kit.getPro_id().getPro_id());
                                                int dem = 0;
                                                while (rs.next()) {
                                                    if (dem == 2) {
                                                        break;
                                                    }

                                                    String[] listImage = rs.getString("pro_image").split("&");
                                            %>
                                            <div class="d-flex mb-3">
                                                <a href="/ProductController/Kit-ban-phim/<%= rs.getInt("pro_id")%>" class="me-3">
                                                    <img src="../../Root/Images/Product/<%= listImage[0]%>"
                                                         style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                                </a>
                                                <div class="infoo">
                                                    <a href="/ProductController/Kit-ban-phim/<%= rs.getInt("pro_id")%>" class="nav-link mb-1">
                                                        <%= rs.getString("pro_name")%> 
                                                    </a>
                                                    <strong class="text-dark"> ₫<%= keyDAO.converterNumber(rs.getInt("pro_price"))%></strong>
                                                </div>
                                            </div>
                                            <%
                                                    dem++;

                                                }
                                            %>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>

            </div>
        </section>
        <%
            }
        %>
        <%
            if (type.equals(
                    "Key-cap")) {

                Keycap key = (Keycap) session.getAttribute("getProduct");
                String[] image = (String[]) session.getAttribute("listImage");
                KeyboardDAO keyDAO = new KeyboardDAO();
        %>
        <section class="py-2" style="margin-top: 120px">
            <div class="container-xxl">
                <div class="row">
                    <div class="col-md-3 ">
                        <div class="row">
                            <div class="aside-left">
                                <div class="product-list">
                                    <ul>
                                        <li><a href="/ProductController/Keyboard">Keyboard</a></li>
                                        <li><a href="/ProductController/Kit-ban-phim">Kit Bàn Phím</a></li>
                                        <li><a href="/ProductController/Key-cap">Keycap</a></li>
                                        <li><a href="/ProductController/Switch">Switch</a></li>
                                        <li><a href="/ProductController/Mouse">Mouse</a></li>
                                        <li><a href="/ProductController/Earphone">Earphone</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-9 border-start mb-5">
                        <div class="row gx-5 pb-5 px-3">
                            <aside class="col-md-6">

                                <div class="galleryImage">
                                    <div class="discontContainer">

                                    </div>

                                    <div class="topGallery" id="topGallery">
                                        <%                                            int count = 0;
                                            while (count != image.length) {
                                                if (count == 0) {

                                        %>
                                        <div class="imageItems" onmouseover="hovertopGallery()">
                                            <img class="itemsImg" src="../../Root/Images/Product/<%= image[count]%>" alt="">
                                        </div>
                                        <%
                                            count++;
                                        } else {
                                        %>
                                        <div class="imageItems">
                                            <img class="itemsImg" src="../../Root/Images/Product/<%= image[count]%>" alt="">
                                        </div>
                                        <%
                                                    count++;
                                                }
                                            }
                                        %>
                                        <a class="prev btnGallery" onclick="plusSlides(-1)">&#10094;</a>
                                        <a class="next btnGallery" onclick="plusSlides(1)">&#10095;</a>
                                    </div>
                                    <div class="thumbPhoto" onmouseover="hovertopGallery()">
                                        <%
                                            count = 1;
                                            while (count != image.length + 1) {
                                        %>
                                        <div onclick="currentSlide(<%= count%>)" class="thumbImage"><img class="itemsImg thumbImage_Items"
                                                                                                         src="../../Root/Images/Product/<%= image[count - 1]%>" alt="">
                                        </div>
                                        <%
                                                count++;
                                            }
                                        %>

                                    </div>
                                </div>


                                <!-- thumbs-wrap.// -->
                                <!-- gallery-wrap .end// -->
                            </aside>
                            <main class="col-md-6">
                                <div class="ps-lg-3">
                                    <a class="title text-muted text-uppercase text-decoration-none" href="#!">Trang Chủ</a> / <a
                                        class="title text-muted text-uppercase text-decoration-none" href="#!"><%=type%></a>
                                    <h4 class="titleProduct"> <%= key.getPro_id().getPro_name()%> </h4>
                                    <div class="d-flex">
                                        <div class="vr my-3" style="width: 50px; height: 2px; background-color: #e5e5e5;"></div>
                                    </div>
                                    <div class="mb-3">
                                        <%
                                            if (key.getPro_id().getPro_discount() != "0") {
                                        %>
                                        <span class="h5 text-decoration-line-through text-muted fs-4 text">
                                            <p class="d-inline text">₫<%=  keyDAO.converterNumber(keyDAO.getPriceBeforeDiscount(Integer.parseInt(key.getPro_id().getPro_discount()), Integer.parseInt(key.getPro_id().getPro_price())))%> </p>
                                        </span>
                                        <%
                                            }
                                        %>
                                        <span class="h5 ms-2  fs-4 text">
                                            <p class="d-inline text">₫<%=  keyDAO.converterNumber(Integer.parseInt(key.getPro_id().getPro_price()))%></p>
                                        </span>
                                    </div>

                                    <div>
                                        <h5 class="text-danger bg-light d-inline">Khuyến Mãi:</h4>
                                            <ul>
                                                <li class="my-2">Freeship toàn quốc khi đặt hàng tại Nghiennghua.vn</li>
                                                <li class="my-2">Chế độ bảo hành 1 đổi 1 trong suốt thời gian bảo hành</li>
                                                <li class="my-2">Chi nhánh bảo hành 3 miền: Bắc – Trung – Nam</li>
                                            </ul>
                                    </div>
                                    <hr />

                                    <form method="post" action="ProductController">
                                        <div class="row mb-4">
                                            <!-- col.// -->
                                            <div class="col-md-4 col-6 mb-3">
                                                <label class="mb-2 d-block">Số lượng</label>
                                                <div class="input-group mb-1" style="width: 170px;">
                                                    <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon1"
                                                            data-mdb-ripple-color="dark">
                                                        <i class="fas fa-minus"></i>
                                                    </button>
                                                    <!-- <input type="text" class="form-control text-center border border-secondary" placeholder="14"
                                                      aria-label="Example text with button addon" aria-describedby="button-addon1" /> -->
                                                    <input type="number" name="txtQuantity" class="form-control text-center border border-secondary" value="1"
                                                           placeholder="1" aria-label="Example text with button addon" aria-describedby="button-addon1"
                                                           id="quantityInput" readonly/>
                                                    <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon2"
                                                            data-mdb-ripple-color="dark">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                        <!--<i class="me-1 fa fa-shopping-basket"></i>-->
                                        <input type="submit" name="btnAddCart" class="btn btn-primary shadow-0" value="Thêm vào giỏ hàng"/>  

                                    </form>
                                </div>
                            </main>
                        </div>
                        <div class="row gx-4">
                            <div class="col-lg-8 mb-4">
                                <div class="border rounded-2 px-3 py-2 bg-white">
                                    <!-- Pills navs -->
                                    <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                                        <li class="nav-item d-flex" role="presentation">
                                            <a class="nav-link d-flex align-items-center justify-content-center w-100 active" id="ex1-tab-1"
                                               data-mdb-toggle="pill" href="#ex1-pills-1" role="tab" aria-controls="ex1-pills-1"
                                               aria-selected="true">Mô Tả</a>
                                        </li>
                                    </ul>
                                    <!-- Pills navs -->

                                    <!-- Pills content -->
                                    <div class="tab-content" id="ex1-content">
                                        <div class="tab-pane fade show active" id="ex1-pills-1" role="tabpanel" aria-labelledby="ex1-tab-1">
                                            <p>
                                                <%= key.getPro_id().getPro_description()%>
                                            </p>

                                            <table class="table border mt-3 mb-2">
                                                <tr>
                                                    <th class="py-2">Chất Liệu:</th>
                                                    <td class="py-2"><%= key.getKc_material()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Profile:</th>
                                                    <td class="py-2"><%= key.getKc_layout()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Độ dày:</th>
                                                    <td class="py-2"><%= key.getKc_thickness()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Độ bền:</th>
                                                    <td class="py-2"><%= key.getKc_reliability()%></td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                    <!-- Pills content -->
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="px-0 border rounded-2 shadow-0">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">Sản Phẩm Tương Tự</h5>
                                            <%
                                                ProductDAO pDAO = new ProductDAO();
                                                ResultSet rs = pDAO.getSimilarProduct("Keycap", key.getPro_id().getPro_id());
                                                int dem = 0;
                                                while (rs.next()) {
                                                    if (dem == 2) {
                                                        break;
                                                    }

                                                    String[] listImage = rs.getString("pro_image").split("&");
                                            %>
                                            <div class="d-flex mb-3">
                                                <a href="/ProductController/Key-cap/<%= rs.getInt("pro_id")%>" class="me-3">
                                                    <img src="../../Root/Images/Product/<%= listImage[0]%>"
                                                         style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                                </a>
                                                <div class="infoo">
                                                    <a href="/ProductController/Keycap/<%= rs.getInt("pro_id")%>" class="nav-link mb-1">
                                                        <%= rs.getString("pro_name")%> 
                                                    </a>
                                                    <strong class="text-dark"> ₫<%= keyDAO.converterNumber(rs.getInt("pro_price"))%></strong>
                                                </div>
                                            </div>
                                            <%
                                                    dem++;

                                                }
                                            %>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>

            </div>
        </section>
        <%
            }
        %>
        <%
            if (type.equals(
                    "Switch")) {

                Switch swi = (Switch) session.getAttribute("getProduct");
                String[] image = (String[]) session.getAttribute("listImage");
                KeyboardDAO keyDAO = new KeyboardDAO();
        %>
        <section class="py-2" style="margin-top: 120px">
            <div class="container-xxl">
                <div class="row">
                    <div class="col-md-3 ">
                        <div class="row">
                            <div class="aside-left">
                                <div class="product-list">
                                    <ul>
                                        <li><a href="/ProductController/Keyboard">Keyboard</a></li>
                                        <li><a href="/ProductController/Kit-ban-phim">Kit Bàn Phím</a></li>
                                        <li><a href="/ProductController/Key-cap">Keycap</a></li>
                                        <li><a href="/ProductController/Switch">Switch</a></li>
                                        <li><a href="/ProductController/Mouse">Mouse</a></li>
                                        <li><a href="/ProductController/Earphone">Earphone</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-9 border-start mb-5">
                        <div class="row gx-5 pb-5 px-3">
                            <aside class="col-md-6">

                                <div class="galleryImage">
                                    <div class="discontContainer">

                                    </div>

                                    <div class="topGallery" id="topGallery">
                                        <%                                            int count = 0;
                                            while (count != image.length) {
                                                if (count == 0) {

                                        %>
                                        <div class="imageItems" onmouseover="hovertopGallery()">
                                            <img class="itemsImg" src="../../Root/Images/Product/<%= image[count]%>" alt="">
                                        </div>
                                        <%
                                            count++;
                                        } else {
                                        %>
                                        <div class="imageItems">
                                            <img class="itemsImg" src="../../Root/Images/Product/<%= image[count]%>" alt="">
                                        </div>
                                        <%
                                                    count++;
                                                }
                                            }
                                        %>
                                        <a class="prev btnGallery" onclick="plusSlides(-1)">&#10094;</a>
                                        <a class="next btnGallery" onclick="plusSlides(1)">&#10095;</a>
                                    </div>
                                    <div class="thumbPhoto" onmouseover="hovertopGallery()">
                                        <%
                                            count = 1;
                                            while (count != image.length + 1) {
                                        %>
                                        <div onclick="currentSlide(<%= count%>)" class="thumbImage"><img class="itemsImg thumbImage_Items"
                                                                                                         src="../../Root/Images/Product/<%= image[count - 1]%>" alt="">
                                        </div>
                                        <%
                                                count++;
                                            }
                                        %>

                                    </div>
                                </div>


                                <!-- thumbs-wrap.// -->
                                <!-- gallery-wrap .end// -->
                            </aside>
                            <main class="col-md-6">
                                <div class="ps-lg-3">
                                    <a class="title text-muted text-uppercase text-decoration-none" href="#!">Trang Chủ</a> / <a
                                        class="title text-muted text-uppercase text-decoration-none" href="#!"><%=type%></a>
                                    <h4 class="titleProduct"> <%= swi.getPro_id().getPro_name()%> </h4>
                                    <div class="d-flex">
                                        <div class="vr my-3" style="width: 50px; height: 2px; background-color: #e5e5e5;"></div>
                                    </div>
                                    <div class="mb-3">
                                        <%
                                            if (swi.getPro_id().getPro_discount() != "0") {
                                        %>
                                        <span class="h5 text-decoration-line-through text-muted fs-4 text">
                                            <p class="d-inline text">₫<%=  keyDAO.converterNumber(keyDAO.getPriceBeforeDiscount(Integer.parseInt(swi.getPro_id().getPro_discount()), Integer.parseInt(swi.getPro_id().getPro_price())))%> </p>
                                        </span>
                                        <%
                                            }
                                        %>
                                        <span class="h5 ms-2  fs-4 text">
                                            <p class="d-inline text">₫<%=  keyDAO.converterNumber(Integer.parseInt(swi.getPro_id().getPro_price()))%></p>
                                        </span>
                                    </div>

                                    <div>
                                        <h5 class="text-danger bg-light d-inline">Khuyến Mãi:</h4>
                                            <ul>
                                                <li class="my-2">Freeship toàn quốc khi đặt hàng tại Nghiennghua.vn</li>
                                                <li class="my-2">Chế độ bảo hành 1 đổi 1 trong suốt thời gian bảo hành</li>
                                                <li class="my-2">Chi nhánh bảo hành 3 miền: Bắc – Trung – Nam</li>
                                            </ul>
                                    </div>
                                    <hr />

                                    <form method="post" action="ProductController">
                                        <div class="row mb-4">
                                            <!-- col.// -->
                                            <div class="col-md-4 col-6 mb-3">
                                                <label class="mb-2 d-block">Số lượng</label>
                                                <div class="input-group mb-1" style="width: 170px;">
                                                    <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon1"
                                                            data-mdb-ripple-color="dark">
                                                        <i class="fas fa-minus"></i>
                                                    </button>
                                                    <!-- <input type="text" class="form-control text-center border border-secondary" placeholder="14"
                                                      aria-label="Example text with button addon" aria-describedby="button-addon1" /> -->
                                                    <input type="number" name="txtQuantity" class="form-control text-center border border-secondary" value="1"
                                                           placeholder="1" aria-label="Example text with button addon" aria-describedby="button-addon1"
                                                           id="quantityInput" readonly/>
                                                    <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon2"
                                                            data-mdb-ripple-color="dark">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                        <!--<i class="me-1 fa fa-shopping-basket"></i>-->
                                        <input type="submit" name="btnAddCart" class="btn btn-primary shadow-0" value="Thêm vào giỏ hàng"/>  


                                    </form>
                                </div>
                            </main>
                        </div>
                        <div class="row gx-4">
                            <div class="col-lg-8 mb-4">
                                <div class="border rounded-2 px-3 py-2 bg-white">
                                    <!-- Pills navs -->
                                    <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                                        <li class="nav-item d-flex" role="presentation">
                                            <a class="nav-link d-flex align-items-center justify-content-center w-100 active" id="ex1-tab-1"
                                               data-mdb-toggle="pill" href="#ex1-pills-1" role="tab" aria-controls="ex1-pills-1"
                                               aria-selected="true">Mô Tả</a>
                                        </li>
                                    </ul>
                                    <!-- Pills navs -->

                                    <!-- Pills content -->
                                    <div class="tab-content" id="ex1-content">
                                        <div class="tab-pane fade show active" id="ex1-pills-1" role="tabpanel" aria-labelledby="ex1-tab-1">
                                            <p>
                                                <%= swi.getPro_id().getPro_description()%>
                                            </p>

                                            <table class="table border mt-3 mb-2">
                                                <tr>
                                                    <th class="py-2">Pin:</th>
                                                    <td class="py-2"><%= swi.getSwitch_pin()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Type:</th>
                                                    <td class="py-2"><%= swi.getSwitch_type()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Lò xo:</th>
                                                    <td class="py-2"><%= swi.getSwitch_spring()%> gam</td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Độ bền:</th>
                                                    <td class="py-2"><%= swi.getSwitch_reliability()%> triệu lần nhấn</td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Hành Trình:</th>
                                                    <td class="py-2"><%= swi.getSwitch_depth()%> mm</td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                    <!-- Pills content -->
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="px-0 border rounded-2 shadow-0">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">Sản Phẩm Tương Tự</h5>
                                            <%
                                                ProductDAO pDAO = new ProductDAO();
                                                ResultSet rs = pDAO.getSimilarProduct(type, swi.getPro_id().getPro_id());
                                                int dem = 0;
                                                while (rs.next()) {
                                                    if (dem == 2) {
                                                        break;
                                                    }
                                                    String[] listImage = rs.getString("pro_image").split("&");
                                            %>
                                            <div class="d-flex mb-3">
                                                <a href="/ProductController/Switch/<%= rs.getInt("pro_id")%>" class="me-3">
                                                    <img src="../../Root/Images/Product/<%= listImage[0]%>"
                                                         style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                                </a>
                                                <div class="infoo">
                                                    <a href="/ProductController/Switch/<%= rs.getInt("pro_id")%>" class="nav-link mb-1">
                                                        <%= rs.getString("pro_name")%> 
                                                    </a>
                                                    <strong class="text-dark"> ₫<%= keyDAO.converterNumber(rs.getInt("pro_price"))%></strong>
                                                </div>
                                            </div>
                                            <%
                                                    dem++;

                                                }
                                            %>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>

            </div>
        </section>
        <%
            }
            if (type.equals(
                    "Earphone")) {
                Earphone ear = (Earphone) session.getAttribute("getProduct");
                String[] image = (String[]) session.getAttribute("listImage");
                KeyboardDAO keyDAO = new KeyboardDAO();
        %>
        <section class="py-2" style="margin-top: 120px">
            <div class="container-xxl">
                <div class="row">
                    <div class="col-md-3 ">
                        <div class="row">
                            <div class="aside-left">
                                <div class="product-list">
                                    <ul>
                                        <li><a href="/ProductController/Keyboard">Keyboard</a></li>
                                        <li><a href="/ProductController/Kit-ban-phim">Kit Bàn Phím</a></li>
                                        <li><a href="/ProductController/Key-cap">Keycap</a></li>
                                        <li><a href="/ProductController/Switch">Switch</a></li>
                                        <li><a href="/ProductController/Mouse">Mouse</a></li>
                                        <li><a href="/ProductController/Earphone">Earphone</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-9 border-start mb-5">
                        <div class="row gx-5 pb-5 px-3">
                            <aside class="col-md-6">

                                <div class="galleryImage">
                                    <div class="discontContainer">

                                    </div>

                                    <div class="topGallery" id="topGallery">
                                        <%                                            int count = 0;
                                            while (count != image.length) {
                                                if (count == 0) {

                                        %>
                                        <div class="imageItems" onmouseover="hovertopGallery()">
                                            <img class="itemsImg" src="../../Root/Images/Product/<%= image[count]%>" alt="">
                                        </div>
                                        <%
                                            count++;
                                        } else {
                                        %>
                                        <div class="imageItems">
                                            <img class="itemsImg" src="../../Root/Images/Product/<%= image[count]%>" alt="">
                                        </div>
                                        <%
                                                    count++;
                                                }
                                            }
                                        %>
                                        <a class="prev btnGallery" onclick="plusSlides(-1)">&#10094;</a>
                                        <a class="next btnGallery" onclick="plusSlides(1)">&#10095;</a>
                                    </div>
                                    <div class="thumbPhoto" onmouseover="hovertopGallery()">
                                        <%
                                            count = 1;
                                            while (count != image.length + 1) {
                                        %>
                                        <div onclick="currentSlide(<%= count%>)" class="thumbImage"><img class="itemsImg thumbImage_Items"
                                                                                                         src="../../Root/Images/Product/<%= image[count - 1]%>" alt="">
                                        </div>
                                        <%
                                                count++;
                                            }
                                        %>

                                    </div>
                                </div>


                                <!-- thumbs-wrap.// -->
                                <!-- gallery-wrap .end// -->
                            </aside>
                            <main class="col-md-6">
                                <div class="ps-lg-3">
                                    <a class="title text-muted text-uppercase text-decoration-none" href="#!">Trang Chủ</a> / <a
                                        class="title text-muted text-uppercase text-decoration-none" href="#!"><%=type%></a>
                                    <h4 class="titleProduct"> <%= ear.getPro_id().getPro_name()%> </h4>
                                    <div class="d-flex">
                                        <div class="vr my-3" style="width: 50px; height: 2px; background-color: #e5e5e5;"></div>
                                    </div>
                                    <div class="mb-3">
                                        <%
                                            if (ear.getPro_id().getPro_discount() != "0") {
                                        %>
                                        <span class="h5 text-decoration-line-through text-muted fs-4 text">
                                            <p class="d-inline text">₫<%=  keyDAO.converterNumber(keyDAO.getPriceBeforeDiscount(Integer.parseInt(ear.getPro_id().getPro_discount()), Integer.parseInt(ear.getPro_id().getPro_price())))%> </p>
                                        </span>
                                        <%
                                            }
                                        %>
                                        <span class="h5 ms-2  fs-4 text">
                                            <p class="d-inline text">₫<%=  keyDAO.converterNumber(Integer.parseInt(ear.getPro_id().getPro_price()))%></p>
                                        </span>
                                    </div>

                                    <div>
                                        <h5 class="text-danger bg-light d-inline">Khuyến Mãi:</h4>
                                            <ul>
                                                <li class="my-2">Freeship toàn quốc khi đặt hàng tại Nghiennghua.vn</li>
                                                <li class="my-2">Chế độ bảo hành 1 đổi 1 trong suốt thời gian bảo hành</li>
                                                <li class="my-2">Chi nhánh bảo hành 3 miền: Bắc – Trung – Nam</li>
                                            </ul>
                                    </div>
                                    <hr />

                                    <form method="post" action="ProductController">
                                        <div class="row mb-4">
                                            <!-- col.// -->
                                            <div class="col-md-4 col-6 mb-3">
                                                <label class="mb-2 d-block">Số lượng</label>
                                                <div class="input-group mb-1" style="width: 170px;">
                                                    <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon1"
                                                            data-mdb-ripple-color="dark">
                                                        <i class="fas fa-minus"></i>
                                                    </button>
                                                    <!-- <input type="text" class="form-control text-center border border-secondary" placeholder="14"
                                                      aria-label="Example text with button addon" aria-describedby="button-addon1" /> -->
                                                    <input type="number" name="txtQuantity" class="form-control text-center border border-secondary" value="1"
                                                           placeholder="1" aria-label="Example text with button addon" aria-describedby="button-addon1"
                                                           id="quantityInput" readonly/>
                                                    <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon2"
                                                            data-mdb-ripple-color="dark">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                        <!--<i class="me-1 fa fa-shopping-basket"></i>-->
                                        <input type="submit" name="btnAddCart" class="btn btn-primary shadow-0" value="Thêm vào giỏ hàng"/>  


                                    </form>
                                </div>
                            </main>
                        </div>
                        <div class="row gx-4">
                            <div class="col-lg-8 mb-4">
                                <div class="border rounded-2 px-3 py-2 bg-white">
                                    <!-- Pills navs -->
                                    <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                                        <li class="nav-item d-flex" role="presentation">
                                            <a class="nav-link d-flex align-items-center justify-content-center w-100 active" id="ex1-tab-1"
                                               data-mdb-toggle="pill" href="#ex1-pills-1" role="tab" aria-controls="ex1-pills-1"
                                               aria-selected="true">Mô Tả</a>
                                        </li>
                                    </ul>
                                    <!-- Pills navs -->

                                    <!-- Pills content -->
                                    <div class="tab-content" id="ex1-content">
                                        <div class="tab-pane fade show active" id="ex1-pills-1" role="tabpanel" aria-labelledby="ex1-tab-1">
                                            <p>
                                                <%= ear.getPro_id().getPro_description()%>
                                            </p>

                                            <table class="table border mt-3 mb-2">
                                                <tr>
                                                    <th class="py-2">Loại tai nghe:</th>
                                                    <td class="py-2"><%= ear.getEar_type()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Cổng kết nối::</th>
                                                    <td class="py-2"><%= ear.getEar_plug()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Độ tương thích:</th>
                                                    <td class="py-2"><%= ear.getEar_compatibility()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Tính đa dụng:</th>
                                                    <td class="py-2"><%= ear.getEar_utility()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Kết nối:</th>
                                                    <td class="py-2"><%= ear.getEar_connect()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Điều khiển:</th>
                                                    <td class="py-2"><%= ear.getEar_control()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Cổng sạc:</th>
                                                    <td class="py-2"><%= ear.getEar_charging_port()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Công nghệ kết nối:</th>
                                                    <td class="py-2"><%= ear.getEar_connect_tech()%></td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                    <!-- Pills content -->
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="px-0 border rounded-2 shadow-0">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">Sản Phẩm Tương Tự</h5>
                                            <%
                                                ProductDAO pDAO = new ProductDAO();
                                                ResultSet rs = pDAO.getSimilarProduct(type, ear.getPro_id().getPro_id());
                                                int dem = 0;
                                                while (rs.next()) {
                                                    if (dem == 2) {
                                                        break;
                                                    }
                                                    String[] listImage = rs.getString("pro_image").split("&");
                                            %>
                                            <div class="d-flex mb-3">
                                                <a href="/ProductController/Switch/<%= rs.getInt("pro_id")%>" class="me-3">
                                                    <img src="../../Root/Images/Product/<%= listImage[0]%>"
                                                         style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                                </a>
                                                <div class="infoo">
                                                    <a href="/ProductController/Switch/<%= rs.getInt("pro_id")%>" class="nav-link mb-1">
                                                        <%= rs.getString("pro_name")%> 
                                                    </a>
                                                    <strong class="text-dark"> ₫<%= keyDAO.converterNumber(rs.getInt("pro_price"))%></strong>
                                                </div>
                                            </div>
                                            <%
                                                    dem++;

                                                }
                                            %>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>

            </div>
        </section>
        <%
            }
            if (type.equals(
                    "Mouse")) {

                Mouse mouse = (Mouse) session.getAttribute("getProduct");
                String[] image = (String[]) session.getAttribute("listImage");
                KeyboardDAO keyDAO = new KeyboardDAO();
        %>
        <section class="py-2" style="margin-top: 120px">
            <div class="container-xxl">
                <div class="row">
                    <div class="col-md-3 ">
                        <div class="row">
                            <div class="aside-left">
                                <div class="product-list">
                                    <ul>
                                        <li><a href="/ProductController/Keyboard">Keyboard</a></li>
                                        <li><a href="/ProductController/Kit-ban-phim">Kit Bàn Phím</a></li>
                                        <li><a href="/ProductController/Key-cap">Keycap</a></li>
                                        <li><a href="/ProductController/Switch">Switch</a></li>
                                        <li><a href="/ProductController/Mouse">Mouse</a></li>
                                        <li><a href="/ProductController/Earphone">Earphone</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-9 border-start mb-5">
                        <div class="row gx-5 pb-5 px-3">
                            <aside class="col-md-6">

                                <div class="galleryImage">
                                    <div class="discontContainer">

                                    </div>

                                    <div class="topGallery" id="topGallery">
                                        <%                                            int count = 0;
                                            while (count != image.length) {
                                                if (count == 0) {

                                        %>
                                        <div class="imageItems" onmouseover="hovertopGallery()">
                                            <img class="itemsImg" src="../../Root/Images/Product/<%= image[count]%>" alt="">
                                        </div>
                                        <%
                                            count++;
                                        } else {
                                        %>
                                        <div class="imageItems">
                                            <img class="itemsImg" src="../../Root/Images/Product/<%= image[count]%>" alt="">
                                        </div>
                                        <%
                                                    count++;
                                                }
                                            }
                                        %>
                                        <a class="prev btnGallery" onclick="plusSlides(-1)">&#10094;</a>
                                        <a class="next btnGallery" onclick="plusSlides(1)">&#10095;</a>
                                    </div>
                                    <div class="thumbPhoto" onmouseover="hovertopGallery()">
                                        <%
                                            count = 1;
                                            while (count != image.length + 1) {
                                        %>
                                        <div onclick="currentSlide(<%= count%>)" class="thumbImage"><img class="itemsImg thumbImage_Items"
                                                                                                         src="../../Root/Images/Product/<%= image[count - 1]%>" alt="">
                                        </div>
                                        <%
                                                count++;
                                            }
                                        %>

                                    </div>
                                </div>


                                <!-- thumbs-wrap.// -->
                                <!-- gallery-wrap .end// -->
                            </aside>
                            <main class="col-md-6">
                                <div class="ps-lg-3">
                                    <a class="title text-muted text-uppercase text-decoration-none" href="#!">Trang Chủ</a> / <a
                                        class="title text-muted text-uppercase text-decoration-none" href="#!"><%=type%></a>
                                    <h4 class="titleProduct"> <%= mouse.getPro_id().getPro_name()%> </h4>
                                    <div class="d-flex">
                                        <div class="vr my-3" style="width: 50px; height: 2px; background-color: #e5e5e5;"></div>
                                    </div>
                                    <div class="mb-3">
                                        <%
                                            if (mouse.getPro_id().getPro_discount() != "0") {
                                        %>
                                        <span class="h5 text-decoration-line-through text-muted fs-4 text">
                                            <p class="d-inline text">₫<%=  keyDAO.converterNumber(keyDAO.getPriceBeforeDiscount(Integer.parseInt(mouse.getPro_id().getPro_discount()), Integer.parseInt(mouse.getPro_id().getPro_price())))%> </p>
                                        </span>
                                        <%
                                            }
                                        %>
                                        <span class="h5 ms-2  fs-4 text">
                                            <p class="d-inline text">₫<%=  keyDAO.converterNumber(Integer.parseInt(mouse.getPro_id().getPro_price()))%></p>
                                        </span>
                                    </div>

                                    <div>
                                        <h5 class="text-danger bg-light d-inline">Khuyến Mãi:</h4>
                                            <ul>
                                                <li class="my-2">Freeship toàn quốc khi đặt hàng tại Nghiennghua.vn</li>
                                                <li class="my-2">Chế độ bảo hành 1 đổi 1 trong suốt thời gian bảo hành</li>
                                                <li class="my-2">Chi nhánh bảo hành 3 miền: Bắc – Trung – Nam</li>
                                            </ul>
                                    </div>
                                    <hr />

                                    <form method="post" action="ProductController">
                                        <div class="row mb-4">
                                            <!-- col.// -->
                                            <div class="col-md-4 col-6 mb-3">
                                                <label class="mb-2 d-block">Số lượng</label>
                                                <div class="input-group mb-1" style="width: 170px;">
                                                    <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon1"
                                                            data-mdb-ripple-color="dark">
                                                        <i class="fas fa-minus"></i>
                                                    </button>
                                                    <!-- <input type="text" class="form-control text-center border border-secondary" placeholder="14"
                                                      aria-label="Example text with button addon" aria-describedby="button-addon1" /> -->
                                                    <input type="number" name="txtQuantity" class="form-control text-center border border-secondary" value="1"
                                                           placeholder="1" aria-label="Example text with button addon" aria-describedby="button-addon1"
                                                           id="quantityInput" readonly/>
                                                    <button class="btn btn-white border border-secondary px-3" type="button" id="button-addon2"
                                                            data-mdb-ripple-color="dark">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                        <!--<i class="me-1 fa fa-shopping-basket"></i>-->
                                        <input type="submit" name="btnAddCart" class="btn btn-primary shadow-0" value="Thêm vào giỏ hàng"/>  


                                    </form>
                                </div>
                            </main>
                        </div>
                        <div class="row gx-4">
                            <div class="col-lg-8 mb-4">
                                <div class="border rounded-2 px-3 py-2 bg-white">
                                    <!-- Pills navs -->
                                    <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                                        <li class="nav-item d-flex" role="presentation">
                                            <a class="nav-link d-flex align-items-center justify-content-center w-100 active" id="ex1-tab-1"
                                               data-mdb-toggle="pill" href="#ex1-pills-1" role="tab" aria-controls="ex1-pills-1"
                                               aria-selected="true">Mô Tả</a>
                                        </li>
                                    </ul>
                                    <!-- Pills navs -->

                                    <!-- Pills content -->
                                    <div class="tab-content" id="ex1-content">
                                        <div class="tab-pane fade show active" id="ex1-pills-1" role="tabpanel" aria-labelledby="ex1-tab-1">
                                            <p>
                                                <%= mouse.getPro_id().getPro_description()%>
                                            </p>

                                            <table class="table border mt-3 mb-2">
                                                <tr>
                                                    <th class="py-2">DPI:</th>
                                                    <td class="py-2"><%= mouse.getMouse_dpi()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Độ dài dây:</th>
                                                    <td class="py-2"><%= mouse.getMouse_wire_length()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Led:</th>
                                                    <td class="py-2"><%= mouse.getMouse_led()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Loại pin:</th>
                                                    <td class="py-2"><%= mouse.getMouse_type_battery()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Khối lượng:</th>
                                                    <td class="py-2"><%= mouse.getMouse_weight()%></td>
                                                </tr>
                                                <tr>
                                                    <th class="py-2">Khả năng tương thích:</th>
                                                    <td class="py-2"><%= mouse.getMouse_compatibility()%></td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                    <!-- Pills content -->
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="px-0 border rounded-2 shadow-0">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">Sản Phẩm Tương Tự</h5>
                                            <%
                                                ProductDAO pDAO = new ProductDAO();
                                                ResultSet rs = pDAO.getSimilarProduct(type, mouse.getPro_id().getPro_id());
                                                int dem = 0;
                                                while (rs.next()) {
                                                    if (dem == 2) {
                                                        break;
                                                    }
                                                    String[] listImage = rs.getString("pro_image").split("&");
                                            %>
                                            <div class="d-flex mb-3">
                                                <a href="/ProductController/Switch/<%= rs.getInt("pro_id")%>" class="me-3">
                                                    <img src="../../Root/Images/Product/<%= listImage[0]%>"
                                                         style="min-width: 96px; height: 96px;" class="img-md img-thumbnail" />
                                                </a>
                                                <div class="infoo">
                                                    <a href="/ProductController/Switch/<%= rs.getInt("pro_id")%>" class="nav-link mb-1">
                                                        <%= rs.getString("pro_name")%> 
                                                    </a>
                                                    <strong class="text-dark"> ₫<%= keyDAO.converterNumber(rs.getInt("pro_price"))%></strong>
                                                </div>
                                            </div>
                                            <%
                                                    dem++;

                                                }
                                            %>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>

            </div>
        </section>
        <%
            }
        %>
        <%@include file="../Footer/Footer.jsp" %>

        <!-- content -->

        <!-- MDB -->
        <!-- <script type="text/javascript" src="js/mdb.min.js"></script> -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <!-- slick slider  -->

        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

        <script src="../../Root/Js/script.js"></script>
        <script src="../../Root/Js/main.js"></script>
        <script src="../../Root/Js/notification.js"></script>

        <%
//            HttpSession session = request.getSession();
            String mesg = (String) session.getAttribute("status");
        %>
        <script>
                                            createToast("<%= mesg%>")
        </script>

        <%
            //            HttpSession session = request.getSession();
            session.setAttribute("status", "");
        %>

    </body>
</html>
