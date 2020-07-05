<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<!-- Kiểm tra trên URL nếu có parameter là "error" thì thông báo lỗi -->
		<c:if test="${param['error'] }">Tên hoặc mật khẩu đăng nhập không chính xác. Thử lại !</c:if>
		
		<!-- "modelAttribute" sẽ mapping với "ModelAndView" tương ứng ở bên controller -->
		<form:form action="dashboard" method="POST" modelAttribute="fresher">
			<table>
				<tr>
					<td>
						<form:label path="username">Username</form:label>
					</td>
					<td>
						<form:input path="username" name="username" id="username"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="password">Password</form:label>
					</td>
					<td>
						<form:input path="password" name="password" id="password"/>
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td>
						<form:button name="login" id="login">Login</form:button>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>