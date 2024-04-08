package br.edu.ifpe.ads.arqsoft.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpe.ads.arqsoft.domain.entity.Produto;
import br.edu.ifpe.ads.arqsoft.repository.DAO;

public class CadastrarProdutoCommand implements Command{

	private final String pagina = "http://localhost:8080/app-arqsoft-ads/controller?acao=listarProdutos";
	private DAO<Produto> dao;
	public CadastrarProdutoCommand(DAO dao) {
		this.dao = dao;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var id = request.getParameter("id");
		var nome = request.getParameter("nome");
		var preco = request.getParameter("preco");
		var produto = new Produto(nome,Double.valueOf(preco));
		produto.setDescricao(request.getParameter("descricao"));

		if(id.isEmpty() || id.isBlank()) {
			this.dao.salvar(produto);
		} else {
			produto.setId(Long.valueOf(id));
			this.dao.atualizar(produto);
		}

		return pagina;
	}

}
