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
   select *from goods
</sql:query>

    <h2>网站营收</h2>
    <table width="60%" border="1" align="center" style="text-align: center;">
    	<tr>
    		<td>商品编号</td>
    		<td>商品名</td>
    		<td>销量</td>
    		<td>单价</td>
    		<td>总计</td>
    	</tr>
    	
    	<c:forEach var="row" items="${result.rows}">
		<tr>
		<td><c:out value="${row.goodsid}"/></td>
		<td><c:out value="${row.goodsname}"/></td>
		<td><c:out value="${row.sales}"/></td>
		<td><c:out value="${row.price}"/></td>
		<td><c:out value="${row.price}*${row.sales}"/></td>
     	</tr>
		</c:forEach> 	
		</table>
  </body>
</html>
