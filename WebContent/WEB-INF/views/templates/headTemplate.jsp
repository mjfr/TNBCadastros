<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<body>
		<c:url value="/login" var="urlLogin"/>
		<c:url value="/user/new" var="urlSignUp"/>
		<ul>
			<li><a href="${urlSignUp}">Sign up</a></li>
			<li><a href="${urlLogin}">Login</a></li>
		</ul>
	</body>
</html>