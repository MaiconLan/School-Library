package service;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import model.Login;

public interface LoginService extends Serializable {

	Login logar(Login login) throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException;

}
