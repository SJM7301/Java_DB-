<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서테이블 보기</title>
</head>
<body>
<h1>부서테이블 보기</h1>
<table border="1">
	<tr>
		<td colspan="3">부서테이블</td>
	</tr>
	
	<tr>
		<td>부서번호</td>
		<td>부서이름</td>
		<td>지역</td>
	</tr>
	
	<c:forEach var="dto" items="${select}" step="1">
		<tr>
			<td>${dto.deptno}</td>
			<td>${dto.dname}</td>
			<td>${dto.loc}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>





