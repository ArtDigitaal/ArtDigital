<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <%@include file='elementos/bootstrap5.html' %>
    
    <title>Entrar | ArtDigital</title>
</head>
<body>
    <%@include file='elementos/Header.jsp' %>
    
    <script type="text/javascript">
    	document.getElementById('headerButtonLogin').classList.add("disabled");
    </script>
    
    <main class="flex-shrink-0">
      <div class="container p-5">
        <div class="text-center">
          <h1>Entrar</h1>
          <p>Digite suas credenciais para entrar no sistema!</p>
        </div>
        <form action="./processamentos/ProcessarLogin.jsp" method="post" class="row g-3 justify-content-center mx-auto" style="max-width: 500px;">
          <div class="col-md-12">
            <input type="email" class="form-control" id="emailInput" name="emailInput" placeholder="Email" required>
          </div>
          <div class="col-md-12">
            <input type="password" class="form-control" id="passwordInput" name="passwordInput" placeholder="Senha" required>
          </div>
          <div class="col-md-12 text-center">
          	<a href="./RecuperarSenha.jsp" class="text-decoration-none">Esqueci minha senha!</a>
          </div>
          <div class="col-12">
            <div class="d-grid gap-2 d-md-flex justify-content-md-center">
              <button class="btn btn-outline-secundary" onclick="history.back()">Voltar</button>
              <button type="submit" class="btn btn-outline-primary">Continuar</button>
            </div>
          </div>
        </form>
      </div>
    </main>

    <%@include file='elementos/footer.html' %>
</body>
</html>