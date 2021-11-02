
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	div{
		margin-bottom: 10px;
	}
	label {
		display: inline-block;
		width: 150px;
	}
	input{
		padding: 5px;
	}
</style>
<body>
 <form action="/add" method="post">
 	<div>
 		<input type="radio" name ="product" id = "" value = "BMW" />BMW
 	</div>
 	<div>
 		<input type="radio" name ="product" id = "" value = "SM5" />SM5
 	</div>
 	<div>
 		<input type="radio" name ="product" id = "" value = "Audi" />Audi
 	</div>
 	<div>
 		<input type="radio" name ="product" id = "" value = "K7" />K7
 	</div>
 <div>
 	<input type="submit" value = "저장" />
 </div>
 </form>
</body>
</html>