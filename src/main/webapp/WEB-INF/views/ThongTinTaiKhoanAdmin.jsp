<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@page session="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Thông tin cá nhân</title>
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
                <div class="pd-20 card-box mb-30">
                    <div class="profile-photo">
                        <a href="modal" data-toggle="modal" data-target="#modal" class="edit-avatar"><i class="fa fa-pencil"></i></a>
                        <img width="500" height="500" id="avatar" class="rounded mx-auto d-block"  src="data:image/*;base64,${taiKhoan.byteAvatar}"/>
                        <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-body pd-5">
                                        <label>Thay đổi ảnh đại diện</label>
                                    </div>
                                    <div class="modal-footer">
                                        <form action="${pageContext.request.contextPath}/admin/uploadAvatar" method="post" enctype="multipart/form-data">
                                            <div class="img-container">
                                                <input type="file" accept="image/*" name="avatar" onchange="loadFile(event)">
                                                <br>
                                                <p style="color: red">${error}</p>
                                                <img id="output"/>
                                                <script>
                                                    var loadFile = function(event) {
                                                        var output = document.getElementById('output');
                                                        output.src = URL.createObjectURL(event.target.files[0]);
                                                        output.onload = function() {
                                                            URL.revokeObjectURL(output.src) // free memory
                                                        }
                                                    };
                                                </script>
                                            </div>
                                         <input type="submit" value="Lưu" class="btn btn-primary">
                                         <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <h5 class="text-center h5 mb-0">${taiKhoan.username}</h5>
                    <div class="profile-info">
                        <h5 class="mb-20 h5 text-blue">Thông tin người dùng</h5>
                        <ul>
                            <li>
                                <span>Tên nhân viên:</span> ${nhanVien.ho} ${nhanVien.ten}
                            </li>
                            <li>
                                <span>Ngày sinh:</span> ${nhanVien.ngaySinh}
                            </li>
                        </ul>
                    </div>
                    <a href="${pageContext.request.contextPath}/admin/edit-profile" class="btn-shadow btn btn-primary">Chỉnh sửa</a>
                </div>
    </div>
    <div class="pd-20 mb-20 card-box">
        <jsp:include page="Footer.jsp"></jsp:include>
    </div>
</div>
</div>
</body>
</html>
