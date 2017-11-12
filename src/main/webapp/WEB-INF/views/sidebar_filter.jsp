<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
</head>

<body>
	<div id="stuff_tooplate_sidebar">
       <h3>Categories</h3>
            <ul class="stuff_sidebar_menu">
				<li><a href="gender"><spring:message code="homepage" /></a>
					<ul>
					<c:forEach items="${gender}" var="genders">
						<li><a href="?genderId=${genders.id}">${genders.genders}</a></li>
					</c:forEach>
					<!-- <li><a href="?genderId=boy"><spring:message code="category_one" /></a></li>
						 <li><a href="?genderId=girl"><spring:message code="category_two" /></a></li>-->
					</ul>
				</li>
				<li><a href="#">Тип обуви</a>
					<ul>
						<c:forEach items="${categories}" var="category">
							<li><a href="?categoryId=${category.id}">${category.categories}</a></li>
						</c:forEach>
					</ul>
				</li>
				<li><a href="#">Размер</a>
					<ul>
						<c:forEach items="${size}" var="sizes">
							<li><a href="?sizeId=${sizes.id}">${sizes.size}</a></li>
						</c:forEach>
					</ul>
				</li>
				<li><a href="#">Бренд</a>
					<ul>
						<c:forEach items="${brands}" var="brand">
							<li><a href="?brandId=${brand.id}">${brand.brand}</a></li>
						</c:forEach>
					</ul>
				</li>
				<!--  <li><a href="#">Сезон</a>
					<ul>
						<li><a href="#">1</a></li>
					</ul>
				</li>-->
				<li><a href="#">Вверх обуви</a>
					<ul>
						<c:forEach items="${um}" var="ums">
							<li><a href="?upperId=${ums.id}">${ums.upper_material}</a></li>
						</c:forEach>
					</ul>
				</li>
				<li><a href="#">Материал подкладки</a>
					<ul>
						<c:forEach items="${lm}" var="lms">
							<li><a href="?linerId=${lms.id}">${lms.liner_material}</a></li>
						</c:forEach>
					</ul>
				</li>
			</ul>
        </div> <!-- END of sidebar -->
</body>
</html>