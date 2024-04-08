package br.edu.ifpe.ads.arqsoft.command;

import br.edu.ifpe.ads.arqsoft.domain.entity.Produto;
import br.edu.ifpe.ads.arqsoft.repository.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarProdutosCommand implements Command {

    String pagina = "./WEB-INF/views/produto/lista_produtos.jsp";
    private DAO<Produto> dao;
    public ListarProdutosCommand(DAO dao) {
        this.dao = dao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("listaDeProdutos", this.dao.listarTodos());
        return pagina;
    }

}
