package com.osvaldsoza.petzapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.osvaldsoza.petzapi.controller.openapi.PetControllerOpenApi;
import com.osvaldsoza.petzapi.model.Pet;
import com.osvaldsoza.petzapi.service.PetService;
import com.osvaldsoza.petzapi.utils.exception.EntidadeNaoEncontradaException;

@CrossOrigin
@RestController
@RequestMapping("/pets")
public class PetController implements PetControllerOpenApi {

	@Autowired
	private PetService petService;

	@GetMapping
	public List<Pet> listaPets() {
		return petService.listaPets();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarpet(@PathVariable("id") Long petID) {
		try {
			var pet = petService.buscarPetPorId(petID);
			return ResponseEntity.ok().body(pet);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pet adicionaPet(@RequestBody @Valid Pet pet) {
		return petService.salvar(pet);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizapet(@PathVariable("id") Long petId, @RequestBody @Valid Pet pet) {
		try {
			pet = petService.atualizar(petId, pet);
			return ResponseEntity.status(HttpStatus.OK).body(pet);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable("id") Long petId) {
		try {
			petService.remover(petId);
			return ResponseEntity.noContent().build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
