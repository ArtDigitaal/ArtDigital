<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="Usuario.UsuarioDAO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
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
	String nome = (String) request.getParameter("inputName");
	String rua = (String) request.getParameter("addressInput");
	String cep = (String) request.getParameter("inputZip");
	int numero = 0;
	String cidade = (String) request.getParameter("cityInput");
	
	try {
		numero = Integer.parseInt(request.getParameter("numberInput"));
	} catch (Exception e) {
		numero = 0;
	}
	
	/* Processando data de nascimento */
	
	String inputDate = (String) request.getParameter("inputDate");
	String[] arrayDate = inputDate.split("-");
	
	Date dataNasc = Date.valueOf(LocalDate.of(
		Integer.parseInt(arrayDate[0]),
		Integer.parseInt(arrayDate[1]),
		Integer.parseInt(arrayDate[2])
	));
	
	Object usuarioValidado = session.getAttribute("usuarioValidado");

	if (usuarioValidado != null) {
		Usuario usuario = (Usuario) usuarioValidado;
		
		usuario.setNome(nome);
		usuario.setRua(rua);
		usuario.setCep(cep);
		usuario.setNumero(numero);
		usuario.setCidade(cidade);
		usuario.setDataNasc(dataNasc);
		
		if (UsuarioDAO.atualizarUsuario(usuario)) {
			out.print(String.format("alert('Usuario %s atualizado com sucesso!')", usuario.getNome()));
		} else {
			out.print("alert('Falha ao atualizar usuario.')");
		}
	}
	%>
	window.location = '../MinhaConta.jsp';
</script>
</body>
</html>