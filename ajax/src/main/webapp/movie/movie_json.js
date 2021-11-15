/**
 *  영화 진흥위원회 일일박스 오피스 오픈 api - json 
 */
$(function(){
init();
	$(":button").click(function(){ 
		let url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=";
		url += $("#txtYear").val() + $("#selMon").val() + $("#selDay").val();
		$.getJSON({
			url:url,
			success:function(data){
				
				if($(data.boxOfficeResult.dailyBoxOfficeList)===""){
					alert("데이터가 없습니다.");					
				}else{
					let resData = "";
					
					$(data.boxOfficeResult.dailyBoxOfficeList).each(function(idx,item){
						// 순위
						resData +=item.rank+"위";
						// 증감
						let rankInten =item.rankInten; 
						
						if(rankInten >0){
							resData += "( ▲ ";
						}else if(rankInten<0){
							resData += "( ▼ ";
						}else{ 
							resData+="( ";
						}
						resData += rankInten+" )";	
						
						// 영화 코드 
						let movieCd = item.movieCd;			
						//영화 이름 
						let movieNm = item.movieNm;
						
						resData += "<a href='#' onclick='javascript:show("+movieCd+")'>"+movieNm+"</a><br>";
						
						
					})
					$("#msg").html(resData);
				}
			}//function 코드 end
		
		})
	})//$(":button") end
})

function show(movieCd){
	let url = "	http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=";
	url += movieCd;
	console.log(url);
	$.getJSON({
		url:url,
		success:function(data){
			let movieInfo = data.movieInfoResult.movieInfo;
			// 영화 제목 추출(한글)
			let movieNm = movieInfo.movieNm;
			// 영화 제목 추출(영어)
			let movieNmEn = movieInfo.movieNmEn;
			//상영시간
			let showTm = movieInfo.showTm;
			// 영화 감독명
			let directorNm = movieInfo.directors[0].peopleNm;
			// 영화 출연배우명
			let peopleNm = "";
			// 출연배우의 수 
			let length = data.movieInfoResult.movieInfo.actors.length;
			$(data.movieInfoResult.movieInfo.actors).each(function(idx,item){// idx >> i와 같은 개념(기본 for문) 
				if(idx ==length-1){
				peopleNm += item.peopleNm;
				}else{
				peopleNm += item.peopleNm + ", ";
				}
			})
			// 보여주기
			let resData = "<ul>";
			resData += "<li>영화제목(국문) : "+movieNm+"</li>";
			resData += "<li>영화제목(영문) : "+movieNmEn+"</li>";
			resData += "<li>상영시간 : "+showTm+"분 </li>";
			resData += "<li>영화 감독 : "+directorNm+"</li>";
			resData += "<li>출연배우: "+peopleNm+"</li></ul>";
			$(".box3").html(resData);
		}
	})
}// show Function end
function init(){
	// 어제 날짜 추출
	let newDate = new Date();
	let year = newDate.getFullYear();
	let month = newDate.getMonth()+1;
	let day = newDate.getDate()-1;
	$("#txtYear").val(year);
	
	if(month <10){
		month = "0"+month;
		
	}
	if(day<10){
		day = "0"+day;
	}
	$("#selMon").val(month);
	$("#selDay").val(day);
}
//---------------------------------------------------------------------------

