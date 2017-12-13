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
	private Integer paginas;
	private Integer estoque;

	@Temporal(value = TemporalType.DATE)
	private Date publicacao;

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

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
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

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public Date getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
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
