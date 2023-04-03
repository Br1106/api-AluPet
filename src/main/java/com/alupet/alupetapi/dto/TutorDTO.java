package com.alupet.alupetapi.dto;

import java.util.ArrayList;
import java.util.List;

import com.alupet.alupetapi.entities.Pet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TutorDTO {

	@NotBlank
	private String nome;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cidade;
	@NotEmpty
	private List<Pet> pets = new ArrayList<>();

}
