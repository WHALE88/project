<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div id="tooplate_main">
			<span class="main_border main_border_t"></span><span
				class="main_border main_border_b"></span>

			<div id="content">
				<h1>Tовары в корзине</h1>

				<table width="580px" cols="0" cellspacing="0" cellpadding="5">
					<tr bgcolor="#ddd">
						<th width="220" align="left">Рисунок</th>
						<th width="100" align="left">Модель</th>
						<th width="80" align="center">Размер</th>
						<th width="100" align="center">Количество</th>
						<th width="60" align="right">Цена</th>
						<th width="60" align="right">Сума</th>
						<th width="90"></th>

					</tr>

					<c:if test="${not empty cart}">
						<c:forEach items="${cart.products}" var="product">
							<tr>
								<td><img
									src="<c:url value="resources/images/${product.product_id}.jpg" />"
									width='50' alt="image" /></td>
								<td>${product.product_brand} ${product.product_model}</td>
								<td align="center">${product.product_size}</td>
								<td align="center"><input type="text"
									value="${product.product_quantity}"
									style="width: 20px; text-align: right" /></td>
								<td align="right">${product.product_price}</td>
								<td align="right">${product.product_price * product.product_quantity}</td>
								<td align="center">
									<button type="button" name="remove">
										<img src="resources/images/remove.png" alt="remove" />
									</button> <br />Remove
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<tr>
						<td colspan="3"
							style="background: url(resources/images/tooplate_h2.png) repeat"
							align="right" height="30px">Обновили корзину? Жми <a
							href="cart"><strong>Update</strong></a>&nbsp;&nbsp;
						</td>
						<td align="right"
							style="background: url(resources/images/tooplate_h2.png) repeat; font-weight: bold">
							Total</td>
						<td align="right"
							style="background: url(resources/images/tooplate_h2.png) repeat; font-weight: bold">${cart.totalAmount}
						</td>
						<td
							style="background: url(images/tooplate_h2.png) repeat; font-weight: bold">
						</td>
					</tr>
				</table>
					 <p class="right"><a href="confirm" class="button">Подтверждение</a></p>

			</div>

			<div id="sidebar">
				<div class="sidebar_section sidebar_section_bg">
					<h3>Popular Products</h3>
					<ul class="sidebar_link_list popular_products">
						<li><img src="images/product/01_xs.jpg" align="image" /> <span
							class="title"><a href="#">Donec tincidunt hendrerit</a></span> <span
							class="price">$28</span> <span class="clear"></span></li>
						<li><img src="images/product/02_xs.jpg" align="image" /> <span
							class="title"><a href="#">Ut ut felis ut nulla</a></span> <span
							class="price">$28</span> <span class="clear"></span></li>
						<li><img src="images/product/03_xs.jpg" align="image" /> <span
							class="title"><a href="#">Curabitur viverra</a></span> <span
							class="price">$28</span> <span class="clear"></span></li>
						<li><img src="images/product/04_xs.jpg" align="image" /> <span
							class="title"><a href="#">Nulla pulvinar felis</a></span> <span
							class="price">$28</span> <span class="clear"></span></li>
						<li><img src="images/product/05_xs.jpg" align="image" /> <span><a
								href="#">Pellentesque luctus </a></span> <span class="price">$28</span>
							<span class="clear"></span></li>
					</ul>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<!-- END of main -->

	</div>
	<!-- END of wrapper -->

	<jsp:include page="footer.jsp" />
</body>