package com.alupet.alupetapi.dto;

import org.hibernate.validator.constraints.Length;

import com.alupet.alupetapi.entities.Abrigo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PetDTO {
	@NotBlank
	private String nome;

	private Integer idade;
	@NotBlank
	private String personalidade;

	private Abrigo abrigo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getPersonalidade() {
		return personalidade;
	}
	public void setPersonalidade(String personalidade) {
		this.personalidade = personalidade;
	}
	public Abrigo getAbrigo() {
		return abrigo;
	}
	public void setAbrigo(Abrigo abrigo) {
		this.abrigo = abrigo;
	}
	
	
}
