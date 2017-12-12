package service;

import java.io.Serializable;

import model.Aluno;

public interface AlunoService extends Serializable {

	void salvar(Aluno aluno) throws NullPointerException, Exception;

}
