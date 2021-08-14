<%@page import="Usuario.Usuario"%>
<body>
	<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between p-3 mb-4 border-bottom">
	      <a href="./index.jsp" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
	        <img src="./img/logo.png" alt="" height="30">
	      </a>
	  
	      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
	        <li><a class="nav-link px-2 link-dark" aria-current="page" href="./index.jsp">Inicio</a></li>
	        <li>
	          <a class="nav-link px-2 link-dark dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Categorias
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="#">Categoria 1</a></li>
	            <li><a class="dropdown-item" href="#">Categoria 2</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="#">Alguma coisa</a></li>
	          </ul>
	        </li>
	        <li><a href="#" class="nav-link px-2 link-dark">FAQs</a></li>
	        <li><a href="#" class="nav-link px-2 link-dark">Sobre</a></li>
	      </ul>
	      <div class="col-md-3 text-end">
		  	<%
			if (session.getAttribute("usuarioValidado") != null) {
				Usuario headerLogin = (Usuario) session.getAttribute("usuarioValidado");
		  		%>
		  		<a class="btn btn-secundary" href="./MinhaConta.jsp" role="button" id="headerButtonLogin"><%=headerLogin.getNome() %></a>
	        	<a class="btn btn-outline-primary" href="./processamentos/RealizarLogout.jsp" role="button" id="headerButtonLogin">Sair</a>
		        <%
			} else {
		  		%>
		        <a class="btn btn-outline-primary" href="./Login.jsp" role="button" id="headerButtonLogin">Entrar</a>
		        <a class="btn btn-primary" href="./Cadastro.jsp" role="button" id="headerButtonSignup">Cadastrar</a>
		        <%
			}
	        %>
	      </div>
	    </header>
</body>
</html>