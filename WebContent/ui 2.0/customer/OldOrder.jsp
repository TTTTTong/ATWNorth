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
   select *from orderlist where username ='${username}' order by orderid desc
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
	    <td>
		<c:choose>
		<c:when test="${row.state == '未发货'}">
  			<a href="${pageContext.request.contextPath }/ReturnServlet?orderid=${row.orderid}">退货</a>
  		</c:when>
  		<c:otherwise>
  		无
  	    </c:otherwise>
		</c:choose>
		</td>
	    
		</tr>
		</c:forEach> 	
		</table>
  </body>
</html>
