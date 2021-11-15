/**
 * 	dataset.html - 서버에서 dataset.xml 데이터 요청후 보여주기
 */
$(function(){

		$.get({
			url:"/data/dataset.xml",
			success:function(data){
				
				let output = "";
				// .each(function(idx)) / each(function()) / each(function(idx,data))
				$(data).find("record").each(function(){
					output+= "<tr><td>"+$(this).find("id").text()+"</td>";
					output+= "<td>"+$(this).find("name").text()+"</td>";
					output+= "<td>"+$(this).find("email").text()+"</td>";
					output+= "<td>: "+$(this).find("gender").text()+"</td></tr>";
					
				});
				
				$("#contents").html(output);
			},
			error: function(xhr,textStatus,error){
				$("#contents").html("데이터 없음");
			}
		})

	
})