<%@ page import="java.io.*,java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
  <meta charset="UTF-8">
  <title>Add to cart animation</title>
  <link rel="stylesheet" href="../css/mngGoodsInfo.css">
  <script src="../../js/jquery-3.2.1.min.js"></script>
   <script src="../../js/jquery-3.2.0.js"></script>
</head>

<body>
<section aria-label="Main content" role="main" class="product-detail">
  <div itemscope >
   
    <div class="shadow">
      <div class="_cont detail-top">
        <div class="cols">
          <img name="look" alt="" src="" width="500" height="400" float="left">
          <div class="right-col">
   			 <form class="login-form" action="${pageContext.request.contextPath}/AddGoodsServlet" method="post" enctype="multipart/form-data"> 
   			   商品：<input type="text"  name="goodsname"  required>
   			   价格：<input type="text" name="price"  required>
   			   简介：<input type="text" name="dscb" required>
                                 图片： <input type="file" id="upload" name="image" />
   		   		 <button type="submit">添加</button>
    		   </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
<script type="text/javascript">
	$("img[name='look']").hide();
	$("input[name='image']").change(function () {
		var reader=new FileReader();
		var file=document.getElementById("upload").files[0];
		reader.readAsDataURL(file);
		reader.onload=function(){
				look.src=this.result;
			}
		$("img[name='look']").show(500);
	});
</script>
<script language="javascript">		
function formSubmit(){
	var action="${pageContext.request.contextPath}/AddGoodsServlet";		
	action+="?goodsname="+document.upload.goodsname.value;
	document.upload.action=action;		
	document.upload.submit();
}
</script>

</html>

