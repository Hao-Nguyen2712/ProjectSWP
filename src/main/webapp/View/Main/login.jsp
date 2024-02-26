<%-- 
    Document   : index
    Created on : Oct 3, 2023, 5:02:50 PM
    Author     : HIEU
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="shortcut icon" href="/Front/assets/image/logo/z4705695345706_20ca59964f9ad379fcebb44ceaad6cd4-removebg-preview.png"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link rel="stylesheet" href="../../Root/Css/style.css"/>
        <link rel="stylesheet" href="../../Root/Css/logninCss.css"/>
        <link rel="stylesheet" href="../../Root/Css/notificationCss.css"/>
    </head>
    <body>
        <%
//            HttpSession sessionLogin = request.getSession();
//            Cookie[] cList = null;
//            cList = request.getCookies();
//            String sessionLogIn = (String) sessionLogin.getAttribute("fullname");
//            if (sessionLogIn != null && cList != null) {
//                boolean flag = false;
//                for (int i = 0; i < cList.length; i++) {
//                    if (cList[i].getName().equals("login")) {
//                        flag = true;
//                        break;
//                    }
//                }
//                if (flag) {
//                    response.sendRedirect("/ProductController/ListProduct/");
//                }
//            }

        %>
        <ul class="notifications"></ul>
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap py-5">
                            <div class="img d-flex align-items-center justify-content-center"
                                 style="background-image: url(../..//Root/Images/Logo/z4705695345706_20ca59964f9ad379fcebb44ceaad6cd4-removebg-preview.png);"></div>
                            <h3 class="text-center mb-0">Welcome</h3>
                            <p class="text-center">Sign in by entering the information below</p>
                            <form action="LoginController" method="post" class="login-form needs-validation" novalidate>
                                <div class="form-group">
                                    <div class="icon d-flex align-items-center justify-content-center"><span
                                            class="bi bi-envelope"></span></div>
                                    <input type="text" class="form-control" name="gmail" placeholder="Gmail" autocomplete="off" required>
                                    <div class="invalid-feedback">
                                        Please provide a valid Gmail.
                                    </div>
                                    <span>${errorUser}</span>
                                </div>
                                <div class="form-group">
                                    <div class="icon d-flex align-items-center justify-content-center"><span
                                            class="bi bi-lock"></span></div>
                                    <input type="password" class="form-control" name="password" placeholder="Password" autocomplete="off" required>
                                    <div class="invalid-feedback">
                                        Please provide a valid Password.
                                    </div>
                                    <span>${ErrorPW}</span>
                                </div>
                                <div class="form-group d-md-flex">
                                    <div class="w-100 text-md-right">
                                        <a href="#">Forgot Password</a>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button name="btnLogin" value="sumbitLogin" type="submit" class="btn form-control btn-primary rounded submit px-3">Get
                                        Started</button>
                                </div>
                            </form>
                            <div class="col">
                                <a href="https://accounts.google.com/o/oauth2/auth?scope=profile%20email&redirect_uri=http://localhost:9999/LoginController&response_type=code
                                   &client_id=788088430920-nlojm5al4l4r6bn5brgrvj8pu5be9ob4.apps.googleusercontent.com&approval_prompt=force" class="google btn"
                                   ><i class="fa-brands fa-google-plus-g" style="font-size: 22px"></i> Login with Google+
                                </a>
                            </div>
                            <div class="w-100 text-center mt-4 text">
                                <p class="mb-0">Don't have an account?</p>
                                <a href="/LoginController/Signup">Sign Up</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

        <script src="../../Root/Js/notification.js"></script>
        <%
     HttpSession sess = request.getSession();
     String mesg = (String) sess.getAttribute("status");
        %>
        <script>
            createToast("<%= mesg%>")
        </script>
        <%
            sess.setAttribute("status", "");
        %>

        <script>
                    // Example starter JavaScript for disabling form submissions if there are invalid fields
                            (function () {
                                'use strict'

                                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                                var forms = document.querySelectorAll('.needs-validation')

                                // Loop over them and prevent submission
                                Array.prototype.slice.call(forms)
                                        .forEach(function (form) {
                                            form.addEventListener('submit', function (event) {
                                                if (!form.checkValidity()) {
                                                    event.preventDefault()
                                                    event.stopPropagation()
                                                }

                                                form.classList.add('was-validated')
                                            }, false)
                                        })
                            })()
        </script>
    </body>
</html>
