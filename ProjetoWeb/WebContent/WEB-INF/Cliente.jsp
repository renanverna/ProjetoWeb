<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="to.ClienteTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cliente</title>
</head>
<body>
	<%ClienteTO to = (ClienteTO)request.getAttribute("cliente"); %>
	Id: <%=to.getId() %><br>
	Nome: <%=to.getNome() %><br>
	Fone: <%=to.getFone() %><br>
</body>
</html>