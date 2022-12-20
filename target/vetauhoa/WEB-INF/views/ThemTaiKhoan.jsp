<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@page session="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Thêm tài khoản</title>
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
<jsp:include page="AdminMenu.jsp"></jsp:include>

<div class="main-container">
    <div class="pd-ltr-20 xs-pd-20-10">
        <div class="min-height-200px">
            <!-- basic table  Start -->
            <div class="pd-20 card-box mb-30">
                <div class="row et-main-content col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
                    <div class="col-md-8 form-group">
                        <h4 class="mb-3">Thêm Tài Khoản</h4>
                        <label style="color: red">${message}</label>
                        <form action="${pageContext.request.contextPath}/admin/tai-khoan/add" class="needs-validation" method="post">
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="username">Username</label>
                                    <input name="username" type="text" class="form-control" id="username" placeholder="" value=""
                                           required="">
                                    <div class="invalid-feedback">
                                        Yêu cầu nhập username.
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="password">Password</label>
                                    <input name="password" type="password" class="form-control" id="password" placeholder="************" value=""
                                           required="">
                                    <div class="invalid-feedback">
                                        Yêu cầu nhập password.
                                    </div>
                                </div>
                            </div>
                            <div class="d-block my-3">
                                <label>Trạng thái</label>
                                <div class="custom-control custom-radio">
                                    <input id="true" name="trangThai" type="radio" class="custom-control-input" value="true"
                                           required="">
                                    <label class="custom-control-label" for="true">Enable</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input id="false" name="trangThai" type="radio" class="custom-control-input" value="false">
                                    <label class="custom-control-label" for="false">Disable</label>
                                </div>
                            </div>
                            <input name="role" value="ADMIN" hidden="true">
                            <hr class="mb-4">
                            <button type="submit" class="btn btn-primary btn-lg btn-block">Thêm</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="pd-20 mb-20 card-box">
            <jsp:include page="Footer.jsp"></jsp:include>
        </div>
    </div>
</div>
</body>
</html>