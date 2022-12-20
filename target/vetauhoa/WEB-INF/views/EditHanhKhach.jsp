<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@page session="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Chỉnh sửa thông tin hành khách</title>
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
<%--<div class="pre-loader">--%>
<%--  <div class="pre-loader-box">--%>
<%--    <div class="loader-logo"><img src="${pageContext.request.contextPath}/resources/vendors/images/logow.png" style="height: 50px;width:auto;" alt=""></div>--%>
<%--    <div class='loader-progress' id="progress_div">--%>
<%--      <div class='bar' id='bar1'></div>--%>
<%--    </div>--%>
<%--    <div class='percent' id='percent30'>0%</div>--%>
<%--    <div class="loading-text">--%>
<%--      Loading...--%>
<%--    </div>--%>
<%--  </div>--%>
<%--</div>--%>
<div class="main-container">
  <div class="pd-ltr-20 xs-pd-20-10">
    <div class="min-height-200px">
      <!-- basic table  Start -->
      <div class="pd-20 card-box mb-30">
        <div class="row et-main-content col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          <div class="col-md-8 form-group">
            <h4 class="mb-3">Chỉnh sủa thông tin hành khách</h4>
            <form action="${pageContext.request.contextPath}/admin/hanh-khach" method="post" class="needs-validation">
              <div class="row">
                <div class="col-md-6 mb-3">
                  <input name="maHanhKhach" type="text" class="form-control" id="maHanhKhach" placeholder="" value="${hanhKhach.maHanhKhach}"
                         required="" hidden="true" >
                  <label for="ho">Họ</label>
                  <input name="ho" type="text" class="form-control" id="ho" placeholder="" value="${hanhKhach.ho}"
                         required="">
                  <div class="invalid-feedback">
                    Yêu cầu nhập họ.
                  </div>
                </div>
                <div class="col-md-6 mb-3">
                  <label for="ten">Tên</label>
                  <input name="ten" type="text" class="form-control" id="ten" placeholder="" value="${hanhKhach.ten}"
                         required="">
                  <div class="invalid-feedback">
                    Yêu cầu nhập tên.
                  </div>
                </div>
              </div>
              <div class="d-block my-3">
                <label>Giới tính</label>
                <div class="custom-control custom-radio">
                  <input id="nam" name="gioiTinh" type="radio" class="custom-control-input" checked=""
                         required="" value="Nam">
                  <label class="custom-control-label" for="nam">Nam</label>
                </div>
                <div class="custom-control custom-radio">
                  <input id="nu" name="gioiTinh" type="radio" class="custom-control-input"
                         required="" value="Nữ">
                  <label class="custom-control-label" for="nu">Nữ</label>
                </div>
                <div class="custom-control custom-radio">
                  <input id="khac" name="gioiTinh" type="radio" class="custom-control-input"
                         required="">
                  <label class="custom-control-label" for="khac">Khác</label>
                </div>
              </div>
              <div class="mb-3">
                <label>Ngày sinh</label>
                <div class="input-group">
                  <input name="ngaySinh" type="date" class="form-control" id="cccd"
                         placeholder="01/01/2021" required="" value="${hanhKhach.ngaySinh}">
                  <div class="invalid-feedback" style="width: 100%;">
                    Yêu cầu nhập ngày sinh.
                  </div>
                </div>
              </div>
              <div class="mb-3">
                <label for="cccd">Chứng minh nhân dân / Căn cước công dân</label></label>
                <div class="input-group">
                  <input name="cccd" type="text" class="form-control" id="cccd" placeholder="CCCD" value="${hanhKhach.cccd}"
                         required="">
                  <div class="invalid-feedback" style="width: 100%;">
                    Yêu cầu nhập CCCD.
                  </div>
                </div>
              </div>

              <div class="mb-3">
                <label for="email">Email <span class="text-muted">(Optional)</span></label>
                <input name="email" type="email" class="form-control" id="email" value="${hanhKhach.email}"
                       placeholder="you@example.com">
                <div class="invalid-feedback">
                  Vui lòng nhập email.
                </div>
              </div>

              <div class="mb-3">
                <label for="sdt">Số điện thoại</label>
                <input name="sdt" type="text" class="form-control" id="sdt" placeholder="" required="" value="${hanhKhach.sdt}">
                <div class="invalid-feedback">
                  Please enter your shipping address.
                </div>
              </div>

              <div class="mb-3">
                <label for="diaChi">Địa chỉ<span class="text-muted">(Optional)</span></label>
                <input name="diaChi" type="text" class="form-control" id="diaChi" value="${hanhKhach.diaChi}"
                       placeholder="Apartment or suite">
              </div>

              <hr class="mb-4">
              <button type="submit" class="btn btn-primary btn-lg btn-block">Lưu</button>
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