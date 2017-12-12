package business;

import java.util.List;

import dao.AlunoDao;
import model.Aluno;
import service.AlunoService;

public class AlunoBusiness implements AlunoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AlunoDao alunoDao = new AlunoDao();

	public void salvar(Aluno aluno) throws NullPointerException, Exception {
		if (aluno.getIdAluno() == null) {
			alunoDao.save(aluno);
		} else {
			alunoDao.update(aluno);
		}
	}

	public List<Aluno> listaAluno(Aluno filtro) {
		return alunoDao.listaFiltro(filtro);
	}

}