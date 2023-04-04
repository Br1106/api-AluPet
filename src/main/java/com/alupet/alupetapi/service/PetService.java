package com.alupet.alupetapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.alupet.alupetapi.entities.Pet;
import com.alupet.alupetapi.repository.PetRepository;
import com.alupet.alupetapi.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PetService {

	@Autowired
	private PetRepository repository;

	public List<Pet> buscarTodos() {
		return repository.findAll();
	}

	public Pet buscarPorId(Long id) {
		Optional<Pet> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Pet inserir(Pet obj) {
		return repository.save(obj);
	}
	public void deletar(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	public Pet atualizar(Long id, Pet obj) {
		try {
			Pet petAtualizado = repository.getReferenceById(id);
			
			atualizarPet(petAtualizado, obj );

			return repository.save(petAtualizado);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void atualizarPet(Pet petAtualizado, Pet petSubstituido ) {
		petAtualizado.setNome(petSubstituido.getNome());
		petAtualizado.setIdade(petSubstituido.getIdade());
		petAtualizado.setPersonalidade(petSubstituido.getPersonalidade());
		petAtualizado.setAbrigo(petSubstituido.getAbrigo());
	}

}
