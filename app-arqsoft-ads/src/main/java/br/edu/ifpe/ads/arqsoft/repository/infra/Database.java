package br.edu.ifpe.ads.arqsoft.repository.infra;

import java.sql.Connection;

public interface Database {
	Connection connect();
	void close(Connection conn);
}
