package br.edu.ifpe.ads.arqsoft.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpe.ads.arqsoft.command.Command;
import br.edu.ifpe.ads.arqsoft.domain.entity.Categoria;
import br.edu.ifpe.ads.arqsoft.domain.entity.Produto;
import br.edu.ifpe.ads.arqsoft.repository.DAO;

public class CadastrarCategoriaCommand implements Command {

	private final String pagina = "http://localhost:8080/app-arqsoft-ads/controller?acao=listarCategorias";
	private DAO<Categoria> dao;
	
	
	public CadastrarCategoriaCommand(DAO dao) {
		this.dao = dao;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		var id = request.getParameter("id");
		var nome = request.getParameter("nome");
		var categoria = new Categoria(nome);
		categoria.setDescricao(request.getParameter("descricao"));
		this.dao.salvar(categoria);
		return pagina;
	}

}
