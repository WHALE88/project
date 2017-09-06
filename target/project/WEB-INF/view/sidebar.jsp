<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	<div id="sidebar">
		<h2>Товары</h2>
			<ul>
				<li><a href="products.php">Категория 1</a></li>
				<li><a href="products.php">Категория 2</a></li>
				<li><a href="products.php">Категория 3</a></li>
					<jsp:include page="menu.jsp"/>
				<li><a href="/cart">Корзина</a></li>
			</ul>
	</div>
</body>
</html>