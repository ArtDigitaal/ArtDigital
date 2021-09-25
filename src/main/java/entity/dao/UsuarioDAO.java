package entity.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import entity.Usuario;
import utils.HibernateUtil;

/** Classe com métodos de crud do Usuário. */
public abstract class UsuarioDAO {
	
	/** Nome dos campos únicos na classe do usuário. */
	private static final String FIELD_NAME_EMAIL = "email";
	private static final String FIELD_NAME_CPF = "cpf";
	private static final String FIELD_NAME_CNPJ = "email";
	
	/** Sessão do Hibernate para acesso ao banco. */
	static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	/**
	 * Salva um usuario no banco.
	 * 
	 * @param usuario Usuário para salvar.
	 * @return salvo com sucesso (true) ou falha (false).
	 */
	public static boolean criarUsuario(Usuario usuario) {
		var success = false;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		try {
			session.save(usuario);
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
	
	/**
	 * Lista os usuários salvos no banco.
	 * 
	 * @return Lista de usuários.
	 */
	public static List<Usuario> listarUsuarios() {
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
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
		return usuarios;
	}
	
	/**
	 * Busca um usuario salvo no banco.
	 * 
	 * @param id Identificador do usuario.
	 * @return Usuario encontrado.
	 */
	public static Usuario procurarUsuario(Long id) {
		Usuario usuario = null;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		try {
			usuario = (Usuario) session.get(Usuario.class, id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
		return usuario;
	}
	
	/**
	 * Deleta um usuário salvo no banco.
	 * 
	 * @param id Identificador do usuario.
	 * @return deletado com sucesso (true) ou falha (false).
	 */
	public static boolean deletarUsuario(Long id) {
		var success = false;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		try {
			var usuario = (Usuario) session.get(Usuario.class, id);
			session.delete(usuario);
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
	
	/**
	 * Atualiza um usuário salvo no banco.
	 * 
	 * @param usuario Usuário para atualizar.
	 * @return atualizado com sucesso (true) ou falha (false).
	 */
	public static boolean atualizarUsuario(Usuario usuario) {
		var success = false;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		try {
			session.update(usuario);
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
	
	/**
	 * Busca um usuário por email.
	 * 
	 * @param email Email do usuário.
	 * @return Usuário encontrado.
	 */
	public static Usuario procurarUsuarioPorEmail(String email) {
		return procurarUsuarioPor(FIELD_NAME_EMAIL, email);
	}
	
	/**
	 * Busca um usuário por cpf.
	 * 
	 * @param cpf Cpf do usuário.
	 * @return Usuário encontrado.
	 */
	public static Usuario procurarUsuarioPorCpf(String cpf) {
		return procurarUsuarioPor(FIELD_NAME_CPF, cpf);
	}
	
	/**
	 * Busca um usuário por cnpj.
	 * 
	 * @param cnpj Cnpj do usuário.
	 * @return Usuário encontrado.
	 */
	public static Usuario procurarUsuarioPorCnpj(String cnpj) {
		return procurarUsuarioPor(FIELD_NAME_CNPJ, cnpj);
	}
	
	/**
	 * Busca um usuário salvo no banco.
	 * 
	 * @param nomeCampo Campo para buscar usuário.
	 * @param valorCampo Valor do campo.
	 * @return Usuário encontrado.
	 */
	private static Usuario procurarUsuarioPor(String campo, String valor) {
		Usuario usuario = null;
		var session = sessionFactory.openSession();
		var transaction = session.beginTransaction();
		try {
			var builder = session.getCriteriaBuilder();
			var query = builder.createQuery(Usuario.class);
			
			var from = query.from(Usuario.class);
			query.select(from);
			query.where(builder.equal(from.get(campo), valor));
			
			usuario = session.createQuery(query).getSingleResult();
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return usuario;
	}
	
	/**
	 * Valida as credenciais de um usuário.
	 * 
	 * @param email Email do usuário.
	 * @param senha Senha do usuário.
	 * @return Usuario validado.
	 */
	public static Usuario validarUsuarioEmailSenha(String email, String senha) {
		var usuario = procurarUsuarioPorEmail(email);
		
		if (usuario != null && !usuario.getSenha().equals(senha)) {
			usuario = null;
		}
		return usuario;
	}
	
}
