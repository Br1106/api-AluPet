package com.alupet.alupetapi.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.alupet.alupetapi.entities.Pet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;

@Data
public class AbrigoDTO {

	@NotBlank
	private String nome;
	
	@NotBlank
	@Length(min = 9)
	private String telefone;
	
	@NotBlank
	private String cidade;
	
	@NotEmpty
	private List<Pet> pets = new ArrayList<>();

}
