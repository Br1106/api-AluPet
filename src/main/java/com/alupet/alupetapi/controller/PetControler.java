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

import com.alupet.alupetapi.dto.PetDTO;
import com.alupet.alupetapi.dto.UsuarioDTO;
import com.alupet.alupetapi.entities.Pet;
import com.alupet.alupetapi.entities.Tutor;
import com.alupet.alupetapi.service.PetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pets")
public class PetControler {

	@Autowired
	private PetService service;
	
	@GetMapping
	public ResponseEntity<List<Pet>> buscarTodos(){
		List <Pet> list = service.buscarTodos();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping( value = "/{id}")
	public ResponseEntity<Pet> buscarPorId(@PathVariable Long id){
		Pet obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping(name = "/cadastrar")
	public ResponseEntity<Pet> cadastrar (@RequestBody @Valid PetDTO objDTO){
		Pet obj = converterDTO(objDTO);
		obj = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pet> atualizar (@PathVariable Long id,@RequestBody @Valid PetDTO objDTO){
		Pet obj = converterDTO(objDTO);
		obj = service.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Pet> deletar (@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
//------------------------------------------------------------------------------------
	private Pet converterDTO(PetDTO objDTO) {
		Pet obj = new Pet();
		BeanUtils.copyProperties(objDTO, obj);
		return obj;	
	}
	
}
