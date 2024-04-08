package br.edu.ifpe.ads.arqsoft.app;

import br.edu.ifpe.ads.arqsoft.command.*;
import br.edu.ifpe.ads.arqsoft.domain.entity.Produto;
import br.edu.ifpe.ads.arqsoft.repository.CategoriaDAO;
import br.edu.ifpe.ads.arqsoft.repository.DAO;
import br.edu.ifpe.ads.arqsoft.repository.ProdutoDAO;
import br.edu.ifpe.ads.arqsoft.repository.infra.DatabaseFactory;
import br.edu.ifpe.ads.arqsoft.repository.infra.DatabasePostgreSQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class ProdutoController
 */
@WebServlet("/controller")
public class AppController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final List<Produto> produtos = new ArrayList<>();
    private final DatabasePostgreSQL conexao = DatabaseFactory.getPostgreDBConnection();
    private final DAO daoProduto =
            new ProdutoDAO(conexao);
    private final DAO daoCategoria = new CategoriaDAO(conexao);
    private final Map<String, Command> comandos = new HashMap<String, Command>();


    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppController() {
        super();
        //produtos
        comandos.put("salvarProduto", new CadastrarProdutoCommand(daoProduto));
        comandos.put("novoProduto", new NovoProdutoCommand());
        comandos.put("listarProdutos", new ListarProdutosCommand(daoProduto));
        comandos.put("editarProduto", new EditarProdutoCommand(daoProduto));
        comandos.put("removerProduto", new RemoverProdutoCommand(daoProduto));

        //categorias
        comandos.put("salvarCategoria", new CadastrarCategoriaCommand(daoCategoria));
        comandos.put("novaCategoria", new NovaCategoriaCommand());
        comandos.put("listarCategorias", new ListarCategoriasCommand(daoCategoria));
        comandos.put("editarCategoria", new EditarCategoriaCommand(daoCategoria));
        comandos.put("removerCategoria", new RemoverCategoriaCommand(daoCategoria));
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var acao = request.getParameter("acao");
        Command command = this.comandos.get(acao);
        String pagina = command.execute(request, response);

        request.getRequestDispatcher(pagina).forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var acao = request.getParameter("acao");
        Command command = this.comandos.get(acao);
        String pagina = command.execute(request, response);

        response.sendRedirect(pagina);
    }
}
