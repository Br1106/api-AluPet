package com.alupet.alupetapi.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioDTO {

	@NotBlank(message = "O nome é Obrigatório")
	@Length(min = 3, max = 35, message = "O nome deverá ter no Máximo {max} caracteres")
	private String nome;
	
	@NotBlank(message = "O E-mail é Obrigatório")
	private String email;
	
	@NotBlank(message = "A Senha é Obrigatória")
	@Length(min = 6,max = 12)
	private String senha;
}
