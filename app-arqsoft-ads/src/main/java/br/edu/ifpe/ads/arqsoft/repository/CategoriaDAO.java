package br.edu.ifpe.ads.arqsoft.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.ads.arqsoft.domain.entity.Categoria;
import br.edu.ifpe.ads.arqsoft.domain.entity.Produto;
import br.edu.ifpe.ads.arqsoft.repository.infra.Database;

public class CategoriaDAO implements DAO<Categoria> {

	private Database database;

	private String sqlSelect = "select id,nome,descricao  from categoria";
	private String sqlSelectPorId = "select id,nome,descricao from categoria where id=?";
	private String sqlAtualizar = "update categoria set nome=?,descricao=? where id=?";
	private String sqlRemover = "delete from categoria where id=?";

	public CategoriaDAO(Database database) {
		this.database = database;
	}

	private String sqlInsert = "insert into produto(nome,descricao,preco,id_categoria) values(?,?,?,?)";
	
	public void salvar(Categoria categoria) {
		Connection conexao = this.database.connect();
		try {
			PreparedStatement pstm = conexao.prepareStatement(sqlInsert);
			pstm.setString(1, categoria.getNome());
			pstm.setString(2, categoria.getDescricao());
			pstm.setLong(4, 1);
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			database.close(conexao);
		}
	}

	public List<Categoria> listarTodos() {
		Connection conexao = this.database.connect();

		List<Categoria> categorias = new ArrayList<>();
		PreparedStatement pstm;
		try {
			pstm = conexao.prepareStatement(sqlSelect);

			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {

				var categoria = new Categoria(rs.getString("nome"));
				categoria.setId(rs.getLong("id"));
				categoria.setDescricao(rs.getString("descricao"));
				categorias.add(categoria);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			database.close(conexao);
		}

		return categorias;
	}

	
	public Categoria atualizar(Categoria categoria) {
		Connection conexao = this.database.connect();
		try {
			PreparedStatement pstm = conexao.prepareStatement(sqlAtualizar);
			pstm.setString(1, categoria.getNome());
			pstm.setString(2, categoria.getDescricao());
			pstm.setLong(3, categoria.getId());
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			database.close(conexao);
		}
		return categoria;
	}
	
	public void remover(Long id) {
		Connection conexao = this.database.connect();

		PreparedStatement pstm;
		try {
			pstm = conexao.prepareStatement(sqlRemover);
			pstm.setLong(1,id);
			ResultSet rs = pstm.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			database.close(conexao);
		}

		
	}
	
	public Categoria pegaPorId(Long id) {
		Connection conexao = this.database.connect();

		PreparedStatement pstm;
		try {
			pstm = conexao.prepareStatement(sqlSelectPorId);
			pstm.setLong(1,id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {

				var categoria = new Categoria(rs.getString("nome"));
				categoria.setId(rs.getLong("id"));
				categoria.setDescricao(rs.getString("descricao"));
				return categoria;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			database.close(conexao);
		}

		return null;
	}



}
