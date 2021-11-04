<%@page import="book.persistence.BookDAO"%>
<%@page import="book.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	// modify.jsp 에서 넘긴 값 가져오기
	String code = request.getParameter("code");
	int price = Integer.parseInt(request.getParameter("price"));
	//db 작업
	Connection con = JdbcUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	boolean updateFlag = dao.update(code, price);
	
	//페이지 이동
	String path = "";
	
	if(updateFlag){
		JdbcUtil.commit(con);
		path ="/index.jsp";
		}else{
		JdbcUtil.rollback(con);
		path ="/index.jsp?tab=modify";
	}
	JdbcUtil.close(con);
		response.sendRedirect(path);
%>