<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TNB - Sign in</title>
</head>
<body>

	<c:if test="${not empty errors}">
		<div style="color: red">
			<c:forEach items="${errors}" var="error">
				<p>${error}</p>
			</c:forEach>
		</div>
	</c:if>
	
	<c:url value="/auth" var="urlAuth"/>
	<form method="post" action="${urlAuth}">
		<label>
			E-mail
			<input type="email" name="email" autofocus="autofocus">
		</label><br>
		<label>
			Password
			<input type="password" name="password">
		</label><br>
		<button type="submit">Login</button>
	</form>

</body>
</html>