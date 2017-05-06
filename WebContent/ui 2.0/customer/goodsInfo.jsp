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
   select *from goods where goodsid ='${goodsInfo}'
</sql:query>
  
    <h2>商品信息</h2>
    <table width="60%" border="1" align="center" style="text-align: center;">
    	<tr>
    		
    		<td>商品</td>
    		<td>销量</td>
    		<td>价格</td>
    		<td>描述</td>
 
    	</tr>
    	<c:forEach var="row" items="${result.rows}">
		<tr>
		<td><c:out value="${row.goodsname}"/></td>
		<td><c:out value="${row.sales}"/></td>
		<td><c:out value="${row.price}"/></td>
		<td><c:out value="${row.dscb}"/></td>
		</tr>
		</c:forEach> 	
		</table>
  </body>
</html>
