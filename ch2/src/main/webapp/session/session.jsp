<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 세션을 유지하는 시간 : 10초 
	session.setMaxInactiveInterval(10);
%>
<h3>세션 테스트</h3>
<p>isNew : <%=session.isNew() %></p>
<p>생성시간 : <%=session.getCreationTime() %></p>
<p>최종접속시간 : <%=session.getLastAccessedTime() %></p>
<p>세션ID : <%=session.getId() %></p>
<div>
<a href="section1.jsp">섹션 1 페이지</a>
</div>
<div>
<a href="user.jsp">user 페이지</a>
</div>
<div>
<a href="main.jsp">main 페이지</a>
</div>
<h2>세션 객체에 담긴 값 : <%=session.getAttribute("name") %></h2>
<h2>세션 객체에 담긴 값 : <%=session.getAttribute("userid") %></h2>
</body>
</html>