package entity.dao;

import static org.junit.Assert.assertNull;

import org.hibernate.SessionFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.junit.MockitoJUnitRunner;

import entity.Produto;
import utils.HibernateTestUtil;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoDAOTest {
	
	static final SessionFactory sessionFactory = HibernateTestUtil.getSessionFactory();

	@Test
	public void teste01_buscarProdutoQuandoIdInvalido() {
		Produto produto = null;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		
		try {
			produto = (Produto) session.get(Produto.class, 1L);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		
		assertNull(produto);
	}
	
}
