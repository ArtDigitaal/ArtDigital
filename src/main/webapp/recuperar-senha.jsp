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
    <%@include file='elementos/header.jsp' %>
	
	<script>
		function enviarCodigo() {
			var email = document.getElementById('emailInput').value;
			// TODO: Logica de envio do email.
			console.log("Enviando codigo para o email " + email + "...");
			return;
		}
		
		function verificarCodigo(email, codigo) {
			// TODO: L�gica de verifica��o do c�digo.
			console.log("Verificando c�digo " + codigo + " com o email " + email + "...");
			return false;
		}
	
		function continuar() {
			var codigoInput = document.getElementById('codigoInput');
			var emailInput = document.getElementById('emailInput');
			
			if (codigoInput.hasAttribute("disabled")) {
				var emailInputInvalido = emailInput.value === "" ||	emailInput.value.includes(" ") || !(emailInput.value.includes("@") && emailInput.value.includes("."));
				
				if (emailInputInvalido) {
					window.alert("Digite um email v�lido");
					return;
				}
				enviarCodigo();
				window.alert("Enviando c�digo por email. Verifique sua caixa de entrada");
				document.getElementById('codigoInput').removeAttribute("disabled");
				document.getElementById('btnPronto').innerHTML = "Pronto";
				document.getElementById('btnEnviarCodigo').removeAttribute("disabled");
				document.getElementById('btnEnviarCodigo').removeAttribute("hidden");
				return;
			}
			
			if (codigoInput.value === "") {
				window.alert("Codigo enviado por email. Verifique sua caixa de entrada ou Reenvie-o no link abaixo.");
				return;
			}
			
			if (!verificarCodigo(emailInput.value, codigoInput.value)) {
				window.alert("Codigo incorreto")
				return;
			}
			
			// TODO: modal de recupera��o de senha.
    		
			document.getElementById('formulario').submit();
		}
	</script>

	<main>
		<div class="container px-5 py-1">
			<div class="p-3 my-3 mx-auto" 
				style="background-color: #c8d9ed; 
				border-radius: 15px; 
				max-width: 500px;">
				<div class="text-center">
		          <p>Digite o email para enviarmos um c�digo de verifica��o!</p>
		        </div>
		        <form id="formulario" 
			        action="" 
			        method="post" 
			        class="row g-3 justify-content-center mx-auto">
		          <div class="col-md-12">
		            <input type="email" 
		            	class="form-control" 
		            	id="emailInput" 
		            	placeholder="Email">
		          </div>
		          <div class="col-md-12">
		            <input type="text" 
		            	class="form-control" 
		            	id="codigoInput" 
		            	placeholder="C�digo de recupera��o" 
		            	disabled 
		            	required>
		          </div>
		          <div class="col-12">
		            <div class="d-grid gap-2 d-md-flex justify-content-md-center">
		            	<a href="#" class="btn btn-primary" 
			              id="btnPronto" 
			              onclick="continuar()" 
			              >Enviar C�digo</a>
		            </div>
		          </div>
		        </form>
			</div>
			
			<div class="text-center py-2">
	       		<a href="#" 
		       		id="btnEnviarCodigo" 
		       		class="text-decoration-none" 
		       		onclick="enviarCodigo()"
		       		hidden
		       		>Reenviar o c�digo!</a>
	       	</div>
		</div>
	</main>
	
	<%@include file='elementos/footer.html' %>
</body>
</html>