<%@page import="file.FileDTO"%>
<%@page import="file.FileDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.File" %>
    
<% 
    int num = Integer.parseInt(request.getParameter("num"));
	FileDAO dao = new FileDAO();
	FileDTO dto = dao.getFileByNum(num);
	
	if(dto != null) {
		// 지정된 파일 삭제
        File file = new File(application.getRealPath("/files/") +
                             dto.getFname());
		if(file != null) {
			file.delete();
		}
		dao.deleteFile(num);
	}
	
    response.sendRedirect("webhard.jsp");
%>