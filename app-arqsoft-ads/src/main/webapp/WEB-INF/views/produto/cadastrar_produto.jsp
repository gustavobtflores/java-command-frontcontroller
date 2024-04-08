<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifpe.ads.arqsoft.domain.entity.Produto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Cadastro de Produto</h1>
	</div>
	<div style="margin-top: 10px">
		<form action="/app-arqsoft-ads/controller?acao=salvarProduto" method="post">
		<%Produto produto = (Produto)request.getAttribute("produto"); %>
		<input type="hidden" id="acao" name="acao" value="salvarProduto">
		<input type="hidden" id="id" name="id" value=<%=(produto!=null ? produto.getId() : "")%>>
			<div>
				<label for="nome">Nome:</label> <input type="text" id="nome"
					name="nome"  value="<%=(produto!=null?produto.getNome():"") %>"/>
			</div>

			<div style="margin-top: 10px">
				<label for="descricao">Descrição:</label> <input type="text"
					id="descricao" name="descricao" value="<%=(produto!=null?produto.getDescricao():"") %>" />
			</div>

			<div style="margin-top: 10px">
				<label for="preco">Preço:</label> <input type="number" id="preco"
					name="preco" value=<%=(produto!=null?produto.getPreco():"") %> />
			</div>
			<div style="margin-top: 10px">
				<button>Enviar</button>
			</div>
		</form>
	</div>
</body>
</html>