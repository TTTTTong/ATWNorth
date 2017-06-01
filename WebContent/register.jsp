<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script src="js/jquery.mobile-1.3.2.min.js"></script>
   <script src="js/jquery-3.2.0.js"></script>
   <script src="ui 2.0/js/login.js"></script>
<link rel="stylesheet" href="ui 2.0/css/login.css">
</head>
<body>
<div class="login-page">
  <div class="form">
<form class="register-form" action="register.do" method="post">
    <input type="text" placeholder="username or email" name="username" required>
	<input type="password" placeholder="password" name="password1" required>
	<input type="password" placeholder="confirm password" name="password2" required>
	<input type="tel" placeholder="phonenumber" name="phonenumber" required>
	<input type="text" placeholder="address" name="address" required>
    <button type="submit" >Create</button>
    <p class="message">Already registered? <a href="login.jsp">Sign In</a></p>
    </form>
    </div>
  </div>
</body>
</html>