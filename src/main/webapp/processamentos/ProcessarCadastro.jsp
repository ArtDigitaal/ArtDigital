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
<title>Processando Cadastro...</title>
</head>
<body>
	<%
	String nome = (String) request.getParameter("inputName");
	String email = (String) request.getParameter("emailInput");
	String rua = (String) request.getParameter("addressInput");
	String cep = (String) request.getParameter("inputZip");
	Integer numero = 0;
	String cidade = (String) request.getParameter("cityInput");
	String cpf = null;
	String cnpj = null;
	String senha = (String) request.getParameter("passwordInput");
	
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
	
	/* Processando cpf e cnpj */
	String inputAccountType = (String) request.getParameter("inputAccountType");
	String inputCpfCnpj = (String) request.getParameter("inputCpfCnpj");
	
	if (inputAccountType.equals("CPF")) {
		cpf = inputCpfCnpj;
	} else if (inputAccountType.equals("CNPJ")) {
		cnpj = inputCpfCnpj;
	}
	
	/* Validando usuarios duplicados */
	boolean usuarioExiste = false; 
	
	if (UsuarioDAO.procurarUsuarioPorEmail(email) != null) {
		out.print("<script>alert('Já existe um usuário com este Email! Tente outro.');</script>");
		usuarioExiste = true;
	} else if (UsuarioDAO.procurarUsuarioPorCpf(cpf) != null) {
		out.print("<script>alert('Já existe um usuário com este Cpf! Tente outro.');</script>");
		usuarioExiste = true;
	} else if (UsuarioDAO.procurarUsuarioPorCnpj(cnpj) != null) {
		out.print("<script>alert('Já existe um usuário com este Cnpj! Tente outro.');</script>");
		usuarioExiste = true;
	}
	
	Usuario usuario = new Usuario(
		nome,
		email,
		cep,
		rua,
		numero,
		cidade,
		cpf,
		cnpj,
		dataNasc
	);
	
	if (!usuarioExiste) {
		if (UsuarioDAO.criarUsuario(usuario, senha)) {
			out.print(String.format("<script>alert('Usuario %s cadastrado com sucesso!');</script>", usuario.getNome()));
		} else {
			out.print("<script>alert('Falha ao criar usuario.');</script>");
		}
		%><script>window.location = '../Login.jsp';</script><%
	} else {
		%><script>history.back();</script><%
	}
	%>
</body>
</html>