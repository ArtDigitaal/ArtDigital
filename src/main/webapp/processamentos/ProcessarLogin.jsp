<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.List"%>
<%@page import="Usuario.Usuario"%>
<%@page import="Usuario.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Validando Usuario... | ArtDigital</title>
</head>
<body>
	<%
	String email = request.getParameter("emailInput");
	String senha = request.getParameter("passwordInput");
	
	Usuario usuarioValidado = UsuarioDAO.validarUsuarioEmailSenha(email, senha);
	
	if (usuarioValidado == null) {
		%><script>
			alert('Credenciais incorretas ou inexistentes no banco de dados')
			window.history.back();
		</script><%
	} else {
		session.setAttribute("usuarioValidado", usuarioValidado);
		%><script>
			window.location = '../MinhaConta.jsp';
		</script><%
	}
	%>
</script>
</body>
</html>