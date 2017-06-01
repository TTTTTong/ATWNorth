<%@ page import="java.io.*,java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>个人信息</title>
      	  <link rel="stylesheet" href="../css/person.css">
          <script src="../../js/jquery.mobile-1.3.2.min.js"></script>
   	    	<script src="../../js/jquery-3.2.0.js"></script>
   			<script src="../js/person.js"></script>
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
    <div class="container">
        <div class="contact" ng-controller="Contacts">
            <h1>Contacts</h1>
            <div class="add-contact">
            <c:forEach var="row" items="${result.rows}">
 <form action="${pageContext.request.contextPath}/ModifyInfoServlet?username=${row.username}" method="post">
          <li>
         用户名：     <label>${row.username}</label>
            </li><br>
            <li>
        注册日期：     <label>${row.regdate}</label>
        </li><br>
            手机号码：    <input type="text" name="phone"  value="${row.phone}">
            收货地址：    <input type="text" name="address" value="${row.address}">
            <button class="btn-add" type="submit">修改</button>
            </form>
             </c:forEach> 	
            </div>
        </div>
    </div>
</body>
 
</html>
