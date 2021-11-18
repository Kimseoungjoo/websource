/**
 *  qna_board_list.jsp 와 관련있는 script
 */
$(function(){
	// 검색버튼을 누르면
	// 검색조건(criteria), 검색어(keyword) 가져온 후
	// 내용이 안들어 있으면 메세지 띄우기 
	
	$(".btn-primary").click(function(){
		let criteria = $("[name='criteria']");
		let keyword = $("[name='keyword']");
		if(criteria.val()=="n"){
			alert("조건을 선택하세요");
			criteria.focus();
			return;
		}else if(keyword.val()==""){
			alert("내용을 적으세요");
			keyword.focus();
			return;
		}
		$("#search").submit();
	})
})