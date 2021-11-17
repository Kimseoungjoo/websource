/**
 *  qna_board_view.jsp 스크립트
 */
$(function(){
	// 삭제시 form 데이터 가져오기
	let formObj = $("[role='form']");
	
	// 목록보기 버튼 클릭시
	$("#list").click(function(){
		location.href="/list.do";
	})
	
	// 삭제 버튼을 클릭 시 - pwdCheck.jsp 보여주기
	//                - formObj 보내기
	$("#delete").click(function(){
		formObj.attr("action", "/view/qna_board_pwdCheck.jsp");
		formObj.submit();
	})
	
	// 수정버튼 클릭시 
	$("#modify").click(function(){
		formObj.attr("action", "/modify.do");
		formObj.submit();
	})
	
	$("#reply").click(function(){
		formObj.attr("action", "/replyView.do");
		formObj.submit();
	})
})