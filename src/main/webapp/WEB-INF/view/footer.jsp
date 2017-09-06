<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

<html>
	<body>
		<div id="footer">
			<p>Copyright (c) by Oliinyk</p>
		</div>
		
<script type="text/javascript">
/* add to cart */
function getProductJson(element) {

    var product = new Object();
    product.id = $(element).find('.prodId').text();
    product.brand = $(element).find('.prodBrand').text();
	product.model = $(element).find('.prodModel').text();
	product.size = $(element).find('.prodSize').text();
    product.price = $(element).find('.prodPrice').text();
    console.log(JSON.stringify(product));
    return JSON.stringify(product);
}


function sendProductToCart(url, productJson) {
    $.ajax({
        type: "post",
        url: url,
        data: {product: productJson},
        dataType: "json",
        success: function (data) {
            alert("Product added to cart");
         //   $(".totalAmountCart").text(data.totalAmount / 100);
        //    $(".totalItemsCart").text(data.totalItems);
        },
        error: function (jqxhr, status, errorMsg) {
            alert("Error: " + errorMsg);
        },
        complete: function () {
        }
    });
}

$(function () {

    $(".add-to-cart").each(function () {
        $(this).click(
            function (e) {
                e.preventDefault();
                sendProductToCart("addTocart", getProductJson($(this)));
            });
    });

});

</script>	
		
		
	</body>
</html>

