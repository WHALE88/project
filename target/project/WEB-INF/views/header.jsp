<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Oliinyk Store</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	  src="https://code.jquery.com/jquery-3.2.1.js"
	  integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
	  crossorigin="anonymous">
 </script>
 		
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
	
<script src="<c:url value="resources/js/rfc.js" />"
	type="text/javascript"></script>
<script src="<c:url value="resources/js/size.js" />"
	type="text/javascript"></script>
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
					<a href="#">Oliinyk store</a>
				</div>
				<div id="tooplate_menu" class="ddsmoothmenu">
					<ul>
						<li><a href="homepage"><spring:message code="homepage"/></a></li>
						<li><a href="stuff"><spring:message code="stuff"/></a>
							<ul>
								<li><a href="#"><spring:message code="category_one"/></a></li>
								<li><a href="#"><spring:message code="category_two"/></a></li>
							</ul></li>
						<li><a href="#"><spring:message code="about"/></a></li>
						<li><a href="#"><spring:message code="faqs"/></a></li>
						<li><a href="#" class="last"><spring:message code="contacts"/></a></li>
					</ul>
					<br style="clear: left" />
				</div>
				<!-- end of tooplate_menu -->
			</div>
			<!-- END of header top -->

			<div id="header_bottom">
				<p>
					<a href="cart"><spring:message code="cart"/></a> |
					<c:choose>
						<c:when test="${empty user}">
							<a href="registration"><spring:message code="registration"/></a> |
		            <a href="login"><spring:message code="authorization"/></a> |
		        </c:when>
						<c:otherwise>
							<a href="myaccount"><spring:message code="profile"/></a> |
		            <a href="logout"><spring:message code="logout"/></a> |
		        </c:otherwise>
					</c:choose>
					<span>| <spring:message code="totalItemsCart"/> </span>
					<span class="totalItemsCart"> <c:choose>
						<c:when test="${not empty cart}">[ ${cart.totalItems} ]</c:when>
							<c:otherwise>[ 0 ]</c:otherwise>
						</c:choose>
					</span>
					<span>| <spring:message code="totalAmountCart"/></span>
					<span class="totalAmountCart">
                        <c:choose>
                            <c:when test="${not empty cart}">${cart.totalAmount}</c:when>
                            <c:otherwise>[0]</c:otherwise>
                        </c:choose>
                    </span>
                    <span>| ${user.login}</span>
                     <span>|
                     <a href="?lang=en">en</a>
                     <a href="?lang=ru">ru</a>
                     <a href="?lang=ua">ua</a>
                     </span>
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