package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import utils.Constante;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private Long idAluno;

	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@OneToMany(mappedBy = "aluno", targetEntity = Telefone.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Telefone> telefones;
	@OneToMany(mappedBy = "aluno", targetEntity = Email.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Email> emails;
	@OneToMany(mappedBy = "aluno", targetEntity = Endereco.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Endereco> enderecos;
	@OneToMany(mappedBy = "aluno", targetEntity = Aluguel.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aluguel> alugeis;

	private boolean ativo;

	public Aluno() {
		telefones = new ArrayList<Telefone>();
		emails = new ArrayList<Email>();
		enderecos = new ArrayList<Endereco>();
		ativo = Constante.ATIVO;
	}

	public final Long getIdAluno() {
		return idAluno;
	}

	public final void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
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

	public final List<Telefone> getTelefones() {
		return telefones;
	}

	public final void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public final List<Email> getEmails() {
		return emails;
	}

	public final void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public final List<Endereco> getEnderecos() {
		return enderecos;
	}

	public final void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public final List<Aluguel> getAlugeis() {
		return alugeis;
	}

	public final void setAlugeis(List<Aluguel> alugeis) {
		this.alugeis = alugeis;
	}

	public final boolean isAtivo() {
		return ativo;
	}

	public final void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", telefones="
				+ telefones + ", emails=" + emails + ", enderecos=" + enderecos + ", ativo=" + ativo + "]";
	}

}
