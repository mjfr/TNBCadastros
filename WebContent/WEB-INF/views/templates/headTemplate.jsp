<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Declaração de URLs --%>
		<c:url value="/login" var="urlLogin"/>
		<c:url value="/user/new" var="urlSignUp"/>
<%-- Fim da declaração --%>

<!DOCTYPE html>
<html>
	<body>
		<ul>
			<li><a href="${urlSignUp}">Sign up</a></li>
			<li><a href="${urlLogin}">Login</a></li>
		</ul>
	</body>
</html>