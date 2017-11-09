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
						<li><a href="?genderId=boy"><spring:message code="category_one" /></a></li>
						<li><a href="?genderId=girl"><spring:message code="category_two" /></a></li>
					</ul>
				</li>
				<li><a href="#">Тип обуви</a>
					<ul>
						<li><a href="#">1</a></li>
					</ul>
				</li>
				<li><a href="#">Размер</a>
					<ul>
						<li><a href="#">1</a></li>
					</ul>
				</li>
				<li><a href="#">Бренд</a>
					<ul>
						<li><a href="?brandId=beloli">Beloli-Belali</a></li>
						<li><a href="?brandId=bg">B&G</a></li>
					</ul>
				</li>
				<li><a href="#">Сезон</a>
					<ul>
						<li><a href="#">1</a></li>
					</ul>
				</li>
				<li><a href="#">Вверх обуви</a>
					<ul>
						<li><a href="#">1</a></li>
					</ul>
				</li>
				<li><a href="#">Материал подкладки</a>
					<ul>
						<li><a href="#">1</a></li>
					</ul>
				</li>
			</ul>
        </div> <!-- END of sidebar -->
</body>
</html>