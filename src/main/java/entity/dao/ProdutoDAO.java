package entity.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;

import entity.Produto;
import entity.Usuario;
import utils.HibernateUtil;

public class ProdutoDAO {
	/** Sessão do Hibernate para acesso ao banco. */
	static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	/** Log */
	static final Logger logger = LoggerFactory.logger(ProdutoDAO.class);
	
	public static List<Produto> listarProdutos(String buscar) {
		List<Produto> produtos = null;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		
		try {
			var builder = session.getCriteriaBuilder();
			var query = builder.createQuery(Produto.class);
			
			var from = query.from(Produto.class);
			query.select(from);
			
			if (buscar != null) {
				var equalNome = builder.like(builder.lower(from.get("nome")), "%" + buscar.toLowerCase() + "%");
				var equalDescricao = builder.like(builder.lower(from.get("descricao")), "%" + buscar.toLowerCase() + "%");
				query.where(builder.or(equalNome, equalDescricao));
			}
			
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
	
	/**
	 * Cadastra um produto no banco.
	 * 
	 * @param Produto produto.
	 * @return Boolean.
	 */
	
	public static boolean cadastrarProduto(Produto produto) {
		var success = false;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		
		try {
			session.save(produto);
			transaction.commit();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		
		return success;
	}
}
