<%@page import="book.domain.BookDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
<style>
.jumbotron{/* background-image: url(https://www.starbucks.co.kr/common/img/main/fav_prod_bg_new.jpg); */
        background: url(data:image/jpeg;base64,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)
          right bottom;
        background-size: auto 30%; /*사용자에게 보여지는 size 다 볼 수 있도록  */
        background-position: center bottom;
        background-attachment: fixed;
        color: gold;
        }
       .container .lead{
       	color:red;
       }
        
</style>

</head>
<body>
<%
	String tab = request.getParameter("tab");
	
	if(tab==null){
		tab = "search";
	}
%>
<script>
	$(function(){
		let selectTab = '<%=tab%>';
		$("#list-tab a[href='#"+selectTab+"']").tab('show');
	})
</script>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">BOOK / JDBC / MODEL1</h1>
    <p class="lead">도서 정보 입력/수정/삭제/조회</p>
  </div>
</div>
<div class = "container-fluid">
	<div class="row">
  <div class="col-4">
    <div class="list-group" id="list-tab" role="tablist">
      <a class="list-group-item list-group-item-action active" id="list-all-list" data-toggle="list" href="#all" role="tab" aria-controls="all">도서목록보기</a>
      <a class="list-group-item list-group-item-action" id="list-insert-list" data-toggle="list" href="#insert" role="tab" aria-controls="insert">도서정보입력</a>
      <a class="list-group-item list-group-item-action" id="list-delete-list" data-toggle="list" href="#delete" role="tab" aria-controls="delete">도서정보삭제</a>
      <a class="list-group-item list-group-item-action" id="list-modify-list" data-toggle="list" href="#modify" role="tab" aria-controls="modify">도서정보수정</a>
      <a class="list-group-item list-group-item-action" id="list-search-list" data-toggle="list" href="#search" role="tab" aria-controls="search">도서정보검색</a>
    </div>
  </div>
  <div class="col-8">
    <div class="tab-content" id="nav-tabContent">
      <div class="tab-pane fade" id="all" role="tabpanel" aria-labelledby="list-all-list">
	  </div>
      <div class="tab-pane fade" id="insert" role="tabpanel" aria-labelledby="list-insert-list">
      		<%@include file="/view/insert.jsp" %>
      </div>
      <div class="tab-pane fade" id="delete" role="tabpanel" aria-labelledby="list-delete-list">
			<%@include file="/view/delete.jsp" %>
		</div>
      <div class="tab-pane fade" id="modify" role="tabpanel" aria-labelledby="list-modify-list">
      		<%@include file="/view/modify.jsp" %>
      </div>
      <%
      	List<BookDTO> searchList = (List<BookDTO>)request.getAttribute("list");
      	if(searchList.isEmpty()){
      %>
      <div class="tab-pane fade" id="search" role="tabpanel" aria-labelledby="list-search-list">
      		<%@include file="/view/search.jsp" %>
      </div>
      <%}else { %>
      <table class="table" style = "margin-top : 20px">
  <thead class="thead-light">
    <tr>
      <th scope="col">code</th>
      <th scope="col">title</th>
      <th scope="col">writer</th>
      <th scope="col">price</th>
    </tr>
  </thead>
  <tbody>
    <%
    	for(BookDTO dto : searchList){
    %>
    <tr>
      <th scope="row"><%=dto.getCode() %></th>
      <td> <%=dto.getTitle() %></td>
      <td><%=dto.getWriter() %></td>
      <td><%=dto.getPrice() %></td>
    </tr>
    <%} %>
  </tbody>
  </table>
      
      <% }%>
    </div>
  </div>
</div>
</div>
<script>
	$('#list-tab a[href="#all"]').click(function() {
		location.href = "/index.jsp?tab=all";
	})
</script>

</body>
</html>