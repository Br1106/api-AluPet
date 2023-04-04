package com.alupet.alupetapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.alupet.alupetapi.entities.Abrigo;
import com.alupet.alupetapi.repository.AbrigoRepository;
import com.alupet.alupetapi.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AbrigoService {

	@Autowired
	private AbrigoRepository repository;

	public List<Abrigo> buscarTodos() {
		return repository.findAll();
	}

	public Abrigo buscarPorId(Long id) {
		Optional<Abrigo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Abrigo inserir(Abrigo obj) {
		return repository.save(obj);
	}
	public Abrigo atualizar(Long id, Abrigo obj) {
		try {
			Abrigo abrigoAtualizado = repository.getReferenceById(id);
			
			atualizarAbrigo(abrigoAtualizado, obj );

			return repository.save(abrigoAtualizado);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	public void deletar(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
/*------------------------------------------------------------------------------------------*/	
	private void atualizarAbrigo(Abrigo abrigoAtualizado, Abrigo abrigoSubstituido ) {
		abrigoAtualizado.setNome(abrigoSubstituido.getNome());
		abrigoAtualizado.setTelefone(abrigoSubstituido.getTelefone());
		abrigoAtualizado.setCidade(abrigoSubstituido.getCidade());
	}
}
