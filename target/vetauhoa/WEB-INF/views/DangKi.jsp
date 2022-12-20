<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Basic Page Info -->
    <meta charset="utf-8">
    <title>Đăng kí</title>

    <!-- Site favicon -->
    <link rel="touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/resources/vendors/images/logo.png">
    <link rel="icon" type="image/png" sizes="32x32"
          href="${pageContext.request.contextPath}/resources/vendors/images/logo.png">
    <link rel="icon" type="image/png" sizes="16x16"
          href="${pageContext.request.contextPath}/resources/vendors/images/logo.png">

    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap"
          rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendors/styles/core.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/vendors/styles/icon-font.min.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/src/plugins/jquery-steps/jquery.steps.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendors/styles/style.css">

    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
    <script>
        window.dataLayer = window.dataLayer || [];

        function gtag() {
            dataLayer.push(arguments);
        }

        gtag('js', new Date());

        gtag('config', 'UA-119386393-1');
    </script>
    <!-- reCaptcha google -->
    <script type="text/javascript">
        var onloadCallback = function () {
            grecaptcha.render('html_element', {
                'sitekey': '6LfqI6UZAAAAAGGI1KPn7lVWNejMNftLz-mOYSRf'
            });
        };
        var correctCaptcha = function (response) {
            document.getElementById("submit").disabled = false;
        };
    </script>

    <script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit" async defer>
    </script>
</head>
<body class="login-page">
<div class="pre-loader">
    <div class="pre-loader-box">
        <div class="loader-logo"><img src="${pageContext.request.contextPath}/resources/vendors/images/logow.png" style="height: 50px;width:auto;" alt=""></div>
        <div class='loader-progress' id="progress_div">
            <div class='bar' id='bar1'></div>
        </div>
        <div class='percent' id='percent2'>0%</div>
        <div class="loading-text">
            Loading...
        </div>
    </div>
</div>
<div class="login-header box-shadow">
    <div class="container-fluid d-flex justify-content-between align-items-center">
        <div class="brand-logo">
            <a href="${pageContext.request.contextPath}/trang-chu">
                <img src="${pageContext.request.contextPath}/resources/vendors/images/logow.png" alt="">
            </a>
        </div>
        <div class="login-menu">
            <ul>
                <li><a href="${pageContext.request.contextPath}/trang-chu">Trang chủ</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="register-page-wrap d-flex align-items-center flex-wrap justify-content-center">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-6 col-lg-7">
                <img src="${pageContext.request.contextPath}/resources/vendors/images/railway-1.png" alt="">
            </div>
            <div class="col-md-6 col-lg-5">
                <div class="register-box bg-white box-shadow border-radius-10">
                    <div class="wizard-content">
                        <form id=register-form class="tab-wizard2 wizard-circle wizard" action="${pageContext.request.contextPath}/verify" method="post">
                            <h5>Tài khoản</h5>
                            <section>
                                <small class="align-middle" style="color:red;"> ${message}</small>
                                <div class="form-wrap max-width-600 mx-auto">
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">Địa chỉ Email<a style="color: red;">*</a></label>
                                        <div class="col-sm-8">
                                            <small id="messagemail"></small>
                                            <input type="email" class="form-control" id="email" name="email"
                                                   placeholder="Email" required="" checked>
                                            <script id="rendered-js">
                                                $('#email').on('input', function () {
                                                    var permalink;
                                                    // Trim empty space
                                                    permalink = $.trim($(this).val());
                                                    // replace more then 1 space with only one
                                                    permalink = permalink.replace(/\s+/g, ' ');
                                                    $('#email-result').val(permalink);
                                                    $('#email-result').val($.trim($('#email-result').val()));
                                                });
                                                //# sourceURL=pen.js
                                            </script>
                                            <script id="rendered-js">
                                                $('#email').blur(function () {
                                                    if (!$(this).val()) {
                                                        $('#messagemail').html('Email không được để trống').css('color', 'red');
                                                    } else {
                                                        $('#messagemail').html('').css('color', 'green');
                                                    }
                                                });
                                            </script>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">Tên tài khoản<a style="color: red;">*</a></label>
                                        <div class="col-sm-8">
                                            <small id="messageusername"></small>
                                            <input type="input" class="form-control" id="username" name="username"
                                                   required="" maxlength="20" pattern="[A-Za-z0-9]+$"
                                                   placeholder="Username">
                                            <script id="rendered-js">
                                                $('#username').on('input', function () {
                                                    var permalink1;
                                                    // Trim empty space
                                                    permalink1 = $.trim($(this).val());
                                                    // replace more then 1 space with only one
                                                    permalink1 = permalink1.replace(/\s+/g, ' ');
                                                    $('#username-result').val(permalink1);
                                                    $('#username-result').val($.trim($('#username-result').val()));
                                                });
                                            </script>
                                            <script>
                                                $('#username').blur(function () {
                                                    if (!$(this).val()) {
                                                        $('#messageusername').html('Username không được để trống').css('color', 'red');
                                                    } else {
                                                        $('#messageusername').html('');
                                                    }
                                                });
                                            </script>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">Mật khẩu<a
                                                style="color: red;">*</a></label>
                                        <div class="col-sm-8">
                                            <small id="messagepassword"></small>
                                            <input type="password" class="form-control" id="password" name="password"
                                                   placeholder="Password" checked>
                                            <script>
                                                $('#password').blur(function () {
                                                    if (!$(this).val()) {
                                                        $('#messagepassword').html('Password không được để trống').css('color', 'red');
                                                    } else {
                                                      $('#messagepassword').html('');
                                                    }
                                                });
                                            </script>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">Xác nhận mật khẩu<a
                                                style="color: red;">*</a></label>
                                        <div class="col-sm-8">
                                            <small id="messagepass"></small>
                                            <input type="password" class="form-control" id="confirm_password"
                                                   name="confirm_password" placeholder="Retype password" checked>
                                            <script>
                                                $('#confirm_password').on('keyup', function () {
                                                    if ($('#password').val() == $('#confirm_password').val()) {
                                                        $('#messagepass').html('Mật khẩu trùng khớp').css('color', 'green');
                                                    } else
                                                        $('#messagepass').html('Mật khẩu không trùng khớp').css('color', 'red');
                                                });
                                            </script>

                                        </div>
                                    </div>
                                </div>
                            </section>
                            <!-- Step 2 -->
                            <h5>Thông tin cá nhân</h5>
                            <section>
                                <div class="form-wrap max-width-600 mx-auto">
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">Họ<a style="color: red;">*</a></label>
                                        <div class="col-sm-8">
                                            <small id="messageho"></small>
                                            <input type="text" class="form-control" id="ho" name="ho" placeholder="Họ" maxlength="45"
                                                   pattern="[A-Za-z+ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]+$" checked>
                                            <script>
                                                $('#ho').blur(function () {
                                                    if (!$(this).val()) {
                                                        $('#messageho').html('Họ không được để trống').css('color', 'red');
                                                    } else {
                                                        $('#messageho').html('');
                                                    }
                                                });
                                            </script>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">Tên<a style="color: red;">*</a></label>
                                        <div class="col-sm-8">
                                            <small id="messageten"></small>
                                            <input type="text" class="form-control" id="ten" name="ten"
                                                   placeholder="Tên" required="" maxlength="45"
                                                   pattern="[A-Za-z+ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]+$" checked>
                                            <script>
                                                $('#ten').blur(function () {
                                                    if (!$(this).val()) {
                                                        $('#messageten').html('Tên không được để trống').css('color', 'red');
                                                    } else {
                                                        $('#messageten').html('');
                                                    }
                                                });
                                            </script>
                                        </div>
                                    </div>
                                    <div class="form-group row align-items-center">
                                        <label class="col-sm-4 col-form-label">Giới tính<a
                                                style="color: red;">*</a></label>
                                        <div class="col-sm-8">
                                            <div class="custom-control custom-radio custom-control-inline pb-0">
                                                <input type="radio" id="nam" name="gioitinh"
                                                       class="custom-control-input">
                                                <label class="custom-control-label" for="nam">Nam</label>
                                            </div>
                                            <div class="custom-control custom-radio custom-control-inline pb-0">
                                                <input type="radio" id="nu" name="gioitinh"
                                                       class="custom-control-input" checked>
                                                <label class="custom-control-label" for="nu">Nữ</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">Mã căn cước<a
                                                style="color: red;">*</a></label>
                                        <div class="col-sm-8">
                                            <small id="messagecccd"></small>
                                            <input type="text" class="form-control" id="cccd" name="cccd" checked>
                                            <script id="rendered-js">
                                                $('#cccd').on('input', function () {
                                                    var cccdlink;
                                                    // Trim empty space
                                                    cccdlink = $.trim($(this).val());
                                                    // replace more then 1 space with only one
                                                    cccdlink = cccdlink.replace(/\s+/g, ' ');
                                                    $('#cccd-result').val(cccdlink);
                                                    $('#cccd-result').val($.trim($('#cccd-result').val()));
                                                });
                                            </script>
                                            <script>
                                                $('#cccd').blur(function () {
                                                    if (!$(this).val()) {
                                                        $('#messagecccd').html('Mã căn cước không được để trống').css('color', 'red');
                                                    } else {
                                                        $('#messagecccd').html('');
                                                    }
                                                });
                                            </script>
                                        </div>
                                    </div>
                                </div>
                            </section>
                            <h5>Xác nhận</h5>
                            <section>
                                <div class="form-wrap max-width-600 mx-auto">
                                    <ul class="register-info">
                                        <li>
                                            <div class="row">
                                                <div class="col-sm-4 weight-600">Địa chỉ email</div>
                                                <div class="col-sm-8">
                                                    <input id="email-result" readonly >
                                                </div>
                                            </div>
                                        </li>

                                        <li>
                                            <div class="row">
                                                <div class="col-sm-4 weight-600">Username</div>

                                                <div class="col-sm-8">
                                                    <input id="username-result" readonly>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="row">
                                                <div class="col-sm-4 weight-600">Mã căn cước</div>
                                                <div class="col-sm-8"><input id="cccd-result" readonly></div>
                                            </div>
                                        </li>
                                    </ul>
                                    <div class="align-content-center" id="html_element"
                                         data-callback="correctCaptcha"></div>
                                </div>
                            </section>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- success Popup html Start -->
<%--<button type="button" id="success-modal-btn" hidden data-toggle="modal" data-target="#success-modal"--%>
<%--        data-backdrop="static">Launch modal--%>
<%--</button>--%>
<%--<div class="modal fade" id="success-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"--%>
<%--     aria-hidden="true">--%>
<%--    <div class="modal-dialog modal-dialog-centered max-width-400" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-body text-center font-18">--%>
<%--                <h3 class="mb-20">Tài khoản đã được tạo!</h3>--%>
<%--                <div class="mb-30 text-center"><img--%>
<%--                        src="${pageContext.request.contextPath}/resources/vendors/images/success.png"></div>--%>
<%--                Mã xác thực đã được gửi đến email của bạn.--%>
<%--            </div>--%>
<%--            <div class="modal-footer justify-content-center">--%>
<%--                <button form="register-form" class="btn btn-primary">Xác thực tài khoản</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<!-- success Popup html End -->
<!-- js -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/vendors/scripts/core.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/script.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/process.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/layout-settings.js"></script>
<script src="${pageContext.request.contextPath}/resources/src/plugins/jquery-steps/jquery.steps.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/steps-setting.js"></script>
</body>

</html>