<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Store</title>
  <link rel="stylesheet" href="../css/cus-main.css">
  <link rel="icon" href="../../img/icon1.ico" type="image/x-icon"/>
</head>
<body>
	 <nav id="nav-1">
  <a class="link-1" href="goods.jsp" target="123">首页</a>
  <a class="link-1" href="shopcar.jsp" target="123">购物车</a>
  <a class="link-1" href="order.jsp" target="123">订单</a>
  <a class="link-1" href="person.jsp"  target="123">我的信息</a>
  
   <c:if test="${username == null}">
  	<a class="link-3" href="../../login.jsp">请登录</a>
  </c:if>
  <c:if test="${username != null}">
  	<a class="link-3" href="person.jsp" target="123">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp你好&nbsp ${username}</a><a class="link-3" href="/ATWNorth/LogoutServlet">注销</a>
  </c:if>

 </nav>
<div class="right" style="text-align: center;">
   	 <form class="login-form" action="${pageContext.request.contextPath}/SearchServlet" method="post">
   	 <input type="text"  name="sname" placeholder="搜索感兴趣的商品" required>
    <button type="submit">搜索</button>
  </form>
</div>
<div>
    <iframe src="search.jsp" frameborder="0" width=100% height=1000px name="123" scrolling="auto" frameborder="0" ></iframe>
</div>

</body>
</html>