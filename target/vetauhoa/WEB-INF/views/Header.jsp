<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
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
    <style>
        ul.menu {
            float: right;
        }

        ul.menu li {
            float: left;
            text-align: center;
        }

        ul li a {
            padding: 0 20px;
            text-align: center;
            font-size: large;
        }

    </style>
</head>
<body>
<security:authorize access="isAnonymous()">
    <c:set var="val" value="anonymous"/>
</security:authorize>
<security:authorize access="hasRole('ROLE_USER')">
    <c:set var="val" value="user"/>
</security:authorize>
<security:authorize access="hasRole('ROLE_ADMIN')">
    <c:set var="val" value="admin"/>
</security:authorize>


<c:choose>
    <c:when test="${val=='admin'}">
        <div class="login-header box-shadow">
            <div class="container-fluid d-flex justify-content-between align-items-center">
                <div class="brand-logo">
                    <a href="${pageContext.request.contextPath}/trang-chu">
                        <img src="${pageContext.request.contextPath}/resources/vendors/images/logow.png" alt="">
                    </a>
                </div>
                <div class="login-menu">
                    <ul class="menu">
                        <li class="active"><a href="${pageContext.request.contextPath}/trang-chu">Tìm
                            vé</a></li>
                        <li><a href="${pageContext.request.contextPath}/admin/hanh-khach">Trang quản
                            trị</a></li>
                        <li><a href="${pageContext.request.contextPath}/admin/thong-tin-tai-khoan">Thông tin tài
                            khoản</a></li>
                        <li><a href="${pageContext.request.contextPath}/dang-xuat">Đăng xuất</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </c:when>
    <c:when test="${val=='user'}">
        <div class="login-header box-shadow">
            <div class="container-fluid d-flex justify-content-between align-items-center">
                <div class="brand-logo">
                    <a href="${pageContext.request.contextPath}/trang-chu">
                        <img src="${pageContext.request.contextPath}/resources/vendors/images/logow.png" alt="">
                    </a>
                </div>
                <div class="login-menu">
                    <ul class="menu">
                        <li class="active"><a href="${pageContext.request.contextPath}/trang-chu">Tìm vé</a></li>
                        <li><a href="${pageContext.request.contextPath}/phieu-dat">Kiểm tra vé</a></li>
                        <li><a href="${pageContext.request.contextPath}/user/thong-tin-tai-khoan">Thông tin tài khoản</a></li>
                        <li><a href="${pageContext.request.contextPath}/dang-xuat">Đăng xuất</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="login-header box-shadow">
            <div class="container-fluid d-flex justify-content-between align-items-center">
                <div class="brand-logo">
                    <a href="${pageContext.request.contextPath}/trang-chu">
                        <img src="${pageContext.request.contextPath}/resources/vendors/images/logow.png" alt="">
                    </a>
                </div>
                <div class="login-menu">
                    <ul class="menu">
                        <li class="active"><a href="${pageContext.request.contextPath}/trang-chu">Tìm vé</a></li>
                        <li><a href="${pageContext.request.contextPath}/phieu-dat">Kiểm tra vé</a></li>
                        <li><a href="${pageContext.request.contextPath}/dang-nhap">Đăng nhập</a></li>
                        <li><a href="${pageContext.request.contextPath}/dang-ki">Đăng kí</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>