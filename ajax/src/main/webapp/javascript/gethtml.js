/**
 * 
 */
function gethtml() {
			// 페이지가 로드가 되자마자 서버가 가지고 있는 html 페이지를 가져와서 div안에 
			// 보여주려고 한다. => 비동기식 방법으로 처리를 하려고 한다. 
			
			// XMLHttpRequest 객체 생성
			let httpRequest = new XMLHttpRequest();
			
			// 생성된 객체를 통해 서버에게 보낼 요청을 설정하는 작업이 필요합니다.
			httpRequest.open("get","/data/data.html");
			
			// 서버로 전송-get 방식일 때는 null or 비워두기, post일때는 전송할 데이터 포함
			httpRequest.send(null);
			
			// 서버가 응답을 보내줄 것이다
			// 서버가 응답 : 200(성공), 400(404), 500(null에러 서버에러) 
			httpRequest.onreadystatechange = function(){
				if(httpRequest.readyState==4){
					if(httpRequest.status == 200){
						let div = document.querySelector("div:last-of-type");
						div.innerHTML = httpRequest.responseText; // responseText 응답 내용을 넣어주것다
					}
				}
			}
}