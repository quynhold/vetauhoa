<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Basic Page Info -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Đăng nhập</title>

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

        function gtag() {
            dataLayer.push(arguments);
        }
        gtag('js', new Date());

        gtag('config', 'UA-119386393-1');
    </script>
    <script src="${pageContext.request.contextPath}/resources/vendors/scripts/core.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendors/scripts/script.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendors/scripts/process.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendors/scripts/layout-settings.js"></script>
</head>

<body class="login-page">
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
<div class="login-wrap d-flex align-items-center flex-wrap justify-content-center">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-6 col-lg-7 center-block">
                <img src="${pageContext.request.contextPath}/resources/vendors/images/railway.png" alt="">
            </div>
            <div class="col-md-6 col-lg-5">
                <div class="login-box bg-white box-shadow border-radius-10">
                    <div class="login-title">
                        <h2 class="text-center text-primary">Đăng nhập</h2>
                    </div>
                    <c:if test="${param.error == 'failed'}">
                        <div style="color:red;margin:10px 0px;">
                            Đăng nhập thất bại<br/>
                            Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                        </div>
                    </c:if>
                    <form action="${pageContext.request.contextPath}/login" method="post">
                        <div class="input-group custom">
                            <input type="text" name="username" class="form-control form-control-lg" placeholder="Username" checked>
                            <div class="input-group-append custom">
                                <span class="input-group-text"><i class="icon-copy dw dw-user1"></i></span>
                            </div>
                        </div>
                        <div class="input-group custom">
                            <input type="password" name="password" class="form-control form-control-lg" placeholder="**********" checked>
                            <div class="input-group-append custom">
                                <span class="input-group-text"><i class="dw dw-padlock1"></i></span>
                            </div>
                        </div>
                        <div class="row pb-30">
                            <div class="col-6">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" name="rememberpass" class="custom-control-input" id="customCheck1">
                                    <label class="custom-control-label" for="customCheck1">Nhớ mật khẩu</label>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="forgot-password"><a href="${pageContext.request.contextPath}/quen-password">Quên mật khẩu</a></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="input-group mb-0">
                                    <!--
                                        use code for form submit
                                        <input class="btn btn-primary btn-lg btn-block" type="submit" value="Sign In">
                                    -->
                                    <button type="submit" class="btn btn-primary btn-lg btn-block" href="${pageContext.request.contextPath}/login">Đăng nhập</button>
                                </div>
                                <div class="font-16 weight-600 pt-10 pb-10 text-center" data-color="#707373">Hoặc</div>
                                <div class="input-group mb-0">
                                    <a class="btn btn-outline-primary btn-lg btn-block" href="${pageContext.request.contextPath}/dang-ki">Tạo tài khoản</a>
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
</body>
</html>