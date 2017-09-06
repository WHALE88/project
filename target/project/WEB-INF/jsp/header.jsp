<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Clothing Template, free HTML CSS template</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<!--
Template 2062 Clothing 
http://www.tooplate.com/view/2062-clothing
-->
<link href="<c:url value="resources/css/tooplate_style.css" />"
	rel="stylesheet" type="text/css" media="screen" />
<link href="<c:url value="resources/css/ddsmoothmenu.css" />"
	rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="<c:url value="resources/js/jquery.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="resources/js/ddsmoothmenu.js"/>">
	/***********************************************
	 * Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
	 * This notice MUST stay intact for legal use
	 * Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
	 ***********************************************/
</script>

<!--Подключаем библиотеку jQuery-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script type="text/javascript">
	ddsmoothmenu.init({
		mainmenuid : "tooplate_menu", //menu DIV id
		orientation : 'h', //Horizontal or vertical menu: Set to "h" or "v"
		classname : 'ddsmoothmenu', //class added to menu's outer DIV
		//customtheme: ["#1c5a80", "#18374a"],
		contentsource : "markup" //"markup" or ["container_id", "path_to_menu_file"]
	})
</script>

<link href="<c:url value="resources/css/jquery.dualSlider.0.2.css" />"
	rel="stylesheet" type="text/css" media="all" />

<script src="<c:url value="resources/js/cart.js" />"
	type="text/javascript"></script>
<script src="<c:url value="resources/js/jquery-1.3.2.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="resources/js/jquery.easing.1.3.js" />"
	type="text/javascript"></script>
<script src="<c:url value="resources/js/jquery.timers-1.2.js" />"
	type="text/javascript"></script>
<script src="<c:url value="resources/js/dualSlider.0.3.min.js" />"
	type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#carousel").dualSlider({
			auto : false,
			autoDelay : 6000,
			easingCarousel : "swing",
			easingDetails : "easeOutBack",
			durationCarousel : 1000,
			durationDetails : 600
		});

	});
</script>

<link href="<c:url value="resources/css/slimbox2.css" />"
	rel="stylesheet" type="text/css" media="screen" />
<script type="text/JavaScript"
	src="<c:url value="resources/js/slimbox2.js" />"></script>

</head>
<body>
	<div id="tooplate_wrapper">
		<div id="tooplate_header">
			<div id="header_top">
				<div id="site_title">
					<a href="#">Clothing Template</a>
				</div>
				<div id="tooplate_menu" class="ddsmoothmenu">
					<ul>
						<li><a href="homepage">Главная</a></li>
						<li><a href="stuff">Товары</a>
							<ul>
								<li><a href="#">Category One</a></li>
								<li><a href="#">Category Two</a></li>
								<li><a href="#">Category Three</a></li>
								<li><a href="#">Category Four</a></li>
								<li><a href="#">Category Five</a></li>
							</ul></li>
						<li><a href="about.html">About</a></li>
						<li><a href="faqs.html">FAQs</a></li>
						<li><a href="contact.html" class="last">Contact</a></li>
					</ul>
					<br style="clear: left" />
				</div>
				<!-- end of tooplate_menu -->
			</div>
			<!-- END of header top -->

			<div id="header_bottom">
				<p>
					<a href="cart">Корзина</a> |
					<c:choose>
						<c:when test="${empty user}">
							<a href="registration">Регистрация</a> |
		            <a href="login">Авторизация</a> |
		        </c:when>
						<c:otherwise>
							<a href="myaccount">Профиль</a> |
		            <a href="logout">Выход</a> |
		        </c:otherwise>
					</c:choose>
					<span>| Товаров в корзине </span>
					<span class="totalItemsCart"> <c:choose>
						<c:when test="${not empty cart}">[ ${cart.totalItems} ]</c:when>
							<c:otherwise>[ 0 ]</c:otherwise>
						</c:choose>
					</span>
					<span>| На  сумму</span>
					<span class="totalAmountCart">
                        <c:choose>
                            <c:when test="${not empty cart}">${cart.totalAmount}</c:when>
                            <c:otherwise>[0]</c:otherwise>
                        </c:choose>
                    </span>
                    <span>| ${user.login}</span>
				</p>

				<div id="tooplate_search">
					<form action="#" method="get">
						<input type="text" value=" " name="keyword" id="keyword"
							title="keyword" onfocus="clearText(this)"
							onblur="clearText(this)" class="txt_field" /> <input
							type="submit" name="Search" value=" " alt="Search"
							id="searchbutton" title="Search" class="sub_btn" />
					</form>
				</div>
			</div>
			<!-- END of header bottom -->
		</div>
		<!-- END of header -->
	</div>
</body>
</html>