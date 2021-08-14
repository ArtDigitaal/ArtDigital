<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<%@include file='elementos/bootstrap5.html' %>

    <title>Cadastro | ArtDigital</title>
</head>
<body>
    <%@include file='elementos/Header.jsp' %>
    
    <script type="text/javascript">
    	document.getElementById('headerButtonSignup').classList.add("disabled");
    	
    	function trocarLabel($i) {
    		var inputCpfCnpj = document.getElementById('inputCpfCnpj');
    		
    		inputCpfCnpj.placeholder = $i;
    		
    		if (inputCpfCnpj.hasAttribute('disabled')) {
    			inputCpfCnpj.removeAttribute('disabled');
    		} 
    		
    		if ($i === 'CPF') {
    			inputCpfCnpj.pattern = ".{11,11}";
    			inputCpfCnpj.title = "O campo CPF deve ter 11 dígitos e sem pontuação"
    		} else if ($i === 'CNPJ') {
    			inputCpfCnpj.pattern = ".{14,14}";
    			inputCpfCnpj.title = "O campo CNPJ deve ter 14 dígitos e sem pontuação"
    		}
    	}
    	
    	function submeterCadastro() {
    		// Validando campos com espaço
    		if (verificarCamposComEspaco(['inputCpfCnpj', 'emailInput', 'inputZip'])) {
    			return;
    		}
    		
    		if (document.getElementById('inputCpfCnpj').hasAttribute('disabled')) {
    			alert('O campo CPF/CNPJ deve ser preenchido!');
    			return;
    		}
    		
    		// Validando e submetendo formulário 
    		document.getElementById('formularioCadastro').requestSubmit();
    	}
    	
    	function verificarCamposComEspaco($param) {
    		for (let i = 0; i < $param.length; i++) {
    			var element  = document.getElementById($param[i]);
    			element.value = element.value.trim();
    			
    			if (element.value.includes(' ')) {
   					alert('O campo '+ element.placeholder +' não pode ter espaços!');
   					return true;
    			}
    		}
    		return false;
		}
    </script>
    
    <main>
      <div class="container p-5">
        <div class="text-center">
          <h1>Cadastro</h1>
          <p>Digite abaixo os dados de usuário à ser cadastrado no sistema!</p>
        </div>
        <form id="formularioCadastro" action="./processamentos/ProcessarCadastro.jsp" method="post" class="row g-3 justify-content-center mx-auto" style="max-width: 750px;">
          <label class="form-label">Informações de Usuario</label>
          <div class="col-md-12">
            <input type="text" class="form-control" id="inputName" name="inputName" placeholder="Nome" onblur="" required>
          </div>
          <div class="col-md-2">
            <select id="inputAccountType" name="inputAccountType" class="form-control" onchange="trocarLabel(value);">
              <option selected disabled value="Escolha">Escolha</option>
              <option value="CPF">CPF</option>
              <option value="CNPJ">CNPJ</option>
            </select>
          </div>
          <div class="col-md-6">
            <input type="text" class="form-control" id="inputCpfCnpj" name="inputCpfCnpj" placeholder="CPF/CNPJ" required pattern="" title="" disabled>
          </div>
          <div class="col-md-4">
          	<input class="form-control" id="inputDate" name="inputDate" type="date" placeholder="Nascimento" required>
          </div>
          <div class="col-md-8">
            <input type="email" class="form-control" id="emailInput" name="emailInput" placeholder="Email" required>
          </div>
          <div class="col-md-4">
            <input type="password" class="form-control" id="passwordInput" name="passwordInput" placeholder="Senha" required pattern=".{8,}" title="A senha deve ter mais de 8 caracteres!">
          </div>
          <label class="form-label">Informações de Endereço</label>
          <div class="col-10">
            <input type="text" class="form-control" id="addressInput" name="addressInput" placeholder="Rua">
          </div>
          <div class="col-2">
            <input type="number" class="form-control" id="numberInput" name="numberInput" placeholder="Número">
          </div>
          <div class="col-md-8">
            <input type="text" class="form-control" id="cityInput" name="cityInput" placeholder="Cidade" required>
          </div>
          <div class="col-md-4">
            <input type="text" class="form-control" id="inputZip" name="inputZip" placeholder="CEP" required pattern=".{8,8}" title="O campo CEP deve ter 8 dígitos e sem pontuação">
          </div>
          <div class="col-12">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" id="gridCheck" name="gridCheck" required>
              <label class="form-check-label" for="gridCheck">
                Confirmo que meus dados foram digitados corretamente!
              </label>
            </div>
          </div>
          <div class="col-12">
            <div class="d-grid gap-2 d-md-flex justify-content-md-center">
              <a href="#" class="btn btn-secundary" onclick="history.back()">Voltar</a>
              <a href="#" class="btn btn-primary" onclick="submeterCadastro()">Continuar</a>
            </div>
          </div>
        </form>
      </div>
    </main>

    <%@include file='elementos/footer.html' %>
</body>
</html>