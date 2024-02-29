<%-- 
    Document   : listProduct
    Created on : Oct 18, 2023, 11:03:43 AM
    Author     : thinh
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="DAOs.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://kit.fontawesome.com/ae360af17e.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css"/>
        <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
        <script src="https://kit.fontawesome.com/ae360af17e.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
    </head>
    <body>
        <style>

            <%@include file="/Root/Css/listProductCss.css" %>
            .overlay {
                display: none;
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.5);
            }

            .overlay-content {
                background-color: white;
                padding: 20px;
                width: 350px;
                height: 200px;
                text-align: center;
                border-radius: 10px;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
            }
            .overlay-content p{
                font-size: 20px;
            }
            #confirmBtn{
                margin-bottom: 7px;
            }
            .overlay-content button{
                width: 100px;
            }
            .table-bordered{
                border: 1px solid #e9ecef;
                width: 100px;
            }
        </style>

        <div class="wrapper">
            <!-- Sidebar -->
            <aside id="sidebar">
                <div class="h-100">
                    <div class="sidebar-logo">
                        <a href="#">Nghiện Chúa</a>
                    </div>
                    <!-- Sidebar Navigation -->
                    <ul class="sidebar-nav">
                        <li class="sidebar-item">
                            <a href="/AdminController/Admin" class="sidebar-link">
                                <i class="fa-solid fa-list pe-2"></i>
                                DashBoard
                            </a>
                        </li>
                        <li class="sidebar-item">
                            <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse" data-bs-target="#pages"
                               aria-expanded="false" aria-controls="pages">
                                <i class="fa-regular fa-file-lines pe-2"></i>
                                Đơn Hàng
                            </a>
                            <ul id="pages" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                                <li class="sidebar-item">
                                    <a href="/AdminController/Accept-Order" class="sidebar-link">Duyệt Đơn Hàng</a>
                                </li>
                                <li class="sidebar-item">
                                    <a href="/AdminController/Create" class="sidebar-link">Thêm sản phẩm</a>
                                </li>
                            </ul>
                        </li>
                        <li class="sidebar-item">
                            <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse" data-bs-target="#dashboard"
                               aria-expanded="false" aria-controls="dashboard">
                                <i class="fa-solid fa-sliders pe-2"></i>
                                Thống kê
                            </a>
                            <ul id="dashboard" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                                <li class="sidebar-item">
                                    <a href="/AdminController/StatisticsDay" class="sidebar-link">Thống Kê Theo Ngày</a>
                                </li>
                                <li class="sidebar-item">
                                    <a href="/AdminController/StatisticsMonth" class="sidebar-link">Thống Kê Theo Tháng</a>
                                </li>
                                <li class="sidebar-item">
                                    <a href="/AdminController/StatisticsYear" class="sidebar-link">Thống Kê Theo Năm</a>
                                </li>
                            </ul>
                        </li>
                        <li class="sidebar-item">
                            <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse" data-bs-target="#auth"
                               aria-expanded="false" aria-controls="auth">
                                <i class="fa-regular fa-user pe-2"></i>
                                Setting
                            </a>
                            <ul id="auth" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                                <li class="sidebar-item">
                                    <a href="/" class="sidebar-link">Trang mua hàng</a>
                                </li>
                                <li class="sidebar-item">
                                    <a href="/HomeController/Logout" class="sidebar-link">Logout</a>
                                </li>
                            </ul>
                        </li>

                </div>
            </aside>
            <div class="main">
                <nav class="navbar navbar-expand px-3 border-bottom">
                    <!-- Button for sidebar toggle -->
                    <button class="btn" type="button" data-bs-theme="dark">
                        <span ><i class="fa-solid fa-bars" style="color: #e9ecef;"></i></span>
                        
                    </button>
                </nav>

                <div class="container-fluid bg-light" >
                    <div class="mb-3 mt-3 py-3">
                        <%
                            if (request.getParameter("id") != null && request.getParameter("id").equals("") == false) {
                                int pro_id = Integer.parseInt(request.getParameter("id"));
                                ProductDAO pDAO = new ProductDAO();
                                pDAO.deleteProduct(pro_id);
                            }
                        %>

                        <h1 class="text-center">List of Products</h1>
                        <a href="/AdminController/ListProduct/Create"><button type="button" class="btn btn-primary mb-2">Create New</button></a>  
                        <div>
                            <table id="example" class="table table-hover  table-bordered dataTable dtr-inline col-sm-12">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Product Name</th>
                                        <th>Quantity</th>
                                        <th>Price</th>
                                        <th>Picture</th>
                                        <th>Description</th>
                                        <th>Discount</th>
                                        <th>Date</th>
                                        <th>Category Name</th>
                                        <th>Brand</th>
                                        <th>Origin</th>


                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        ProductDAO pDAO = new ProductDAO();
                                        ResultSet rs = pDAO.getAllProduct();
                                        while (rs.next()) {
                                        String description = rs.getString("pro_description");
                                        String result ="";
                                     if(description.length() > 100) {
                                       
                                       result = description.substring(0,100) + "...";
                                        }
                                        else{
                                        result = description;
                                        }
                                        String[] image = rs.getString("pro_image").split("&");
                                    %>
                                    <tr>
                                        <td><%= rs.getInt("pro_id")%></td>
                                        <td><%= rs.getString("pro_name")%></td>
                                        <td><%= rs.getInt("pro_quantity")%></td>
                                        <td><%= rs.getString("pro_price")%></td>                                 
                                        <td><img src="../../Root/Images/Product/<%= image[0]%>" alt="Laptop" style="width: 60px"/></td>
                                        <td><%= result%></td>
                                        <td><%= rs.getString("pro_discount")%></td>
                                        <td><%= rs.getString("pro_date")%></td>
                                        <td><%= rs.getString("pro_category")%></td>
                                        <td><%= rs.getString("pro_brand")%></td>
                                        <td><%= rs.getString("pro_origin")%></td>

                                        <td>
                                            <a href="/AdminController/ListProduct/Edit/<%= rs.getString("pro_id")%>"><button type="button" class="btn btn-success m-2">Edit</button></a>  <a onclick="return confirm('Are you sure?')" href="/AdminController/ListProduct/Delete/<%= rs.getString("pro_id")%>" class="btn btn-danger link-delete">Delete</a>

                                        </td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script>


                                                const toggler = document.querySelector(".btn");
                                                toggler.addEventListener("click", function () {
                                                    document.querySelector("#sidebar").classList.toggle("collapsed");
                                                });

                                                var collapse = document.getElementsByClassName("collapse");
                                                for (var i = 0; i < collapse.length; i++) {
                                                    collapse[i].addEventListener("click", function () {
                                                        collapse[i].classList.remove("show");
                                                    })
                                                }
        </script>
    </body>
</html>
