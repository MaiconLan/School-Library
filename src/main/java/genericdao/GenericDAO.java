package genericdao;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.Criteria;

import jpautil.PersistenceUtil;

public class GenericDAO<T> {
	protected static Criteria filtro;
	protected static EntityManager em;
	protected Class<T> clazz;

	/**
	 * @throws IOException
	 * @property Abre conexão
	 */
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		try {
			em = PersistenceUtil.currentEntityManager();
			this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

		} catch (PersistenceException e) {
			e.printStackTrace();

		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @property Salvar registros
	 */
	public void save(T t) throws NullPointerException, Exception {
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();

		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	/**
	 * @property Atualizar registros
	 */
	public void update(T t) throws NullPointerException, Exception {
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();

		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();

		}
	}

	/**
	 * @property Procurar registros pelo ID
	 */
	public T findById(Long id) throws NullPointerException, Exception {
		return em.find(clazz, id);
	}

	/**
	 * @property Lista registros
	 */
	@SuppressWarnings("unchecked")
	public List<T> list() throws NullPointerException, Exception {
		Query query = em.createQuery("FROM " + clazz.getSimpleName());
		return query.setMaxResults(100).getResultList();
	}

	/**
	 * @property Remove registros por ID
	 */
	public void remove(Long id) throws NullPointerException, Exception {
		T t = findById(id);
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> listaFiltroNome(String pesquisa) throws NullPointerException, Exception {
		String hql = "from " + clazz.getSimpleName() + " c where upper(nom_nome) LIKE :nome ";
		Query query = em.createQuery(hql);
		query.setParameter("nome", "%" + pesquisa.toUpperCase() + "%");

		return query.setMaxResults(100).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> listaFiltroDescricao(String pesquisa) throws NullPointerException, Exception {
		String hql = "from " + clazz.getSimpleName() + " c where upper(nom_descricao) LIKE :descricao ";
		Query query = em.createQuery(hql);
		query.setParameter("descricao", "%" + pesquisa.toUpperCase() + "%");

		return query.setMaxResults(100).getResultList();
	}

}
