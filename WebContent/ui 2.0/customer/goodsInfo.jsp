<%@ page import="java.io.*,java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
  <meta charset="UTF-8">
  <title>Add to cart animation</title>
   <link rel="stylesheet" href="../css/goodsInfo.css">
  
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
            <h1 itemprop="name">${goodsInfo.goodsname}</h1>
            <br>
            <br>
            <div itemprop="offers" itemscope itemtype="http://schema.org/Offer">
              <meta itemprop="priceCurrency" content="USD">
              <link itemprop="availability" href="http://schema.org/InStock">
              <div class="price-shipping">
                <div class="price" id="price-preview" quickbeam="price" quickbeam-price="800">
                  	 ￥${goodsInfo.price}
                </div>
                 <ul>
                  <li class="promise_lo">&nbsp&nbsp&nbsp&nbsp&nbsp销量&nbsp${goodsInfo.sales}</li>
                 </ul>
              </div>
              <div class="swatches">
                <div class="swatch clearfix" data-option-index="0">
                  <div class="header">${goodsInfo.dscb}</div>
                
                </div>
                <div class="swatch clearfix" data-option-index="1">
                  <div class="header"></div>
          
                </div>
              </div>
              <!-- <form method="post" enctype="multipart/form-data" id="AddToCartForm"> -->
              <form id="AddToCartForm">
              
              <div class="btn-and-quantity-wrap">
                  <div class="btn-and-quantity">
                 <!--     <div class="spinner">
                    <span class="btn minus" data-id="2721888517"></span>
                      <input type="text" id="updates_2721888517" name="quantity" value="1" class="quantity-selector">
                      <input type="hidden" id="product_id" name="product_id" value="2721888517">
                      <!-- <span class="q">Qty.</span> 
                      <span class="btn plus" data-id="2721888517"></span>
                    </div>
                 -->  
                    <div id="AddToCart" >
                     <!--   <span id="AddToCartText" >加入购物车</span>  -->
                      <a href="${pageContext.request.contextPath }/BuyServlet?goodsid=${goodsInfo.goodsid}">加入购物车</a>
                    </div>
                  </div>
                </div>
              </form>
               <div class="tabs">
                <div class="promise">
  <dl>
  
 <dt class="priceinfo_dt" style="margin-top:15px;">
 <br>
 <br>
 <br>
 <br>
 <br>
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
</body>
</html>

