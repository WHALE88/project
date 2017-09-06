<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div id="tooplate_slider" class="section_content"><span class="frame"></span>
        <div id="carousel">
            <div class="panel">
                
                <div class="details_wrapper">
                    
                    <div class="details">
                    
                        <div class="detail">
                            <h2>Как определить размер обуви?</h2>
                            <p>Ребенку нужна удобная и качественная обувь, которая идеально подходила бы ему по размеру. Именно от этого .... </p>
                            <a href="productdetail.html" title="Read more" class="slider_more">Read more</a>
                        </div><!-- /detail -->
                        
                        <div class="detail">
                            <h2>УСЛОВИЯ И СРОКИ ГАРАНТИИ</h2>
                            <p> Гарантия не предоставляется в следующих случаях: ... </p>
                            <a href="productdetail.html" title="Read more" class="slider_more">Read more</a>
                        </div><!-- /detail -->
                        
                        <div class="detail">
                            <h2>Как выбрать обувь?</h2>
                            <p> В иллюстрированном каталоге вы найдете самые разнообразные модели, которые ... </p>
                            <a href="productdetail.html" title="Read more" class="slider_more">Read more</a>
                        </div><!-- /detail -->
                    
                    </div><!-- /details -->
                    
                </div><!-- /details_wrapper -->
                
          </div><!-- /panel -->
        
            <a href="javascript:void(0);" class="previous" title="Previous" >Previous</a>
            <a href="javascript:void(0);" class="next" title="Next">Next</a>
        
<div id="slider-image-frame">
                <div class="backgrounds">
                    
                    <div class="item item_1">
                        <img src="<c:url value="resources/images/slider/01.jpg" />" alt="image" />
                    </div><!-- /item -->
                    
                    <div class="item item_2">
                         <img src="<c:url value="resources/images/slider/02.jpg" />" alt="image" />
                    </div><!-- /item -->
                    
                    <div class="item item_3">
                         <img src="<c:url value="resources/images/slider/03.jpg" />" alt="image" />>
                    </div><!-- /item -->
                   
                </div><!-- /backgrounds -->
            </div>
        </div>
        <div class="clear"></div>
    </div> <!-- END of slider -->
    
    <div id="tooplate_main"><span class="main_border main_border_t"></span><span class="main_border main_border_b"></span>
    	<div class="product">
        	<h1>New Products</h1>
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
        
        <div class="clear h20"></div>
        <hr />
        <div class="clear h10"></div>
        
        <div class="product">
        	<h1>Popular Products</h1>
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