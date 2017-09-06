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

	<div id="nav"></div>

	<div id="sidebar1"></div>

	<div id="page">
		<div id="bg1">
			<div id="bg2">
				<div id="bg3">
					<div id="content">
						<!-- 	<form action="/stuff" method='get'>   -->
						<c:forEach items="${products}" var="product">
							<table border='1'>
								<tr>
									<td width='200' height='50' align='center'>Art.
										${product.id}</td>
									<td width='200' height='50' align='center'>
										${product.brand.brand} ${product.model}</td>
								</tr>
								<tr>
									<td width='200' height='50' align='center'><img
										src="<c:url value="resources/images/${product.id}.jpg" />"
										width='200' /></td>
									<td width='200' height='50' align='center'>
										Размер:${product.size.size} Пол: ${product.genders.genders}
										Материал подкладки : ${product.liner_material.liner_material}
										Материал вверха:${product.upper_material.upper_material}
										Категория: ${product.categories.categories}</td>
								</tr>
								<tr>
									<td width='200' height='50' align='center'>Price:
										${product.price}</td>
									<td width='200' height='50' align='center'>
										<!--<input type='submit' value='Buy' /> 
										<input type='button' onclick="sendProductToCart()" value='ДОБАВИТЬ В КОРЗИНУ' /> -->
										<c:if test="${user != null}">
											<button class="add-to-cart" href="">
												ДОБАВИТЬ В КОРЗИНУ <i class="cart">
													<div hidden class="hide product">
														<div class="prodId">${product.id}</div>
														<div class="prodBrand">${product.brand.brand}</div>
														<div class="prodModel">${product.model}</div>
														<div class="prodSize">${product.size.size}</div>
														<div class="prodSex">${product.genders.genders}</div>
														<div class="prodLin">${product.liner_material.liner_material}</div>
														<div class="prodUpp">${product.upper_material.upper_material}</div>
														<div class="prodCateg">${product.categories.categories}</div>
														<div class="prodPrice">${product.price}</div>
													</div>
												</i>
											</button>
										</c:if>
									</td>
								</tr>
							</table>
						</c:forEach>
						<!--  	</form>   -->
					</div>
					<jsp:include page="sidebar.jsp" />
				</div>
			</div>
		</div>
	</div>

	<div id="sidebar2"></div>
	<jsp:include page="footer.jsp" />
</body>	