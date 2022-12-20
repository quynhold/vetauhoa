<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="vi">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Error</title>

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
<div class="error-page d-flex align-items-center flex-wrap justify-content-center pd-20">
    <div class="pd-10">
        <div class="error-page-wrap text-center">
            <h1>404</h1>
            <h3>Không tìm thấy trang</h3>
            <p>Không thể truy cập địa chỉ này</p>
            <div class="pt-20 mx-auto max-width-200">
                <a href="${pageContext.request.contextPath}/trang-chu" class="btn btn-primary btn-block btn-lg">Quay trở lại</a>
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