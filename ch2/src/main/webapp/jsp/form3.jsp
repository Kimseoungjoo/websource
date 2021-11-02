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
 <form action="../InfoServlet" method="post">
       <div>
        <label for="userid">아이디</label>
        <input type="text" id="userid" name="userid" />
      </div>
      <div>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" />
      </div>
      <div>
        <label for="username">이름</label>
        <input type="text" id="username" name="username" />
      </div>
      <button type="submit">전송</button>
    </form>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
      $(function () {
        $("button").click(function (e) {
          // 태그가 가지고 있는 기능 막기
          // submit
          e.preventDefault();
          // input요소 가져오기
          let userid = $("#userid"); // document.querySelector("#userid");

          //비밀번호 가져오기
          let userPw = $("#password"); // document.querySelector("#password");

          // 이름 가져오기
          let username = $("#username"); // document.querySelector("#username");

          // input요소가 가지고있는 값을 가져오기
          console.log(userid.value);

          // 폼 유효성 검증
          // if (userid.value == "" || userPw.value == "" || userName.value == "") {
          //   return;
          // }
          if (userid.val() == "") {
            alert("아이디 값을 넣어주세요 ");
            userid.focus(); // 아이디란에 꿈뻑꿈뻑 거림
            return;
          } else if (userPw.val() == "") {
            alert("비밀번호를 넣어주세요 ");
            userPw.focus(); // 비밀번호란에 꿈뻑꿈뻑 거림
            return;
          } else if (username.val() == "") {
            alert("이름을 넣어주세요 ");
            username.focus(); // 이름란에 꿈뻑꿈뻑 거림
            return;
          }
          //폼전송
          $("form").submit();
        });
      });
    </script>
</body>
</html>