/**
 *  qna_board_list.jsp 와 관련있는 script
 */
$(function(){
	// 제목을 클릭하면 actionForm을 보내면 된다 .
	$(".count").click(function(e){
		e.preventDefault(); // a태그 움직임 방지 
		
		let href = $(this).attr('href'); // a태그가 가지고 있는 href 속성 가져오기
		
		$("#actionForm").find("[name='bno']").val(href);
		//$("#actionForm").append("<input type='hidden' name='bno' value='"+href+"'>"); //정산코드
		$("#actionForm").attr("action","/countUpdate.do");
		
		$("#actionForm").submit();
	})
		
	// 하단의 페이지 번호를 클릭하면 form을 보낼 것이다.
	// 어떤 폼을 보낼거냐면  list.jsp form을 보낼것이다
	$(".move").click(function(e){
		e.preventDefault(); // a태그 움직임 방지 
		
		let href = $(this).attr('href'); // a태그가 가지고 있는 href 속성 가져오기 
		
		$("#actionForm").fine("[name='bno']").remove();
		$("#actionForm").find("[name='page']").val(href); // form에 page에 변
		$("#actionForm").submit();
	})
	// 검색어에서 enter 치는 것 방지 해보기 
	$(":text").keydown(function(e){
		if(e.keyCode==13){
			e.preventDefault();
		}
	})
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
		$("#search").find("[name='page']").val("1");
		$("#search").submit();
	})
})