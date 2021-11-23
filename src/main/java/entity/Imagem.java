package entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imagem")
public class Imagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_img")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "bytes")
	private byte[] bytes;
	
	public Imagem() {
	}
	
	public Imagem(String nome, String tipo, byte[] bytes) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.bytes = bytes;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	@Override
	public String toString() {
		return "Imagem [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", bytes=" + Arrays.toString(bytes) + "]";
	}
}
