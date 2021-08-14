package Usuario;

import java.sql.Date;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String cep;
	private String rua;
	private int numero;
	private String cidade;
	private String cpf;
	private String cnpj;
	private Date dataNasc;
	
	public Usuario(String nome, String email, String cep, String rua, int numero, String cidade, String cpf,
			String cnpj, Date dataNasc) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", cep=" + cep + ", rua=" + rua
				+ ", numero=" + numero + ", cidade=" + cidade + ", cpf=" + cpf + ", cnpj=" + cnpj + ", dataNasc="
				+ dataNasc + "]";
	}
}
