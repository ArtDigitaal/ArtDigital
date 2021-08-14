<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <%@include file='elementos/bootstrap5.html' %>
    
	<title>Recuperar Senha | ArtDigital</title>
</head>
<body>
    <%@include file='elementos/Header.jsp' %>
	
	<script>
		function mostrarCampos() {
			var emailInput = document.getElementById('emailInput').value;
			
			if (emailInput === "" || emailInput.includes(" ")) {
				window.alert("Digite um email válido");
				return;
			}
			
			window.alert("Codigo enviado por email. Verifique sua caixa de entrada");
			
			document.getElementById('codigoInput').removeAttribute("hidden");
			document.getElementById('btnPronto').removeAttribute("disabled");
			
			document.getElementById('btnEnviarCodigo').textContent = "Reenviar o código";
		}
		
		
	</script>

	<main>
		<div class="container p-5">
			<div class="text-center">
	          <h1>Recuperar Senha</h1>
	          <p>Digite o email para enviarmos um link de recuperação de senha!</p>
	        </div>
	        <form action="" method="post" class="row g-3 justify-content-center mx-auto" style="max-width: 500px;">
	          <div class="col-md-12">
	            <input type="email" class="form-control" id="emailInput" placeholder="Email">
	          </div>
	          <div class="col-md-12">
	            <input type="text" class="form-control" id="codigoInput" placeholder="Código de recuperação" hidden required>
	          </div>
	          <div class="col-md-12 text-center">
	          	<a href="#" id="btnEnviarCodigo" class="text-decoration-none" onclick="mostrarCampos()">Enviar o código</a>
	          </div>
	          <div class="col-12">
	            <div class="d-grid gap-2 d-md-flex justify-content-md-center">
	              <button class="btn btn-outline-secundary" onclick="history.back()">Voltar</button>
	              <button type="submit" class="btn btn-outline-primary" id="btnPronto" disabled>Pronto</button>
	            </div>
	          </div>
	        </form>
		</div>
	</main>
	
	<%@include file='elementos/footer.html' %>
</body>
</html>