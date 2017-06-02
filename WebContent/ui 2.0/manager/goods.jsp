<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <script src="js/jquery.mobile-1.3.2.min.js"></script>
   <script src="js/jquery-3.2.0.js"></script>
   <script src="../js/goods.js"></script>
   <link rel="stylesheet" href="../css/newgoods.css">
   <link rel="stylesheet" href="../css/goodsInfo.css">
   
<title>Insert title here</title>
</head>
<body>
 <sql:setDataSource var="snapshot" 
     driver="oracle.jdbc.driver.OracleDriver"
     url="jdbc:oracle:thin:127.0.0.1:1521:orcl"
     user="scott"  
     password="tiger"/>
	<sql:query dataSource="${snapshot}" var="result">
   		select *from goods order by goodsid asc
	</sql:query>
	 <sql:setDataSource var="snapshot1" 
     driver="oracle.jdbc.driver.OracleDriver"
     url="jdbc:oracle:thin:127.0.0.1:1521:orcl"
     user="scott"  
     password="tiger"/>
	<sql:query dataSource="${snapshot}" var="result1">
   		select *from siteinfo
	</sql:query>
 	
 	
 	
 	<c:forEach var="row" items="${result.rows}">
 	<figure class="snip1584"><img src="${row.image}"/>
 	 <figcaption>
    <h3>${row.goodsname}</h3>
    <h5>￥${row.price}</h5>
 	 </figcaption><a href="${pageContext.request.contextPath }/MngGetGoodsInfoServlet?goodsid=${row.goodsid}"></a>
	</figure>
    </c:forEach>

<footer role="contentinfo" aria-label="Footer">
  <div class="_cont">
    <div class="top">
    <c:forEach var="row" items="${result1.rows}">
      <div class="right">
      ${row.copyright}版权所有
      </div>
      <div class="left">
        <span class="phone">${row.sitephone}</span>
        <a class="mail" href="mailto:email.from@settings.com">${row.emaile}</a>
      </div>
       </c:forEach>
    </div>
    
  </div>
</footer>


</body>
</html>