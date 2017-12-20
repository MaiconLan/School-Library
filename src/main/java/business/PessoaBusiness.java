package business;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.PessoaDao;
import model.Pessoa;
import service.PessoaService;
import utils.Criptografia;

public class PessoaBusiness implements PessoaService {

	private static final long serialVersionUID = 1L;

	private PessoaDao pessoaDao = new PessoaDao();

	public List<Pessoa> listaAluno(Pessoa filtro) {
		return pessoaDao.listaFiltro(filtro);
	}

	public Pessoa salvar(Pessoa pessoa) throws NullPointerException, PersistenceException, Exception {
		pessoa.setLogin(Criptografia.criptografar(pessoa.getLogin()));
		pessoa.getLogin().setPessoa(pessoa);
		
		if (pessoa.getIdPessoa() == null) {
			pessoaDao.save(pessoa);
		} else {
			pessoaDao.update(pessoa);
		}
		return pessoa;
	}

}