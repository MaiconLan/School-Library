package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
	private Long id_livro;

	private String titulo;
	private String subtitulo;
	private Integer qtd_paginas;
	private int estoque;

	@Temporal(value = TemporalType.DATE)
	private Date data_publicacao;

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

	public Long getId_livro() {
		return id_livro;
	}

	public void setId_livro(Long id_livro) {
		this.id_livro = id_livro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public Integer getQtd_paginas() {
		return qtd_paginas;
	}

	public void setQtd_paginas(Integer qtd_paginas) {
		this.qtd_paginas = qtd_paginas;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public Date getData_publicacao() {
		return data_publicacao;
	}

	public void setData_publicacao(Date data_publicacao) {
		this.data_publicacao = data_publicacao;
	}

	public Estante getEstante() {
		return estante;
	}

	public void setEstante(Estante estante) {
		this.estante = estante;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public final List<Aluguel> getAlugeis() {
		return alugeis;
	}

	public final void setAlugeis(List<Aluguel> alugeis) {
		this.alugeis = alugeis;
	}

}
