<%-- 
    Document   : resetPassword.jsp
    Created on : Feb 28, 2024, 1:40:40 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nghiện Nhựa </title>
        <link rel="shortcut icon" href="/Front/assets/image/logo/z4705695345706_20ca59964f9ad379fcebb44ceaad6cd4-removebg-preview.png"/>
        <link
            href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="../../Root/Css/logninCss.css"/>
        <link rel="stylesheet" href="../../Root/Css/notificationCss.css"/>
    </head>
    <body>
        <ul class="notifications"></ul>
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap py-5">
                            <div
                                class="img d-flex align-items-center justify-content-center"
                                style="
                                background-image: url(../..//Root/Images/Logo/z4705695345706_20ca59964f9ad379fcebb44ceaad6cd4-removebg-preview.png);
                                "
                                ></div>
                            <h3 class="text-center mb-0">Welcome</h3>
                            <p class="text-center">Enter your email to reset your password</p>
                            <form action="/AccountController" method="post" class="login-form needs-validation" novalidate>
                                <div class="form-group">
                                    <div
                                        class="icon d-flex align-items-center justify-content-center"
                                        >
                                        <span class="fa-regular fa-envelope"></span>
                                    </div>
                                    <input
                                        name="email"
                                        type="email"
                                        class="form-control"
                                        placeholder="Email"
                                        required
                                        />
                                    <div class="invalid-feedback">
                                        Please provide a valid Gmail.
                                    </div>
                                </div>

                                <div class="form-group">
                                    <button
                                        name="btnEmail"
                                        type="submit"
                                        class="btn form-control btn-primary rounded submit px-3"
                                        >
                                        Submit
                                    </button>
                                </div>
                            </form>
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
        <script
            src="https://kit.fontawesome.com/2610154aa0.js"
            crossorigin="anonymous"
        ></script>

        <script>
            (function () {
                "use strict";

                var forms = document.querySelectorAll(".needs-validation");

                Array.prototype.slice.call(forms).forEach(function (form) {
                    form.addEventListener(
                            "submit",
                            function (event) {
                                if (!form.checkValidity()) {
                                    event.preventDefault();
                                    event.stopPropagation();
                                }

                                form.classList.add("was-validated");
                            },
                            false
                            );
                });
            })();
        </script>
    </body>
</html>
