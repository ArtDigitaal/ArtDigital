package entity.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.junit.MockitoJUnitRunner;

import entity.Usuario;
import utils.HibernateTestUtil;
import utils.UsuarioUtil;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioDAOTest {
	
	static final SessionFactory sessionFactory = HibernateTestUtil.getSessionFactory();

	@Test
	public void teste01_criarUsuarioQuandoUsuarioValido() {
		var usuario = UsuarioUtil.usuarioExemplo();
		usuario.setId(1L);
		
		var success = false;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		
		try {
			session.save(usuario);
			
			transaction.commit();
			success = true;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		
		assertTrue(success);
	}
	
	@Test
	public void teste02_listarUsuario() {
		var usuario = UsuarioUtil.usuarioExemplo();

		List<Usuario> usuarios = null;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		try {
			var criteriaBuilder = session.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(Usuario.class);
			query.select(query.from(Usuario.class));
		
			usuarios = session.createQuery(query).list();
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		
		assertNotNull(usuarios);
		assertTrue(usuarios instanceof List);
		assertTrue(usuarios.size() == 1);
	}
	
	@Test
	public void teste03_procurarUsuarioQuandoIdValido() {
		var usuarioExemplo = UsuarioUtil.usuarioExemplo();
		usuarioExemplo.setId(1L);
		
		Usuario usuario = null;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		try {
			usuario = (Usuario) session.get(Usuario.class, usuarioExemplo.getId());
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

		assertNotNull(usuario);
		assertTrue(usuarioExemplo.getNome() == usuario.getNome());
	}
	
	@Test
	public void teste04_atualizarUsuarioQuandoIdValido() {
		var usuarioExemplo = UsuarioUtil.usuarioExemplo();
		usuarioExemplo.setNome("Doe Jhon");
		usuarioExemplo.setId(1L);
		
		var success = false;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		try {
			session.update(usuarioExemplo);
			transaction.commit();
			success = true;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		
		assertTrue(success);
	}
	
	@Test
	public void teste05_procurarUsuarioPorQuandoParametrosValidos() {
		var usuarioExemplo = UsuarioUtil.usuarioExemplo();
		
		Usuario usuario = null;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		try {
			var builder = session.getCriteriaBuilder();
			var query = builder.createQuery(Usuario.class);
			
			var from = query.from(Usuario.class);
			query.select(from);
			query.where(builder.equal(from.get("email"), usuarioExemplo.getEmail()));
			
			usuario = session.createQuery(query).getSingleResult();
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		
		assertNotNull(usuario);
		assertTrue(usuario instanceof Usuario);
		assertTrue(usuario.getSenha() == usuarioExemplo.getSenha());
	}
	
	@Test
	public void teste06_deletarUsuarioQuandoIdValido() {
		var usuarioExemplo = UsuarioUtil.usuarioExemplo();
		usuarioExemplo.setId(1L);
		
		var success = false;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		try {
			var usuario = (Usuario) session.get(Usuario.class, usuarioExemplo.getId());
			session.delete(usuario);
			transaction.commit();
			success = true;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		
		assertTrue(success);
	}

}
