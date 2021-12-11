<%@page import="java.io.File"%>
<%@page import="entity.dao.CategoriaDAO"%>
<%@page import="entity.dao.ProdutoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="entity.Login"%>
<%@page import="entity.Produto"%>
<%@page import="entity.Imagem"%>
<%@page import="entity.Categoria"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Processando Anuncio...</title>
</head>
<body>

	<%
	String nome = (String) request.getParameter("nomeInput");
	String imagemFileName = (String) request.getParameter("imagemInput");
	String quantidade = (String) request.getParameter("quantidadeInput");
	String preco = (String) request.getParameter("preco");
	String descricao = (String) request.getParameter("descInput");
	
	String categoriaId = (String) request.getParameter("selectInput");
	Categoria categoria = CategoriaDAO.procurarCategoria(Long.parseLong(categoriaId));
	
	Imagem imagem = new Imagem("nu", "nu", "null".getBytes());
	Produto produto = new Produto(descricao, nome, Integer.parseInt(quantidade), Double.parseDouble(preco), categoria, imagem);

	if (ProdutoDAO.cadastrarProduto(produto)) {
		out.print(String.format("<script>alert('Produto %s cadastrado com sucesso!');</script>", produto.getNome()));
	%><script>window.location = '../index.jsp';</script>
	<%
	} else {
	out.print("<script>alert('Falha ao criar produto.');</script>");
	%><!-- <script>history.back();</script> -->
		<%
	}
	%>


</body>
</html>