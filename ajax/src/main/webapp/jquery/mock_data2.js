/**
 *  mock_data.json 파일 요청후 보여주기 
 */
$(function(){
		$.getJSON({
		url:"/data/mock_data.json",
			success:function(data){
				let output = "<table><tr><th>id</th><th>name</th><th>email</th><th>gender</th><th>address</th></tr>";
				
				$(data).each(function(idx,item){
					output += "<tr><td>"+item.id+"</td>";
					output += "<td>"+item.name+"</td>";
					output += "<td>"+item.email+"</td>";
					output += "<td>"+item.gender+"</td>";
					output += "<td>"+item.ip_address+"</td></tr>";
				})
				
				$("body").append(output);
				},
				
				error:function(xhr,textStatus,error){
				$("body").append("데이터없음");
					
				}
			
		})
	})
