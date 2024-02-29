<%-- 
    Document   : cart
    Created on : Oct 30, 2023, 8:19:41 PM
    Author     : HIEU
--%>

<%@page import="DAOs.KeyboardDAO"%>
<%@page import="Models.Account"%>
<%@page import="Models.Product"%>
<%@page import="Models.Cart"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="DAOs.CartDAO"%>
<%@page import="DAOs.AccountDAO"%>
<%@page import="DAOs.UserDAO"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nghien nhua</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="/Front/assets/image/logo/z4705695345706_20ca59964f9ad379fcebb44ceaad6cd4-removebg-preview.png"/>
        <!-- icon -->
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.2.1/css/fontawesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="../../Root/Css/cartCss.css">
        <link rel="stylesheet" href="../../Root/Css/notificationCss.css">

        <style>
            .buttonPayment {
                width: 100%;
                height: 40px;
                background-color: var(--wp--preset--color--luminous-vivid-orangeRed);
                border: none;
                font-weight: bold;
                color: var(--wp--preset--color--white);
                padding-top: unset;
                display: flex;
                align-items: center;
                justify-content: center;
            }

        </style>

    </head>
    <body>
        <%
            Account account =(Account) session.getAttribute("account");
            AccountDAO accDAO = new AccountDAO();
            UserDAO userDAO = new UserDAO();
            int user_id = userDAO.getUserIDWithAccID(accDAO.getAccIDWithGmail(account.getEmail()));
            CartDAO cDAO = new CartDAO();
            ResultSet rs = cDAO.getProductInCart(user_id);
            KeyboardDAO kDAO = new KeyboardDAO();
            int totalMoney = 0;
        %>


        <%@include file="../Header/Header.jsp" %>

        <ul class="notifications"></ul>

        <%           
            boolean test = true;
            ResultSet r = cDAO.getProductInCart(user_id);
            Product pro=new Product();
            Cart cart = new Cart();
            if (r.next()) {
                test = false;
            }
            if (!test) {
        %>
        <div class="main" style=" width: 100%; height: auto; padding-bottom: 50px;">
            <div class="container" style=" height: auto;">
                <div class="row">
                    <div class="col-md-7 left" style="border: none;">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th colspan="3" class="productName product1">
                                        Sản phẩm
                                    </th>
                                    <th class="productPrice product product1">
                                        Giá
                                    </th>
                                    <th class="productQuantity product">
                                        Số lượng
                                    </th>
                                    <th class="productTotal product">
                                        Tạm Tính
                                    </th>
                                </tr>
                            </thead>
                            <tbody class="listBodyProduct">
                                <%                  
                  int count=1;
                  while (rs.next()) {
                                        pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getDate("pro_date"), rs.getString("pro_category"), rs.getString("pro_brand"), rs.getString("pro_origin"));
                                        String[] imageList = pro.getPro_image().split("&");
                                        cart= new Cart(rs.getInt("cart_id"),rs.getInt("user_id"),rs.getInt("cart_quantity"),rs.getInt("pro_id"));
                                %>
                                <tr>
                                    <td class="tableItemFirst">
                                        <button class="productRemove"><a href="/CartController/Delete/<%= pro.getPro_id() %>">x</a></button>
                                    </td>
                                    <td>
                                        <img class="productPicture " src="../../Root/Images/Product/<%= imageList[0]%>"
                                             alt="">
                                    </td>
                                    <td class="tableItemThird">
                                        <a class="productContent ItemProduct" href=""><%= pro.getPro_name() %></a>
                                    </td>
                                    <td class="ItemProduct1">
                                        <span>
                                            <%= kDAO.converterNumber(Integer.parseInt(pro.getPro_price()))%>
                                        </span>
                                    </td>
                                    <td>
                                        <div class="d-flex ItemProduct" style="width: 100px; text-align: center">
                                            <span>
                                                <div class="input-group mb-1" style="width: 100px;">
                                                    <button class="btn btn-white border border-secondary px-1" type="button" id="button-addon1_<%= count %>"
                                                            data-mdb-ripple-color="dark">
                                                        <i class="fas fa-minus"></i>
                                                    </button>
                                                    <input type="number" name="txtQuantity" class="form-control text-center border border-secondary" value="<%=cart.getCart_quantity() %>"
                                                           placeholder="1" aria-label="Example text with button addon" aria-describedby="button-addon1"
                                                           id="quantityInput_<%= count %>" readonly style="width: 50px" />
                                                    <button class="btn btn-white border border-secondary px-1" type="button" id="button-addon2_<%= count %>"
                                                            data-mdb-ripple-color="dark">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                            </span>
                                        </div>
                                    </td>
                                    <td class="ItemProduct1">
                                        <span>
                                            <%
                                                totalMoney += cart.getCart_quantity() * Integer.parseInt(pro.getPro_price());
                                            %>
                                            <%= kDAO.converterNumber(cart.getCart_quantity()  * Integer.parseInt(pro.getPro_price()))%>
                                        </span>
                                    </td>
                                </tr>
                                <%                                   
                                    count++;
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>

                    <div class="col-md-5 right">
                        <div class="container">
                            <table class="table totalTable">
                                <thead>
                                    <tr>
                                        <th>
                                            CỘNG GIỎ HÀNG
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="amoutTable">
                                        <th>
                                            Tạm tính
                                        </th>
                                        <td class="before">
                                            <%= kDAO.converterNumber(totalMoney)%>
                                        </td>
                                    </tr>
                                    <tr class="shipmountTable">
                                        <th>Giao hàng</th>
                                        <td>
                                            <ul>
                                                <li>
                                                    <input type="radio" name="check" id="" value="" checked readonly>
                                                    <label for=""><span>Đồng giá: ₫20,000</span></label>
                                                </li>
                                            </ul>
                                        </td>
                                    </tr>
                                    <tr class="amoutTable">
                                        <th>
                                            Tổng
                                        </th>
                                        <td class="final">
                                            <%= kDAO.converterNumber(totalMoney + 20000)%>
                                        </td>
                                    </tr>
                                    <tr>

                                    </tr>
                                </tbody>
                            </table>
                            <div class=" buttonPayment">
                                <a  class="text-decoration-none text-light"  href="/OrderController/Order">
                                    <!--<input style="cursor: pointer" name="submitCart" value="Tiến hàng thanh toán"/>-->
                                    Tiến hành thanh toán
                                </a>
                            </div>
                        </div>
                        <div class="discountCode">
                            <div class="discountCode-label">
                                <i class="bi bi-tag-fill"></i>
                                <span>
                                    Phiếu ưu đãi
                                </span>
                            </div>
                            <input type="text" placeholder="Mã ưu đãi">
                            <input type="submit" name="" id="" value="Áp dụng" class="submitCode">
                        </div>
                    </div>
                </div>

            </div>

        </div>
        <%
        } else {
        %>
        <div class="d-flex justify-content-center align-items-center flex-column" style="width: 100% ; height: 500px">
            <span>Chưa có sản phẩm nào trong giỏ hàng</span>
            <a href="/" class="btn btn-success">Go home</a>
        </div>
        <%
            }
        %>
        <%@include file="../Footer/Footer.jsp" %>
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
        <script>
            <%
            ResultSet rs_sc = cDAO.getProductInCart(user_id);
            int count = 0;
            int pro_id=0;
            while(rs_sc.next())     {                     
                pro_id = rs_sc.getInt("pro_id");
                count++;
                        
            %>
            var quantityInput_<%=count%> = document.getElementById("quantityInput_" +<%= count%>);
            var addButton_<%=count%> = document.getElementById("button-addon2_" + <%= count%>);
            var minusButton_<%=count%> = document.getElementById("button-addon1_" + <%= count%>);

            addButton_<%=count%>.addEventListener('click', function () {
                quantityInput_<%=count%>.value = parseInt(quantityInput_<%=count%>.value) + 1;
                quantityInput_<%=count%>.placeholder = quantityInput_<%=count%>.value


            });
            minusButton_<%=count%>.addEventListener('click', function () {
                var currentValue = parseInt(quantityInput_<%=count%>.value);
                if (currentValue > 1) {
                    quantityInput_<%=count%>.value = currentValue - 1;
                }
                quantityInput_<%=count%>.placeholder = quantityInput_<%=count%>.value

            });
            $(document).ready(function () {
                if (quantityInput_<%=count%>.value < 0) {
                    quantityInput_<%=count%>.value = 1;
                    quantityInput_<%=count%>.placeholder = 1;
                }
            })
            <%
            }
            %>

        </script>


        <%
            String mesg = (String) session.getAttribute("status");
        %>
        < script >
        createToast("<%= mesg%>")
    </script>

    <%
        session.setAttribute("status", "");
    %>





</body>
</html>
