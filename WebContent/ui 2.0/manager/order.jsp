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
  <h1>订单列表</h1>
  <sql:setDataSource var="snapshot" 
     driver="oracle.jdbc.driver.OracleDriver"
     url="jdbc:oracle:thin:127.0.0.1:1521:orcl"
     user="scott"  
     password="tiger"/>
<sql:query dataSource="${snapshot}" var="result">
   select *from orderlist order by orderid desc
</sql:query>



<div class="shopping-cart">
  <div class="column-labels">
  <label class="product-price"></label>
    <label class="product-price1">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp商品</label>
    <label class="product-price1">地址</label>
    <label class="product-price1">订单号</label>
    <label class="product-price">数量</label>
    <label class="product-price">总价</label>
    <label class="product-price">状态</label>
    <label class="product-price">操作</label>
  </div>
  
<c:forEach var="row" items="${result.rows}">
  <div class="product">
     <div class="product-details">
      <div class="product-title"></div>
    </div>
   <div class="product-quantity">${row.username}</div>
    <div class="product-quantity1">${row.goods}</div>
    <div class="product-quantity1">${row.address}</div>
    <div class="product-quantity1">${row.orderid}</div>
    <div class="product-quantity">${row.count}</div>
    <div class="product-quantity">${row.price}</div>
    <div class="product-quantity">${row.state}</div>
    <div class="product-removal">
    <c:if test="${row.state == '已发货'}">
	                     无
	     </c:if>
	     <c:if test="${row.state == '未发货' }">
	     <button class="remove-product" onclick="window.location.href='${pageContext.request.contextPath }/DeliverServlet?orderid=${row.orderid}'">
              发货
      </button>
	    </c:if>
	     <c:if test="${row.state == '请求退货' }">
	      <button class="remove-product" onclick="window.location.href='${pageContext.request.contextPath }/AffirmReturnServlet?orderid=${row.orderid}'">
              确认退货
      </button>
	     </c:if>
    </div>
  </div>


</c:forEach> 
</div>

</body>
</html>