package service;

import java.io.Serializable;

import javax.persistence.PersistenceException;

import model.Pessoa;

public interface PessoaService extends Serializable {

	void salvar(Pessoa pessoa) throws NullPointerException, PersistenceException, Exception;

}
