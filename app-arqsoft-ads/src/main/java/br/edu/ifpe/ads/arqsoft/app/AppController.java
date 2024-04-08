package br.edu.ifpe.ads.arqsoft.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpe.ads.arqsoft.command.CadastrarProdutoCommand;
import br.edu.ifpe.ads.arqsoft.command.Command;
import br.edu.ifpe.ads.arqsoft.command.NovaCategoriaCommand;
import br.edu.ifpe.ads.arqsoft.command.NovoProdutoCommand;
import br.edu.ifpe.ads.arqsoft.domain.entity.Produto;
import br.edu.ifpe.ads.arqsoft.repository.CategoriaDAO;
import br.edu.ifpe.ads.arqsoft.repository.DAO;
import br.edu.ifpe.ads.arqsoft.repository.ProdutoDAO;
import br.edu.ifpe.ads.arqsoft.repository.infra.DatabaseFactory;
import br.edu.ifpe.ads.arqsoft.repository.infra.DatabasePostgreSQL;

/**
 * Servlet implementation class ProdutoController
 */
@WebServlet("/controller")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Produto> produtos = new ArrayList<>();
	private DatabasePostgreSQL conexao = DatabaseFactory.getPostgreDBConnection();
	private DAO daoProduto= 
			new ProdutoDAO(conexao);
	private DAO daoCategoria = new CategoriaDAO(conexao);
	private Map<String,Command> comandos = new HashMap<String,Command>();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppController() {
        super();
        //produtos
        comandos.put("salvarProduto", new CadastrarProdutoCommand(daoProduto));
        comandos.put("novoProduto", new NovoProdutoCommand());
        
        //categorias
        comandos.put("salvarCategoria", new CadastrarCategoriaCommand(daoCategoria));
        comandos.put("novaCategoria", new NovaCategoriaCommand());
        
    }

	private DAO CategoriaDAO(DatabasePostgreSQL conexao2) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var acao = request.getParameter("acao");
		Command command = this.comandos.get(acao);
		String pagina = command.execute(request, response);
		request.getRequestDispatcher(pagina).forward(request, response);

		
		
//		if(acao.equalsIgnoreCase("listar")) {
//		var produtos = 	this.dao.listarTodos();
//		System.out.println("PRODUTOS "+produtos);
//			request.setAttribute("listaDeProdutos", produtos);
//			request.getRequestDispatcher("./WEB-INF/views/produto/lista_produtos.jsp").forward(request, response);
//		}  else if(acao.equalsIgnoreCase("editar")) {
//			var idProduto = Long.parseLong(request.getParameter("id"));
//			var produto = this.dao.pegaPorId(idProduto);
//			request.setAttribute("produto",produto);
//			request.getRequestDispatcher("./WEB-INF/views/produto/cadastrar_produto.jsp")
//			.forward(request, response);
//
//		}else if(acao.equalsIgnoreCase("remover")) {
//			var idProduto = Long.parseLong(request.getParameter("id"));
//
//			this.dao.remover(idProduto);
//			response.sendRedirect("http://localhost:8080/app-arqsoft-ads/produtos?acao=listar");
//		}
//		System.out.println("Ação, "+acao+"!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		if(!id.equals("")) {
//			produto.setId(Long.parseLong(id));
//			dao.atualizar(produto);
//			}
//		else {
//			dao.salvar(produto);//salva produto no BD
//		produtos.add(produto);//salva produto numa lista local(in-memory)
		var acao = request.getParameter("acao"); //Retorna salvarProduto
		Command command = this.comandos.get(acao);
		String pagina = command.execute(request, response);
		
		response.sendRedirect(pagina);
		}
		
	

}
