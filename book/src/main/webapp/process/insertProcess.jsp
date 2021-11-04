<%@page import="book.persistence.BookDAO"%>
<%@page import="book.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="book.domain.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- JSP 파일안 항상 상단에 이 문장이 꼭있어야한다 -->

<%
	request.setCharacterEncoding("utf-8");
	// insert.jsp 에서 넘오온 값을 넣어준다
	BookDTO insertDto = new BookDTO();
	insertDto.setCode(request.getParameter("code"));
	insertDto.setTitle(request.getParameter("title"));
	insertDto.setWriter(request.getParameter("writer"));
	insertDto.setPrice(Integer.parseInt(request.getParameter("price")));

	//db작업
	Connection con = JdbcUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	
	boolean insertFlag = dao.insert(insertDto);
	
	//페이지 이동
	String path = "";
	if(insertFlag){
		JdbcUtil.commit(con);
		path = "/index.jsp";
	}else {
		JdbcUtil.rollback(con);	
		path = "/index.jsp";
	}
	JdbcUtil.close(con);
	response.sendRedirect(path);

%>
