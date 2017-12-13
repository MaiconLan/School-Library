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
	@Column(name = "id_aluno")
	private Long idAluno;

	private String nome;

	@Temporal(TemporalType.DATE)
	private Date nascimento;

	private String telefone;

	private String email;

	private String endereco;

	private boolean ativo;

	@OneToMany(mappedBy = "aluno", targetEntity = Aluguel.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aluguel> alugueis;

	public Aluno() {
		ativo = Constante.ATIVO;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
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

	public final List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public final void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Aluno [id_aluno=" + idAluno + ", nome_completo=" + nome + ", data_nascimento=" + nascimento
				+ ", telefones=" + telefone + ", emails=" + email + ", enderecos=" + endereco + ", ativo=" + ativo
				+ ", aluguel=" + alugueis + "]";
	}

}
