package br.edu.ifpe.ads.arqsoft.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.ads.arqsoft.domain.entity.Produto;
import br.edu.ifpe.ads.arqsoft.repository.infra.Database;

public class ProdutoDAO implements DAO<Produto> {

	private Database database;

	private String sqlSelect = "select id,nome,descricao, preco from produto";
	private String sqlSelectPorId = "select id,nome,descricao, preco from produto where id=?";
	private String sqlAtualizar = "update produto set nome=?,descricao=?,preco=? where id=?";
	private String sqlRemover = "delete from produto where id=?";

	public ProdutoDAO(Database database) {
		this.database = database;
	}

	private String sqlInsert = "insert into produto(nome,descricao,preco,id_categoria) values(?,?,?,?)";
	
	public void salvar(Produto produto) {
		Connection conexao = this.database.connect();
		try {
			PreparedStatement pstm = conexao.prepareStatement(sqlInsert);
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setDouble(3, produto.getPreco());
			pstm.setLong(4, 1);
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			database.close(conexao);
		}
	}

	public List<Produto> listarTodos() {
		Connection conexao = this.database.connect();

		List<Produto> produtos = new ArrayList<>();
		PreparedStatement pstm;
		try {
			pstm = conexao.prepareStatement(sqlSelect);

			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {

				var produto = new Produto(rs.getString("nome"), rs.getDouble("preco"));
				produto.setId(rs.getLong("id"));
				produto.setDescricao(rs.getString("descricao"));
				produtos.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			database.close(conexao);
		}

		return produtos;
	}

	
	public Produto atualizar(Produto produto) {
		Connection conexao = this.database.connect();
		try {
			PreparedStatement pstm = conexao.prepareStatement(sqlAtualizar);
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setDouble(3, produto.getPreco());
			pstm.setLong(4, produto.getId());
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			database.close(conexao);
		}
		return produto;
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
	
		
	public Produto pegaPorId(Long id) {
		Connection conexao = this.database.connect();

		PreparedStatement pstm;
		try {
			pstm = conexao.prepareStatement(sqlSelectPorId);
			pstm.setLong(1,id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {

				var produto = new Produto(rs.getString("nome"), rs.getDouble("preco"));
				produto.setId(rs.getLong("id"));
				produto.setDescricao(rs.getString("descricao"));
				return produto;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			database.close(conexao);
		}

		return null;
	}

	

}
