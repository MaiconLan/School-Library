package dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.persistence.Query;

import genericdao.GenericDAO;
import model.Login;
import utils.Criptografia;

public class LoginDao extends GenericDAO<Login> {
	
	@Override
	public void save(Login login) {
		try {
			login.setSenha(Criptografia.criptofragar(login.getSenha()));

			em.getTransaction().begin();
			em.persist(login);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();

		}
	}

	public boolean isValido(Login login) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
		Login loginSelecionado = dadosLogin(login);

		if (login.getUsuario().equals(loginSelecionado.getUsuario())
				&& Criptografia.criptofragar(login.getSenha()).equals(loginSelecionado.getSenha())) {
			return true;
		} else {
			return false;
		}
	}


	public Login dadosLogin(Login login) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
		String hql = "FROM Login l WHERE usuario = :usuario AND senha = :senha ";

		Query query = em.createQuery(hql);
		query.setParameter("usuario", login.getUsuario());
		query.setParameter("senha", Criptografia.criptofragar(login.getSenha()));

		return (Login) query.getSingleResult();
	}

}
