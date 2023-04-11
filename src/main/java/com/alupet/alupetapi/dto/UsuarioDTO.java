package com.alupet.alupetapi.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

@Data
public class UsuarioDTO {

	@NotBlank
	@Length(min = 3, max = 35, message = "O nome deverá ter no Máximo {max} caracteres")
	private String nome;
	
	@NotBlank
	@Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", message = "Endereço de e-mail inválido")
	private String email;
	
	@NotBlank
	@Pattern(regexp = "^(?=.*[A-Z]).{6,12}$", message = "A senha deve ter pelo menos 6 caracteres, no máximo 12 caracteres e pelo menos uma letra maiúscula")
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
