package br.edu.ifpe.ads.arqsoft.testdrive;

import br.edu.ifpe.ads.arqsoft.repository.infra.Database;
import br.edu.ifpe.ads.arqsoft.repository.infra.DatabasePostgreSQL;

public class ConnectionTestDrive {

	public static void main(String[] args) {

		
		Database db = new DatabasePostgreSQL();
		
		System.out.println((db.connect() != null? "conectado":"não conectado! lascou-se!"));
	}

}
