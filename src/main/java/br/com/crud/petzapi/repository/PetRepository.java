package br.com.crud.petzapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crud.petzapi.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{

}
