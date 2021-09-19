<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <%@include file='elementos/bootstrap5.html' %>
    
	<title>Informações do Produto | ArtDigital</title>
</head>
<body>
    <%@include file='elementos/Header.jsp' %>

	<main>
		<div class="container px-5 py-1">
			<div class="d-flex flex-xl-row flex-column justify-content-center p-3" style="background-color: #c8d9ed; border-radius: 15px 15px 0px 0px">
				<div class="m-3" style="object-fit: cover; border-radius: 15px;">
					<img src="./img/imagem3.jpeg"
						style="object-fit: cover; border-radius: 15px;"
						height="400px" width="400px"
						alt="Foto do produto">
				</div>
				<div class="m-3 p-4 w-100" style="background-color: #c2c2c2; border-radius: 15px;">
					<div class="d-flex flex-md-row flex-column justify-content-between">
						<h3>Nome do Produto 1</h3>
						<h3>R$ 10,00</h3>
					</div>
					<div class="d-flex flex-column">
						<p>Nome da pessoa quem postou</p>
						<h3>Descrição</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget ligula eu lectus lobortis condimentum. Aliquam nonummy auctor massa. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla at risus. Quisque purus magna, auctor et, sagittis ac, posuere eu, lectus. Nam mattis, felis ut adipiscing.</p>
					</div>
				</div>
			</div>
			<div class="d-flex flex-md-row justify-content-end w-100" style="height: 90px; background-color: #c2c2c2;">
				<button class="btn border border-2 border-dark my-4" style="background-color: #2bb5f0; width: 150px; border-radius: 20px">Comprar</button>
            	<button class="btn border border-2 border-dark my-4 mx-5" style="background-color: #e9b4b4; width: 200px; border-radius: 20px">Adicionar ao carrinho</button>
			</div>
		</div>
	</main>
	
	<%@include file='elementos/footer.html' %>
</body>
</html>