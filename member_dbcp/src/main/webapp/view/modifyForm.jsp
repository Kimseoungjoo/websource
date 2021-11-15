<%@page import="member.domain.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%
	// 세션에서 로그인 정보 가져오기
	//MemberDTO loginDto = (MemberDTO)session.getAttribute("loginDto");

%>
<form id="modifyform" action="/modify.do" method="post">
	<div class="card"  style="width: 40rem;margin:40px auto;">	
		<div class="card-header">
	    	<h4>비밀번호 변경</h4>
	  	</div>
	 	<div class="card-body">	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="password" name="current_password" id="current_password" class="form-control" placeholder="현재 비밀번호" autofocus="autofocus"/>
					<small id="current_password" class="text-info"></small>	
				</div>
			</div>	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="password" name="new_password" id = "new_password" class="form-control" placeholder="새 비밀번호"/>
					<small id="new_password" class="text-info"></small>
				</div>	
			</div>	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="password" name="confirm_password" id = "confirm_password" class="form-control" placeholder="새 비밀번호 확인"/>
					<small id="confirm_password" class="text-info"></small>
				</div>	
			</div>	
			<div class="form-group text-center">		
				<button type="submit" class="btn btn-primary">수정</button>
			    <button type="reset" class="btn btn-secondary" id="modifycancel">취소</button>		
			</div>
		</div>
	</div>		
</form>
<%--로그인 후 메뉴 --%>
	<script>
		<%-- let name = '<%=loginDto.getName()%>'; --%>
		let name = '${loginDto.name}';
	</script>
<script src = "../js/menu.js"></script>
<%-- 정보수정 들어왔으니 정보수정 버튼 없애기 --%>
<script>
	$(function(){
		$("#modify").detach();
	})
</script>
<%--폼 검증 --%>
<script>
$(function(){

	$(":submit").click(function(e){
	//new_password와 confirm_password 값을 가져온 후 둘의 값이 같은지 확인
		e.preventDefault();
		const newPw = $("#new_password");
		const conPw = $("#confirm_password");
		const curPw = $("#current_password");
	
	
		if(curPw.val() == ""){
			alert("현재 비밀번호를 확인해 주세요 ");
			curPw.focus();
			return;
		}else if(newPw.val() ==""){
			alert("새 비밀번호를 확인해 주세요 ");
			newPw.focus();
			return;
		}else if(conPw.val() == ""){
			alert("새 비밀번호를 확인해 주세요 ");
			conPw.focus();
			return;
		}	
		// javascript (document.querySelector("#new_password")) / jquery
		
		if(newPw.val()!==conPw.val()){
			//다르면 사용자에게 경고창을 띄우고 new_password란에 focus 줘~ 
			alert("변경을 위한 비밀번호가 서로 다릅니다");
			newPw.val("");
			conPw.val("");
			newPw.focus();
			return;
		
		}
			// 같으면 form submit, 
			$("form").submit();
		})
		
	
	})

</script>

<%-- 버튼 이벤트 --%>
<script src = "../js/command.js"></script>
<%@ include file="../layout/footer.jsp" %>