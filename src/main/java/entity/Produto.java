package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_prod")
	private Long id;
	@Column(name = "descricao_prod")
	private String descricao;
	@Column(name = "nome_prod")
	private String nome;
	@Column(name = "quantidade")
	private int quantidade;
	@Column(name = "valor_unit")
	private Double valorUnit;
	@OneToOne
	@JoinColumn(name = "cod_img", nullable = false)
	private Imagem imagem;
	@ManyToOne
	@JoinColumn(name = "cod_categ", nullable = false)
	private Categoria categoria;
	
	public Produto() {
	}
	
	public Produto(Long id, String descricao, String nome, int quantidade, Double valorUnit, Categoria categoria, Imagem imagem) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valorUnit = valorUnit;
		this.categoria = categoria;
		this.imagem = imagem;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(Double valorUnit) {
		this.valorUnit = valorUnit;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Imagem getImagem() {
		return this.imagem;
	}
	
	public void setImagem(Imagem imagem) {
		
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", nome=" + nome + ", quantidade=" + quantidade
				+ ", valorUnit=" + valorUnit + ", categoria=" + categoria + ", imagem=" + imagem + "]";
	}
	
}
