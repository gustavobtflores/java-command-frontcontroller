package br.edu.ifpe.ads.arqsoft.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoProdutoCommand implements Command {

	
	String pagina = "./WEB-INF/views/produto/cadastrar_produto.jsp";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("COMANDO NOVO PRODUTO");
		return pagina;
	}

}
