<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="Free Web tutorials" />
<meta name="keywords" content="HTML,CSS,XML,JavaScript" />
</head>

<body>
	<jsp:include page="header.jsp" />
<div id="tooplate_wrapper">
	<jsp:include page="sidebar_filter.jsp" />
    <div id="stuff_main"><span class="main_border main_border_t"></span><span class="main_border main_border_b"></span>
    	<div class="stuff">
        	<h1><spring:message code="products"/></h1>			
			<c:forEach items="${products}" var="product">
				 <div class="product_box">
            			<div class="img_box"><span></span>
							<a href="productdetail?prodId=${product.id}"><img
								src="<c:url value="resources/images/${product.id}.jpg" />" width="150" alt="image" /></a>
						</div>
							<h2><a href="<c:url value="productdetail?prodId=${product.id}" />">${product.brand.brand} ${product.model}</a></h2>
						<p class="price">${product.price}</p>
				</div>	
			</c:forEach>
        </div>

        <hr />
        
        <div class="pagging">
            <ul>
                <li><a href="#" target="_parent">Previous</a></li>
                <li><a href="#1" target="_parent">1</a></li>
                <li><a href="#2" target="_parent">2</a></li>
                <li><a href="#3" target="_parent">3</a></li>
                <li><a href="#4" target="_parent">4</a></li>
                <li><a href="#5" target="_parent">5</a></li>
                <li><a href="#6" target="_parent">6</a></li>
                <li><a href="#" target="_parent">Next</a></li>
            </ul>
            <div class="clear"></div>
        </div>       
        
            
        <div class="clear"></div>
    </div>

</div>
	
	<jsp:include page="footer.jsp" />
</body>