package entity.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import entity.Produto;
import entity.Usuario;
import utils.HibernateUtil;

public class ProdutoDAO {
	/** Sessão do Hibernate para acesso ao banco. */
	static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	/** Log */
	static final Logger logger = LoggerFactory.logger(ProdutoDAO.class);
	
	public static List<Produto> listarProdutos() {
		List<Produto> produtos = null;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		
		try {
			var criteriaBuilder = session.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(Produto.class);
			
			query.select(query.from(Produto.class));
			produtos = session.createQuery(query).list();
			transaction.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
			transaction.rollback();
		} finally {
			session.close();
		}
		
		return produtos;
	}

	/**
	 * Busca um produto no banco.
	 * 
	 * @param id Identificador do produto.
	 * @return Produto encontrado.
	 */
	public static Produto procurarProduto(Long id) {
		Produto produto = null;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		
		try {
			produto = (Produto) session.get(Produto.class, id);
			transaction.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
			transaction.rollback();
		} finally {
			session.close();
		}
		
		return produto;
	}
}
