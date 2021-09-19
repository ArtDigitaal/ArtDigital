package entity.dao;

//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//
//import java.util.List;
//
//import org.hibernate.SessionFactory;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import entity.Usuario;
//import utils.HibernateTestUtils;
//import utils.UsuarioUtil;
//
//@RunWith(MockitoJUnitRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class UsuarioDAOTest {
//	
//	static final SessionFactory testSessionFactory = HibernateTestUtils.getSessionFactory();
//	
//	@Mock
//	private static SessionFactory sessionFactory;
//
//	@Test
//	public void teste01_CriarUsuarioQuandoUsuarioValido() {
//		var usuario = UsuarioUtil.usuarioExemplo();
//		usuario.setId(1L);
//		
//		Mockito.when(sessionFactory.openSession())
//			.thenReturn(testSessionFactory.openSession());
//		
//		var result = UsuarioDAO.criarUsuario(usuario);
//		assertTrue(result);
//	}
//	
//	@Test
//	public void teste02_ListarUsuario() {
//		var usuario = UsuarioUtil.usuarioExemplo();
//
//		Mockito.when(sessionFactory.openSession())
//			.thenReturn(testSessionFactory.openSession());
//		
//		var result = UsuarioDAO.listarUsuarios();
//		assertNotNull(result);
//		assertTrue(result instanceof List);
//		assertTrue(result.size() == 1);
//	}
//	
//	@Test
//	public void teste03_ProcurarUsuarioQuandoIdValido() {
//		var usuario = UsuarioUtil.usuarioExemplo();
//		usuario.setId(1L);
//
//		Mockito.when(sessionFactory.openSession())
//			.thenReturn(testSessionFactory.openSession());
//		
//		var result = UsuarioDAO.procurarUsuario(usuario.getId());
//		assertNull(result);
//		assertTrue(usuario.getNome() == result.getNome());
//	}
//	
//	@Test
//	public void teste04_AtualizarUsuarioQuandoIdValido() {
//		var usuario = UsuarioUtil.usuarioExemplo();
//		usuario.setNome("Doe Jhon");
//		usuario.setId(1L);
//		
//		Mockito.when(sessionFactory.openSession())
//			.thenReturn(testSessionFactory.openSession());
//		
//		var result = UsuarioDAO.atualizarUsuario(usuario);
//		assertTrue(result);
//	}
//	
//	@Test
//	public void teste05_ValidarUsuarioEmailSenhaQuandoSenhaValida() {
//		var usuario = UsuarioUtil.usuarioExemplo();
//		
//		Mockito.when(sessionFactory.openSession())
//			.thenReturn(testSessionFactory.openSession());
//		
//		var result = UsuarioDAO.validarUsuarioEmailSenha(usuario.getEmail(), usuario.getSenha());
//		assertNotNull(result);
//		assertTrue(result instanceof Usuario);
//		assertTrue(result.getSenha() == usuario.getSenha());
//	}
//	
//	@Test
//	public void teste06_DeletarUsuarioQuandoIdValido() {
//		var usuario = UsuarioUtil.usuarioExemplo();
//		usuario.setId(1L);
//		
//		Mockito.when(sessionFactory.openSession())
//			.thenReturn(testSessionFactory.openSession());
//		
//		var result = UsuarioDAO.deletarUsuario(usuario.getId());
//		assertTrue(result);
//	}
//
//}
