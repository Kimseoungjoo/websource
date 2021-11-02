<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 위 코드는 jsp 파일에 무조건 들어와야하는 코드 --> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- jsp 주석 --%>
<!--  htmㅣ 주석  -->
<body>
<% 
	// 자바코드 사용법
	// 1~10 까지 출력 
	for(int i=0; i<11; i++){
		out.print(i+"<br>");
	}

%>
<div>
	<a href="sendRedirect.jsp">이동</a>
	<a href="main.jsp">main</a>
</div>
</body>
</html>