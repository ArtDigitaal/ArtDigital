package Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import DAO.ConexaoBanco;

public abstract class UsuarioDAO {
	public static List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		
		try {
			Connection bancoConexao = ConexaoBanco.conectaBanco();
			
			String sql = "SELECT * FROM `USUARIO`";
			
			PreparedStatement statement = bancoConexao.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				int usuarioId = result.getInt("Cod_Usuario");
				String usuarioNome = result.getString("Nome_Razao");
				String usuarioEmail = result.getString("Email");
				String usuarioCep = result.getString("Cep");
				String usuarioRua = result.getString("Rua");
				int usuarioNumero = result.getInt("Numero");
				String usuarioCidade = result.getString("Cidade");
				String usuarioCpf = result.getString("Cpf");
				String usuarioCnpj = result.getString("Cnpj");
				Date usuarioDataNasc = result.getDate("Data_Nasc");
				
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

	public static Usuario procurarUsuario(int id) {
		Usuario usuario = null;
		
		try {
			Connection bancoConexao = ConexaoBanco.conectaBanco();
			
			String sql = "SELECT * FROM `USUARIO` WHERE Cod_Usuario = ?";
			
			PreparedStatement statement = bancoConexao.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				int usuarioId = result.getInt("Cod_Usuario");
				String usuarioNome = result.getString("Nome_Razao");
				String usuarioEmail = result.getString("Email");
				String usuarioCep = result.getString("Cep");
				String usuarioRua = result.getString("Rua");
				int usuarioNumero = result.getInt("Numero");
				String usuarioCidade = result.getString("Cidade");
				String usuarioCpf = result.getString("Cpf");
				String usuarioCnpj = result.getString("Cnpj");
				Date usuarioDataNasc = result.getDate("Data_Nasc");
				
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
			statement.setDate(10, usuario.getDataNasc());
			
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

	public static boolean deletarUsuario(int id) {
		boolean usuarioDeletadoSucesso = false;
		
		try {
			Connection conn = ConexaoBanco.conectaBanco();
			
			String sql = "DELETE FROM `USUARIO` WHERE Cod_Usuario = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			
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
			statement.setDate(7, usuario.getDataNasc());

			statement.setInt(8, usuario.getId());
			 
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
				int usuarioId = result.getInt("Cod_Usuario");
				String usuarioNome = result.getString("Nome_Razao");
				String usuarioEmail = result.getString("Email");
				String usuarioCep = result.getString("Cep");
				String usuarioRua = result.getString("Rua");
				int usuarioNumero = result.getInt("Numero");
				String usuarioCidade = result.getString("Cidade");
				String usuarioCpf = result.getString("Cpf");
				String usuarioCnpj = result.getString("Cnpj");
				Date usuarioDataNasc = result.getDate("Data_Nasc");
				
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
				int usuarioId = result.getInt("Cod_Usuario");
				String usuarioNome = result.getString("Nome_Razao");
				String usuarioEmail = result.getString("Email");
				String usuarioCep = result.getString("Cep");
				String usuarioRua = result.getString("Rua");
				int usuarioNumero = result.getInt("Numero");
				String usuarioCidade = result.getString("Cidade");
				String usuarioCpf = result.getString("Cpf");
				String usuarioCnpj = result.getString("Cnpj");
				Date usuarioDataNasc = result.getDate("Data_Nasc");
				
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
				int usuarioId = result.getInt("Cod_Usuario");
				String usuarioNome = result.getString("Nome_Razao");
				String usuarioEmail = result.getString("Email");
				String usuarioCep = result.getString("Cep");
				String usuarioRua = result.getString("Rua");
				int usuarioNumero = result.getInt("Numero");
				String usuarioCidade = result.getString("Cidade");
				String usuarioCpf = result.getString("Cpf");
				String usuarioCnpj = result.getString("Cnpj");
				Date usuarioDataNasc = result.getDate("Data_Nasc");
				
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
				int usuarioId = result.getInt("Cod_Usuario");
				String usuarioNome = result.getString("Nome_Razao");
				String usuarioEmail = result.getString("Email");
				String usuarioCep = result.getString("Cep");
				String usuarioRua = result.getString("Rua");
				int usuarioNumero = result.getInt("Numero");
				String usuarioCidade = result.getString("Cidade");
				String usuarioCpf = result.getString("Cpf");
				String usuarioCnpj = result.getString("Cnpj");
				Date usuarioDataNasc = result.getDate("Data_Nasc");
				
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
