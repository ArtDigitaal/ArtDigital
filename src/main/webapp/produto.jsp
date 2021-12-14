<%@page import="java.util.Base64"%>
<%@page import="entity.Produto"%>
<%@page import="entity.dao.ProdutoDAO"%>
<%@page import="entity.dao.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <%@include file='elementos/bootstrap5.html' %>
    
	<title>Informa��es do Produto | ArtDigital</title>
</head>
<body>
    <%@include file='elementos/header.jsp' %>

	<%
	Long id = Long.parseLong(request.getParameter("id"));
	Produto produto = ProdutoDAO.procurarProduto(id);
	%>
	<main>
		<div class="container px-5 py-1">
		<% if (produto != null) { %>
			<div class="d-flex flex-lg-row flex-column justify-content-center p-3" style="background-color: #c8d9ed; border-radius: 15px 15px 0px 0px">
				<div class="m-3" style="object-fit: cover; border-radius: 15px;">
					<img src="data:<%= produto.getImagem().getTipo() %>;base64,<%= Base64.getEncoder().encodeToString(produto.getImagem().getBytes()) %>"
						style="object-fit: cover; border-radius: 15px;"
						height=400px width=100%
						alt="Foto do produto">
				</div>
				<div class="m-3 p-4 w-auto" style="background-color: #c2c2c2; border-radius: 15px; min-width: 60%">
					<div class="d-flex justify-content-between">
						<h3><%= produto.getNome() %></h3>
						<h3>R$ <%= String.format("%.2f", produto.getValorUnit()) %></h3>
					</div>
					<div class="d-flex justify-content-between">
						<p><%= produto.getUsuario().getNome() %> - <%= produto.getUsuario().getEmail() %></p>
						<p><%= produto.getQuantidade() %> itens dispon�veis</p>
					</div>
					<div class="d-flex flex-column">
						<h4>Descri��o</h4>
						<p><%= produto.getDescricao() %></p>
					</div>
					<div class="d-flex justify-content-end"><p><%= produto.getCategoria().getDescricao() %></p></div>
				</div>
			</div>
			<div class="d-flex justify-content-md-end justify-content-center w-100" style="height: auto; background-color: #c2c2c2;">
				<button class="btn border border-2 border-dark m-4" 
					style="background-color: #2bb5f0; width: 150px; border-radius: 20px">Comprar</button>
            	<button class="btn border border-2 border-dark m-4" 
            		style="background-color: #e9b4b4; width: 200px; border-radius: 20px">Adicionar ao carrinho</button>
			</div>
		<% } else { %>
			<div class="p-3" style="background-color: #c8d9ed; border-radius: 15px 15px 0px 0px">
				<h3>Produto n�o encontrado</h3>
				<p>Este produto deve ter sido removido pelo anunciante</p>
			</div>
			<div class="d-flex justify-content-md-end justify-content-center w-100" style="height: auto; background-color: #c2c2c2;">
				<button class="btn border border-2 border-dark m-4" 
					style="background-color: #2bb5f0; width: 150px; border-radius: 20px" 
					onclick="history.back()">Voltar</button>
			</div>
		<% } %>
		</div>
	</main>
	
	<%@include file='elementos/footer.html' %>
</body>
</html>