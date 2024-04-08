package br.edu.ifpe.ads.arqsoft.domain.entity;

import java.util.Objects;

public class Produto {
	private Long id;
	private String nome;
	private String descricao;
	private double preco;

	private Categoria categoria;

	public Produto(String nome, double preco, Categoria categoria) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
	}

	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;

	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", categoria="
				+ categoria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, descricao, id, nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
