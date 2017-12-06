package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import business.AlunoBusiness;
import model.Aluno;
import model.Email;
import model.Endereco;
import model.Telefone;

@RequestScoped
@ManagedBean(name = "alunoWebBean")
public class AlunoWebBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluno aluno;
	private Email email;
	private Telefone telefone;
	private Endereco endereco;

	private AlunoBusiness alunoBusinnes;

	@PostConstruct
	public void initialize() {
		alunoBusinnes = new AlunoBusiness();
		aluno = new Aluno();
		email = new Email();
		telefone = new Telefone();
		endereco = new Endereco();
	}

	public void adicionarTelefone() {
		aluno.getTelefones().add(telefone);
		telefone.setAluno(aluno);
		telefone = new Telefone();
	}

	public void adicionarEmail() {
		aluno.getEmails().add(email);
		email.setAluno(aluno);
		email = new Email();
	}

	public void adicionarEndereco() {
		aluno.getEnderecos().add(endereco);
		endereco.setAluno(aluno);
		endereco = new Endereco();
	}

	public void salvar() {
		if (alunoBusinnes.salvarAluno(aluno)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Registro salvo com sucesso!"));
			aluno = new Aluno();
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao salvar registro!"));
		}

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
