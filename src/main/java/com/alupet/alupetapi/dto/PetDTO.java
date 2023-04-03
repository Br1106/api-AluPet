package com.alupet.alupetapi.dto;

import com.alupet.alupetapi.entities.Tutor;
import com.alupet.alupetapi.enums.Porte;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class PetDTO {
	@NotBlank
	private String nome;
	@NotBlank
	private Integer idade;
	@NotBlank
	private String personalidade;
	@Enumerated
	private Porte porte;
	@NotEmpty
	private Tutor dono;
}
