package com.alupet.alupetapi.entities;

import java.io.Serializable;

import com.alupet.alupetapi.enums.Porte;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_pet")

@EqualsAndHashCode(of = "id")
public class Pet implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer idade;
	private String personalidade;

	private Porte porte;
	
	//Necessário para rodar a API
	@JsonIgnore
	//Muitos p/ 1
	@ManyToOne
	@JoinColumn(name = "dono_id")//Coluna contendo o Id do dono do Pet
	private Tutor dono;

	public Pet() {}

	
	public Pet(String nome, Integer idade, String personalidade, Porte porte, Tutor dono) {
		this.nome = nome;
		this.idade = idade;
		this.personalidade = personalidade;
		this.porte = porte;
		this.dono = dono;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


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

	public Porte getPorte() {
		return porte;
	}

	public void setPorte(Porte porte) {
		this.porte = porte;
	}

	public Tutor getDono() {
		return dono;
	}

	public void setDono(Tutor dono) {
		this.dono = dono;
	}
	
}
