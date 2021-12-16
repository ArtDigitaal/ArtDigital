<%@page import="java.util.List"%>
<%@page import="entity.Categoria"%>
<%@page import="entity.dao.CategoriaDAO"%>
<%@page import="entity.Usuario"%>
<body style="background-image: url('./img/arte5.jpg');">
	<header
		class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between p-3 mb-4 border-bottom"
		style="background-color: #EEDD82; background-image: url('./img/barra2.jpg');">
		
		<div class="container">
			<div class="row">
				<div class="col-sm">
					<a href="./index.jsp"
						class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
						<img src="./img/logo.png" alt="Inicio" height="50">
					</a>
				</div>
				<div class="col-sm">
					<ul
						class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
						<li><a class="nav-link px-2 link-dark dropdown-toggle"
							href="#" id="navbarDropdown" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Categorias </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<%
								List<Categoria> categorias = CategoriaDAO.retornaCategorias();
								for (Categoria cat : categorias) {
								%>
								<li><a class="dropdown-item"
									href="./index.jsp?categoria=<%=cat.getId()%>"><%=cat.getDescricao()%></a></li>
								<%
								}
								%>
							</ul></li>
						<li><a href="./sobre.jsp" class="nav-link px-2 link-dark">Sobre</a></li>
					</ul>
				</div>
				<div class="col-sm">
					<a href="./anunciar.jsp" class="btn border border-dark"
						style="background-color: #CD5C5C; border-radius: 15px; font-weight: bold;">
						Anunciar </a>
				</div>
				<div class="col-sm">
					<div class="col text-end">

						<%
						if (session.getAttribute("usuarioValidado") != null) {
							Usuario headerLogin = (Usuario) session.getAttribute("usuarioValidado");
						%>
						<a class="btn btn-secundary mx-2" style="border-radius: 0px"
							href="./minha-conta.jsp" role="button" id="headerButtonLogin"><%=headerLogin.getNome()%></a>
						<a href="./carrinho.jsp" class="my-2"> <img
							src="./img/cart.png" alt="Carrinho" height="30">
						</a> 
						<a class="btn btn-outline-primary mx-2"
							style="border-radius: 0px"
							href="./processamentos/RealizarLogout.jsp" role="button"
							id="headerButtonLogin">Sair</a>
						<%
						} else {
						%>
						<a class="btn btn-outline-primary mx-2" style="border-radius: 0px"
							href="./login.jsp" role="button" id="headerButtonLogin">Entrar</a>
						<a class="btn btn-primary mx-2" style="border-radius: 0px"
							href="./cadastro.jsp" role="button" id="headerButtonSignup">Cadastrar</a>
						<%
						}
						%>
					</div>
				</div>
			</div>
		</div>
	</header>
</body>
</html>