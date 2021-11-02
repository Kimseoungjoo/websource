<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
      integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
      crossorigin="anonymous"
    />
<style>
	
	div{
		margin-bottom: 10px;
	}
	label {
		display: inline-block;
		width: 200px;
	}
	input{
		padding: 5px;
	}
	#insertbtn {
	background-color: skyblue;
	}
	#resetbtn{
	background-color: gray;
	}
</style>
<body>
 <form action="joinprocess.jsp" method="post">
 <div class="container">
       <div>
        <label for="userid">아이디</label>
        <input type="text" id="userid" name="userid"autofocus
          placeholder="아이디를 입력하세요" />
      </div>
      <div>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요"/>
      </div>
      <div>
        <label for="password2">비밀번호확인</label>
        <input type="password" id="password2" name="password" placeholder="비밀번호를 다시 입력하세요"/>
      </div>
      <div>
        <label for="username">이름</label>
        <input type="text" id="username" name="username" placeholder="이름을 입력하세요" />
      </div>
      <div>
      	<label for="gender">성별</label>
      	<input type="radio" id = "" value ="남"/>남
      	<input type="radio" id = "" value ="여"/>여
       </div>
      <div>
        <label for="email">이메일</label>
        <input type="text" id="email" name="email" placeholder="example@gmail.com"/>
      </div>
      <button type="submit" id = "insertbtn">입력</button>
      
      <button type="reset" id = "resetbtn">취소</button>
      </div>
    </form>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
   /*  $(function () {
		$("#insertbtn").click(function () {
			if($("#password").val()==$("#password2").val()){
			alert("비밀번호가 같지않습니다.");
			}else{
				$("form").attr("action","joinprocess.jsp");
				
			}
		})
    
	}) */
    </script>
    
</body>
</html>