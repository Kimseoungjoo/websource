<%@page import="java.util.UUID"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>note : <%=request.getParameter("note") %></h1> <!--  Encoding 타입이 request.getParameter는 사용 안돼  -->
<h1>upfile : <%=request.getParameter("upfile") %></h1>
<hr />
<%-- commons-fileupload 이용한 처리 --%>
<%
	//enctype="multipart/form-data"으로 처리했는지 여부 확인
	boolean isMultipart = ServletFileUpload.isMultipartContent(request); 

	if(isMultipart){  
		// 전송된 파일을 디스크에 저장하기 위한 객체 
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 업로드 가능 사이즈 지정
		upload.setSizeMax(2000*1024); // 2KB 
		
		// 사용자의 request를 분석 
		List<FileItem> fileItems = upload.parseRequest(request);
		
		String fieldName = null, fileName = null, value = null;
		
		Iterator<FileItem> iter = fileItems.iterator();
		
		while(iter.hasNext()){
			FileItem item = iter.next();
			// text,password, checkbox ... 			
			if(item.isFormField()){
				// 요소명
				fileName = item.getFieldName();
				// 요소안에 들어있는 value 값 
				value = item.getString("utf-8");
				out.print("<h3>일반 데이터</h3>");
				out.print(fieldName+" : "+value+"<br>");
				
			}else{ // type= file 로 넘어오는 작업
				//요소명
				fieldName =item.getFieldName();
				//파일명
				fileName = item.getName();
				//업로드된 파일 사이즈
				long size = item.getSize();
				File file = null;
				if(!fileName.isEmpty()){
					//파일 저장
					String path = "c:\\upload\\";
					// 중복되지 않은 고유한 키 값 생성
					UUID uuid = UUID.randomUUID(); // D:\\upload\\고유값_업로드파일명

					file = new File(path+uuid.toString()+"_"+fileName);
					
					item.write(file);
				}
				
				
				out.print("<h3>파일 데이터</h3>");
	            out.print(fieldName+" : "+fileName+"<br>");
	            out.print("파일 크기 : "+size);
				
	            // file-download -> 다운로드시킬 파일명 전송 Summit the name of the file to be downloaded
				out.print("<p>");
				out.print("<a href='download.jsp?fileName="+file.getName()+"'>"+fileName+"</a>");
				out.print("</p>");
				
			}
		}
	}
	/*  향상된 for문으로 사용 가능하다.
		for(FileItem item :fileItems){
			if(item.isFormField()){
				
				fileName = item.getFieldName();
				value = item.getString("utf-8");
				out.print("<h3>일반 데이터</h3>");
				out.print(fieldName+" : "+value+"<br>");
				
			}else{ // type= file 로 넘어오는 작업
				fieldName =item.getFieldName();
				fileName = item.getName();
				long size = item.getSize();
				value = item.getString("utf-8");
				out.print("<h3>파일 데이터</h3>");
				out.print(fieldName+" : "+fileName+"<br>");
				out.print("파일 크기 : "+size);
				
			}
		} */
		
%>
</body>
</html>