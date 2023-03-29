package com.alupet.alupetapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.alupet.alupetapi.entities.Tutor;
import com.alupet.alupetapi.repository.TutorRepository;
import com.alupet.alupetapi.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TutorService {

	@Autowired
	private TutorRepository repository;

	public List<Tutor> buscarTodos() {
		return repository.findAll();
	}

	public Tutor buscarPorId(Long id) {
		Optional<Tutor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Tutor inserir(Tutor obj) {
		return repository.save(obj);
	}
	public Tutor atualizar(Long id, Tutor obj) {
		try {
			Tutor tutorAtualizado = repository.getReferenceById(id);
			
			atualizarTutor(tutorAtualizado, obj );

			return repository.save(tutorAtualizado);
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
	private void atualizarTutor(Tutor tutorAtualizado, Tutor tutorSubstituido ) {
		tutorAtualizado.setNome(tutorSubstituido.getNome());
		tutorAtualizado.setTelefone(tutorSubstituido.getTelefone());
		tutorAtualizado.setCidade(tutorSubstituido.getCidade());
		tutorAtualizado.setNomePet(tutorSubstituido.getNomePet());
	}
}
