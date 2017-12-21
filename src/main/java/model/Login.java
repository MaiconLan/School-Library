package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_login")
	private Long idLogin;

	@Column(name = "tipo_login")
	private String tipoLogin;

	private String usuario;

	private String senha;

	@OneToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	public final Long getIdLogin() {
		return idLogin;
	}

	public final void setIdLogin(Long idLogin) {
		this.idLogin = idLogin;
	}

	public final String getTipoLogin() {
		return tipoLogin;
	}

	public final void setTipoLogin(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

	public final String getUsuario() {
		return usuario;
	}

	public final void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public final String getSenha() {
		return senha;
	}

	public final void setSenha(String senha) {
		this.senha = senha;
	}

	public final Pessoa getPessoa() {
		return pessoa;
	}

	public final void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
