package com.jagat.petclinic.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.jagat.petclinic.model.Pets;

public interface PetService {

	List<Pets> listOfAllPets();

	void saveNewPetData(Pets pets);

	Pets getPetByPetId(Long petId);

	void deletePetDataBypetId(long petId);

	// method for pagination
	Page<Pets> findPaginated(int pageNo, int pageSize);
}
