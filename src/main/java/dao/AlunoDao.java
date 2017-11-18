package dao;

import java.util.List;

import genericdao.GenericDAO;
import model.Aluno;

public class AlunoDao extends GenericDAO<Aluno> {

	@SuppressWarnings("unchecked")
	public List<Aluno> listaFiltro(Aluno filtro) {
		StringBuilder hql = new StringBuilder();
		hql.append(" FROM Aluno a ");

		if (filtro != null) {
			hql.append("WHERE a.id_aluno IS NOT NULL");
			populaFiltros(filtro, hql);
		}

		return em.createQuery(hql.toString()).setMaxResults(100).getResultList();
	}

	public StringBuilder populaFiltros(Aluno filtro, StringBuilder hql) {
		if (isNotNull(filtro.getId_aluno())) {
			hql.append(" AND a.id_aluno = " + filtro.getId_aluno());
		}
		if (isNotNull(filtro.getNome_completo())) {
			hql.append(" AND a.nome_completo ILIKE = '" + filtro.getNome_completo() + "%'");
		}
		return hql;
	}

	public Boolean isNotNull(Object o) {
		return o != null;
	}

}
