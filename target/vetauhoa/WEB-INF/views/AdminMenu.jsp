<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
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
</head>
<body>
<div class="left-side-bar header-white sidebar-light">
    <div class="brand-logo">
        <a href="index.html">
            <img src="${pageContext.request.contextPath}/resources/vendors/images/logow.png" alt="">
        </a>
        <div class="close-sidebar" data-toggle="left-sidebar-close">
            <i class="ion-close-round"></i>
        </div>
    </div>
    <div class="menu-block customscroll">
        <div class="sidebar-menu">
            <ul id="accordion-menu">
                <li>
                    <a href="${pageContext.request.contextPath}/trang-chu" class="dropdown-toggle no-arrow">
                        <span class="micon dw dw-house-1"></span><span class="mtext">Trang chủ</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/admin/hanh-khach" class="dropdown-toggle no-arrow">
                        <span class="micon dw dw-human-resources"></span><span class="mtext">Quản lý hành khách</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/admin/nhan-vien" class="dropdown-toggle no-arrow">
                        <span class="micon dw dw-id-card"></span><span class="mtext">Quản lý nhân viên</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/admin/tai-khoan" class="dropdown-toggle no-arrow">
                        <span class="micon dw dw-password"></span><span class="mtext">Quản lý tài khoản</span>
                    </a>
                </li>
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/admin/phieu-dat" class="dropdown-toggle no-arrow">
                        <span class="micon dw dw-ticket"></span><span class="mtext">Quản lý phiếu đặt</span>
                    </a>
                </li>
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/admin/lich-trinh" class="dropdown-toggle no-arrow">
                        <span class="micon dw dw-train"></span><span class="mtext">Quản lý lịch trình</span>
                    </a>
                </li>
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/admin/thong-ke" class="dropdown-toggle no-arrow">
                        <span class="micon dw dw-analytics-21"></span><span class="mtext">Thống kê số liệu</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/dang-xuat" class="dropdown-toggle no-arrow">
                        <span class="micon dw dw-logout"></span><span class="mtext">Đăng xuất</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="mobile-menu-overlay"></div>

</body>
</html>
