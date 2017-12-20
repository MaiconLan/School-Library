package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.Pessoa;
import service_local.PessoaServiceLocal;

@ManagedBean(name = "pessoaWebBean")
public class PessoaWebBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private boolean isCreateUsuario;

	private PessoaServiceLocal pessoaServiceLocal;

	@PostConstruct
	public void initialize() {
		pessoa = new Pessoa();
		pessoaServiceLocal = new PessoaServiceLocal();
	}

	public void salvar() {
		try {
			pessoaServiceLocal.salvar(pessoa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo",
					"Pessoa " + pessoa.getNome() + " salvo com sucesso!"));
			pessoa = new Pessoa();

		} catch (NullPointerException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
					"Erro ao salvar o pessoa " + pessoa.getNome()));

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Erro Genérico!"));

		}

	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public final boolean isCreateUsuario() {
		return isCreateUsuario;
	}

	public final void setCreateUsuario(boolean isCreateUsuario) {
		this.isCreateUsuario = isCreateUsuario;
	}

}
