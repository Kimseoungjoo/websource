/**
 * 
 */
$(function(){
	$("#modify").click(function(){
		location.href = "../view/modifyForm.jsp";
	})
	
	$("#logout").click(function(){
		//logout.do 이동
		location.href = "/logout.do";
	})
	$("#leave").click(function(){
		// 탈퇴 
		location.href = "../view/leaveForm.jsp";
	})
})