package com.alupet.alupetapi.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.alupet.alupetapi.entities.Pet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
	
	private List<Pet> pets = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Pet> getPets() {
		return pets;
	}
}
