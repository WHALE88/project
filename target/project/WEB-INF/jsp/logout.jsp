<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<form action="logout" method="post">
				<input type='hidden' name='logout' />
				<input type='submit' value='Logout' />
			</form>
		</div>
	<jsp:include page="footer.jsp" />
</body>