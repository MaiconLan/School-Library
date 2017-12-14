package controller;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Login;
import service.LoginService;

@ManagedBean(name = "loginWebBean")
@SessionScoped
public class LoginWebBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Login pessoaLogada, filtro;

	private LoginService loginService;

	@PostConstruct
	public void initialize() {
		pessoaLogada = new Login();
		filtro = new Login();
	}

	public void logar() {
		try {
			pessoaLogada = loginService.logar(filtro);
			System.out.println(pessoaLogada.getUsuario());
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Logado",
					filtro.getPessoa().getNome() + " logado com sucesso!"));
			filtro = new Login();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Erro na criptografia da senha!"));
			filtro = new Login();

		} catch (SQLException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Erro no SQL!"));
			filtro = new Login();

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Erro genérico!"));
			filtro = new Login();

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
