package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import business.AlunoBusiness;
import model.Aluno;

@ManagedBean(name = "alunoWebBean")
public class AlunoWebBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluno aluno;

	private AlunoBusiness alunoBusinnes;

	@PostConstruct
	public void initialize() {
		aluno = new Aluno();
		alunoBusinnes = new AlunoBusiness();
	}

	public void salvar() {
		FacesContext mensagens = FacesContext.getCurrentInstance();

		try {
			alunoBusinnes.salvar(aluno);
			mensagens.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Aluno " + aluno.getNome() + " salvo com sucesso!"));
			aluno = new Aluno();
		} catch (NullPointerException e) {
			e.printStackTrace();
			mensagens.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao salvar o aluno " + aluno.getNome()));

		} catch (Exception e) {
			e.printStackTrace();
			mensagens.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Erro Genérico!"));
		}

	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
