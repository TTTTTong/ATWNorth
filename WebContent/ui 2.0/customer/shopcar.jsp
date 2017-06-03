<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
   <script src="../../js/jquery-3.2.1.min.js"></script>
   <script src="../../js/jquery-3.2.0.js"></script>
    <script src="../js/cart.js"></script>


  <link rel="stylesheet" href="../css/cart.css">
</head>
<body>
  <h1>我的购物车</h1>
  <sql:setDataSource var="snapshot" 
     driver="oracle.jdbc.driver.OracleDriver"
     url="jdbc:oracle:thin:127.0.0.1:1521:orcl"
     user="scott"  
     password="tiger"/>
<sql:query dataSource="${snapshot}" var="result">
   select *from shopcar where username ='${username}' order by orderid desc
</sql:query>



<div class="shopping-cart">
  <div class="column-labels">
    <label class="product-details">商品</label>
    <label class="product-price">总价</label>
    <label class="product-quantity">数量</label>
    <label class="product-price">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp操作</label>

  </div>
<c:forEach var="row" items="${result.rows}">
  <div class="product">
    
    <div class="product-details">
      <div class="product-title">${row.goods}</div>
    </div>
    <div class="product-price">${row.price}</div>
    <div class="product-price">${row.count}</div>
    <div class="product-removal">
      <button class="remove-product" onclick="window.location.href='${pageContext.request.contextPath }/SubmitOrderServlet?orderid=${row.orderid}'">
        结算
      </button>
       <button class="remove-product" onclick="window.location.href='${pageContext.request.contextPath }/DeleteOrderServlet?orderid=${row.orderid}'">
        删除
      </button>
    </div>
  </div>


</c:forEach> 
</div>

</body>
</html>