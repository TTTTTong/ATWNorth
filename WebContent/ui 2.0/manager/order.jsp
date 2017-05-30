<%@page import="com.sun.rowset.internal.Row"%>
<%@ page import="java.io.*,java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <body style="text-align:center;">
  
  <sql:setDataSource var="snapshot" 
     driver="oracle.jdbc.driver.OracleDriver"
     url="jdbc:oracle:thin:127.0.0.1:1521:orcl"
     user="scott"  
     password="tiger"/>

<sql:query dataSource="${snapshot}" var="result">
   select *from orderlist order by username
</sql:query>

    <h2>订单列表</h2>
    <table width="60%" border="1" align="center" style="text-align: center;">
    	<tr>
    		<td>用户</td>
    		<td>手机号</td>
    		<td>商品</td>
    		<td>收货地址</td>
    		<td>订单号</td>
    		<td>数量</td>
    		<td>总价</td>
    		<td>状态</td>
    		<td>操作</td>
 
    	</tr>
    	
    	<c:forEach var="row" items="${result.rows}">
    	
		<tr>
		<td><c:out value="${row.username}"/></td>
		<td><c:out value="${row.phone}"/></td>
		<td><c:out value="${row.goods}"/></td>
		<td><c:out value="${row.address}"/></td>
		<td><c:out value="${row.orderid}"/></td>
		<td><c:out value="${row.count}"/></td>
		<td><c:out value="${row.price}"/></td>
		<td><c:out value="${row.state}"/></td>
		<td><c:if test="${row.state == '已发货'}">
	                     无
	     </c:if>
	     <c:if test="${row.state == '未发货' }">
	       <a href="${pageContext.request.contextPath }/DeliverServlet?orderid=${row.orderid}">发货</a>
	     </c:if>
	     <c:if test="${row.state == '请求退货' }">
	       <a href="${pageContext.request.contextPath }/AffirmReturnServlet?orderid=${row.orderid}">确认退货</a>
	     </c:if>
	     </td>
     	</tr>
		</c:forEach> 	
		</table>
  </body>
</html>
