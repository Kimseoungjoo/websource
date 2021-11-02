<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 보기</title>
</head>
<body>
<h3>장바구니 보기</h3>

<%
	// 세션에서 보내는거 가져오기
	String product = (String)session.getAttribute("product");
%>
<p>
	<%=product %>
</p>
</body>
</html>