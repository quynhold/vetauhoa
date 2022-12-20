<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
  <!-- Basic Page Info -->
  <meta charset="utf-8">
  <title>Thay đổi Password</title>

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
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendors/styles/style.css">


  <!-- Global site tag (gtag.js) - Google Analytics -->
  <script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
  <script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'UA-119386393-1');
  </script>
</head>

<body>
<div class="login-header box-shadow">
  <div class="container-fluid d-flex justify-content-between align-items-center">
    <div class="brand-logo">
      <a href="${pageContext.request.contextPath}/trang-chu">
        <img src="${pageContext.request.contextPath}/resources/vendors/images/logow.png" alt="">
      </a>
    </div>
    <div class="login-menu">
      <ul>
        <li><a href="${pageContext.request.contextPath}/dang-nhap">Đăng nhập</a></li>
      </ul>
    </div>
  </div>
</div>
<div class="login-wrap d-flex align-items-center flex-wrap justify-content-center">
  <div class="container">
    <div class="row align-items-center">
      <div class="col-md-6">
        <img src="${pageContext.request.contextPath}/resources/vendors/images/register-page-img.png" alt="">
      </div>
      <div class="col-md-6">
        <div class="login-box bg-white box-shadow border-radius-10">
          <div class="login-title">
            <h2 class="text-center text-primary">Thay đổi mật khẩu</h2>
          </div>
          <h6 class="mb-20" style="color: red">${message}</h6>
          <form action="${pageContext.request.contextPath}/${username}/save-password" method="post">

            <div class="form-group row">
              <label class="col-sm-4 col-form-label">Mật khẩu<a
                      style="color: red;">*</a></label>
              <div class="col-sm-8">
                <small id="messagepassword"></small>
                <input type="password" class="form-control" id="password" name="password"
                       placeholder="Password" checked>
                <script>
                  $('#password').blur(function () {
                    if (!$(this).val()) {
                      $('#messagepassword').html('Password không được để trống').css('color', 'red');
                    } else {
                      $('#messagepassword').html('');
                    }
                  });
                </script>
              </div>
            </div>
            <div class="form-group row">
              <label class="col-sm-4 col-form-label">Xác nhận mật khẩu<a
                      style="color: red;">*</a></label>
              <div class="col-sm-8">
                <small id="messagepass"></small>
                <input type="password" class="form-control" id="confirm_password"
                       name="confirm_password" placeholder="Retype password" checked>
                <script>
                  $('#confirm_password').on('keyup', function () {
                    if ($('#password').val() == $('#confirm_password').val()) {
                      $('#messagepass').html('Mật khẩu trùng khớp').css('color', 'green');
                    } else
                      $('#messagepass').html('Mật khẩu không trùng khớp').css('color', 'red');
                  });
                </script>

              </div>
            </div>
            <div class="row align-items-center">
              <div class="col-5">
                <div class="input-group mb-0">
                </div>
              </div>
              <div class="col-2">
                <div class="font-16 weight-600 text-center" data-color="#707373"></div>
              </div>

              <div class="col-5">
                <div class="input-group mb-0">
                  <!--
                      use code for form submit
                      <input class="btn btn-primary btn-lg btn-block" type="submit" value="Submit">
                  -->
                  <button class="btn btn-primary btn-lg btn-block" type="submit">Xác nhận</button>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/vendors/scripts/core.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/script.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/process.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/layout-settings.js"></script>
<script src="${pageContext.request.contextPath}/resources/src/plugins/jquery-steps/jquery.steps.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendors/scripts/steps-setting.js"></script>
</body>

</html>
