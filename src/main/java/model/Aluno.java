package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import utils.Constante;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_aluno;

	private String nome_completo;

	@Temporal(TemporalType.DATE)
	private Date data_nascimento;

	@OneToMany(mappedBy = "aluno", targetEntity = Telefone.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Telefone> telefones;
	@OneToMany(mappedBy = "aluno", targetEntity = Email.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Email> emails;
	@OneToMany(mappedBy = "aluno", targetEntity = Endereco.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Endereco> enderecos;
	@OneToMany(mappedBy = "aluno", targetEntity = Aluguel.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Aluguel> alugeis;

	private boolean ativo;

	public Aluno() {
		telefones = new ArrayList<Telefone>();
		emails = new ArrayList<Email>();
		enderecos = new ArrayList<Endereco>();
		ativo = Constante.ATIVO;
	}

	@OneToOne(fetch = FetchType.LAZY)
	private Aluguel aluguel;

	public Long getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Long id_aluno) {
		this.id_aluno = id_aluno;
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

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public final List<Aluguel> getAlugeis() {
		return alugeis;
	}

	public final void setAlugeis(List<Aluguel> alugeis) {
		this.alugeis = alugeis;
	}

	@Override
	public String toString() {
		return "Aluno [id_aluno=" + id_aluno + ", nome_completo=" + nome_completo + ", data_nascimento="
				+ data_nascimento + ", telefones=" + telefones + ", emails=" + emails + ", enderecos=" + enderecos
				+ ", ativo=" + ativo + ", aluguel=" + aluguel + "]";
	}

}
