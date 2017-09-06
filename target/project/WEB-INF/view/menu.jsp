<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:choose>
        <c:when test="${empty user}">
            <li><a href="registration">Регистрация</a></li>
            <li><a href="login">Вход</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="myaccount">Профиль</a></li>
            <li><a href="logout">Выход</a></li>
        </c:otherwise>
    </c:choose>
