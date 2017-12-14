package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import business.PessoaBusiness;
import model.Pessoa;

@ManagedBean(name = "pessoaWebBean")
public class PessoaWebBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;

	private PessoaBusiness pessoaBusinnes;

	@PostConstruct
	public void initialize() {
		pessoa = new Pessoa();
		pessoaBusinnes = new PessoaBusiness();
	}

	public void salvar() {
		try {
			
			pessoaBusinnes.salvar(pessoa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo",
					"Pessoa " + pessoa.getNome() + " salvo com sucesso!"));
			pessoa = new Pessoa();

		} catch (NullPointerException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
					"Erro ao salvar o pessoa " + pessoa.getNome()));

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Erro Genérico!"));

		}

	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
