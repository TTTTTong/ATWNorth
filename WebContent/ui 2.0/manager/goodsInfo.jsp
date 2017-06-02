<%@ page import="java.io.*,java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
  <meta charset="UTF-8">
  <title>Add to cart animation</title>
  <link rel="stylesheet" href="../css/mngGoodsInfo.css">
  <script src="../../js/jquery.mobile-1.3.2.min.js"></script>
   <script src="../../js/jquery-3.2.0.js"></script>
</head>

<body>
<section aria-label="Main content" role="main" class="product-detail">
  <div itemscope itemtype="http://schema.org/Product">
    <meta itemprop="url" content="http://html-koder-test.myshopify.com/products/tommy-hilfiger-t-shirt-new-york">
    <meta itemprop="image" content="//cdn.shopify.com/s/files/1/1047/6452/products/product_grande.png?v=1446769025">
    <div class="shadow">
      <div class="_cont detail-top">
        <div class="cols">
          <div class="left-col">
            <div class="big">
              <span id="big-image" class="img" style="background-image: url(${goodsInfo.image})" data-src="${goodsInfo.image}"></span>
            </div>
          </div>
          <div class="right-col">
            
   			   <form class="login-form" action="${pageContext.request.contextPath}/EditGoodsInfoServlet?goodsid=${goodsInfo.goodsid}" method="post">
   			   商品：<input type="text"  name="goodsname" value="${goodsInfo.goodsname}" required>
   			   价格：<input type="text" name="price" value="${goodsInfo.price}" required>
   			   简介：<input type="text" name="dscb" value="${goodsInfo.dscb}"required>
   		   		 <button type="submit">修改</button>
    		   </form>
    		    <a class="link-1" href="${pageContext.request.contextPath}/DeleteGoodsServlet?goodsid=${goodsInfo.goodsid}" >删除</a>
            <div itemprop="offers" itemscope itemtype="http://schema.org/Offer">
              <meta itemprop="priceCurrency" content="USD">
              <link itemprop="availability" href="http://schema.org/InStock">
               <div class="tabs">
                <div class="promise">
  <dl>
 	<dt class="priceinfo_dt" style="margin-top:15px;">
      	  服务承诺
      </dt>
      	<dd>
        <ul>
          <li class="promise_li">正品保证&nbsp&nbsp&nbsp按时发货&nbsp&nbsp&nbsp极速退款</li>
          <br/>
          <li class="promise_li" >
            七天无理由退换
          </li>
        </ul>
      </dd>
 </dl>
</div>
                
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</section>
<footer role="contentinfo" aria-label="Footer">
  <div class="_cont">
    <div class="top">
      <div class="right">
        
      </div>
      <div class="left">
        <span class="phone">+420 123 456 789</span>
        <a class="mail" href="mailto:email.from@settings.com">email.from@settings.com</a>
      </div>
    </div>
  </div>
</footer>
</body>
</html>

