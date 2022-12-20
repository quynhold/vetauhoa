<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title></title>
  <base href="${pageContext.servletContext.contextPath}/">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/vetauhoa.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js"></script>
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
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="mx-auto">
  <div class="pd-ltr-20 xs-pd-20-10">
    <div class="pd-20 card-box">
    <h3>Giá vé : ${giaVe}</h3>
    </div>
    <div class="min-height-200px">
      <div class="row">
        <div class="pd-20 card-box mb-30">
          <div class="row et-car-floor">
            <div class="et-car-nm-full-block">
              <div class="et-full-width" style="margin-left: 30px;">
                <c:forEach var="choDat" items="${trangThaiChoDatList}">
                  <form action="${maLichTrinh}/${maToa}/${choDat.choDatByMaChoDat.maChoDat}/dat-ve">
                    <div class="et-car-nm-64-sit" direct="direct">
                      <div class="et-car-seat-left et-seat-h-35" analytics-on="click" analytics-event="SelectTicket"
                           ng-click="buyTicket(seat, direct)" ng-show="seat.Status">
                        <div class="et-col-16 et-sit-side" style="text-align: center; size:20px">${choDat.choDatByMaChoDat.soThuTu}</div>
                        <div class="et-col-84 et-sit-sur-outer">
                          <div class="et-sit-sur text-center et-sit-avaiable">
<%--                            <div popover-title="Chỗ trống" popover-trigger="mouseenter"--%>
<%--                                 popover-placement="top" class="et-sit-no ng-scope">--%>
                              <c:choose>
                                <c:when test="${choDat.trangThai=='C'}">
                                  <span>Trống</span>
                                  <button type="submit" class="btn-shadow btn btn-primary float-end height-auto">Đặt</button>
                                </c:when>
                                <c:otherwise>
                                  <span>Đã đặt</span>
                                </c:otherwise>
                              </c:choose>
<%--                            </div>--%>
                          </div>
                        </div>
                      </div>
                    </div>
                  </form>
                </c:forEach>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>