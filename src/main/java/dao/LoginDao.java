package dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.persistence.Query;

import genericdao.GenericDAO;
import model.Login;

public class LoginDao extends GenericDAO<Login> {
	
	@Override
	public void save(Login login) {
		try {
			login.setSenha(criptofragar(login.getSenha()));

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
				&& criptofragar(login.getSenha()).equals(loginSelecionado.getSenha())) {
			return true;
		} else {
			return false;
		}
	}

	private String criptofragar(String cript) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(cript.getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		return hexString.toString();
	}

	public Login dadosLogin(Login login) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
		String hql = "from Login l where usuario = :usuario " + "and senha = :senha ";

		Query query = em.createQuery(hql);
		query.setParameter("usuario", login.getUsuario());
		query.setParameter("senha", criptofragar(login.getSenha()));

		return (Login) query.getSingleResult();
	}

}
