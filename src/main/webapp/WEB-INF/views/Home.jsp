<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Trang chủ - Tìm kiếm</title>
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
    <!-- bootstrap-tagsinput css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/src/plugins/bootstrap-tagsinput/bootstrap-tagsinput.css">
    <!-- bootstrap-touchspin css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/src/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendors/styles/style.css">

    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
    <script src="${pageContext.request.contextPath}/resources/vendors/scripts/core.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendors/scripts/script.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendors/scripts/process.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendors/scripts/layout-settings.js"></script>
    <!-- switchery js -->
    <script src="${pageContext.request.contextPath}/resources/src/plugins/switchery/switchery.min.js"></script>
    <!-- bootstrap-tagsinput js -->
    <script src="${pageContext.request.contextPath}/resources/src/plugins/bootstrap-tagsinput/bootstrap-tagsinput.js"></script>
    <!-- bootstrap-touchspin js -->
    <script src="${pageContext.request.contextPath}/resources/src/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendors/scripts/advanced-components.js"></script>
    <script>
        window.dataLayer = window.dataLayer || [];

        function gtag() {
            dataLayer.push(arguments);
        }
        gtag('js', new Date());

        gtag('config', 'UA-119386393-1');
    </script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="login-wrap d-flex align-items-center flex-wrap justify-content-center">
            <div class="col-md-6 col-lg-7 center-block">
                <div class="login-box bg-white box-shadow border-radius-10">
                    <form action="tim-kiem" method="post">
                        <datalist id="gaList">
                            <c:forEach var="ga" items="${gaList}">
                                <option value="${ga.tenGa}">${ga.tenGa}</option>
                            </c:forEach>
                        </datalist>
                        <div class="clearfix mb-30">
                            <div class="pull-left">
                                <h4 class="text-blue h4">Tìm kiếm chuyến tàu</h4>
                            </div>
                        </div>
                        <p>${message}</p>
                        <div class="form-group">
                            <h4>Ga đi</h4>
                            <div class="input-group input-cal-picker">
                                <input list="gaList" name="tenGaDi">
                            </div>
                        </div>
                        <div class="form-group">
                            <h4>Ga đến</h4>
                            <div class="input-group input-cal-picker">
                                <input list="gaList" name="tenGaDen">
                            </div>
                        </div>
                        <div class="form-group">
                            <h4>Ngày đi</h4>
                            <div class="input-group input-cal-picker">
                                <input type="date" name="ngayDi">
                            </div>
                        </div>
                        <button>Tìm kiếm</button>
                    </form>
                </div>
            </div>
            <div class="col-md-6 col-lg-5">
                <img src="${pageContext.request.contextPath}/resources/vendors/images/railway-6.png" alt="">
            </div>
    <jsp:include page="Footer.jsp"></jsp:include>
</div>

<%--script--%>
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/core.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/script.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/process.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/layout-settings.js"></script>
<!-- switchery js -->
<script src="${pageContext.request.contextPath}/resources/src/plugins/switchery/switchery.min.js"></script>
<!-- bootstrap-tagsinput js -->
<script src="${pageContext.request.contextPath}/resources/src/plugins/bootstrap-tagsinput/bootstrap-tagsinput.js"></script>
<!-- bootstrap-touchspin js -->
<script src="${pageContext.request.contextPath}/resources/src/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
</body>
</html>