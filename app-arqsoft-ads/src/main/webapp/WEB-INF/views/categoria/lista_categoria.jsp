<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="br.edu.ifpe.ads.arqsoft.domain.entity.Produto"%>

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
		<% List<Produto> produtos = (List<Produto>) request.getAttribute("listaDeProdutos"); %>
		<% for (Produto p: produtos){ %>
			<tr>				
				<td><%= p.getNome() %></td>
				<td><%= p.getDescricao() %></td>
				<td><%= p.getPreco() %></td>
				<td><a href="./produtos?acao=editar&id=<%=p.getId()%>">Editar</a></td>
				<td><a href="./produtos?acao=remover&id=<%=p.getId()%>">Remover</a></td>

			</tr>
		<% } %>
		</tbody>
	</table>
</body>
</html>