package service_local;

import javax.persistence.PersistenceException;

import business.PessoaBusiness;
import model.Pessoa;
import service.PessoaService;

public class PessoaServiceLocal implements PessoaService {

	private static final long serialVersionUID = 1L;

	private PessoaBusiness pessoaBusiness = new PessoaBusiness();

	public Pessoa salvar(Pessoa pessoa) throws NullPointerException, PersistenceException, Exception {
		return pessoaBusiness.salvar(pessoa);
	}
}
