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
<form action="empInsert.do" method="post">
	사원번호<input type="text" name="empno"><br>
	사원이름<input type="text" name="ename"><br>
	직책<input type="text" name="job"><br>
	매니저<input type="text" name="mgr"><br>
	입사일<input type="text" name="hiredate"><br>
	연봉<input type="text" name="sal"><br>
	보너스<input type="text" name="comm"><br>
	부서번호<input type="text" name="deptno"><br>
	<input type="submit" value="데이터입력">
</form>
</body>
</html>