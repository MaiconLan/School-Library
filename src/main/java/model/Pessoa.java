package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Long idPessoa;

	private String nome;

	private String telefone;

	private String email;

	private String endereco;

	@Temporal(TemporalType.DATE)
	private Date nascimento;

	@Temporal(TemporalType.DATE)
	private Date obito;

	private String genero;

	@OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private Login login;

	public Pessoa() {
		login = new Login();
	}

	public final Long getIdPessoa() {
		return idPessoa;
	}

	public final void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public final String getNome() {
		return nome;
	}

	public final void setNome(String nome) {
		this.nome = nome;
	}

	public final Date getNascimento() {
		return nascimento;
	}

	public final void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public final String getTelefone() {
		return telefone;
	}

	public final void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getEndereco() {
		return endereco;
	}

	public final void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public final Date getObito() {
		return obito;
	}

	public final void setObito(Date obito) {
		this.obito = obito;
	}

	public final String getGenero() {
		return genero;
	}

	public final void setGenero(String genero) {
		this.genero = genero;
	}

	public final Login getLogin() {
		return login;
	}

	public final void setLogin(Login login) {
		this.login = login;
	}

}
