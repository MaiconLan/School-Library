package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.Pessoa;
import service.PessoaService;

@ManagedBean(name = "pessoaWebBean")
public class PessoaWebBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;

	private PessoaService pessoaService;

	@PostConstruct
	public void initialize() {
		pessoa = new Pessoa();
	}

	public String salvar() {
		String tela = "";
		try {
			pessoaService.salvar(pessoa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo",
					"Pessoa " + pessoa.getNome() + " salvo com sucesso!"));
			pessoa = new Pessoa();
			tela = "/index.xhtml";

		} catch (NullPointerException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
					"Erro ao salvar o pessoa " + pessoa.getNome()));

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Erro Gen�rico!"));

		}

		return tela;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaService getPessoaService() {
		return pessoaService;
	}

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

}