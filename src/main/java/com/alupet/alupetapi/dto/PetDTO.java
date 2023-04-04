package com.alupet.alupetapi.dto;

import com.alupet.alupetapi.entities.Abrigo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PetDTO {
	@NotBlank
	private String nome;
	@NotBlank
	private Integer idade;
	@NotBlank
	private String personalidade;
	@NotEmpty
	private Abrigo abrigo;
}
