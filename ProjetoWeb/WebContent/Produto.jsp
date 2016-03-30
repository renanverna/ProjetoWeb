<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@page import="transferobject.ProdutoTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="NewEstiloConsult.css">
<title>Controller REMAP</title>
</head>
<body>
	
<center><table border="11px" id="tformproduto" width="20%"><td id="tformproduto2" width="102%;"></center><br>
Id:  <input type="text" value=${Produto.id} style="width:230px"/></br>
Descricao:  <input type="text" value=${Produto.descricao} style="width:230px"/></br>
Valor Compra:  <input type="text"  value=${Produto.valor_compra} style="width:230px" /></br>
Valor Venda:  <input type="text"  value=${Produto.valor_venda} style="width:230px" /></br>
Quantidade:  <input type="text"  value=${Produto.quantidade_estoque} style="width:230px"/></br>
</center></br></td></table></form></br></center>
	
	
</body>
</html>