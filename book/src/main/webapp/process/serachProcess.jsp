<%@page import="book.domain.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="book.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="book.persistence.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//serch.jsp 넘긴 값 가져오기 
	String criteria = request.getParameter("criteria");
	String keyword = request.getParameter("keycode");
	
	//db작업 
	Connection con = JdbcUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	
	List<BookDTO> searchList =dao.search(criteria, keyword);
	
	JdbcUtil.close(con);
	
	request.setAttribute("list", searchList);
	// 페이지 이동 
	pageContext.forward("/searchIndex.jsp");
	
	
%>