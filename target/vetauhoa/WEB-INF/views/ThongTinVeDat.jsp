<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Thông tin vé đặt</title>
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
<div class="main-container">
  <div class="pd-ltr-20 xs-pd-20-10">
    <div class="min-height-200px">
      <div class="row">
        <!-- Bootstrap Switchery Start -->
        <div class="col-md-6 col-sm-12 mb-30">
          <div class="pd-20 card-box height-100-p">

          </div>
        </div>
      </div>
    </div>
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
</body>
</html>