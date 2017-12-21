package service_local;

import java.util.List;

import javax.persistence.PersistenceException;

import business.PessoaBusiness;
import model.Pessoa;
import service.PessoaService;

public class PessoaServiceLocal implements PessoaService {

	private static final long serialVersionUID = 1L;

	private PessoaBusiness pessoaBusiness = new PessoaBusiness();

	public Pessoa salvar(Pessoa pessoa, Boolean isCriarLogin) throws NullPointerException, PersistenceException, Exception {
		return pessoaBusiness.salvar(pessoa, isCriarLogin);
	}
	
	public List<Pessoa> listar(Pessoa filtro) throws NullPointerException, PersistenceException, Exception {
		return pessoaBusiness.listar(filtro);
	}
}
