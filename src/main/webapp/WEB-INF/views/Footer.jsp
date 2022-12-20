<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <!-- Google Font -->
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
  <!-- CSS -->

  <script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
  <script>
    window.dataLayer = window.dataLayer || [];

    function gtag() {
      dataLayer.push(arguments);
    }
    gtag('js', new Date());

    gtag('config', 'UA-119386393-1');
  </script>
  <script src="${pageContext.request.contextPath}/resources/vendors/scripts/core.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendors/scripts/script.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendors/scripts/process.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendors/scripts/layout-settings.js"></script>
  <style>
    .footer {
      left: 0;
      bottom: 0;
      width: 100%;
      background-color: whitesmoke;
      color: rgb(0,155,255);
      text-align: center;
    }
  </style>
</head>
<body>
<div class="footer">
  <div class="container">
    <div class="row">
      <div class="col-sm-4 footer-container">
        <div class="brand-logo">
          <a href="${pageContext.request.contextPath}/trang-chu">
            <img src="${pageContext.request.contextPath}/resources/vendors/images/logow.png" alt="">
          </a>
        </div>
        <div class="about-brand">
        </div>
      </div>
      <div class="col-sm-4 footer-container">
        <div class="contact">
          <h4> <i class="	fa fa-address-card-o"></i>LIÊN HỆ</h4>
          <div class="contact-info">
            <p><strong><i class="fa fa-mail-forward"></i> Email:</strong>vetauhoa.cskh@gmail.com</p>
          </div>
        </div>
      </div>
      <div class="col-sm-4 footer-container">
        <div class="fb-page">
          <p><strong><i class="fa fa-user-circle-o"></i> Mã số sv:</strong>N18DCAT027</p>
          <p><strong><i class="fa fa-user-circle-o"></i> Mã số sv:</strong>N18DCAT065</p>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>