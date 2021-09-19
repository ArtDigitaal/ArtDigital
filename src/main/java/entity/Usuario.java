package entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Cod_Usuario")
	private Long id;
	@Column(name = "Nome_Razao")
	private String nome;
	@Column(name = "Email")
	private String email;
	@Column(name = "Cep")
	private String cep;
	@Column(name = "Rua")
	private String rua;
	@Column(name = "Numero")
	private int numero;
	@Column(name = "Cidade")
	private String cidade;
	@Column(name = "Cpf")
	private String cpf;
	@Column(name = "Cnpj")
	private String cnpj;
	@Column(name = "Data_Nasc")
	private LocalDate dataNasc;
	
	public Usuario() {
	}
	
	public Usuario(String nome, String email, String cep, String rua, int numero, String cidade, String cpf,
			String cnpj, LocalDate dataNasc) {
		super();
		this.nome = nome;
		this.email = email;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.dataNasc = dataNasc;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", cep=" + cep + ", rua=" + rua
				+ ", numero=" + numero + ", cidade=" + cidade + ", cpf=" + cpf + ", cnpj=" + cnpj + ", dataNasc="
				+ dataNasc + "]";
	}
}
