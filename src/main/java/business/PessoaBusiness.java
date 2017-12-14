package business;

import java.util.List;

import dao.PessoaDao;
import model.Pessoa;
import service.PessoaService;

public class PessoaBusiness implements PessoaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PessoaDao pessoaDao = new PessoaDao();

	public List<Pessoa> listaAluno(Pessoa filtro) {
		return pessoaDao.listaFiltro(filtro);
	}

	public void salvar(Pessoa pessoa) throws NullPointerException, Exception {
		pessoa.getLogin().setPessoa(pessoa);
		if (pessoa.getIdPessoa() == null) {
			pessoaDao.save(pessoa);
		} else {
			pessoaDao.update(pessoa);
		}
	}

}