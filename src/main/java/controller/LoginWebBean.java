package controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import model.Login;
import service_local.LoginServiceLocal;

@ManagedBean(name = "loginWebBean")
@SessionScoped
public class LoginWebBean implements Serializable {

	private static final String CAMINHO_INDEX = "/SchoolLibrary/index.xhtml";
	
	private static final long serialVersionUID = 1L;

	private Login pessoaLogada, filtro;

	@Inject
	private LoginServiceLocal loginServiceLocal;

	@PostConstruct
	public void initialize() {
		filtro = new Login();
		loginServiceLocal = new LoginServiceLocal();
	}

	public void logar() {
		try {
			pessoaLogada = loginServiceLocal.logar(filtro);
			System.out.println(pessoaLogada.getUsuario());
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Logado",
					pessoaLogada.getPessoa().getNome() + " logado com sucesso!"));
			filtro = new Login();
			FacesContext.getCurrentInstance().getExternalContext().redirect(CAMINHO_INDEX);
			
		} catch (NoResultException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Login/Senha inválido", "Insira Login/Senha válidos."));
			filtro = new Login();

		} catch (SQLException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", e.toString()));
			filtro = new Login();

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", e.toString()));
			filtro = new Login();
		}
	}
	
	public void deslogar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			FacesContext.getCurrentInstance().getExternalContext().redirect(CAMINHO_INDEX);
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final Login getPessoaLogada() {
		return pessoaLogada;
	}

	public final void setPessoaLogada(Login pessoaLogada) {
		this.pessoaLogada = pessoaLogada;
	}

	public final Login getFiltro() {
		return filtro;
	}

	public final void setFiltro(Login filtro) {
		this.filtro = filtro;
	}

	
	
}
