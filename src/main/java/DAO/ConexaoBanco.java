package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class ConexaoBanco {
	
	private static Connection con = null;
	
	private final static String url = "jdbc:mysql://localhost:44149/ARTDIGITAL";
	private final static String user = "root";
	private final static String senha = "my-secret-pw";

	public static Connection conectaBanco(){
		if(con == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, senha);
				System.out.println("Conexão realizada com sucesso!");
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Erro na conexão com o banco de dados");
			}
		}
		return con;
	}
	
	public static void desconectaBanco() {
		if(con != null) {
			try {
				con.close();
				con = null;
				System.out.println("Conexão fechada com sucesso!");
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Erro ao fechar conexão com o banco de dados");
			}
		}
	}
}
