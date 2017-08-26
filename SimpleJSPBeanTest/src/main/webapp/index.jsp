<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${\"post\".equalsIgnoreCase(pageContext.request.method)}">
		<jsp:useBean id="user" class="com.dagobravo.simple_jsp_bean_test.beans.User">
			<c:catch var="error">
				<jsp:setProperty property="*" name="user" />
			</c:catch>
			<c:if test="${user.validateUser()}">
				<c:out value="Username/Password: ${user.userName}/${user.password}"></c:out>
			</c:if>
		</jsp:useBean>
	</c:if>
	<form method="post">
		Usuario: <input type="text" name="userName" /> 
		Contraseña: <input type="password" name="password" />
		<button type="submit">Enviar</button>
	</form>
</body>
</html>