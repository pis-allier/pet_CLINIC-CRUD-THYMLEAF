package com.jagat.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jagat.petclinic.model.Pets;
import com.jagat.petclinic.repository.PetRepository;

@Service
public class PetServiceimpl implements PetService {

	@Autowired
	private PetRepository petRepository;

	@Override
	public List<Pets> listOfAllPets() {
		// TODO Auto-generated method stub
		return petRepository.findAll();
	}

	@Override
	public void saveNewPetData(Pets pets) {
		// TODO Auto-generated method stub
		this.petRepository.save(pets);

	}

	@Override
	public Pets getPetByPetId(Long petId) {
		// TODO Auto-generated method stub
		Optional<Pets> optional = petRepository.findById(petId);
		Pets pets = null;
		if (optional.isPresent()) {
			pets = optional.get();
		} else {
			throw new RuntimeException("Pet data not Found  for Id  " + petId);
		}

		return pets;
	}

	@Override
	public void deletePetDataBypetId(long petId) {
		// TODO Auto-generated method stub
		this.petRepository.deleteById(petId);
	}

	@Override
	public Page<Pets> findPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageRequest pagable = PageRequest.of(pageNo - 1, pageSize);
		return this.petRepository.findAll(pagable);
	}

}
