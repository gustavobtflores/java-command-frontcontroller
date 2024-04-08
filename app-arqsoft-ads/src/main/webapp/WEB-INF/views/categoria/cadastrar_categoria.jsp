<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifpe.ads.arqsoft.domain.entity.Categoria" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ArqSoft2024 - Cadastro de Categorias</title>
</head>
<body>
	<div>
		<h1>Cadastro de Categoria</h1>
	</div>
	<div style="margin-top: 10px">
		<form action="/app-arqsoft-ads/controller" method="post">
		<%Categoria categoria = (Categoria)request.getAttribute("produto"); %>
		
		<input type="hidden" id="acao" name="acao" value="salvarCategoria">
		<input type="hidden" id="id" name="id" value=<%=(categoria!=null ? categoria.getId() : "")%>>
			<div>
				<label for="nome">Nome:</label> <input type="text" id="nome"
					name="nome"  value="<%=(categoria!=null?categoria.getNome():"") %>"/>
			</div>

			<div style="margin-top: 10px">
				<label for="descricao">Descrição:</label> <input type="text"
					id="descricao" name="descricao" value="<%=(categoria!=null?categoria.getDescricao():"") %>" />
			</div>

			
			<div style="margin-top: 10px">
			
			

				<button>Enviar</button>
			</div>
		</form>
	</div>
</body>
</html>