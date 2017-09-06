<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 <head>
		<meta charset="utf-8">
		<meta name="description" content="Free Web tutorials"/>
		<meta name="keywords" content="HTML,CSS,XML,JavaScript"/>
 </head>

<body>
<jsp:include page="header.jsp"/>

  <div id="nav">
  </div>

	<div id="page">
		<div id="bg1">
			<div id="bg2">
				<div id="bg3">
					<div id="content">
						Spring MVC: ${mymessage}
					</div>
						<jsp:include page="sidebar.jsp"/>
				</div>
			</div>
		</div>
	</div>

  <div id="sidebar2">
  </div>
<jsp:include page="footer.jsp"/>
</body>