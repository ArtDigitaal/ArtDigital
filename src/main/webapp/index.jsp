<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <%@include file='elementos/bootstrap5.html' %>
    
    <title>Início | ArtDigital</title>
</head>
<body>
    <%@include file='elementos/header.jsp' %>
    
    <main class="flex-shrink-0">
      <div class="container px-5 py-1">
        <div>
          <form class="d-flex">
            <input class="form-control me-2" style="border-radius: 0px; background-color: #c2c2c2" type="search" placeholder="Pesquisar" aria-label="Search">
            <button class="btn btn-primary" style="border-radius: 0px" type="submit">Pesquisar</button>
          </form>
        </div>
        <div>
        	<p>Resultados (999)</p>
        </div>
        
        <div class="row">
        	<div class="col-12 col-md-6 col-lg-4" >
				<div class="p-3 my-3" style="background-color: #c8d9ed; border-radius: 15px">
					<img src="./img/imagem3.jpeg"
							style="object-fit: cover; border-radius: 15px;"
							height=300px width=100%
							alt="Foto do produto">
					<a href="./produto.jsp?id=1" style="color: black; text-decoration: none">
						<div class="d-flex flex-row justify-content-between m-2">
							<h5>Nome do Produto</h5>
							<h5>R$ 10,00</h5>
						</div>
					</a>
					<div class="d-flex flex-row justify-content-center">
						<button class="btn btn-primary mx-2">Comprar</button>
						<button class="btn btn-outline-primary mx-2">Adicionar ao carrinho</button>
					</div>
				</div>
			</div>
			
			<!-- startsection: Apagar -->
			
			
        	<div class="col-12 col-md-6 col-lg-4" >
				<div class="p-3 my-3" style="background-color: #c8d9ed; border-radius: 15px">
					<img src="./img/imagem3.jpeg"
							style="object-fit: cover; border-radius: 15px;"
							height=300px width=100%
							alt="Foto do produto">
					<a href="./produto.jsp?id=1" style="color: black; text-decoration: none">
						<div class="d-flex flex-row justify-content-between m-2">
							<h5>Nome do Produto</h5>
							<h5>R$ 10,00</h5>
						</div>
					</a>
					<div class="d-flex flex-row justify-content-center">
						<button class="btn btn-primary mx-2">Comprar</button>
						<button class="btn btn-outline-primary mx-2">Adicionar ao carrinho</button>
					</div>
				</div>
			</div>
        	<div class="col-12 col-md-6 col-lg-4" >
				<div class="p-3 my-3" style="background-color: #c8d9ed; border-radius: 15px">
					<img src="./img/imagem3.jpeg"
							style="object-fit: cover; border-radius: 15px;"
							height=300px width=100%
							alt="Foto do produto">
					<a href="./produto.jsp?id=1" style="color: black; text-decoration: none">
						<div class="d-flex flex-row justify-content-between m-2">
							<h5>Nome do Produto</h5>
							<h5>R$ 10,00</h5>
						</div>
					</a>
					<div class="d-flex flex-row justify-content-center">
						<button class="btn btn-primary mx-2">Comprar</button>
						<button class="btn btn-outline-primary mx-2">Adicionar ao carrinho</button>
					</div>
				</div>
			</div>
        	<div class="col-12 col-md-6 col-lg-4" >
				<div class="p-3 my-3" style="background-color: #c8d9ed; border-radius: 15px">
					<img src="./img/imagem3.jpeg"
							style="object-fit: cover; border-radius: 15px;"
							height=300px width=100%
							alt="Foto do produto">
					<a href="./produto.jsp?id=1" style="color: black; text-decoration: none">
						<div class="d-flex flex-row justify-content-between m-2">
							<h5>Nome do Produto</h5>
							<h5>R$ 10,00</h5>
						</div>
					</a>
					<div class="d-flex flex-row justify-content-center">
						<button class="btn btn-primary mx-2">Comprar</button>
						<button class="btn btn-outline-primary mx-2">Adicionar ao carrinho</button>
					</div>
				</div>
			</div>
        	<div class="col-12 col-md-6 col-lg-4" >
				<div class="p-3 my-3" style="background-color: #c8d9ed; border-radius: 15px">
					<img src="./img/imagem3.jpeg"
							style="object-fit: cover; border-radius: 15px;"
							height=300px width=100%
							alt="Foto do produto">
					<a href="./produto.jsp?id=1" style="color: black; text-decoration: none">
						<div class="d-flex flex-row justify-content-between m-2">
							<h5>Nome do Produto</h5>
							<h5>R$ 10,00</h5>
						</div>
					</a>
					<div class="d-flex flex-row justify-content-center">
						<button class="btn btn-primary mx-2">Comprar</button>
						<button class="btn btn-outline-primary mx-2">Adicionar ao carrinho</button>
					</div>
				</div>
			</div>
			
			<!-- endsection: Apagar -->
        </div>
      </div>
    </main>

    <%@include file='elementos/footer.html' %>
</body>
</html>