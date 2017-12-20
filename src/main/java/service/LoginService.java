package service;

import java.io.Serializable;
import java.sql.SQLException;

import javax.persistence.NoResultException;

import model.Login;

public interface LoginService extends Serializable{

	Login logar(Login login) throws NoResultException, SQLException, Exception;

}
