package br.edu.ifpe.ads.arqsoft.domain.entity;

import java.util.Objects;

public class Categoria {

	private Long id;
	private String nome;
	private String descricao;
	
	
	
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}



	@Override
	public int hashCode() {
		return Objects.hash(descricao, nome);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(nome, other.nome);
	}
	
	
	
	
}
