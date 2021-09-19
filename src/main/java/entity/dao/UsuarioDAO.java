package entity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import dao.ConexaoBanco;
import entity.Usuario;
import utils.HibernateUtil;

/** Classe com métodos de crud do Usuário. */
public abstract class UsuarioDAO {
	
	/** Sessão do Hibernate para acesso ao banco. */
	static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	/**
	 * Salva um usuario no banco.
	 * @param usuario Usuário para salvar.
	 * @return salvo com sucesso (true) ou falha (false).
	 */
	public static boolean criarUsuarioV2(Usuario usuario) {
		Transaction transaction = null;
		try (var session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			
			session.save(usuario);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
			return false;
		}
		return true;
	}
	
	/**
	 * Lista os usuários salvos no banco.
	 * @return Lista de usuários.
	 */
	public static List<Usuario> listarUsuariosV2() {
		List<Usuario> usuarios = null;
		Transaction transaction = null;
		try (var session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			
			var criteriaBuilder = session.getCriteriaBuilder();
			var query = criteriaBuilder.createQuery(Usuario.class);
			query.select(query.from(Usuario.class));
		
			usuarios = session.createQuery(query).list();
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}
		return usuarios;
	}
	
	// TODO: remover os métodos abaixo assim que for implementado Hibernate a todos.

	@Deprecated
	public static List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		
		try {
			Connection bancoConexao = ConexaoBanco.conectaBanco();
			
			String sql = "SELECT * FROM `USUARIO`";
			
			PreparedStatement statement = bancoConexao.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				Long usuarioId = result.getLong("Cod_Usuario");
				String usuarioNome = result.getString("Nome_Razao");
				String usuarioEmail = result.getString("Email");
				String usuarioCep = result.getString("Cep");
				String usuarioRua = result.getString("Rua");
				int usuarioNumero = result.getInt("Numero");
				String usuarioCidade = result.getString("Cidade");
				String usuarioCpf = result.getString("Cpf");
				String usuarioCnpj = result.getString("Cnpj");
				LocalDate usuarioDataNasc = result.getDate("Data_Nasc").toLocalDate();
				
				Usuario usuario = new Usuario(
					usuarioNome,
					usuarioEmail,
					usuarioCep,
					usuarioRua,
					usuarioNumero,
					usuarioCidade,
					usuarioCpf,
					usuarioCnpj,
					usuarioDataNasc
				);
				usuario.setId(usuarioId);
				
				usuarios.add(usuario);
				
				ConexaoBanco.conectaBanco();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}

	public static Usuario procurarUsuario(Long id) {
		Usuario usuario = null;
		
		try {
			Connection bancoConexao = ConexaoBanco.conectaBanco();
			
			String sql = "SELECT * FROM `USUARIO` WHERE Cod_Usuario = ?";
			
			PreparedStatement statement = bancoConexao.prepareStatement(sql);
			statement.setLong(1, id);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				Long usuarioId = result.getLong("Cod_Usuario");
				String usuarioNome = result.getString("Nome_Razao");
				String usuarioEmail = result.getString("Email");
				String usuarioCep = result.getString("Cep");
				String usuarioRua = result.getString("Rua");
				int usuarioNumero = result.getInt("Numero");
				String usuarioCidade = result.getString("Cidade");
				String usuarioCpf = result.getString("Cpf");
				String usuarioCnpj = result.getString("Cnpj");
				LocalDate usuarioDataNasc = result.getDate("Data_Nasc").toLocalDate();
				
				usuario = new Usuario(
						usuarioNome,
						usuarioEmail,
						usuarioCep,
						usuarioRua,
						usuarioNumero,
						usuarioCidade,
						usuarioCpf,
						usuarioCnpj,
						usuarioDataNasc
				);
				usuario.setId(usuarioId);
			}

			ConexaoBanco.desconectaBanco();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return usuario;
	}

	@Deprecated
	public static boolean criarUsuario(Usuario usuario, String senha) {
		boolean criadoSucesso = false;
		
		try {
			Connection conexaoBanco = ConexaoBanco.conectaBanco();
			
			String sql = "INSERT INTO `USUARIO` VALUES (default,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement statement = conexaoBanco.prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, senha);
			statement.setString(4, usuario.getCep());
			statement.setString(5, usuario.getRua());
			statement.setInt(6, usuario.getNumero());
			statement.setString(7, usuario.getCidade());
			statement.setString(8, usuario.getCpf());
			statement.setString(9, usuario.getCnpj());
//			statement.setDate(10, usuario.getDataNasc());
			
			int result = statement.executeUpdate();
			
			if (result >= 1) {
				criadoSucesso = true;
			}
			
			ConexaoBanco.desconectaBanco();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return criadoSucesso;
	}

	public static boolean deletarUsuario(Long id) {
		boolean usuarioDeletadoSucesso = false;
		
		try {
			Connection conn = ConexaoBanco.conectaBanco();
			
			String sql = "DELETE FROM `USUARIO` WHERE Cod_Usuario = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0)
				usuarioDeletadoSucesso = true;
			
			ConexaoBanco.desconectaBanco();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return usuarioDeletadoSucesso;
	}

	public static boolean atualizarUsuario(Usuario usuario) {
		boolean usuarioAtualizadoSucesso = false;
		
		try {
			Connection conn = ConexaoBanco.conectaBanco();
			
			String sql = "UPDATE `USUARIO` SET Nome_Razao=?, Email=?, Rua=?, Cep=?, Numero=?, Cidade=?, Data_Nasc=? WHERE Cod_Usuario=?";
			 
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getRua());
			statement.setString(4, usuario.getCep());
			statement.setInt(5, usuario.getNumero());
			statement.setString(6, usuario.getCidade());
//			statement.setDate(7, usuario.getDataNasc());

			statement.setLong(8, usuario.getId());
			 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    usuarioAtualizadoSucesso = true;
			}
			
			ConexaoBanco.desconectaBanco();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return usuarioAtualizadoSucesso;
	}
	
	public static Usuario validarUsuarioEmailSenha(String email, String senha) {
		Usuario usuario = null;
		
		try {
			Connection bancoConexao = ConexaoBanco.conectaBanco();
			
			String sql = "SELECT * FROM `USUARIO` WHERE Email = ?";
			
			PreparedStatement statement = bancoConexao.prepareStatement(sql);
			statement.setString(1, email);
			
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Long usuarioId = result.getLong("Cod_Usuario");
				String usuarioNome = result.getString("Nome_Razao");
				String usuarioEmail = result.getString("Email");
				String usuarioCep = result.getString("Cep");
				String usuarioRua = result.getString("Rua");
				int usuarioNumero = result.getInt("Numero");
				String usuarioCidade = result.getString("Cidade");
				String usuarioCpf = result.getString("Cpf");
				String usuarioCnpj = result.getString("Cnpj");
				LocalDate usuarioDataNasc = result.getDate("Data_Nasc").toLocalDate();
				
				String usuarioSenha = result.getString("Senha");
				
				usuario = new Usuario(
						usuarioNome,
						usuarioEmail,
						usuarioCep,
						usuarioRua,
						usuarioNumero,
						usuarioCidade,
						usuarioCpf,
						usuarioCnpj,
						usuarioDataNasc
				);
				usuario.setId(usuarioId);
				
				if (!usuarioSenha.equals(senha)) {
					usuario = null;
				}
			}
			
			ConexaoBanco.desconectaBanco();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return usuario;
	}
	
	public static Usuario procurarUsuarioPorEmail(String email) {
		Usuario usuario = null;
		
		try {
			Connection bancoConexao = ConexaoBanco.conectaBanco();
			
			String sql = "SELECT * FROM `USUARIO` WHERE Email = ?";
			
			PreparedStatement statement = bancoConexao.prepareStatement(sql);
			statement.setString(1, email);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				Long usuarioId = result.getLong("Cod_Usuario");
				String usuarioNome = result.getString("Nome_Razao");
				String usuarioEmail = result.getString("Email");
				String usuarioCep = result.getString("Cep");
				String usuarioRua = result.getString("Rua");
				int usuarioNumero = result.getInt("Numero");
				String usuarioCidade = result.getString("Cidade");
				String usuarioCpf = result.getString("Cpf");
				String usuarioCnpj = result.getString("Cnpj");
				LocalDate usuarioDataNasc = result.getDate("Data_Nasc").toLocalDate();
				
				usuario = new Usuario(
						usuarioNome,
						usuarioEmail,
						usuarioCep,
						usuarioRua,
						usuarioNumero,
						usuarioCidade,
						usuarioCpf,
						usuarioCnpj,
						usuarioDataNasc
				);
				usuario.setId(usuarioId);
			}
			
			ConexaoBanco.desconectaBanco();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return usuario;
	}
	
	public static Usuario procurarUsuarioPorCpf(String cpf) {
		Usuario usuario = null;
		
		try {
			Connection bancoConexao = ConexaoBanco.conectaBanco();
			
			String sql = "SELECT * FROM `USUARIO` WHERE Cpf = ?";
			
			PreparedStatement statement = bancoConexao.prepareStatement(sql);
			statement.setString(1, cpf);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				Long usuarioId = result.getLong("Cod_Usuario");
				String usuarioNome = result.getString("Nome_Razao");
				String usuarioEmail = result.getString("Email");
				String usuarioCep = result.getString("Cep");
				String usuarioRua = result.getString("Rua");
				int usuarioNumero = result.getInt("Numero");
				String usuarioCidade = result.getString("Cidade");
				String usuarioCpf = result.getString("Cpf");
				String usuarioCnpj = result.getString("Cnpj");
				LocalDate usuarioDataNasc = result.getDate("Data_Nasc").toLocalDate();
				
				usuario = new Usuario(
						usuarioNome,
						usuarioEmail,
						usuarioCep,
						usuarioRua,
						usuarioNumero,
						usuarioCidade,
						usuarioCpf,
						usuarioCnpj,
						usuarioDataNasc
				);
				usuario.setId(usuarioId);
			}
			
			ConexaoBanco.desconectaBanco();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return usuario;
	}
	
	public static Usuario procurarUsuarioPorCnpj(String cnpj) {
		Usuario usuario = null;
		
		try {
			Connection bancoConexao = ConexaoBanco.conectaBanco();
			
			String sql = "SELECT * FROM `USUARIO` WHERE Cnpj = ?";
			
			PreparedStatement statement = bancoConexao.prepareStatement(sql);
			statement.setString(1, cnpj);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				Long usuarioId = result.getLong("Cod_Usuario");
				String usuarioNome = result.getString("Nome_Razao");
				String usuarioEmail = result.getString("Email");
				String usuarioCep = result.getString("Cep");
				String usuarioRua = result.getString("Rua");
				int usuarioNumero = result.getInt("Numero");
				String usuarioCidade = result.getString("Cidade");
				String usuarioCpf = result.getString("Cpf");
				String usuarioCnpj = result.getString("Cnpj");
				LocalDate usuarioDataNasc = result.getDate("Data_Nasc").toLocalDate();
				
				usuario = new Usuario(
						usuarioNome,
						usuarioEmail,
						usuarioCep,
						usuarioRua,
						usuarioNumero,
						usuarioCidade,
						usuarioCpf,
						usuarioCnpj,
						usuarioDataNasc
				);
				usuario.setId(usuarioId);
			}
			
			ConexaoBanco.desconectaBanco();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return usuario;
	}
}
