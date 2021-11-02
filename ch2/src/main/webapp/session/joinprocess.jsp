<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String userid = request.getParameter("userid");
	String password = 	request.getParameter("password");
	String password2 = request.getParameter("password2");
	String username = request.getParameter("username");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<p>아이디 : <%=userid %></p>
</div>
<div>
<p>이름 : <%=username %></p>
</div>
<div>
<p>비밀번호 : <%=password %></p>
</div>
<div>
<p>email : <%=email %></p>
</div>
<div>
<p>성별 : <%=gender %></p>
</div>

</body>
</html>