<%@page import="book.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="book.persistence.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	// delete.jsp 값 받아오기
	String code = request.getParameter("code");
	//db 작업
	Connection con  = JdbcUtil.getConnection();	
	BookDAO dao = new BookDAO(con);
	boolean deleteFlag = dao.delete(code);
	
	// 페이지 넘기기
	String path = "/index.jsp";
	
	if(deleteFlag){
		JdbcUtil.commit(con);
		path += "?tab=all";
	}else{
		JdbcUtil.rollback(con);
		path += "?tab=delete";
	}
		JdbcUtil.close(con);
		response.sendRedirect(path);
%>