<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			url: "checkStrength",
			data: ({password : $('#password').val()}),
			success: function(data) {
				$('#strengthValue').html(data);
			}

		})
	}
</script>

<body>
	<jsp:include page="header.jsp" />
<div id="tooplate_wrapper">
<div id="tooplate_main"><span class="main_border main_border_t"></span><span class="main_border main_border_b"></span>
    	<div class="col col_1">
            <h1>Авторизация</h1>
            
			<h3>Введите данные</h3> 
		</div>
        <div class="col col_2">
			<form:form method="POST" commandName="validator" action="login">
							<table>
								<tr>
									<td><label>Login:</label> </td>
									<td><form:input path="login" name="login" id="login" /></td>
									<td><form:errors path="login" /></td>
								</tr>
								<tr>
									<td><label>Password:</label></td>
									<td><form:password path="password" name="password"
											id="password" onkeyup="doAjax()" /></td>
									<td><form:errors path="password" /> 
									<span style="float: right" id="strengthValue"></span></td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" value="Submit"
										name="submit"></td>
								</tr>
							</table>
						</form:form>
            
        </div>     
        <div class="clear"></div>
    </div> <!-- END of main -->
    
</div> <!-- END of wrapper -->

	
	<jsp:include page="footer.jsp" />
</body>