<%-- 
    Document   : changePassword
    Created on : Mar 1, 2024, 1:53:51 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nghiện Nhựa</title>
        <link
            href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
            rel="stylesheet"
            />
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            />  
        <link rel="shortcut icon" href="/Front/assets/image/logo/z4705695345706_20ca59964f9ad379fcebb44ceaad6cd4-removebg-preview.png"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="../../Root/Css/logninCss.css"/>
    </head>
    <body>
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap py-5">
                            <div
                                class="img d-flex align-items-center justify-content-center"
                                style="
                                background-image: url(images/z4705695345706_20ca59964f9ad379fcebb44ceaad6cd4-removebg-preview.png);
                                "
                                ></div>
                            <h3 class="text-center mb-0">Welcome</h3>
                            <p class="text-center">Change password</p>
                            <form action="/AccountController" method="post" class="login-form needs-validation" novalidate>
                                <div class="form-group">
                                    <div
                                        class="icon d-flex align-items-center justify-content-center"
                                        >
                                        <span class="fa-solid fa-lock"></span>
                                    </div>
                                    <input
                                        name="oldPassword"
                                        id="oldPassword"
                                        type="password"
                                        class="form-control"
                                        placeholder="Old password"
                                        required
                                        />
                                    <div class="invalid-feedback">
                                        Please provide a valid password.
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div
                                        class="icon d-flex align-items-center justify-content-center"
                                        >
                                        <span class="fa-solid fa-lock"></span>
                                    </div>
                                    <input
                                        name="newPassword"
                                        id="newPassword"
                                        type="password"
                                        class="form-control"
                                        placeholder="New password"
                                        required
                                        />
                                    <div class="invalid-feedback">
                                        Please provide a valid password.
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div
                                        class="icon d-flex align-items-center justify-content-center"
                                        >
                                        <span class="fa-solid fa-lock"></span>
                                    </div>
                                    <input
                                        name="confirmPassword"
                                        id="confirmPassword"
                                        type="password"
                                        class="form-control"
                                        placeholder="Confirm new password"
                                        required
                                        />
                                    <div class="invalid-feedback">
                                        Please provide a valid confirm password.
                                    </div>
                                </div>

                                <div class="form-group">
                                    <button
                                        name="btnChangePassword"
                                        value="change"
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
        <script
            src="https://kit.fontawesome.com/2610154aa0.js"
            crossorigin="anonymous"
        ></script>
        <script src="js/main.js"></script>
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
                                // check password and confirm password
                                if (
                                        form.newPassword.value !== form.confirmPassword.value &&
                                        form.newPassword.value !== "" &&
                                        form.confirmPassword.value !== ""
                                        ) {
                                    form.confirmPassword.setCustomValidity(
                                            "Passwords do not match"
                                            );
                                    event.preventDefault();
                                } else {
                                    form.confirmPassword.setCustomValidity("");
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
