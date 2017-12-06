package business;

import java.util.List;

import dao.AlunoDao;
import model.Aluno;
import utils.Constante;

public class AlunoBusiness {

	private AlunoDao alunoDao = new AlunoDao();

	public Boolean salvarAluno(Aluno aluno) {
		Boolean salvou = Constante.FALSO;

		if (aluno.getIdAluno() == null) {
			alunoDao.save(aluno);
			salvou = Constante.VERDADEIRO;
		} else {
			alunoDao.update(aluno);
			salvou = Constante.VERDADEIRO;
		}
		return salvou;
	}

	public List<Aluno> listaAluno(Aluno filtro) {
		return alunoDao.listaFiltro(filtro);
	}

}