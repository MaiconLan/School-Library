package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import business.AlunoBusiness;
import model.Aluno;
import model.Email;
import model.Endereco;
import model.Telefone;

@RequestScoped
@Named(value= "alunoWebBean")
public class AlunoWebBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluno aluno;
	private Email email;
	private Telefone telefone;
	private Endereco endereco;

	@Inject
	private AlunoBusiness alunoBusinnes;

	@PostConstruct
	public void initialize() {
		aluno = new Aluno();
		email = new Email();
		telefone = new Telefone();
		endereco = new Endereco();
	}

	public void adicionarTelefone() {
		telefone.setAluno(aluno);
		aluno.getTelefones().add(telefone);
		telefone = new Telefone();
	}

	public void adicionarEmail() {
		email.setAluno(aluno);
		aluno.getEmails().add(email);
		email = new Email();
	}

	public void adicionarEndereco() {
		endereco.setAluno(aluno);
		aluno.getEnderecos().add(endereco);
		endereco = new Endereco();
	}

	public void salvar() {
		if (aluno == null) {
			alunoBusinnes.salvar(aluno);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Aluno salvo com sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Campos em branco!", "Aluno não contém campos válidos!"));
		}

		aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public final Email getEmail() {
		return email;
	}

	public final void setEmail(Email email) {
		this.email = email;
	}

	public final Telefone getTelefone() {
		return telefone;
	}

	public final void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public final Endereco getEndereco() {
		return endereco;
	}

	public final void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
