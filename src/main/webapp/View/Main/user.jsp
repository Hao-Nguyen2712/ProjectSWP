<%-- 
    Document   : user
    Created on : Mar 1, 2024, 10:14:56 AM
    Author     : thinh
--%>
<%@page import="DAOs.AccountDAO"%>
<%@page import="DAOs.UserDAO "%>
<%@page import="Models.User"%>
<%@page import="Models.Account"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="shortcut icon" href="/Front/assets/image/logo/z4705695345706_20ca59964f9ad379fcebb44ceaad6cd4-removebg-preview.png"/>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
            .gradient-custom {
                background: rgb(255,101,249);
                background: linear-gradient(90deg, rgba(255,101,249,1) 0%, rgba(249,247,112,1) 100%);
            }
            .btn-logout{
                /* fallback for old browsers */

                background: rgb(255,101,249);
                background: linear-gradient(90deg, rgba(255,101,249,1) 0%, rgba(249,247,112,1) 100%);
            }
        </style>
    </head>
    <body>
        <%@include file="../Header/Header.jsp" %>
        <%        
                           Account a = (Account) session.getAttribute("account");
                          User user = null;
                         AccountDAO aDAO = new AccountDAO();
                         UserDAO uDAO = new UserDAO(); 
                         int acc_id = aDAO.getAccIDWithGmail(a.getEmail());
                         user = uDAO.getUserByAcc_id(acc_id);
            
        %>

        <section class="vh-100" style="background-color: #f4f5f7;">
            <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-lg-9 mb-4 mb-lg-0">
                        <div class="card mb-3" style="border-radius: .5rem;">
                            <div class="row g-0">
                                <div class="col-md-4 gradient-custom text-center text-white"
                                     style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp" alt="Avatar"
                                         class="img-fluid my-5" style="width: 80px;" />
                                    <h5>Trang cá nhân</h5>
                                    <p class="fw-bold">Con nghiện</p>
                                    <i class="far fa-edit mb-5"></i>
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body p-4">
                                        <h4>Thông tin</h4>
                                        <hr class="mt-0 mb-4">
                                        <div class="row pt-1">                                            
                                            <div class="col-6 mb-3">
                                                <h6>Họ và tên</h6>
                                                <p class="text-muted"><%= user.getUser_fullName()%></p>
                                            </div>
                                            <div class="col-6 mb-3">
                                                <h6>Gmail</h6> 
                                                <p class="text-muted"><%= a.getEmail()%></p>
                                            </div>
                                        </div>
                                        <div class="row pt-1">
                                            <div class="col-6 mb-3">
                                                <h6>Địa chỉ</h6>
                                                <p class="text-muted"><%= user.getUser_address()%></p>
                                            </div>
                                            <div class="col-6 mb-3">
                                                <h6>Số điện thoại</h6>
                                                <p class="text-muted"><%= user.getUser_phoneNumber()%></p>
                                            </div>
                                        </div>
                                        <div class="row pt-1">
                                            <div class="d-flex">
                                                <div class=" mb-3">
                                                    <a href="/HomeController/User/Edit" class="btn btn-logout text-white text-end me-3 border-0" style="float: right;">Sửa thông tin</a>
                                                </div>
                                                <div class=" mb-3">
                                                    <a href="/HomeController/Order-List" class="btn btn-logout text-white text-end me-3 border-0" style="float: right;">Lịch sử mua hàng</a>
                                                </div>
                                                <div class=" mb-3">
                                                    <a href="/AccountController/ChangePassword" class="btn btn-logout text-white text-end me-3 border-0" style="float: right;">Thay đổi mật khẩu</a>
                                                </div>
                                                <div class=" mb-3">
                                                    <a href="/LoginController/Logout" class="btn btn-logout text-white text-end me-3 border-0" style="float: right;">Log out</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="../Footer/Footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        <script src="../../Root/Js/main.js"></script>
    </body>
</html>
