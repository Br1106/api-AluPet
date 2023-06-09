package com.alupet.alupetapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alupet.alupetapi.dto.AbrigoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_abrigo")
@EqualsAndHashCode(of = "id")
public class Abrigo implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String telefone;
	private String cidade;
	
	//Relação entre abrigo e pets--> 1 p/ Muitos
	@OneToMany(mappedBy = "abrigo")
	private List<Pet> pets = new ArrayList<>();
	
	public Abrigo () {}

	public Abrigo(String nome, String telefone, String cidade) {
		this.nome = nome;
		this.telefone = telefone;
		this.cidade = cidade;
	}
	public Abrigo(AbrigoDTO objDTO) {
		this.nome = objDTO.getNome();
		this.telefone = objDTO.getTelefone();
		this.cidade = objDTO.getCidade();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
