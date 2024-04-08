package br.edu.ifpe.ads.arqsoft.command;

import br.edu.ifpe.ads.arqsoft.domain.entity.Categoria;
import br.edu.ifpe.ads.arqsoft.repository.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarCategoriaCommand implements Command {
    String pagina = "./WEB-INF/views/categoria/cadastrar_categoria.jsp";

    private DAO<Categoria> dao;
    public EditarCategoriaCommand(DAO dao) {
        this.dao = dao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        var id = Long.valueOf(request.getParameter("id"));
        request.setAttribute("categoria", this.dao.pegaPorId(id));

        return pagina;
    }
}
