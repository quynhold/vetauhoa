<!-- Things to note regarding the servlet API:
HttpServletRequest.setCharacterEncoding() normally only applies to the request body NOT the URI.
Therefore, use POST with forms to return parameters as the parameters are then part of the request body.

http://nagoya.apache.org/bugzilla/show_bug.cgi?id=23929
http://nagoya.apache.org/bugzilla/show_bug.cgi?id=12253
http://java.sun.com/developer/qow/archive/179/index.jsp
http://jakarta.apache.org/tomcat/tomcat-5.0-doc/config/http.html
-->

<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Thử request parameters (Form) với Tiếng Việt Unicode</title>

</head>

<body>

<%
  request.setCharacterEncoding("UTF-8");
  String title = "JSP với Tiếng Việt";
  String name = request.getParameter("name");
%>

request encoding: <%= request.getCharacterEncoding() %><br />
response encoding: <%= response.getCharacterEncoding() %><br /><br />

Title: <%= title %><br />
Tên: <%= name %><br /><br />

<form method="GET" action="lang">
  Tên: <input type="text" name="name" value="" >
  <input type="submit" name="submit" value="GET Submit" />
</form>

<form method="POST" action="lang">
  Tên: <input type="text" name="name" value="" >
  <input type="submit" name="submit" value="POST Submit" />
</form>

</body>
</html>