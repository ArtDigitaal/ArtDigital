package entity.dao;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import entity.Produto;
import utils.HibernateUtil;

public class ProdutoDAO {
	/** Sessão do Hibernate para acesso ao banco. */
	static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	/** Log */
	static final Logger logger = LoggerFactory.logger(ProdutoDAO.class);

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
