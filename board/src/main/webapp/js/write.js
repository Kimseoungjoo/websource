/**
 *  qna_board_write.jsp
 */
$(function(){
	$("#list").click(function(){
		/*location.href='list.do';*/
		$("#actionForm").attr("action", "/list.do"); 
		$("#actionForm").submit();
		
	})
})