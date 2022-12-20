<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@page session="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Quản lý phiếu đặt</title>
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
        <div class="clearfix mb-20">
          <div class="pull-left">
            <h4 class="text-blue h4">Danh sách phiếu đặt</h4>
          </div>
        </div>
        <table class="table table-hover">
<%--          <div class="container ">--%>
<%--            <form class="d-inline-block" action="${pageContext.request.contextPath}/admin/hanh-khach/add">--%>
<%--              <button type="submit" class="btn-shadow btn btn-primary">Thêm</button>--%>
<%--            </form>--%>
<%--            <form class="d-inline-block" action="${pageContext.request.contextPath}/error">--%>
<%--              <input type="text" class="input-sm">--%>
<%--              <button type="submit" class="btn-shadow btn btn-primary right">Tìm kiếm</button>--%>
<%--            </form>--%>
<%--          </div>--%>
          <thead>
          <tr>
            <th class="text-center"  scope="col">Mã phiếu đặt</th>
            <th class="text-center" scope="col">Ga đi</th>
            <th class="text-center"  scope="col">Ga đến</th>
            <th class="text-center"  scope="col">Thời gian đặt</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="phieuDat" items="${phieuDatList}">
            <tr class="table-active align-middle text-truncate mb-0 table table-borderless table-hover">
              <td class="text-center" scope="col">${phieuDat.maPhieuDat}</td>
              <td class="text-center" scope="col">${phieuDat.lichTrinhByMaLichTrinh.gaByMaGaXuatPhat.tenGa}</td>
              <td class="text-center" scope="col">${phieuDat.gaByMaGaDen.tenGa}</td>
              <td class="text-center" scope="col">${phieuDat.thoiGianDat}</td>
            </tr
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <div class="pd-20 mb-20 card-box">
    <jsp:include page="Footer.jsp"></jsp:include>
  </div>
</div>

</body>
</html>
