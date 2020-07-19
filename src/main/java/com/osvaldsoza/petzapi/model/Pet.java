package com.osvaldsoza.petzapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@ApiModel(value = "PetModel", description = "É uma representa da tabela pet no banco de dados petz")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@ApiModelProperty(example = "4")
	private Long id;
	
	
	@NotBlank
	@Column(nullable = false)
	@ApiModelProperty(example = "Anakin", required = true)
	private String nome;

	@Enumerated(EnumType.STRING)
	@NotBlank
	@Column(nullable = false)
	@ApiModelProperty(example = "GATO", required = true)
	private Tipo tipo;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente cliente;
}
