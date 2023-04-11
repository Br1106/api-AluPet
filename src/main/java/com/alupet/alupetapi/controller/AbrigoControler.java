package com.alupet.alupetapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.BeanUtils;
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

import com.alupet.alupetapi.dto.AbrigoDTO;
import com.alupet.alupetapi.entities.Abrigo;
import com.alupet.alupetapi.service.AbrigoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/abrigos")
public class AbrigoControler {

	@Autowired
	private AbrigoService service;
	
	@GetMapping
	public ResponseEntity<List<Abrigo>> buscarTodos(){
		List <Abrigo> list = service.buscarTodos();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping( value = "/{id}")
	public ResponseEntity<Abrigo> buscarPorId(@PathVariable Long id){
		Abrigo obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Abrigo> cadastrar (@RequestBody @Valid AbrigoDTO objDTO){
		Abrigo obj = new Abrigo(objDTO);
		obj.getPets().addAll(objDTO.getPets()) ;
		obj = service.inserir(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Abrigo> atualizar (@PathVariable Long id,@RequestBody @Valid AbrigoDTO objDTO){
		Abrigo obj = new Abrigo(objDTO);
		obj = service.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Abrigo> deletar (@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
//-------------------------------------------------------------------------------------------------------
}
