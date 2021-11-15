/**
 *  mock_data.json 파일 요청후 보여주기 
 */
$(function(){
		$.getJSON({
			url:"/data/mock_data.json",
			success:function(data){

			let output = "";			
			$(data).each(function(idx,item){  // each가 두개의 인자를 받는다 하나가 index, 하나가 처리할 data가 온다
				output+= "<tr><td>"+item.id+"</td>";
					output+= "<td>"+item.name+"</td>";
					output+= "<td>"+item.email+"</td>";
					output+= "<td>: "+item.gender+"</td>";
					output+= "<td>: "+item.ip_address+"</td></tr>";

			})
			
			$("#contents").html(output);
			},
			error: function(xhr,textStatus,error){
				$("#contents").html("가져올 데이터 없음");
			}
			
		})
	})
