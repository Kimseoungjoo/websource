<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
	<a href="/index.do">컨트롤러</a>
</p>
<p>
	<a href="/view/insert.jsp">삽입하기</a>
</p>
<p>
	<!-- <a href="/view/update.jsp">수정하기</a> -->
	<form action="/insert.do" method = "post">
		<div>
			<label for="userid">아이디</label>
			<input type="text" name = "userid" id="userid" />
		</div>
		<div>
			<label for="password">아이디</label>
			<input type="password" name = "password" id="password" />
		</div>
		<div>
			<button type ="submit">보내기</button>
		</div>
	</form>
</p>
</body>
</html>