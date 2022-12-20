<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@page session="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Thêm lich trình</title>
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
    <!-- bootstrap-tagsinput css -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/src/plugins/bootstrap-tagsinput/bootstrap-tagsinput.css">
    <!-- bootstrap-touchspin css -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/src/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.css">
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
                        <h4 class="mb-3">Thêm lịch trình</h4>
                        <form action="${pageContext.request.contextPath}/admin/lich-trinh/add" class="needs-validation" method="post">
                            <datalist id="gaList">
                                <c:forEach var="ga" items="${gaList}">
                                    <option value="${ga.maGa}">${ga.tenGa}</option>
                                </c:forEach>
                            </datalist>
                            <datalist id="tauList">
                                <c:forEach var="tau" items="${tauList}">
                                    <option value="${tau.maTau}">${tau.bienSo}</option>
                                </c:forEach>
                            </datalist>
                            <div class="col-md-6 mb-3">
                                <label>Ga Xuất Phát</label>
                                <input name="maGaXuatPhat" type="text" list="gaList" class="form-control" id="gaXuatPhat">
                                <div class="invalid-feedback">
                                    Yêu cầu chon ga.
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label>Ga Cuối</label>
                                <input name="maGaCuoi" type="text" list="gaList" class="form-control" id="gaCuoi">
                                <div class="invalid-feedback">
                                    Yêu cầu chọn ga.
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label>Giờ xuất phát</label>
                                <div class="input-group">
                                    <input name="gioXuatPhat" type="time" class="form-control" id="gioXuatPhat">
                                    <div class="invalid-feedback" style="width: 100%;">
                                        Yêu cầu nhập giờ đi.
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label>Ngày xuất phát</label>
                                <div class="input-group">
                                    <input name="ngayXuatPhat" type="date" class="form-control" id="ngayXuatPhat">
                                    <div class="invalid-feedback" style="width: 100%;">
                                        Yêu cầu nhập ngày đi.
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label>Tàu<span class="text-muted"></span></label>
                                <input name="maTau" type="text" list="tauList" class="form-control" id="maTau">
                                <div class="invalid-feedback">
                                    Vui lòng chọn tàu.
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label>Giá mở cửa</label>
                                <input name="giaMoCua" type="number" class="form-control" id="giaMoCua"
                                       placeholder="" required="">
                                <div class="invalid-feedback">
                                    Vui lòng nhập giá.
                                </div>
                            </div>
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Thêm</button>
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