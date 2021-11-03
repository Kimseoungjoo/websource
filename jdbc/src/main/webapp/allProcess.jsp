<%@page import="java.io.PrintWriter"%>
<%@page import="user.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="user.persistence.MemberDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="user.persistence.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 전체조회 후 페이지 이동
	Connection con = JdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	
	List<MemberDTO> list = dao.getRows();
	
	request.setAttribute("list", list);
	pageContext.forward("all.jsp");
	
	JdbcUtil.close(con);
	
	
	
%>