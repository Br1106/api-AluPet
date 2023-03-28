package com.alupet.alupetapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alupet.alupetapi.entities.Tutor;
import com.alupet.alupetapi.repository.TutorRepository;
import com.alupet.alupetapi.service.exceptions.ResourceNotFoundException;

@Service
public class TutorService {

	@Autowired
	private TutorRepository repository;

	public List<Tutor> listarTurores() {
		return repository.findAll();
	}

	public Tutor buscarPorId(Long id) {
		Optional<Tutor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
