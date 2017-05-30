<%@ page import="java.io.*,java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>个人信息</title>
  </head>
  
  <body style="text-align:center;">
  
  <sql:setDataSource var="snapshot" 
     driver="oracle.jdbc.driver.OracleDriver"
     url="jdbc:oracle:thin:127.0.0.1:1521:orcl"
     user="scott"  
     password="tiger"/>

<sql:query dataSource="${snapshot}" var="result">
   select *from myuser where username ='${username}'
</sql:query>

    <h2>我的信息</h2>
  
    	<c:forEach var="row" items="${result.rows}">
    	<form action="modify.do" method="post">
    	 	<input type="text" placeholder="${row.username}" name="username"><br>
    	 	<input type="text" placeholder="${row.phone}" name="username"><br>
    	 	<input type="text" placeholder="${row.address}" name="username"><br>
    	 	<button type="submit" >修改</button>
    	 	</form>
		</c:forEach> 	
		
  </body>
</html>
