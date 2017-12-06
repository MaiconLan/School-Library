package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "autor")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_autor")
	private Long idAutor;

	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_obito")
	private Date dataObito;

	@ManyToMany
	@JoinTable(name = "muitos_autores_tem_muitos_livros", joinColumns = {
			@JoinColumn(name = "id_autor") }, inverseJoinColumns = { @JoinColumn(name = "id_livro") })
	private List<Livro> livros;

	public final Long getIdAutor() {
		return idAutor;
	}

	public final void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public final String getNome() {
		return nome;
	}

	public final void setNome(String nome) {
		this.nome = nome;
	}

	public final Date getDataNascimento() {
		return dataNascimento;
	}

	public final void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public final Date getDataObito() {
		return dataObito;
	}

	public final void setDataObito(Date dataObito) {
		this.dataObito = dataObito;
	}

	public final List<Livro> getLivros() {
		return livros;
	}

	public final void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", dataObito="
				+ dataObito + "]";
	}

}
