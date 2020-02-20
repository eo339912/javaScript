<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>getData.jsp</title>
</head>
<body>
	<%
	
		String name = request.getParameter("name");
        String major = request.getParameter("major");
        String sex = request.getParameter("sex");
		out.print("이름: " + name);
		out.print("전공: " + major);
		out.print("성별 :" + sex);
	%>
</body>
</html>