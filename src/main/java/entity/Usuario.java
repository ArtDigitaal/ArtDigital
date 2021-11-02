package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usuario")
	private Long id;
	
	@Column(name = "nome_razao")
	private String nome;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@OneToOne
	@JoinColumn(name = "id_login")
	@Cascade(CascadeType.ALL)
	private Login login;

	@Column(name = "cep")
	private String cep;

	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "rua")
	private String rua;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "uf")
	private String uf;
	
	@Column(name = "cpf", unique = true)
	private String cpf;
	
	@Column(name = "cnpj", unique = true)
	private String cnpj;
	
	public Usuario() {
	}

	public Usuario(String nome, String telefone, String email, Login login, String cep, String bairro,
			String rua, int numero, String cidade, String uf, String cpf, String cnpj) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.login = login;
		this.cep = cep;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.uf = uf;
		this.cpf = cpf;
		this.cnpj = cnpj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", login="
				+ login + ", cep=" + cep + ", bairro=" + bairro + ", rua=" + rua + ", numero=" + numero + ", cidade="
				+ cidade + ", uf=" + uf + ", cpf=" + cpf + ", cnpj=" + cnpj + "]";
	}
	
}
