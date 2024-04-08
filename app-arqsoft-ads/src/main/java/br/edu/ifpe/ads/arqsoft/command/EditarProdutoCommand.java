package br.edu.ifpe.ads.arqsoft.command;

import br.edu.ifpe.ads.arqsoft.domain.entity.Produto;
import br.edu.ifpe.ads.arqsoft.repository.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarProdutoCommand implements Command {
    String pagina = "./WEB-INF/views/produto/cadastrar_produto.jsp";

    private DAO<Produto> dao;
    public EditarProdutoCommand(DAO dao) {
        this.dao = dao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        var id = Long.valueOf(request.getParameter("id"));
        request.setAttribute("produto", this.dao.pegaPorId(id));

        return pagina;
    }
}
