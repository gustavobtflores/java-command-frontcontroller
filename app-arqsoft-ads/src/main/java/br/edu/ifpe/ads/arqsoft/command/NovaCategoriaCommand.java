package br.edu.ifpe.ads.arqsoft.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaCategoriaCommand implements Command {

	String pagina = "./WEB-INF/views/categoria/cadastrar_categoria.jsp";

	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return pagina;
	}

}
