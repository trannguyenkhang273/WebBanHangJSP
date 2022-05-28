<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose> 
		<c:when test="${sessionScope.user==null}">
			Welcome you
		</c:when> 
		
		<c:otherwise>
			Welcome ${user.fullname}
			<br>
			<a href="sign-out">Đăng xuất</a> 
			<c:if test="${sessionScope.user.admin}"> 
				<a href="">Quản trị</a>
			</c:if>
		</c:otherwise>	
	</c:choose>
	
	
</body>
</html>