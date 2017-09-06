<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
 <head>
   <title>Logout</title>
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
						<form action="/cart" method="get">
						<c:forEach items="${cart.products}" var="product">
							<table border='1'>
								<tr>
									<td width='200' height='50' align='center'>Art.
										${product.id}</td>
									<td width='200' height='50' align='center'>
										${product.brand} ${product.model}</td>
								</tr>
								<tr>
									<td width='200' height='50' align='center'><img
										src="<c:url value="resources/images/${product.id}.jpg" />"
										width='200' /></td>
									<td width='200' height='50' align='center'>
										Размер:${product.size}</td>
								</tr>
								<tr>
									<td width='200' height='50' align='center'>Price:
									${product.price}</td>
								</tr>
							</table>
						</c:forEach>
						</form>
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