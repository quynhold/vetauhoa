<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <!-- Basic Page Info -->
    <meta charset="utf-8">
    <title>Xác thực email</title>

    <!-- Site favicon -->
    <link rel="touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/resources/vendors/images/logo.png">
    <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/resources/vendors/images/logo.png">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/vendors/images/logo.png">

    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendors/styles/core.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendors/styles/icon-font.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendors/styles/style.css">


    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag(){dataLayer.push(arguments);}
        gtag('js', new Date());

        gtag('config', 'UA-119386393-1');
    </script>
</head>

<body>
<div class="login-header box-shadow">
    <div class="container-fluid d-flex justify-content-between align-items-center">
        <div class="brand-logo">
            <a href="${pageContext.request.contextPath}/trang-chu">
                <img src="${pageContext.request.contextPath}/resources/vendors/images/logow.png" alt="">
            </a>
        </div>
        <div class="login-menu">
            <ul>
                <li><a href="${pageContext.request.contextPath}/dang-nhap">Đăng nhập</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="login-wrap d-flex align-items-center flex-wrap justify-content-center">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-6">
                <img src="${pageContext.request.contextPath}/resources/vendors/images/forgot-password.png" alt="">
            </div>
            <div class="col-md-6">
                <div class="login-box bg-white box-shadow border-radius-10">
                    <div class="login-title">
                        <h2 class="text-center text-primary">Xác thực email</h2>
                    </div>
                    <h6 class="mb-20">Nhập mã đã được gửi đến email của bạn</h6>
                    <form action="${pageContext.request.contextPath}/${username}/change-password" method="post">
                        <div class="input-group custom">
                            <input type="text" id="verify-code" name="verify-code" class="form-conttrol form-control-lg" placeholder="Code 6-digit">
                            <div class="input-group-append custom">
                                <span class="input-group-text"><i class="fa fa-code" aria-hidden="true"></i></span>
                            </div>
                        </div>
                        <div class="row align-items-center">
                            <div class="col-5">
                            </div>
                            <div class="col-2">
                                <div class="font-16 weight-600 text-center" data-color="#707373"></div>
                            </div>

                            <div class="col-5">
                                <div class="input-group mb-0">
                                    <button class="btn btn-primary btn-lg btn-block" type="submit">Kiểm mã</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- js -->
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/core.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/script.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/process.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/layout-settings.js"></script>
</body>

</html>
