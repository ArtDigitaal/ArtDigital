<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="Usuario.UsuarioDAO"%>
<%@page import="Usuario.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<script>
	<%
	Object usuarioValidado = session.getAttribute("usuarioValidado");

	if (usuarioValidado != null) {
		Usuario usuario = (Usuario) usuarioValidado;
		
		if (UsuarioDAO.deletarUsuario(usuario.getId())) {
			out.print(String.format("alert('Usuario %s deletado com sucesso!')", usuario.getNome()));
		} else {
			out.print(String.format("alert('Erro ao deletar usuario %s!')", usuario.getNome()));
			%>history.back();<%
		}
		
		session.setAttribute("usuarioValidado", null);
	}
	%>
	window.location = '../Login.jsp';
</script>
</body>
</html>