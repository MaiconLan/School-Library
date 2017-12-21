package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

import model.Pessoa;
import service_local.PessoaServiceLocal;

@ManagedBean(name = "pessoaWebBean")
public class PessoaWebBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa, filtro;
	private List<Pessoa> pessoas;
	private Boolean isCriarLogin;

	private PessoaServiceLocal pessoaServiceLocal;

	@PostConstruct
	public void initialize() {
		pessoa = new Pessoa();
		pessoaServiceLocal = new PessoaServiceLocal();
		isCriarLogin = Boolean.FALSE;
		listar();
	}

	public void salvar() {
		try {
			pessoaServiceLocal.salvar(pessoa, isCriarLogin);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo",
					"Pessoa " + pessoa.getNome() + " salvo com sucesso!"));

		} catch (NullPointerException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
					"Erro ao salvar o pessoa " + pessoa.getNome()));

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Erro Genérico!"));

		}

		pessoa = new Pessoa();
	}
	
	public void listar() {
		try {
			pessoas = new ArrayList<Pessoa>();
			pessoas = pessoaServiceLocal.listar(filtro);
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Boolean getIsCriarLogin() {
		return isCriarLogin;
	}

	public void setIsCriarLogin(Boolean isCriarLogin) {
		this.isCriarLogin = isCriarLogin;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
