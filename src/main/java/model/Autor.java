package model;

import java.util.Date;
import java.util.List;

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
	private Long id_autor;

	private String nome_completo;

	@Temporal(TemporalType.DATE)
	private Date data_nascimento;
	@Temporal(TemporalType.DATE)
	private Date data_obito;

	@ManyToMany
	@JoinTable(name = "muitos_autores_tem_muitos_livros", joinColumns = {
			@JoinColumn(name = "id_autor") }, inverseJoinColumns = { @JoinColumn(name = "id_livro") })
	private List<Livro> livros;

	public Long getId_autor() {
		return id_autor;
	}

	public void setId_autor(Long id_autor) {
		this.id_autor = id_autor;
	}

	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public Date getData_obito() {
		return data_obito;
	}

	public void setData_obito(Date data_obito) {
		this.data_obito = data_obito;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}
