package business;

import java.util.List;

import dao.AlunoDao;
import model.Aluno;

public class AlunoBusiness {

	private AlunoDao alunoDao = new AlunoDao();

	public void salvar(Aluno aluno) {
		if (aluno.getId_aluno() == null) {
			alunoDao.save(aluno);
		} else {
			alunoDao.update(aluno);
		}
	}

	public List<Aluno> listaAluno(Aluno filtro) {
		return alunoDao.listaFiltro(filtro);
	}

}