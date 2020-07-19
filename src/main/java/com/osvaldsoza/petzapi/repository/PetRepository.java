package com.osvaldsoza.petzapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osvaldsoza.petzapi.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{

}
