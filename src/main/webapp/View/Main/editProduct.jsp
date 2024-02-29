<%-- 
    Document   : create
    Created on : Feb 22, 2024, 2:09:53 PM
    Author     : thinh
--%>

<%@page import="Models.Mouse"%>
<%@page import="Models.Earphone"%>
<%@page import="Models.Switch"%>
<%@page import="Models.Keycap"%>
<%@page import="Models.Kit"%>
<%@page import="Models.Keyboard"%>
<%@page import="Models.Product"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="DAOs.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/ae360af17e.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <title>Nghien Nhua</title>
        <link rel="shortcut icon" href="../../Root/Images/Logo/z4705695345706_20ca59964f9ad379fcebb44ceaad6cd4-removebg-preview.png"/>
        <style>
            .form-control.valid {
                border-color: #28a745;
                padding-right: calc(1.5em + 0.75rem);
                background-image: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 8 8'%3e%3cpath fill='%2328a745' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e");
                background-repeat: no-repeat;
                background-position: center right calc(0.375em + 0.1875rem);
                background-size: calc(0.75em + 0.375rem) calc(0.75em + 0.375rem);
            }
            .form-control.invalid{
                border-color: #dc3545;
                padding-right: calc(1.5em + 0.75rem);
                background-image: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' fill='%23dc3545' viewBox='-2 -2 7 7'%3e%3cpath stroke='%23dc3545' d='M0 0l3 3m0-3L0 3'/%3e%3ccircle r='.5'/%3e%3ccircle cx='3' r='.5'/%3e%3ccircle cy='3' r='.5'/%3e%3ccircle cx='3' cy='3' r='.5'/%3e%3c/svg%3E");
                background-repeat: no-repeat;
                background-position: center right calc(0.375em + 0.1875rem);
                background-size: calc(0.75em + 0.375rem) calc(0.75em + 0.375rem);
            }
            .form-message {
                color: #dc3545;
                font-size: 14px;
            }
        </style>
    </head>
    <body>
        <%
            Product pro = (Product) session.getAttribute("pro");
        %>
        <div class="container-fluid bg-light" style="border-radius: 10px">
            <div class="container p-5">
                <div>
                    <h2>Edit</h2>
                    <p>Product</p>
                    <hr class="bg-danger border-1 border-top border-dark" />
                </div>

                <form  method="post" id="form" action="UserController" enctype="multipart/form-data" class="row my-4 g-3 needs-validation d-flex justify-content-center" novalidate>

                    <div class="col-md-8 row my-2 d-flex justify-content-between">
                        <div class="col-auto">
                            <label for="exampleFormControlInput1" class="form-label">ID</label>
                        </div>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="Pro_id" name="txtID" value="<%= pro.getPro_id()%>" disabled="">
                            <input type="hidden" name="hiddenID" value="<%= pro.getPro_id()%>">
                            <div class="form-message text-start"></div>
                        </div>
                    </div>

                    <div class="col-md-8 row my-2 d-flex justify-content-between">
                        <div class="col-auto">
                            <label for="exampleFormControlInput1" class="form-label">Tên sản phẩm:</label>
                        </div>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="Pro_name" name="txtName" value="<%= pro.getPro_name()%>" >
                            <div class="form-message text-start"></div>
                        </div>
                    </div>

                    <div class="col-md-8 row my-2 d-flex justify-content-between">
                        <div class="col-auto">
                            <label for="exampleFormControlInput1" class="form-label">Số lượng:</label>
                        </div>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="Pro_quan" name="txtQuantity"  value="<%= pro.getPro_quantity()%>">
                            <div class="form-message text-start"></div>
                        </div>
                    </div>

                    <div class="col-md-8 row my-2 d-flex justify-content-between">
                        <div class="col-auto">
                            <label for="exampleFormControlInput1" class="form-label">Giá:</label>
                        </div>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="Pro_price" name="txtPrice"  value="<%= pro.getPro_price()%>">
                            <div class="form-message text-start"></div>
                        </div>
                    </div>

                    <div class="col-md-8 row my-2 d-flex justify-content-between">
                        <div class="col-auto">
                            <label for="formFile" class="form-label">Hình ảnh:</label>
                        </div>
                        <div class="col-md-10">
                            <%
                                String img = pro.getPro_image();
                                 String[] image = img.split("&");
                            %>
                            <img src="../../Root/Images/Product/<%= image[0]%>" alt="alt" class="img-thumbnail" width="100px">

                            <input class="form-control" type="hidden" id="formFile" value="<%= img%>" name="txtPicture2"  multiple="true">
                            <input class="form-control" type="file" id="formFile" value="img" name="txtPicture"  multiple="true">
                            <div class="form-message text-start"></div>
                        </div>
                    </div>

                    <div class="col-md-8 row my-2 d-flex justify-content-between">
                        <div class="col-auto">
                            <label for="exampleFormControlTextarea1" class="form-label">Mô tả:</label>
                        </div>
                        <div class="col-md-10">
                            <input  type="text" class="form-control" id="Pro_des" name="txtDescription"  value="<%= pro.getPro_description()%>">
                            <div class="form-message text-start"></div>
                        </div>
                    </div>

                    <div class="col-md-8 row my-2 d-flex justify-content-between">
                        <div class="col-auto">
                            <label for="exampleFormControlInput1" class="form-label">Giảm giá:</label>
                        </div>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="Pro_dis" name="txtDiscount"  value="<%= pro.getPro_discount()%>">
                            <div class="form-message text-start"></div>
                        </div>
                    </div>

                    <div class="col-md-8 row my-2 d-flex justify-content-between">
                        <div class="col-auto">
                            <label for="exampleFormControlInput1" class="form-label">Hãng:</label>
                        </div>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="Pro_brand" name="txtBrand"  value="<%= pro.getPro_brand()%>">
                            <div class="form-message text-start"></div>
                        </div>
                    </div>

                    <div class="col-md-8 row my-2 d-flex justify-content-between">
                        <div class="col-auto">
                            <label for="exampleFormControlInput1" class="form-label">Xuất xứ:</label>
                        </div>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="Pro_origin" name="txtOrigin"  value="<%= pro.getPro_origin()%>" >
                            <div class="form-message text-start"></div>
                        </div>
                    </div>

                    <div class="col-md-8 row my-2 d-flex justify-content-between">
                        <div class="col-auto">
                            <label for="category" class="form-label">Loại sản phẩm: </label>
                        </div>
                        <div class="col-md-10">
                            <select class="form-select form-control" aria-label="Default select example" name="txtCateName" id="category" disabled="">
                                <option value="default">-- Chọn --</option>
                                <%
                                    ProductDAO pDAO = new ProductDAO();
                                    ResultSet rs = pDAO.getProCategory();
                                    String category = pro.getPro_category();
                                    while (rs.next()) {
                                %>      
                                <option value="<%= rs.getString("pro_category")%>" <%= (category.equals(rs.getString("pro_category"))) ? "selected" : ""%>><%= rs.getString("pro_category")%></option>
                                <%
                                    }
                                %>
                            </select>
                            <input type="hidden" id="hiddenSelect" name="hiddenSelect">
                            <div class="form-message text-start"></div>
                        </div>


                    </div>
                    <div id="fields" class="row  d-flex justify-content-center"></div>
                    <div class="col-12 my-2 d-flex justify-content-center gap-2">
                        <input type="submit" value="Update" name="btnUpdate" class="btn btn-primary"/>
                        <a href="/AdminController/ListProduct">
                            <button type="button" class="btn btn-danger" name="btnBack"> Back to list</button>
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    const cate = document.getElementById("category");
    function getcate_id() {
        var selectedValue = document.getElementById("category").value;
        document.getElementById("hiddenSelect").value = selectedValue;
    }
    getcate_id();
</script>

<script>
    function showFields() {
        var category = document.getElementById("category").value;
        var fieldsDiv = document.getElementById("fields");
        fieldsDiv.innerHTML = "";
        if (category === "Keyboard") {
            fieldsDiv.innerHTML = `
    <% if (pro.getPro_category().equals("Keyboard")) {
            Keyboard keyboard = (Keyboard) session.getAttribute("keyboard");
    %>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Led:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="keyboard_led" name="led_keyboard" value="<%= keyboard.getKb_led()%>">
<div class="form-message text-start"></div>
</div>
</div>
            
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Mode:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="keyboard_mode" name="mode_keyboard" value="<%= keyboard.getKb_mode()%>">
<div class="form-message"></div>
</div>
</div>
            
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Switch:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="keyboard_switch" name="switchType_keyboard" value="<%= keyboard.getKb_switch()%>">
<div class="form-message"></div>
</div>
</div>
            
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Keycap:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="keyboard_keycap" name="keycapType_keyboard" value="<%= keyboard.getKb_keycap()%>">
<div class="form-message"></div>
</div>
</div>
            
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Plate:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="keyboard_plate" name="plate_keyboard" value="<%= keyboard.getKb_plate()%>">
<div class="form-message"></div>
</div>
</div>
            
 <div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Case:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="keyboard_case" name="case_keyboard" value="<%= keyboard.getKb_case()%>">
<div class="form-message"></div>
</div>
</div>
    <% }%>
`;
            const keyboard_led = document.getElementById('keyboard_led');
            const keyboard_mode = document.getElementById('keyboard_mode');
            const keyboard_switch = document.getElementById('keyboard_switch');
            const keyboard_keycap = document.getElementById('keyboard_keycap');
            const keyboard_plate = document.getElementById('keyboard_plate');
            const keyboard_case = document.getElementById('keyboard_case');

            const setError = (element, message) => {
                const inputControl = element.parentElement;
                const errorDisplay = inputControl.querySelector('.form-message');
                errorDisplay.innerText = message;
                inputControl.classList.add('error');
                inputControl.classList.remove('success');
            };
            const setSuccess = element => {
                const inputControl = element.parentElement;
                const errorDisplay = inputControl.querySelector('.form-message');
                errorDisplay.innerText = '';
                inputControl.classList.add('success');
                inputControl.classList.remove('error');
            };
            const isValidNumber = number => {
                const regex = /^[1-9]\d*$/;
                return regex.test(String(number).toLowerCase());
            };
            const validateInputs = () => {
                const keyboard_ledValue = keyboard_led.value.trim();
                const keyboard_modeValue = keyboard_mode.value.trim();
                const keyboard_switchValue = keyboard_switch.value.trim();
                const keyboard_keycapValue = keyboard_keycap.value.trim();
                const keyboard_plateValue = keyboard_plate.value.trim();
                const keyboard_caseValue = keyboard_case.value.trim();
                let hasError = false;

                if (keyboard_ledValue === '') {
                    keyboard_led.classList.add('invalid');
                    keyboard_led.classList.remove('valid');
                    setError(keyboard_led, 'Led không được bỏ trống');
                    hasError = true;
                } else {
                    keyboard_led.classList.remove('invalid');
                    keyboard_led.classList.add('valid');
                    setSuccess(keyboard_led);
                }

                if (keyboard_modeValue === '') {
                    keyboard_mode.classList.add('invalid');
                    keyboard_mode.classList.remove('valid');
                    setError(keyboard_mode, 'Mode Không được bỏ trống');
                    hasError = true;
                } else {
                    keyboard_mode.classList.remove('invalid');
                    keyboard_mode.classList.add('valid');
                    setSuccess(keyboard_mode);
                }

                if (keyboard_switchValue === '') {
                    keyboard_switch.classList.add('invalid');
                    keyboard_switch.classList.remove('valid');
                    setError(keyboard_switch, 'Switch không được bỏ trống');
                    hasError = true;
                } else {
                    keyboard_switch.classList.remove('invalid');
                    keyboard_switch.classList.add('valid');
                    setSuccess(keyboard_switch);
                }

                if (keyboard_keycapValue === '') {
                    keyboard_keycap.classList.add('invalid');
                    keyboard_keycap.classList.remove('valid');
                    setError(keyboard_keycap, 'Keycap không được bỏ trống');
                    hasError = true;
                } else {
                    keyboard_keycap.classList.remove('invalid');
                    keyboard_keycap.classList.add('valid');
                    setSuccess(keyboard_keycap);
                }

                if (keyboard_plateValue === '') {
                    keyboard_plate.classList.add('invalid');
                    keyboard_plate.classList.remove('valid');
                    setError(keyboard_plate, 'Plate không được bỏ trống');
                    hasError = true;
                } else {
                    keyboard_plate.classList.remove('invalid');
                    keyboard_plate.classList.add('valid');
                    setSuccess(keyboard_plate);
                }

                if (keyboard_caseValue === '') {
                    keyboard_case.classList.add('invalid');
                    keyboard_case.classList.remove('valid');
                    setError(keyboard_case, 'Case không được bỏ trống');
                    hasError = true;
                } else {
                    keyboard_case.classList.remove('invalid');
                    keyboard_case.classList.add('valid');
                    setSuccess(keyboard_case);
                }

                return !hasError;
            }
            ;
            form.addEventListener('submit', function (e) {
                if (!validateInputs()) {
                    e.preventDefault(); // Ngăn chặn biểu mẫu gửi đi nếu có lỗi
                }
            });
        } else if (category === "Kit") {
            fieldsDiv.innerHTML = `
    <% if (pro.getPro_category().equals("Kit")) {
            Kit kit = (Kit) session.getAttribute("kit");
    %>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Layout:</label> 
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="kit_layout" name="layout_kit" value="<%= kit.getLayout() %>">
<div class="form-message"></div>
</div>
</div>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Mạch:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="kit_circuit" name="circuit_kit" value="<%= kit.getCircuit() %>">
<div class="form-message"></div>
</div>
</div>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Plate:</label>
                    
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="kit_plate" name="plate_kit" value="<%= kit.getPlate() %>">
<div class="form-message"></div>
</div>
</div>
</div><div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Mode:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="kit_mode" name="mode_kit" value="<%= kit.getMode() %>">
<div class="form-message"></div>
</div>
</div>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Case:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="kit_case" name="case_kit"  value="<%= kit.getKitCase() %>">
<div class="form-message"></div>
</div>
</div>
    <%}%>
`;
            const kit_layout = document.getElementById('kit_layout');
            const kit_circuit = document.getElementById('kit_circuit');
            const kit_plate = document.getElementById('kit_plate');
            const kit_mode = document.getElementById('kit_mode');
            const kit_case = document.getElementById('kit_case');
            let hasError = false;

            const setError = (element, message) => {
                const inputControl = element.parentElement;
                const errorDisplay = inputControl.querySelector('.form-message');
                errorDisplay.innerText = message;
                inputControl.classList.add('error');
                inputControl.classList.remove('success');
            };
            const setSuccess = element => {
                const inputControl = element.parentElement;
                const errorDisplay = inputControl.querySelector('.form-message');
                errorDisplay.innerText = '';
                inputControl.classList.add('success');
                inputControl.classList.remove('error');
            };
            const isValidNumber = number => {
                const regex = /^[1-9]\d*$/;
                return regex.test(String(number).toLowerCase());
            };
            const validateInputs = () => {
                const kit_layoutValue = kit_layout.value.trim();
                const kit_circuitValue = kit_circuit.value.trim();
                const kit_plateValue = kit_plate.value.trim();
                const kit_modeValue = kit_mode.value.trim();
                const kit_caseValue = kit_case.value.trim();
                let hasError = false;
                if (kit_layoutValue === '') {
                    kit_layout.classList.add('invalid');
                    kit_layout.classList.remove('valid');
                    setError(kit_layout, 'Layout không được bỏ trống');
                    hasError = true;
                } else {
                    kit_layout.classList.remove('invalid');
                    kit_layout.classList.add('valid');
                    setSuccess(kit_layout);
                }

                if (kit_circuitValue === '') {
                    kit_circuit.classList.add('invalid');
                    kit_circuit.classList.remove('valid');
                    setError(kit_circuit, 'Mạch không được bỏ trống');
                    hasError = true;
                } else {
                    kit_circuit.classList.remove('invalid');
                    kit_circuit.classList.add('valid');
                    setSuccess(kit_circuit);
                }

                if (kit_plateValue === '') {
                    kit_plate.classList.add('invalid');
                    kit_plate.classList.remove('valid');
                    setError(kit_plate, 'Plate không được bỏ trống');
                    hasError = true;
                } else {
                    kit_plate.classList.remove('invalid');
                    kit_plate.classList.add('valid');
                    setSuccess(kit_plate);
                }

                if (kit_modeValue === '') {
                    kit_mode.classList.add('invalid');
                    kit_mode.classList.remove('valid');
                    setError(kit_mode, 'Mode không được bỏ trống');
                    hasError = true;
                } else {
                    kit_mode.classList.remove('invalid');
                    kit_mode.classList.add('valid');
                    setSuccess(kit_mode);
                }

                if (kit_caseValue === '') {
                    kit_case.classList.add('invalid');
                    kit_case.classList.remove('valid');
                    setError(kit_case, 'Case không được bỏ trống');
                    hasError = true;
                } else {
                    kit_case.classList.remove('invalid');
                    kit_case.classList.add('valid');
                    setSuccess(kit_case);
                }
                return !hasError;
            }
            ;
            form.addEventListener('submit', function (e) {
                if (!validateInputs()) {
                    e.preventDefault(); // Ngăn chặn biểu mẫu gửi đi nếu có lỗi
                }
            });


        } else if (category === "Keycap") {
            fieldsDiv.innerHTML = `
    <% if (pro.getPro_category().equals("Keycap")) {
            Keycap keycap = (Keycap) session.getAttribute("keycap");
    %>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Chất liệu:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="keycap_material" name="material_key_cap" value="<%= keycap.getKc_material() %>">
<div class="form-message"></div>
</div>
</div>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Layout:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="keycap_layout" name="layout_keycap" value="<%= keycap.getKc_layout() %>">
<div class="form-message"></div>
</div>
</div>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Độ dày:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="keycap_thickness" name="thickness_keycap" value="<%= keycap.getKc_thicknessl() %>">
<div class="form-message"></div>
</div>
</div>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Độ bền:</label>
</div>
<div class="col-md-10">                   
<input type="text" class="form-control" id="keycap_durability" name="durability_keycap" value="<%= keycap.getKc_reliability() %>">
<div class="form-message"></div>
</div>
</div>
    <%}%>         
`;
            const keycap_material = document.getElementById('keycap_material');
            const keycap_layout = document.getElementById('keycap_layout');
            const keycap_thickness = document.getElementById('keycap_thickness');
            const keycap_durability = document.getElementById('keycap_durability');
            let hasError = false;

            const setError = (element, message) => {
                const inputControl = element.parentElement;
                const errorDisplay = inputControl.querySelector('.form-message');
                errorDisplay.innerText = message;
                inputControl.classList.add('error');
                inputControl.classList.remove('success');
            };

            const setSuccess = element => {
                const inputControl = element.parentElement;
                const errorDisplay = inputControl.querySelector('.form-message');
                errorDisplay.innerText = '';
                inputControl.classList.add('success');
                inputControl.classList.remove('error');
            };

            const isValidNumber = number => {
                const regex = /^[1-9]\d*$/;
                return regex.test(String(number).toLowerCase());
            };
            const validateInputs = () => {
                const keycap_materialValue = keycap_material.value.trim();
                const keycap_layoutValue = keycap_layout.value.trim();
                const keycap_thicknessValue = keycap_thickness.value.trim();
                const keycap_durabilityValue = keycap_durability.value.trim();

                let hasError = false;
                if (keycap_materialValue === '') {
                    keycap_material.classList.add('invalid');
                    keycap_material.classList.remove('valid');
                    setError(keycap_material, 'Chất liệu không được bỏ trống');
                    hasError = true;
                } else {
                    keycap_material.classList.remove('invalid');
                    keycap_material.classList.add('valid');
                    setSuccess(keycap_material);
                }

                if (keycap_layoutValue === '') {
                    keycap_layout.classList.add('invalid');
                    keycap_layout.classList.remove('valid');
                    setError(keycap_layout, 'Layout không được bỏ trống');
                    hasError = true;
                } else {
                    keycap_layout.classList.remove('invalid');
                    keycap_layout.classList.add('valid');
                    setSuccess(keycap_layout);
                }

                if (keycap_thicknessValue === '') {
                    keycap_thickness.classList.add('invalid');
                    keycap_thickness.classList.remove('valid');
                    setError(keycap_thickness, 'Độ dày không được bỏ trống');
                    hasError = true;
                } else {
                    keycap_thickness.classList.remove('invalid');
                    keycap_thickness.classList.add('valid');
                    setSuccess(keycap_thickness);
                }

                if (keycap_durabilityValue === '') {
                    keycap_durability.classList.add('invalid');
                    keycap_durability.classList.remove('valid');
                    setError(keycap_durability, 'Độ bền không được bỏ trống');
                    hasError = true;
                } else {
                    keycap_durability.classList.remove('invalid');
                    keycap_durability.classList.add('valid');
                    setSuccess(keycap_durability);
                }
                return !hasError;
            }
            ;
            form.addEventListener('submit', function (e) {
                if (!validateInputs()) {
                    e.preventDefault(); // Ngăn chặn biểu mẫu gửi đi nếu có lỗi
                }
            });

        } else if (category === "Switch") {
            fieldsDiv.innerHTML = `
    <% if (pro.getPro_category().equals("Switch")) {
            Switch switchs = (Switch) session.getAttribute("switch");
    %>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Pin:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="switch_pin" name="pin_switch" value="<%= switchs.getSw_pin() %>">
<div class="form-message"></div>
</div>
</div>
</div>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Loại:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="switch_type" name="type_switch" value="<%= switchs.getSw_type() %>">
<div class="form-message"></div>
</div>
</div>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Lò xò:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="switch_complexity" name="complexity_switch" value="<%= switchs.getSw_spring() %>">
<div class="form-message"></div>
</div>
</div>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Độ bền:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="switch_durability" name="durability_switch" value="<%= switchs.getSw_reliability() %>">
<div class="form-message"></div>
</div>
</div>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Hành trình:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="switch_travel" name="travel_switch" value="<%= switchs.getSw_depth() %>">
<div class="form-message"></div>
</div>
</div>
    <%}%>                
`;
            const switch_pin = document.getElementById('switch_pin');
            const switch_type = document.getElementById('switch_type');
            const switch_complexity = document.getElementById('switch_complexity');
            const switch_durability = document.getElementById('switch_durability');
            const switch_travel = document.getElementById('switch_travel');
            let hasError = false;

            const setError = (element, message) => {
                const inputControl = element.parentElement;
                const errorDisplay = inputControl.querySelector('.form-message');
                errorDisplay.innerText = message;
                inputControl.classList.add('error');
                inputControl.classList.remove('success');
            };

            const setSuccess = element => {
                const inputControl = element.parentElement;
                const errorDisplay = inputControl.querySelector('.form-message');
                errorDisplay.innerText = '';
                inputControl.classList.add('success');
                inputControl.classList.remove('error');
            };

            const isValidNumber = number => {
                const regex = /^[1-9]\d*$/;
                return regex.test(String(number).toLowerCase());
            };
            const validateInputs = () => {
                const switch_pinValue = switch_pin.value.trim();
                const switch_typeValue = switch_type.value.trim();
                const switch_complexityValue = switch_complexity.value.trim();
                const switch_durabilityValue = switch_durability.value.trim();
                const switch_travelValue = switch_travel.value.trim();

                if (switch_pinValue === '') {
                    switch_pin.classList.add('invalid');
                    switch_pin.classList.remove('valid');
                    setError(switch_pin, 'Pin không được bỏ trống');
                    hasError = true;
                } else {
                    switch_pin.classList.remove('invalid');
                    switch_pin.classList.add('valid');
                    setSuccess(switch_pin);
                }

                if (switch_typeValue === '') {
                    switch_type.classList.add('invalid');
                    switch_type.classList.remove('valid');
                    setError(switch_type, 'Loại không được bỏ trống');
                    hasError = true;
                } else {
                    switch_type.classList.remove('invalid');
                    switch_type.classList.add('valid');
                    setSuccess(switch_type);
                }

                if (switch_complexityValue === '') {
                    switch_complexity.classList.add('invalid');
                    switch_complexity.classList.remove('valid');
                    setError(switch_complexity, 'Lò xo không được bỏ trống');
                    hasError = true;
                } else {
                    switch_complexity.classList.remove('invalid');
                    switch_complexity.classList.add('valid');
                    setSuccess(switch_complexity);
                }

                if (switch_durabilityValue === '') {
                    switch_durability.classList.add('invalid');
                    switch_durability.classList.remove('valid');
                    setError(switch_durability, 'Độ bền không được bỏ trống');
                    hasError = true;
                } else {
                    switch_durability.classList.remove('invalid');
                    switch_durability.classList.add('valid');
                    setSuccess(switch_durability);
                }

                if (switch_travelValue === '') {
                    switch_travel.classList.add('invalid');
                    switch_travel.classList.remove('valid');
                    setError(switch_travel, 'Hành trình không được bỏ trống');
                    hasError = true;
                } else {
                    switch_travel.classList.remove('invalid');
                    switch_travel.classList.add('valid');
                    setSuccess(switch_travel);
                }

                return !hasError;
            }
            ;
            form.addEventListener('submit', function (e) {
                if (!validateInputs()) {
                    e.preventDefault(); // Ngăn chặn biểu mẫu gửi đi nếu có lỗi
                }
            });


        } else if (category === "Earphone") {
            fieldsDiv.innerHTML = `
    <% if (pro.getPro_category().equals("Earphone")) {
            Earphone earphone = (Earphone) session.getAttribute("earphone");
    %>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Type:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="earphone_type" name="type_earphone" value="<%= earphone.getEar_type() %>">
<div class="form-message"></div>
</div>
</div>
            
 <div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Plug:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="earphone_plug" name="plug_earphone" value="<%= earphone.getEar_plug() %>">
<div class="form-message"></div>
</div>
</div>

<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Compatibility:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="earphone_compatibility" name="compatibility_earphone" value="<%= earphone.getEar_compatibility() %>">
<div class="form-message"></div>
</div>
</div>

<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Wire length:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="earphone_wirelength" name="wirelength_earphone" value="<%= earphone.getEar_wireLength() %>">
<div class="form-message"></div>
</div>
</div>

<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Utility:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="earphone_utility" name="utility_earphone" value="<%= earphone.getEar_utility() %>">
<div class="form-message"></div>
</div>
</div>

<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Connect:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="earphone_connect" name="connect_earphone" value="<%= earphone.getEar_connect() %>">
<div class="form-message"></div>
</div>
</div>

<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Control:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="earphone_control" name="control_earphone" value="<%= earphone.getEar_control() %>">
<div class="form-message"></div>
</div>
</div>

<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Charging port:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="earphone_chargingport" name="chargingport_earphone" value="<%= earphone.getEar_chargingPort() %>">
<div class="form-message"></div>
</div>
</div>

<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Connect tech:</label>
</div>
<div class="col-md-10">            
<input type="text" class="form-control" id="earphone_connecttech" name="connecttech_earphone" value="<%= earphone.getEar_connectTeach() %>">
<div class="form-message"></div>
</div>
</div>
    <%}%>                
`;
            const earphone_type = document.getElementById('earphone_type');
            const earphone_plug = document.getElementById('earphone_plug');
            const earphone_compatibility = document.getElementById('earphone_compatibility');
            const earphone_wirelength = document.getElementById('earphone_wirelength');
            const earphone_utility = document.getElementById('earphone_utility');
            const earphone_connect = document.getElementById('earphone_connect');
            const earphone_control = document.getElementById('earphone_control');
            const earphone_chargingport = document.getElementById('earphone_chargingport');
            const earphone_connecttech = document.getElementById('earphone_connecttech');
            let hasError = false;

            const setError = (element, message) => {
                const inputControl = element.parentElement;
                const errorDisplay = inputControl.querySelector('.form-message');
                errorDisplay.innerText = message;
                inputControl.classList.add('error');
                inputControl.classList.remove('success');
            };

            const setSuccess = element => {
                const inputControl = element.parentElement;
                const errorDisplay = inputControl.querySelector('.form-message');
                errorDisplay.innerText = '';
                inputControl.classList.add('success');
                inputControl.classList.remove('error');
            };

            const isValidNumber = number => {
                const regex = /^[1-9]\d*$/;
                return regex.test(String(number).toLowerCase());
            };
            const validateInputs = () => {
                const earphone_typeValue = earphone_type.value.trim();
                const earphone_plugValue = earphone_plug.value.trim();
                const earphone_compatibilityValue = earphone_compatibility.value.trim();
                const earphone_wirelengthValue = earphone_wirelength.value.trim();
                const earphone_utilityValue = earphone_utility.value.trim();
                const earphone_connectValue = earphone_connect.value.trim();
                const earphone_controlValue = earphone_control.value.trim();
                const earphone_chargingportValue = earphone_chargingport.value.trim();
                const earphone_connecttechValue = earphone_connecttech.value.trim();


                if (earphone_typeValue === '') {
                    earphone_type.classList.add('invalid');
                    earphone_type.classList.remove('valid');
                    setError(earphone_type, 'Type không được bỏ trống');
                    hasError = true;
                } else {
                    earphone_type.classList.remove('invalid');
                    earphone_type.classList.add('valid');
                    setSuccess(earphone_type);
                }

                if (earphone_plugValue === '') {
                    earphone_plug.classList.add('invalid');
                    earphone_plug.classList.remove('valid');
                    setError(earphone_plug, 'Plug không được bỏ trống');
                    hasError = true;
                } else {
                    earphone_plug.classList.remove('invalid');
                    earphone_plug.classList.add('valid');
                    setSuccess(earphone_plug);
                }

                if (earphone_compatibilityValue === '') {
                    earphone_compatibility.classList.add('invalid');
                    earphone_compatibility.classList.remove('valid');
                    setError(earphone_compatibility, 'Compatibility không được bỏ trống');
                    hasError = true;
                } else {
                    earphone_compatibility.classList.remove('invalid');
                    earphone_compatibility.classList.add('valid');
                    setSuccess(earphone_compatibility);
                }

                if (earphone_wirelengthValue === '') {
                    earphone_wirelength.classList.add('invalid');
                    earphone_wirelength.classList.remove('valid');
                    setError(earphone_wirelength, 'Wire leng không được bỏ trống');
                    hasError = true;
                } else {
                    earphone_wirelength.classList.remove('invalid');
                    earphone_wirelength.classList.add('valid');
                    setSuccess(earphone_wirelength);
                }

                if (earphone_utilityValue === '') {
                    earphone_utility.classList.add('invalid');
                    earphone_utility.classList.remove('valid');
                    setError(earphone_utility, 'Utility không được bỏ trống');
                    hasError = true;
                } else {
                    earphone_utility.classList.remove('invalid');
                    earphone_utility.classList.add('valid');
                    setSuccess(earphone_utility);
                }

                if (earphone_connectValue === '') {
                    earphone_connect.classList.add('invalid');
                    earphone_connect.classList.remove('valid');
                    setError(earphone_connect, 'Connect không được bỏ trống');
                    hasError = true;
                } else {
                    earphone_connect.classList.remove('invalid');
                    earphone_connect.classList.add('valid');
                    setSuccess(earphone_connect);
                }

                if (earphone_controlValue === '') {
                    earphone_control.classList.add('invalid');
                    earphone_control.classList.remove('valid');
                    setError(earphone_control, 'Control không được bỏ trống');
                    hasError = true;
                } else {
                    earphone_control.classList.remove('invalid');
                    earphone_control.classList.add('valid');
                    setSuccess(earphone_control);
                }

                if (earphone_chargingportValue === '') {
                    earphone_chargingport.classList.add('invalid');
                    earphone_chargingport.classList.remove('valid');
                    setError(earphone_chargingport, 'Chargingport không được bỏ trống');
                    hasError = true;
                } else {
                    earphone_chargingport.classList.remove('invalid');
                    earphone_chargingport.classList.add('valid');
                    setSuccess(earphone_chargingport);
                }

                if (earphone_connecttechValue === '') {
                    earphone_connecttech.classList.add('invalid');
                    earphone_connecttech.classList.remove('valid');
                    setError(earphone_connecttech, 'Connecttech không được bỏ trống');
                    hasError = true;
                } else {
                    earphone_connecttech.classList.remove('invalid');
                    earphone_connecttech.classList.add('valid');
                    setSuccess(earphone_connecttech);
                }

                return !hasError;
            }
            ;
            form.addEventListener('submit', function (e) {
                if (!validateInputs()) {
                    e.preventDefault(); // Ngăn chặn biểu mẫu gửi đi nếu có lỗi
                }
            });
        } else if (category === "Mouse") {
            fieldsDiv.innerHTML = `
    <% if (pro.getPro_category().equals("Mouse")) {
            Mouse mouse = (Mouse) session.getAttribute("mouse");
    %>
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">DPi:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="mouse_dpi" name="dpi_mouse" value="<%= mouse.getMouse_dpi() %>">
<div class="form-message text-start"></div>
</div>
</div>
            
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Wire length:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="mouse_wirelength" name="wirelength_mouse" value="<%= mouse.getMouse_wireLength() %>">
<div class="form-message text-start"></div>
</div>
</div>
            
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Led:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="mouse_led" name="led_mouse" value="<%= mouse.getMouse_led() %>">
<div class="form-message text-start"></div>
</div>
</div>
            
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Type battery:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="mouse_typebattery" name="typebattery_mouse" value="<%= mouse.getMouse_typeBattery() %>">
<div class="form-message text-start"></div>
</div>
</div>
            
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Weight:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="mouse_weight" name="weight_mouse" value="<%= mouse.getMouse_weight() %>">
<div class="form-message text-start"></div>
</div>
</div>
            
<div class="col-md-8 row my-2 d-flex justify-content-between">
<div class="col-auto">
<label for="exampleFormControlInput1" class="form-label">Compatibility:</label>
</div>
<div class="col-md-10">
<input type="text" class="form-control" id="mouse_compatibility" name="compatibility_mouse" value="<%= mouse.getMouse_compatibility() %>">
<div class="form-message text-start"></div>
</div>
</div>
    <%}%>                
`;
            const mouse_dpi = document.getElementById('mouse_dpi');
            const mouse_wirelength = document.getElementById('mouse_wirelength');
            const mouse_led = document.getElementById('mouse_led');
            const mouse_typebattery = document.getElementById('mouse_typebattery');
            const mouse_weight = document.getElementById('mouse_weight');
            const mouse_compatibility = document.getElementById('mouse_compatibility');

            const setError = (element, message) => {
                const inputControl = element.parentElement;
                const errorDisplay = inputControl.querySelector('.form-message');
                errorDisplay.innerText = message;
                inputControl.classList.add('error');
                inputControl.classList.remove('success');
            };
            const setSuccess = element => {
                const inputControl = element.parentElement;
                const errorDisplay = inputControl.querySelector('.form-message');
                errorDisplay.innerText = '';
                inputControl.classList.add('success');
                inputControl.classList.remove('error');
            };
            const isValidNumber = number => {
                const regex = /^[1-9]\d*$/;
                return regex.test(String(number).toLowerCase());
            };
            const validateInputs = () => {
                const mouse_dpiValue = mouse_dpi.value.trim();
                const mouse_wirelengthValue = mouse_wirelength.value.trim();
                const mouse_ledValue = mouse_led.value.trim();
                const mouse_typebatteryValue = mouse_typebattery.value.trim();
                const mouse_weightValue = mouse_weight.value.trim();
                const mouse_compatibilityValue = mouse_compatibility.value.trim();
                let hasError = false;

                if (mouse_dpiValue === '') {
                    mouse_dpi.classList.add('invalid');
                    mouse_dpi.classList.remove('valid');
                    setError(mouse_dpi, 'DPI không được bỏ trống');
                    hasError = true;
                } else {
                    mouse_dpi.classList.remove('invalid');
                    mouse_dpi.classList.add('valid');
                    setSuccess(mouse_dpi);
                }

                if (mouse_wirelengthValue === '') {
                    mouse_wirelength.classList.add('invalid');
                    mouse_wirelength.classList.remove('valid');
                    setError(mouse_wirelength, 'Wirelength Không được bỏ trống');
                    hasError = true;
                } else {
                    mouse_wirelength.classList.remove('invalid');
                    mouse_wirelength.classList.add('valid');
                    setSuccess(mouse_wirelength);
                }

                if (mouse_ledValue === '') {
                    mouse_led.classList.add('invalid');
                    mouse_led.classList.remove('valid');
                    setError(mouse_led, 'Led không được bỏ trống');
                    hasError = true;
                } else {
                    mouse_led.classList.remove('invalid');
                    mouse_led.classList.add('valid');
                    setSuccess(mouse_led);
                }

                if (mouse_typebatteryValue === '') {
                    mouse_typebattery.classList.add('invalid');
                    mouse_typebattery.classList.remove('valid');
                    setError(mouse_typebattery, 'Type battery không được bỏ trống');
                    hasError = true;
                } else {
                    mouse_typebattery.classList.remove('invalid');
                    mouse_typebattery.classList.add('valid');
                    setSuccess(mouse_typebattery);
                }

                if (mouse_weightValue === '') {
                    mouse_weight.classList.add('invalid');
                    mouse_weight.classList.remove('valid');
                    setError(mouse_weight, 'Weight không được bỏ trống');
                    hasError = true;
                } else {
                    mouse_weight.classList.remove('invalid');
                    mouse_weight.classList.add('valid');
                    setSuccess(mouse_weight);
                }

                if (mouse_compatibilityValue === '') {
                    mouse_compatibility.classList.add('invalid');
                    mouse_compatibility.classList.remove('valid');
                    setError(mouse_compatibility, 'Compatibility không được bỏ trống');
                    hasError = true;
                } else {
                    mouse_compatibility.classList.remove('invalid');
                    mouse_compatibility.classList.add('valid');
                    setSuccess(mouse_compatibility);
                }

                return !hasError;
            }
            ;
            form.addEventListener('submit', function (e) {
                if (!validateInputs()) {
                    e.preventDefault(); // Ngăn chặn biểu mẫu gửi đi nếu có lỗi
                }
            });
        }

    }
    showFields();
</script>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        const form = document.querySelector('#form');
        const pro_name = document.getElementById('Pro_name');
        const pro_price = document.getElementById('Pro_price');
        const pro_quan = document.getElementById('Pro_quan');
        const pro_pic = document.getElementById('formFile');
        const pro_des = document.getElementById('Pro_des');
        const pro_dis = document.getElementById('Pro_dis');
        const pro_brand = document.getElementById('Pro_brand');
        const pro_origin = document.getElementById('Pro_origin');
        const pro_type = document.getElementById('category');


        const setError = (element, message) => {
            const inputControl = element.parentElement;
            const errorDisplay = inputControl.querySelector('.form-message');
            errorDisplay.innerText = message;
            inputControl.classList.add('error');
            inputControl.classList.remove('success');
        };
        const setSuccess = element => {
            const inputControl = element.parentElement;
            const errorDisplay = inputControl.querySelector('.form-message');
            errorDisplay.innerText = '';
            inputControl.classList.add('success');
            inputControl.classList.remove('error');
        };
        const isValidNumber = number => {
            const regex = /^[0-9]*\.?[0-9]+$/;
            return regex.test(String(number).toLowerCase());
        };
        const isValidDiscount = number => {
            const regex = /^[0-9]\d*$/;
            return regex.test(String(number).toLowerCase());
        };
        const validateInputs = () => {
            const pro_nameValue = pro_name.value.trim();
            const pro_priceValue = pro_price.value.trim();
            const pro_quanValue = pro_quan.value.trim();
            const pro_picValue = pro_pic.value.trim();
            const pro_desValue = pro_des.value.trim();
            const pro_disValue = pro_dis.value.trim();
            const pro_brandValue = pro_brand.value.trim();
            const pro_originValue = pro_origin.value.trim();
            const pro_typeValue = pro_type.value.trim();
            let hasError = false;

            if (pro_nameValue === '') {
                pro_name.classList.add('invalid');
                pro_name.classList.remove('valid');
                setError(pro_name, 'Tên sản phẩm không được để trống');
                hasError = true;
            } else {
                pro_name.classList.remove('invalid');
                pro_name.classList.add('valid');
                setSuccess(pro_name);
            }



            if (pro_priceValue === '') {
                pro_price.classList.add('invalid');
                pro_price.classList.remove('valid');
                setError(pro_price, 'Giá không được để trống');
                hasError = true;
            } else if (!isValidNumber(pro_priceValue)) {
                pro_price.classList.add('invalid');
                pro_price.classList.remove('valid');
                setError(pro_price, 'Giá không hợp lệ ');
                hasError = true;
            } else {
                pro_price.classList.remove('invalid');
                pro_price.classList.add('valid');
                setSuccess(pro_price);
            }

            if (pro_quanValue === '') {
                pro_quan.classList.add('invalid');
                pro_quan.classList.remove('valid');
                setError(pro_quan, 'Số lượng không được để trống');
                hasError = true;
            } else if (!isValidNumber(pro_quanValue)) {
                pro_quan.classList.add('invalid');
                pro_quan.classList.remove('valid');
                setError(pro_quan, 'Số lượng không hợp lệ');
                hasError = true;
            } else {
                pro_quan.classList.remove('invalid');
                pro_quan.classList.add('valid');
                setSuccess(pro_quan);
            }



            if (pro_picValue === '') {
                pro_pic.classList.add('invalid');
                pro_pic.classList.remove('valid');
                setError(pro_pic, 'Hình ảnh không được để trống');
                hasError = true;
            } else {
                pro_pic.classList.remove('invalid');
                pro_pic.classList.add('valid');
                setSuccess(pro_pic);
            }

            if (pro_desValue === '') {
                pro_des.classList.add('invalid');
                pro_des.classList.remove('valid');
                setError(pro_des, 'Mô tả không được để trông');
                hasError = true;
            } else {
                pro_des.classList.remove('invalid');
                pro_des.classList.add('valid');
                setSuccess(pro_des);
            }

            if (pro_disValue === '') {
                pro_dis.classList.add('invalid');
                pro_dis.classList.remove('valid');
                setError(pro_dis, 'Giảm giá không được để trống');
                hasError = true;
            } else if (!isValidDiscount(pro_disValue) || pro_disValue > 100) {
                pro_dis.classList.add('invalid');
                pro_dis.classList.remove('valid');
                setError(pro_dis, 'Giảm giá không hợp lệ');
                hasError = true;
            } else {
                pro_dis.classList.remove('invalid');
                pro_dis.classList.add('valid');
                setSuccess(pro_dis);
            }

            if (pro_brandValue === '') {
                pro_brand.classList.add('invalid');
                pro_brand.classList.remove('valid');
                setError(pro_brand, 'Hãng không được để trống');
                hasError = true;
            } else {
                pro_brand.classList.remove('invalid');
                pro_brand.classList.add('valid');
                setSuccess(pro_brand);
            }

            if (pro_originValue === '') {
                pro_origin.classList.add('invalid');
                pro_origin.classList.remove('valid');
                setError(pro_origin, 'Xuất xứ không được để trống');
                hasError = true;
            } else {
                pro_origin.classList.remove('invalid');
                pro_origin.classList.add('valid');
                setSuccess(pro_origin);
            }

            if (pro_typeValue === 'default') {
                pro_type.classList.add('invalid');
                pro_type.classList.remove('valid');
                setError(pro_type, 'Loại sản phẩm không được để trống');
                hasError = true;
            } else {
                pro_type.classList.remove('invalid');
                pro_type.classList.add('valid');
                setSuccess(pro_type);
            }

            return !hasError;
        }
        ;
        form.addEventListener('submit', function (e) {
            if (!validateInputs()) {
                e.preventDefault(); // Ngăn chặn biểu mẫu gửi đi nếu có lỗi
            }
        });
    }
    );
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
crossorigin="anonymous"></script>
</body>
</html>
