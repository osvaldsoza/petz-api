package br.com.crud.petzapi.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	
	@NotBlank
	@Column(nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	@NotBlank
	@Column(nullable = false)
	private Tipo tipo;

}
