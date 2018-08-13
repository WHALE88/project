<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="Free Web tutorials" />
<meta name="keywords" content="HTML,CSS,XML,JavaScript" />
</head>

<script type="text/javascript">
	function doAjax() {
		$.ajax({
			url : "checkStrength",
			data : ({
				password : $('#password').val()
			}),
			success : function(data) {
				$('#strengthValue').html(data);
			}

		})
	}
</script>

<body>
	<jsp:include page="header.jsp" />
	<div id="tooplate_wrapper">
		<div id="tooplate_main">
			<span class="main_border main_border_t"></span><span
				class="main_border main_border_b"></span>
			<div class="col col_1">
				<h1><spring:message code="registration"/></h1>

				<h3><spring:message code="enter_data"/></h3>
			</div>
			<div class="col col_2">
				<form:form method="POST" modelAttribute="validator"
					action="registration">
					<table>
						<tr>
							<td><label><spring:message code="login"/>:</label></td>
							<td><form:input path="login" name="login" id="login" /></td>
							<td><form:errors path="login" /></td>
						</tr>
						<tr>
							<td><label><spring:message code="email"/>:</label></td>
							<td><form:input path="email" name="email" id="email" /></td>
							<td><form:errors path="email" /></td>
						</tr>
						<tr>
							<td><label><spring:message code="password"/>:</label></td>
							<td><form:password path="password" name="password"
									id="password" onkeyup="doAjax()" /></td>
							<td><form:errors path="password" /> <span
								style="float: right" id="strengthValue"></span></td>
						</tr>
						<tr>
							<td><label><spring:message code="repassword"/>:</label></td>
							<td><form:password path="retypePassword" name="retypePassword"
									id="retypePassword" /></td>
							<td><form:errors path="retypePassword" /></td>
						</tr>
						<tr>
							<td><label><spring:message code="name"/>:</label></td>
							<td><form:input path="name" name="name" id="name" /></td>
							<td><form:errors path="name" /></td>
						</tr>
						<tr>
							<td><label><spring:message code="phonenumber"/>:</label></td>
							<td><form:input path="phonenumber" name="phonenumber"
									id="phonenumber" /></td>
							<td><form:errors path="phonenumber" /></td>
						</tr>
						<tr>
							<td><label><spring:message code="region"/>:</label></td>
							<td><form:select path="region">
									<form:option value="UK" label="UK" />
									<form:option value="USA" label="USA" />
									<form:option value="UA" label="UA" />
								</form:select></td>
							<td><form:errors path="region" /></td>
						</tr>
						<tr>
							<td><label><spring:message code="feedback"/>:</label></td>
							<td><form:textarea path="feedback" name="feedback"
									id="feedback" /></td>
							<td><form:errors path="feedback" /></td>
						</tr>
						<tr>
							<td><label><spring:message code="gender"/>:</label></td>
							<td><form:radiobutton path="gender" value="M" /><spring:message code="gender.male"/> <form:radiobutton
									path="gender" value="F" /><spring:message code="gender.female"/></td>
							<td><form:errors path="gender" /></td>
						</tr>
						<tr>
							<td><label><spring:message code="agreement"/>:</label></td>
							<td><form:checkbox path="agreement" /></td>
							<td><form:errors path="agreement" /></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="<spring:message code="submit"/>"
								name="submit"></td>
						</tr>
					</table>
				</form:form>

			</div>
			<div class="clear"></div>
		</div>
		<!-- END of main -->

	</div>
	<!-- END of wrapper -->


	<jsp:include page="footer.jsp" />
</body>