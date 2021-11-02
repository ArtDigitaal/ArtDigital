package entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_login")
	private Long id;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@Column(name = "data_acesso")
	private LocalDateTime dataAcesso;
	
	public Login() {
		super();
	}

	public Login(String senha, LocalDateTime dataAcesso) {
		super();
		this.senha = senha;
		this.dataAcesso = dataAcesso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDateTime getDataAcesso() {
		return dataAcesso;
	}

	public void setDataAcesso(LocalDateTime dataAcesso) {
		this.dataAcesso = dataAcesso;
	}
	
	
}
