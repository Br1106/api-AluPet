package com.alupet.alupetapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alupet.alupetapi.entities.Pet;


public interface PetRepository extends JpaRepository<Pet, Long>{

}
