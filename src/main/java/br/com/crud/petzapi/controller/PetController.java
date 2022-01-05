package br.com.crud.petzapi.controller;

import br.com.crud.petzapi.model.Pet;
import br.com.crud.petzapi.service.PetService;
import br.com.crud.petzapi.utils.exception.EntidadeNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pets")
public class PetController {

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
