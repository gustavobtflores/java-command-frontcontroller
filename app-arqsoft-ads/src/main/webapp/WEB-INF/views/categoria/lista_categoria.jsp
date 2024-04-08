<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="br.edu.ifpe.ads.arqsoft.domain.entity.Categoria" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Produtos</title>
</head>
<body>
	<h1>Lista Produtos</h1>
	<table border="1">
		<thead>
			<tr>
				<td>nome</td>
				<td>descrição</td>
				<td>preço</td>
				<td colspan="2">ações</td>
			</tr>
		</thead>
		<tbody>
		<% List<Categoria> categorias = (List<Categoria>) request.getAttribute("listaDeCategorias"); %>
		<% for (Categoria c: categorias){ %>
			<tr>				
				<td><%= c.getNome() %></td>
				<td><%= c.getDescricao() %></td>
				<td><a href="./controller?acao=editarCategoria&id=<%=c.getId()%>">Editar</a></td>
				<td><a href="./controller?acao=removerCategoria&id=<%=c.getId()%>">Remover</a></td>

			</tr>
		<% } %>
		</tbody>
	</table>
</body>
</html>