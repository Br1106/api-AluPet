package com.alupet.alupetapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alupet.alupetapi.entities.Tutor;
import com.alupet.alupetapi.service.TutorService;

@RestController
@RequestMapping(value = "/tutores")
public class TutorControler {

	@Autowired
	private TutorService service;
	
	@GetMapping
	public ResponseEntity<List<Tutor>> buscarTodos(){
		List <Tutor> list = service.buscarTodos();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping( value = "/{id}")
	public ResponseEntity<Tutor> buscarPorId(@PathVariable Long id){
		Tutor obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Tutor> insert (@RequestBody Tutor obj){
		obj = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Tutor> atualizar (@PathVariable Long id,@RequestBody Tutor obj){
		obj = service.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Tutor> deletar (@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
