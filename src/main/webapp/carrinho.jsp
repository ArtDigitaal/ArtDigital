<%@page import="entity.Produto"%>
<%@page import="java.util.List"%>
<%@page import="entity.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<%@include file='elementos/bootstrap5.html' %>
		<title>Carrinho | ArtDigital</title>
	</head>
	<body>
	<%
	if (session.getAttribute("usuarioValidado") != null) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioValidado");
		
		List<Produto> produtos = usuario.getCarrinho().getProdutos();
		
		for (Produto produto: produtos) {
			out.print(produto.getNome());
		}
	}
	else {
		response.sendRedirect("login.jsp");
	}
	%>
	</body>
</html>