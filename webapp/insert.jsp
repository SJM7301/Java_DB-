<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 입력</title>
</head>
<body>
<h1>테이블 데이터입력 화면</h1>
<form action="insert.do" method="post">
	부서번호<input type="text" name="deptno"><br>
	부서이름<input type="text" name="dname"><br>
	지역<input type="text" name="loc"><br>
	<input type="submit" value="데이터입력">
</form>
</body>
</html>