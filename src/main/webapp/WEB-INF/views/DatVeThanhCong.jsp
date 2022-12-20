<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Vé tàu hỏa - Đặt vé thành công</title>
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
<div class="login-header">
    <jsp:include page="Header.jsp"></jsp:include>
</div>
<div class="mx-auto">
    <div class="pd-ltr-20">
        <div class="min-height-200px">
            <div class="page-header">
                <div class="row">
                    <div class="align-content-lg-center">
                        <h3 style="font-family: 'Times New Roman';color: blue">Đặt vé thành công</h3>
                    </div>
                    <table class="table table-hover">
                        <thead class="et-table-header">
                        <tr>
                            <th style="width: 120px;background-color: royalblue;" class="ng-binding">Mã tàu</th>
                            <th style="width: 120px;background-color: royalblue;" class="ng-binding">Ga Đi</th>
                            <th style="width: 120px;background-color: royalblue;" class="ng-binding">Ga Đến</th>
                            <th style="width: 120px;background-color: royalblue;" class="ng-binding">Mã Toa</th>
                            <th style="width: 120px;background-color: royalblue;" class="ng-binding">Số ghế</th>
                            <th style="background-color: royalblue;" class="ng-binding"> Thời gian xuất phát</th>
                            <th style="background-color: royalblue;width: 120px;" class="ng-binding">Thành tiền (VNĐ)</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${lichTrinh.tauByMaTau.maTau}</td>
                            <td>${lichTrinh.gaByMaGaXuatPhat.tenGa}</td>
                            <td>${phieuDat.gaByMaGaDen.tenGa}</td>
                            <td>${phieuDat.choDatByMaChoDat.toaByMaToa.maToa}</td>
                            <td>${phieuDat.choDatByMaChoDat.soThuTu}</td>
                            <td type="datetime-local" lang="vi"><fmt:formatDate value="${lichTrinh.thoiGianXuatPhat}" pattern="dd/MM/yyyy HH:mm"/></td>
                            <td type="currency">${giaVe}</td>
                        </tr><!-- end ngRepeat: ve in ves.chieuDi -->
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- Default Basic Forms Start -->
            <div class="pd-20 card-box mb-30">
                <div class="clearfix">
                    <div class="pull-left">
                        <h4 class="text-blue h4">Thông tin vé</h4>
                    </div>
                </div>
                <form action="${pageContext.request.contextPath}/trang-chu" method="get">
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Họ</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" name="ho" type="text" value="${hanhKhach.ho}" readonly>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Tên</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" name="ten" type="text" value="${hanhKhach.ten}" readonly >
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Số CMND/Hộ chiếu</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" type="text" name="CCCD" id="registerIdentity" maxlength="20" value="${hanhKhach.cccd}" readonly>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Email</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" type="email" id="email" name="email" value="${hanhKhach.email}" readonly>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Số di động</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" type="tel" id="sdt" name="sdt" maxlength="20" value="${hanhKhach.sdt}" readonly>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Hình thức thanh toán</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" type="tel" id="httt" name="httt" maxlength="20" value="${hoaDon.hinhThucThanhToan}" readonly>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Mã số vé</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" type="tel" id="httt" name="httt" maxlength="20" value="${ve.maVe}" readonly>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Mã hóa đơn</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" type="tel" id="httt" name="httt" maxlength="20" value="${hoaDon.maHoaDon}" readonly>
                        </div>
                    </div>
                    <button type="submit" class="btn mb-20 btn-primary btn-block" id="trang-chu">Trở về trang chủ</button>
                </form>
            </div>
        </div>
    </div>
    <div class="pd-20 mb-20 card-box">
        <jsp:include page="Footer.jsp"></jsp:include>
    </div>
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
<!-- add sweet alert js & css in footer -->
</body>
</html>