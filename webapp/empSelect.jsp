<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원테이블 보기</title>
</head>
<body>
<h1>사원테이블 보기</h1>
<table border="1">
	<tr>
		<td colspan="8">사원테이블</td>
	</tr>
	
	<tr>
		<td>사원번호</td>
		<td>사원이름</td>
		<td>직책</td>
		<td>매니저</td>
		<td>입사일</td>
		<td>연봉</td>
		<td>보너스</td>
		<td>부서번호</td>
	</tr>
	
	<c:forEach var="dto" items="${empSelect}" step="1">
		<tr>
			<td>${dto.empno}</td>
			<td>${dto.ename}</td>
			<td>${dto.job}</td>
			<td>${dto.mgr}</td>
			<td>${dto.hiredate}</td>
			<td>${dto.sal}</td>
			<td>${dto.comm}</td>
			<td>${dto.deptno}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
