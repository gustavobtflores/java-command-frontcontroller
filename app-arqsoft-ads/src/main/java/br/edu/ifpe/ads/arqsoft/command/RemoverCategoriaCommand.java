package br.edu.ifpe.ads.arqsoft.command;

import br.edu.ifpe.ads.arqsoft.domain.entity.Categoria;
import br.edu.ifpe.ads.arqsoft.repository.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoverCategoriaCommand implements Command {

    String pagina = "./WEB-INF/views/categoria/lista_categoria.jsp";
    private DAO<Categoria> dao;
    public RemoverCategoriaCommand(DAO dao) {
        this.dao = dao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        var id = request.getParameter("id");
        System.out.println(id);
        this.dao.remover(Long.valueOf(id));
        request.setAttribute("listaDeCategorias", this.dao.listarTodos());

        return pagina;
    }

}
