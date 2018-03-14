<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TNB - Sign up</title>
</head>
<body>
<c:url value="/user/save" var="urlSave"/>
	<form method="post" action="${urlSave}">
		<label>
			Name
			<input type="text" name="name">
		</label><br>
		<label>
			E-mail
			<input type="email" name="email">
		</label><br>
		<label>
			Gender
			<input type="radio" name="gender">
		</label><br>
		<label>
			Birthday
			<input type="date" name="birthday">
		</label><br>
		<label>
			Password
			<input type="password" name="password">
		</label>
		<label>
			Confirm password
			<input type="password" name="confirmation">
		</label><br>
		<button type="submit">Save</button>
		<button type="reset">Clean</button>
	</form>
</body>
</html>