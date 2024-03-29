﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help">
		<c:if test="${user==null}">
			<a href="login.jsp">登录</a>
			<a href="register.jsp">注册</a>
		</c:if>
		<c:if test="${user!=null}">
			欢迎您，${user}
		</c:if>
		<a href="#" class="shopping">购物车</a>
		<a href="guestbook.jsp">留言</a>
		<c:if test="${user!=null}">
			<a href="/loginOut.do">退出</a>
		</c:if>
	</div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="#">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; <a href="product-list.jsp">图书音像</a> &gt; 图书
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<c:forEach var ="ca" items="${categoryList}">
					<c:if test="${ca.epcParentId==0}">
						<dt>${ca.epcName}</dt>
					</c:if>
					<c:forEach var="pca" items="${categoryList}">
						<c:if test="${pca.epcParentId==ca.epcId}">
							<dd><a href="/productList.do?epc_id=${pca.epcId}">${pca.epcName}</a></dd>
						</c:if>
					</c:forEach>

				</c:forEach>
			</dl>
		</div>
	</div>
	<div id="product" class="main">

		<h1>${proCon.epName}</h1>
		<div class="infos">
			<div class="thumb"><img src="images/product/${proCon.epId}.jpg" /></div>
			<div class="buy">
				<p>商城价：<span class="price">￥${proCon.epPrice}</span></p>
				<c:if test="${proCon.epStock!=0}">
				<p>库　存：有货</p>
				</c:if>
				<c:if test="${proCon.epStock==0}">
				<p>库　存：没有货</p>
				</c:if>
				<div class="button"><input type="button" name="button" value="" onclick="goBuy(1)" /><a href="/shop.do?id=2">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品描述</strong></h2>
			<div class="text">
				${proCon.epDescription}<br />
					${proCon.epDescription}<br />
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
