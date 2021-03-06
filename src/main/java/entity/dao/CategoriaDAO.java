package entity.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import entity.Categoria;
import entity.Produto;
import utils.HibernateUtil;

public class CategoriaDAO {
	
	/** Sessão do Hibernate para acesso ao banco. */
	static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	/** Log */
	static final Logger logger = LoggerFactory.logger(ProdutoDAO.class);

	
	public static List<Categoria> retornaCategorias() {
		
		List<Categoria> categorias = null;
		
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		
		try {
			
			var criteriaBuilder = session.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(Categoria.class);
			query.select(query.from(Categoria.class));
		
			categorias = session.createQuery(query).list();
			
			transaction.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
			transaction.rollback();
		} finally {
			session.close();
		}
		
		return categorias;
	}
	
	/**
	 * Busca uma categoria no banco.
	 * 
	 * @param id Identificador da categoria.
	 * @return Categoria encontrada.
	 */
	public static Categoria procurarCategoria(Long id) {
		Categoria categoria = null;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		
		try {
			categoria = (Categoria) session.get(Categoria.class, id);
			transaction.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
			transaction.rollback();
		} finally {
			session.close();
		}
		
		return categoria;
	}
}
