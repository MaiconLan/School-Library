package business;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import dao.LoginDao;
import model.Login;
import service.LoginService;

public class LoginBusiness implements LoginService {

	private static final long serialVersionUID = 1L;
	
	private LoginDao loginDao = new LoginDao();

	public Login logar(Login login) throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException {
		Login pessoaLogada = new Login();
		
		if (loginDao.isValido(login)) {
			pessoaLogada = loginDao.dadosLogin(login);
		}
		
		return pessoaLogada;
	}

}
