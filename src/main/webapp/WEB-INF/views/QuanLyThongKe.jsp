<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@page session="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Thống kê số liệu</title>
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
  <div class="xs-pd-20-10 pd-ltr-20">

    <div class="title pb-20">
      <h2 class="h3 mb-0">Số liệu thống kê</h2>
    </div>

    <div class="row pb-10">
      <div class="col-xl-3 col-lg-3 col-md-6 mb-20">
        <div class="card-box height-100-p widget-style3">
          <div class="d-flex flex-wrap">
            <div class="widget-data">
              <div class="weight-700 font-24 text-dark">${tauList.size()}</div>
              <div class="font-14 text-secondary weight-500">Đầu tàu</div>
            </div>
            <div class="widget-icon">
              <div class="icon" data-color="#00eccf"><i class="dw dw-train1"></i></div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-xl-3 col-lg-3 col-md-6 mb-20">
        <div class="card-box height-100-p widget-style3">
          <div class="d-flex flex-wrap">
            <div class="widget-data">
              <div class="weight-700 font-24 text-dark">${toaList.size()}</div>
              <div class="font-14 text-secondary weight-500">Toa tàu</div>
            </div>
            <div class="widget-icon">
              <div class="icon" data-color="#ff5b5b"><span class="fa fa-train"></span></div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-xl-3 col-lg-3 col-md-6 mb-20">
        <div class="card-box height-100-p widget-style3">
          <div class="d-flex flex-wrap">
            <div class="widget-data">
              <div class="weight-700 font-24 text-dark">${choDatList.size()}</div>
              <div class="font-14 text-secondary weight-500">Chỗ ngồi</div>
            </div>
            <div class="widget-icon">
              <div class="icon"><i class="dw dw-user2" aria-hidden="true"></i></div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-xl-3 col-lg-3 col-md-6 mb-20">
        <div class="card-box height-100-p widget-style3">
          <div class="d-flex flex-wrap">
            <div class="widget-data">
              <div class="weight-700 font-24 text-dark">${tongDoanhThu.intValue()} VND</div>
              <div class="font-14 text-secondary weight-500">Tổng doanh thu</div>
            </div>
            <div class="widget-icon">
              <div class="icon" data-color="#09cc06"><i class="icon-copy fa fa-money" aria-hidden="true"></i></div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="row pb-10">
      <div class="col-md-6 mb-20">
        <div class="card-box min-height-200px pd-20 mb-20" data-bgcolor="#455a64">
          <div class="d-flex justify-content-between pb-20 text-white">
            <div class="icon h1 text-white">
              <i class="fa fa-calendar" aria-hidden="true"></i>
              <!-- <i class="icon-copy fa fa-stethoscope" aria-hidden="true"></i> -->
            </div>
<%--            <div class="font-14 text-right">--%>
<%--              <div><i class=""></i>${lichTrinhToDay.size()}</div>--%>
<%--              <div class="font-12">Chuyến đang chạy</div>--%>
<%--            </div>--%>
          </div>
          <div class="d-flex justify-content-between align-items-end">
            <div class="text-white">
              <div class="font-14">Tổng số chuyến</div>
              <div class="font-24 weight-500">${lichTrinhList.size()}</div>
            </div>
            <div class="max-width-150">
              <div id="appointment-chart"></div>
            </div>
          </div>
        </div>
      </div>

      <div class="col-md-6 mb-20">
        <div class="card-box min-height-200px pd-20" data-bgcolor="#265ed7">
          <div class="d-flex justify-content-between pb-20 text-white">
            <div class="icon h1 text-white">
              <i class="fa fa-user" aria-hidden="true"></i>
            </div>
<%--            <div class="font-14 text-right">--%>
<%--              <div><i class="icon-copy ion-arrow-down-c"></i> 3.69%</div>--%>
<%--              <div class="font-12">Since last month</div>--%>
<%--            </div>--%>
          </div>
          <div class="d-flex justify-content-between align-items-end">
            <div class="text-white">
              <div class="font-14">Hành khách</div>
              <div class="font-24 weight-500">${hanhKhachList.size()}</div>
            </div>
            <div class="max-width-150">
              <div id="surgery-chart"></div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="card-box pb-10">
      <div class="h5 pd-20 mb-0">Danh sách lịch trình</div>
      <table class="data-table table nowrap">
        <thead>
        <tr>
          <th class="table-plus">Mã lịch trình</th>
          <th>Ga xuất phát</th>
          <th>Ga cuối</th>
          <th>Thời gian xuất phát</th>
          <th>Số vé đặt</th>
          <th>Doanh thu</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="tklt" items="${thongKeLichTrinhList}">
        <tr>
          <td class="table-plus">
              <div class="txt">
                <div class="weight-600">${tklt.lichTrinh.maLichTrinh}</div>
              </div>
          </td>
          <td>${tklt.lichTrinh.gaByMaGaXuatPhat.tenGa}</td>
          <td>${tklt.lichTrinh.gaByMaGaCuoi.tenGa}</td>
          <td>${tklt.lichTrinh.thoiGianXuatPhat}</td>
          <td>${tklt.lichTrinh.phieuDatsByMaLichTrinh.size()}</td>
          <td>${tklt.doanhThu.intValue()} VND</td>

        </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
  <div class="pd-20 mb-20 card-box">
    <jsp:include page="Footer.jsp"></jsp:include>
  </div>
</div>
</body>
</html>