package com.jagat.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jagat.petclinic.model.Pets;

@Repository
public interface PetRepository extends JpaRepository<Pets, Long> {

}
