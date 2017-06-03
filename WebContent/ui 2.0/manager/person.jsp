<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单列表</title>
   <script src="../../js/jquery-3.2.1.min.js"></script>
   <script src="../../js/jquery-3.2.0.js"></script>
    <script src="../js/cart.js"></script>

  <link rel="stylesheet" href="../css/cart.css">
</head>
<body>
  <h1>用户信息</h1>
  <sql:setDataSource var="snapshot" 
     driver="oracle.jdbc.driver.OracleDriver"
     url="jdbc:oracle:thin:127.0.0.1:1521:orcl"
     user="scott"  
     password="tiger"/>
<sql:query dataSource="${snapshot}" var="result">
     select *from myuser
</sql:query>



<div class="shopping-cart">
  <div class="column-labels">
  <label class="product-price"></label>
    <label class="product-price1">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp手机号</label>
    <label class="product-price1">收货地址</label>
    <label class="product-price">注册日期</label>
    <label class="product-price1">最后登录日期</label>
    <label class="product-price">操作</label>
  </div>
  
<c:forEach var="row" items="${result.rows}">
  <div class="product">
     <div class="product-details">
      <div class="product-title"></div>
    </div>
   <div class="product-quantity">${row.username}</div>
    <div class="product-quantity1">${row.phone}</div>
    <div class="product-quantity1">${row.address}</div>
    <div class="product-quantity">${row.regdate}</div>
    <div class="product-quantity1">${row.lastlogin}</div>

    <div class="product-removal">
 
	     <button class="remove-product" onclick="window.location.href='${pageContext.request.contextPath}/DeleteUserServlet?username=${row.username}'">
             拉黑
      </button>
	   
    </div>
  </div>


</c:forEach> 
</div>

</body>
</html>