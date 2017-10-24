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
 <div id="tooplate_main"><span class="main_border main_border_t"></span><span class="main_border main_border_b"></span>
    
    	<div class="product">
        	<div class="col col_2 product_preview">
	            <a rel="lightbox" href="<c:url value="resources/images/${product.id}.jpg" />"><img src="<c:url value="resources/images/${product.id}.jpg" />" width="260" alt="image" /></a>
                <ul class="nobullet">
					<li><a rel="lightbox" href="<c:url value="resources/images/${product.id}.jpg" />"><img src="<c:url value="resources/images/${product.id}.jpg" />" width="120" alt="image" /></a></li>
                    <li><a rel="lightbox" href="<c:url value="resources/images/${product.id}.jpg" />"><img src="<c:url value="resources/images/${product.id}.jpg" />" width="120" alt="image" /></a></li>
				</ul>
                <div class="clear"></div>
            </div>
            <div class="col col_2 product_detail">
            	<h1><spring:message code="aboutProduct"/></h1>
				<p><spring:message code="article_number"/>: ${product.id}</p>
                <p><spring:message code="size"/>:
	                <c:forEach items="${product.size}" var="prod">
						  ${prod.size}
					</c:forEach>
				</p>
				<p><spring:message code="brand"/>: ${product.brand.brand}</p>
				<p><spring:message code="model"/>: ${product.model}</p>
				<p><spring:message code="gender"/>: ${product.genders.genders}</p>
				<p><spring:message code="upper_material"/>: ${product.upper_material.upper_material}</p>
				<p><spring:message code="liner_material"/>: ${product.liner_material.liner_material}</p>
				<p><spring:message code="type"/>: ${product.categories.categories}</p>
                <div class="clear h20"></div>
              <p class="price">${product.price} грн<span><spring:message code="availability"/>:<strong>В наличии</strong></span></p>
                <div class="clear h20"></div>
              <p class="add_to_cart"><spring:message code="quantity"/><input type="text" value="1" style="width: 20px; text-align: right" /></p>
            		
	              		<select id="selectSize">
							<option value="0"></option>
							<c:forEach items="${product.size}" var="prod">
								<option value="${prod.size}">${prod.size}</option>
							</c:forEach>
						</select> 
						
						<p>SIZE: <span class="prodSize"></span></p>
				
            		<button class="add-to-cart" id="add-to-cart" disabled>
							<spring:message code="add_to_cart"/><i class="cart">
							<div hidden class="hide product">
								<div class="prodId">${product.id}</div>
								<div class="prodBrand">${product.brand.brand}</div>
								<div class="prodModel">${product.model}</div>
								<div class="prodSize"></div>
								<div class="prodSex">${product.genders.genders}</div>
								<div class="prodLin">${product.liner_material.liner_material}</div>
								<div class="prodUpp">${product.upper_material.upper_material}</div>
								<div class="prodCateg">${product.categories.categories}</div>
								<div class="prodPrice">${product.price}</div>
							</div>
						</i>
					</button>
					
			</div>
			
            <div class="">
            </div>
            
            <div class="clear"></div>
		</div>
        
        <hr />
        
        <div class="product">
        	<h2><spring:message code="recommended_products"/></h2>
            <div class="product_box">
            	<div class="img_box"><span></span>
	                <a href="productdetail.html"><img src="images/product/01.jpg" alt="image" /></a>
				</div>
                <h2><a href="productdetail.html">Product One</a></h2>
                <p class="price">$30</p>
            </div>
            <div class="product_box">
               	<div class="img_box"><span></span>
	                <a href="productdetail.html"><img src="images/product/02.jpg" alt="image" /></a>
			  </div>
                <h2><a href="productdetail.html">Product One</a></h2>
                <p class="price">$30</p>
            </div>
            <div class="product_box">
                <div class="img_box"><span></span>
	                <a href="productdetail.html"><img src="images/product/03.jpg" alt="image" /></a>
				</div>
                <h2><a href="productdetail.html">Product One</a></h2>
                <p class="price">$30</p>
            </div>
            <div class="product_box">
                <div class="img_box"><span></span>
	                <a href="productdetail.html"><img src="images/product/04.jpg" alt="image" /></a>
				</div>
                <h2><a href="productdetail.html">Product One</a></h2>
                <p class="price">$30</p>
            </div>
		</div>
        
        
            
        <div class="clear"></div>
    </div> <!-- END of main -->
    
</div> <!-- END of wrapper -->
	
	<jsp:include page="footer.jsp" />
</body>