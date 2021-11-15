/**
 *  getjson.html에서 메뉴4 클릭시 동작 ㅏ아아아아아아아아아그리워라 
 */

$(function(){
	$(".container div:last-child").click(function(){
		$.getJSON({
			url:"/data/dataArray.json",
			success:function(data){
				let resText = "<ul>";
			
			$(data).each(function(idx,item){  // each가 두개의 인자를 받는다 하나가 index, 하나가 처리할 data가 온다
				resText +="<li>version : "+item.version+"</li>";
				resText += "<li>codename : "+item.codename+"</li>";
			})
			
			$("#contents").html(resText+"</ul>");
			},
			error: function(xhr,textStatus,error){
				$("#contents").html("가져올 데이터 없음");
			}
			
		})
	})
})
// 메뉴 4와 이벤트를 연결 
/*let last_div = document.querySelector(".container div:last-child").addEventListener('click',makeRequest);

let xhr = new XMLHttpRequest();

function makeRequest(){
	
	xhr.onreadystatechange = getJson;
	xhr.open("get", "/data/dataArray.json");
	xhr.send();
	
}

// 서버가 응답하는 경우 호출되는 함수 
function getJson(){
	
	// 서버가 보내준 데이터를 contents 영역에 보여주기 
	let contents = document.querySelector("#contents");
	if(xhr.readyState==4){
		if(xhr.status==200){// 서버 응답이 성공했으면 200 
			
			//json 데이터를 자바스크립트 객체로 파싱!
			let response = JSON.parse(xhr.responseText);
			console.log(response);
			
			let resText = "<ul>";
			
			response.forEach((item)=>{
				resText +="<li>version : "+item.version+"</li>";
				resText += "<li>codename : "+item.codename+"</li>";
			})
			
			contents.innerHTML = resText+"</ul>";
		
		}else{
			contents.innerHTML = "가져온 데이터 없음";
		}
	}
}*/
