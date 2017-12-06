package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_livro")
	private Long idLivro;

	private String titulo;
	private String subtitulo;

	@Column(name = "qtd_paginas")
	private Integer qtdPaginas;
	private int estoque;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_publicacao")
	private Date dataPublicacao;

	@ManyToOne
	@JoinColumn(name = "id_estante")
	private Estante estante;

	@ManyToOne
	@JoinColumn(name = "id_genero")
	private Genero genero;

	@OneToMany(mappedBy = "livro", targetEntity = Aluguel.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aluguel> alugeis;

	@ManyToMany(mappedBy = "livros")
	private List<Autor> autores;

	public final Long getIdLivro() {
		return idLivro;
	}

	public final void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public final String getTitulo() {
		return titulo;
	}

	public final void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public final String getSubtitulo() {
		return subtitulo;
	}

	public final void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public final Integer getQtdPaginas() {
		return qtdPaginas;
	}

	public final void setQtdPaginas(Integer qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}

	public final int getEstoque() {
		return estoque;
	}

	public final void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public final Date getDataPublicacao() {
		return dataPublicacao;
	}

	public final void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public final Estante getEstante() {
		return estante;
	}

	public final void setEstante(Estante estante) {
		this.estante = estante;
	}

	public final Genero getGenero() {
		return genero;
	}

	public final void setGenero(Genero genero) {
		this.genero = genero;
	}

	public final List<Aluguel> getAlugeis() {
		return alugeis;
	}

	public final void setAlugeis(List<Aluguel> alugeis) {
		this.alugeis = alugeis;
	}

	public final List<Autor> getAutores() {
		return autores;
	}

	public final void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

}
