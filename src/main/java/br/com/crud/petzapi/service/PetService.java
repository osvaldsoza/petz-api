package br.com.crud.petzapi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.crud.petzapi.model.Pet;
import br.com.crud.petzapi.repository.PetRepository;
import br.com.crud.petzapi.utils.exception.EntidadeNaoEncontradaException;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;

	public List<Pet> listaPets() {
		return petRepository.findAll();
	}

	public Pet buscarPetPorId(Long petId) {
		var pet = petRepository.findById(petId).orElseThrow(
				() -> new EntidadeNaoEncontradaException(String.format("Pet de código %d não encontrado.", petId)));
		
		return pet;
	}

	public Pet salvar(Pet pet) {
		return petRepository.save(pet);
	}

	public Pet atualizar(Long petId, Pet pet) {
		var petAtual = buscarPetPorId(petId);

		BeanUtils.copyProperties(pet, petAtual, "id");
		
		return salvar(petAtual);
	}

	public void remover(Long petId) {
		try {
			petRepository.deleteById(petId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Pet de código %d não encontrado.", petId));
		} 
	}
}
