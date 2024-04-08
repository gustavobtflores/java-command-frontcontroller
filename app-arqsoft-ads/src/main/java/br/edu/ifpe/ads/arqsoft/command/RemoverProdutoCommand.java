package br.edu.ifpe.ads.arqsoft.command;

import br.edu.ifpe.ads.arqsoft.domain.entity.Produto;
import br.edu.ifpe.ads.arqsoft.repository.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoverProdutoCommand implements Command {

    String pagina = "./WEB-INF/views/produto/lista_produtos.jsp";
    private DAO<Produto> dao;
    public RemoverProdutoCommand(DAO dao) {
        this.dao = dao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        var id = request.getParameter("id");
        System.out.println(id);
        this.dao.remover(Long.valueOf(id));
        request.setAttribute("listaDeProdutos", this.dao.listarTodos());

        return pagina;
    }

}
