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
		<!-- Kiểm tra trên URL nếu có parameter là "error" thì thông báo lỗi đăng ký -->
		<c:if test="${param['error'] }">Thông tin đăng ký không chính xác. Thử lại !</c:if>
		
		<!-- "modelAttribute" sẽ mapping với "ModelAndView" tương ứng ở bên controller,
		 là lúc request yêu cầu controller vào trang đăng nhập nó sẽ mapping vào đây -->
		<!-- action="userRegister" sẽ mapping với controller có @RequestMapping(value="") tương ứng khi click "Register" -->
		<form:form action="userRegister" method="POST" modelAttribute="fresher2">
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
						<form:label path="location">Location</form:label>
					</td>
					<td>
						<form:input path="location" name="location" id="location"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="year">year</form:label>
					</td>
					<td>
						<form:input path="year" name="year" id="year"/>
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td>
						<form:button name="register" id="register">Register</form:button>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>