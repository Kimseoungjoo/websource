<%@page import="user.domain.MemberDTO"%>
<%@page import="user.persistence.MemberDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="user.persistence.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 사용자가 입력한 값(insert.jsp_)을 가져오기
	/* String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email"); */
	request.setCharacterEncoding("utf-8");
	
	MemberDTO dto = new MemberDTO();
	dto.setUserid(request.getParameter("userid"));
	dto.setPassword(request.getParameter("password"));
	dto.setName(request.getParameter("name"));
	dto.setGender(request.getParameter("gender"));
	dto.setEmail(request.getParameter("email"));
	//db작업
	// Connection 생성
	Connection con = JdbcUtil.getConnection();
	// 생성된 connection을 이용해 DAO 객체 생성
	MemberDAO dao = new MemberDAO(con);
	boolean insertFlag = dao.insert(dto);
	
	// db 작업 결과에 따라 페이지 이동
	if(insertFlag){ //입력에 성공
		JdbcUtil.commit(con);
		response.sendRedirect("allProcess.jsp");
	}else { // 입력 실패
		JdbcUtil.rollback(con);
		response.sendRedirect("insert.jsp");		
	}
	
%>