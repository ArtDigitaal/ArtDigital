<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <%@include file='elementos/bootstrap5.html' %>
    
    <title>ArtDigital</title>
</head>
<body>
    <%@include file='elementos/Header.jsp' %>
    
    <main class="flex-shrink-0">
      <div class="container p-5">
        <div>
          <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
          </form>
        </div>

        <div class="album py-5">
          <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
              <!-- Album de Items -->
              <div class="col">
                <div class="card shadow-sm">
                  <img alt="Nome Produto 1" src="./img/imagem3.jpeg" class="card-img-top"  height="300px">
                  <div class="card-body">
                  	<a href="./Produto.jsp?id=1" class="text-decoration-none">
                  		<h5 class="card-title">Nome Produto 1</h5>
                  	</a>
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      <div class="btn-group" >
                        <button type="button" class="btn btn-sm btn-outline-secondary" width:"250%">Comprar</button>
                        <button type="button" class="btn btn-sm btn-outline-secondary">Carrinho</button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col">
                <div class="card shadow-sm">
                  <img alt="Nome Produto 2" src="./img/imagem4.jpeg" class="card-img-top" height="300px">
                  <div class="card-body">
                  	<h5 class="card-title">Nome Produto 2</h5>
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      <div class="btn-group" >
                        <button type="button" class="btn btn-sm btn-outline-secondary" width:"250%">Comprar</button>
                        <button type="button" class="btn btn-sm btn-outline-secondary">Carrinho</button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col">
                <div class="card shadow-sm">
                  <img alt="Nome Produto 3" src="./img/imagem5.jpeg" class="card-img-top" height="300px">
                  <div class="card-body">
                  	<h5 class="card-title">Nome Produto 3</h5>
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      <div class="btn-group" >
                        <button type="button" class="btn btn-sm btn-outline-secondary" width:"250%">Comprar</button>
                        <button type="button" class="btn btn-sm btn-outline-secondary">Carrinho</button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col">
                <div class="card shadow-sm">
                  <img alt="Nome Produto 4" src="./img/imagem6.jpeg" class="card-img-top" height="300px">
                  <div class="card-body">
                  	<h5 class="card-title">Nome Produto 4</h5>
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      <div class="btn-group" >
                        <button type="button" class="btn btn-sm btn-outline-secondary" width:"250%">Comprar</button>
                        <button type="button" class="btn btn-sm btn-outline-secondary">Carrinho</button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
          </div>
        </div>
      </div>
    </main>

    <%@include file='elementos/footer.html' %>
</body>
</html>