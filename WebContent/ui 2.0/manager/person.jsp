
    <%@page import="com.sun.rowset.internal.Row"%>
<%@ page import="java.io.*,java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center;">
  
  <sql:setDataSource var="snapshot" 
     driver="oracle.jdbc.driver.OracleDriver"
     url="jdbc:oracle:thin:127.0.0.1:1521:orcl"
     user="scott"  
     password="tiger"/>

<sql:query dataSource="${snapshot}" var="result">
   select *from myuser
</sql:query>

    <h2>订单列表</h2>
    <table width="60%" border="1" align="center" style="text-align: center;">
    	<tr>
    		<td>用户</td>
    		<td>手机号</td>
    		<td>收货地址</td>
    		<td>注册日期</td>
    		<td>最后登录日期</td>
   
 
    	</tr>
    	
    	<c:forEach var="row" items="${result.rows}">
    	
		<tr>
		<td><c:out value="${row.username}"/></td>
		<td><c:out value="${row.phone}"/></td>
		<td><c:out value="${row.address}"/></td>
		<td><c:out value="${row.regdate}"/></td>
		<td><c:out value="${row.lastlogin}"/></td>

     	</tr>
		</c:forEach> 	
		</table>
  </body>
</html>