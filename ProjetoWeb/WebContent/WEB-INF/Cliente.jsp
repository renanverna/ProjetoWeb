<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="transferobject.ProdutoTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produto</title>
</head>
<body>
	<%ProdutoTO to = (ProdutoTO)request.getAttribute("produto"); %>
	Id: <%=to.getId() %><br>
	Descrição: <%=to.getDescricao() %><br>
	Valor_compra: <%=to.getValor_compra() %><br>
	Valor_Venda: <%=to.getValor_venda() %><br>
</body>
</html>