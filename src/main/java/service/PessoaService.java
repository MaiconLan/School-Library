package service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceException;

import model.Pessoa;

public interface PessoaService extends Serializable {

	Pessoa salvar(Pessoa pessoa, Boolean isCadastrarLogin) throws NullPointerException, PersistenceException, Exception;

	List<Pessoa> listar(Pessoa filtro) throws NullPointerException, PersistenceException, Exception;
}
