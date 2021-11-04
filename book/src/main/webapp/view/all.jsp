<%@page import="book.domain.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="book.persistence.BookDAO"%>
<%@page import="book.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 전체 도서 목록 보기 
	Connection con = JdbcUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	
	List<BookDTO> list = dao.list();
	//페이지 이동
%>
<%-- 도서 전체 조회 하는 테이블 --%>
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
    	for(BookDTO dto : list){
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
