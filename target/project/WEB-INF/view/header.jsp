<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name       : Photoshoot 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20110926
-->

	<html xmlns="http://www.w3.org/1999/xhtml">
		<head>
			<meta name="keywords" content="" />
			<meta name="description" content="" />
			<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>M-STORE</title>
			<link href="<c:url value="resources/css/style.css" />" rel="stylesheet" type="text/css" media="screen" />
			<!--Подключаем библиотеку-->
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		</head>
		
		<body>
			<div id="header" class="container">
				<div id="logo">
					<h1><a href="regFormWithDB/index.jsp">M-STORE</a></h1>
				</div>
				<div id="menu">
					<ul>
						<li class="current_page_item"><a href="index.jsp">Главная</a></li>
						<li><a href="stuff">Товары</a></li>
								<jsp:include page="menu.jsp"/>
						 <li><a href="cart">Корзина</a></li>
						<li>${user}</li>
						<li>${validator}</li>
					</ul>
				</div>
			</div>
			
			<div id="poptrox">
			<!-- start -->
				<ul id="gallery">
				
					<li><a href="<c:url value="resources/images/img01.jpg" />"><img src="<c:url value="resources/images/img01.jpg" />" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
					<li><a href="<c:url value="resources/images/img02.jpg" />"><img src="<c:url value="resources/images/img02.jpg" />" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
					<li><a href="<c:url value="resources/images/img03.jpg" />"><img src="<c:url value="resources/images/img03.jpg" />" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
					<li><a href="<c:url value="resources/images/img04.jpg" />"><img src="<c:url value="resources/images/img04.jpg" />" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
					<li><a href="<c:url value="resources/images/img02.jpg" />"><img src="<c:url value="resources/images/img02.jpg" />" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
					<li><a href="<c:url value="resources/images/img04.jpg" />"><img src="<c:url value="resources/images/img04.jpg" />" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
					<li><a href="<c:url value="resources/images/img01.jpg" />"><img src="<c:url value="resources/images/img01.jpg" />" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
					<li><a href="<c:url value="resources/images/img03.jpg" />"><img src="<c:url value="resources/images/img03.jpg" />" title="Phasellus nec erat sit amet nibh pellentesque congue." alt="" /></a></li>
				</ul>
					<br class="clear" />
			<!--  	<script type="text/javascript">
					$('#gallery').poptrox();
				</script>  -->
				<!-- end -->
			</div>
		</body>
		<!-- end #header -->
	</html>	