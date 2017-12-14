package dao;

import java.util.List;

import genericdao.GenericDAO;
import model.Pessoa;

public class PessoaDao extends GenericDAO<Pessoa> {

	@SuppressWarnings("unchecked")
	public List<Pessoa> listaFiltro(Pessoa filtro) {
		StringBuilder hql = new StringBuilder();
		hql.append(" FROM Pessoa p ");

		if (filtro != null) {
			hql.append("WHERE p.id_pessoa IS NOT NULL");
			populaFiltros(filtro, hql);
		}

		return em.createQuery(hql.toString()).setMaxResults(100).getResultList();
	}

	public StringBuilder populaFiltros(Pessoa filtro, StringBuilder hql) {
		if (isNotNull(filtro.getIdPessoa())) {
			hql.append(" AND p.id_pessoa = " + filtro.getIdPessoa());
		}
		if (isNotNull(filtro.getNome())) {
			hql.append(" AND p.nome ILIKE = '" + filtro.getNome() + "%'");
		}
		return hql;
	}

	public Boolean isNotNull(Object o) {
		return o != null;
	}

}
