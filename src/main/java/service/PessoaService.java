package service;

import java.io.Serializable;

import model.Pessoa;

public interface PessoaService extends Serializable {

	void salvar(Pessoa pessoa) throws NullPointerException, Exception;

}
