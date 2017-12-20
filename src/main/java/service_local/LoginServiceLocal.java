package service_local;

import java.sql.SQLException;

import javax.persistence.NoResultException;

import business.LoginBusiness;
import model.Login;
import service.LoginService;

public class LoginServiceLocal implements LoginService {

	private LoginBusiness loginBusiness = new LoginBusiness();
	
	private static final long serialVersionUID = 1L;

	public Login logar(Login login) throws NoResultException, SQLException, Exception {
		return loginBusiness.logar(login);
	}

}
