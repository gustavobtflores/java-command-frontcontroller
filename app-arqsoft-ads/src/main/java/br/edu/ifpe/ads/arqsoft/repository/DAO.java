package br.edu.ifpe.ads.arqsoft.repository;

import java.util.List;

public interface DAO<T> {

	void salvar(T t);
	List<T> listarTodos();
	T atualizar(T t);
	void remover(Long id);
	T pegaPorId(Long id);
}
