package com.generation.farmacia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity // Indica que a classe é uma entidade JPA, ou seja, que será mapeada para uma tabela no banco de dados.
@Table(name = "tb_categorias") // Define o nome da tabela no banco de dados que será mapeada para essa entidade.
public class Categoria {
	
	// Atributos
	
	@Id // Indica que o atributo é a chave primária da entidade.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração automática do valor da chave primária
	private Long id;
	
	@NotBlank(message = "O atributo tipo é obrigatório!") // Indica que o atributo não pode ser nulo ou vazio.
	@Size(min = 3, max = 100, message = "O atributo tipo deve conter no mínimo 3 e no máximo 100 caracteres") // Define o tamanho mínimo e máximo do atributo.
	@Column(name = "tipo", nullable = false, length = 100) // Define o nome da coluna, se ela pode ser nula e seu tamanho máximo.
	private String tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
