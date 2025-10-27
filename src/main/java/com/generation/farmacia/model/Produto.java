package com.generation.farmacia.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	
	// Atributos
	
	@Id // Indica que o atributo é a chave primária da entidade.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração automática do valor da chave primária
	private Long id; // Identificador único do produto.
	
	@NotBlank(message = "O nome é obrigatório!") // Indica que o atributo não pode ser nulo ou vazio.
	@Size(min = 3, max = 100, message = "O atributo nome deve conter no mínimo 3 e no máximo 100 caracteres") // Define o tamanho mínimo e máximo do atributo.
	@Column(nullable = false, length = 100) // Garante que a coluna não pode ser nula e define seu tamanho máximo.
	private String nome; // Nome do produto.
	
	@Size(min = 5, max = 500) // Define o tamanho mínimo e máximo do atributo.
	@Column(nullable = false, length = 500) // Garante que a coluna não pode ser nula e define seu tamanho máximo.
	private String descricao; // Descrição do produto.
	
    @Column(nullable = false, precision = 12, scale = 2) // Define o nome da coluna, se ela pode ser nula, precisão e escala.
	@NotNull(message = "O preço é obrigatório!") // Indica que o atributo não pode ser nulo.
	@DecimalMin(value = "0.01", inclusive = true, message = "O preço não pode ser negativo nem zero.") // Garante que o valor mínimo seja 0.01.
	@Digits(integer = 10, fraction = 2) // Define o número máximo de dígitos inteiros e fracionários.
	private BigDecimal preco; // Preço do produto.

    @NotNull(message = "A quantidade é obrigatória.") // Indica que o atributo não pode ser nulo.
    @Positive(message = "A quantidade deve ser maior que zero.") // Garante que o valor seja positivo.
    @Column(nullable = false) // Garante que a coluna não pode ser nula.
	private Integer quantidade; // Quantidade em estoque do produto.
	
    @NotBlank(message = "O laboratório é obrigatório.") // Indica que o atributo não pode ser nulo ou vazio.
    @Size(max = 100) // Define o tamanho máximo do atributo.
    @Column(nullable = false, length = 100) // Garante que a coluna não pode ser nula e define seu tamanho máximo.
	private String laboratorio; // Nome do laboratório fabricante do produto.
	
    @Size(max = 500) // Define o tamanho máximo do atributo.
    @Column(length = 500) // Define o tamanho máximo da coluna.
	private String foto; // URL da foto do produto.
    
    @Column(name = "receita_obrigatoria", nullable = false) // Define o nome da coluna e se ela pode ser nula.
    private boolean receitaObrigatoria; // Indica se o produto requer receita médica.
    
    @ManyToOne 	//Muitos produtos podem pertencer a uma categoria.
    @JsonIgnoreProperties("produtos") //Relacionação bidirecional, ignorando a propriedade "produtos" na serialização JSON
    private Categoria categoria;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public boolean isReceitaObrigatoria() {
		return receitaObrigatoria;
	}

	public void setReceitaObrigatoria(boolean receitaObrigatoria) {
		this.receitaObrigatoria = receitaObrigatoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
    

}
