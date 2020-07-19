package com.osvaldsoza.petzapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ApiModel(value = "ClienteModel", description = "É uma representa da tabela cliente no banco de dados petz")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@ApiModelProperty(example = "1")
	private Long id;
	
	
	@NotBlank
	@Column(nullable = false)
	@ApiModelProperty(example = "Fulano de Tal", required = true)
	private String nome;
}
