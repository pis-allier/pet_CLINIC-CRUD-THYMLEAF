package com.jagat.petclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pets")
public class Pets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long petId;
	private String petName;
	private String petBreed;
	private String petParentName;
	private String petParentCellNo;
	private String petParentAddress;
	private String isPetVaccinated;

	public long getPetId() {
		return petId;
	}

	public void setPetId(long petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetBreed() {
		return petBreed;
	}

	public void setPetBreed(String petBreed) {
		this.petBreed = petBreed;
	}

	public String getPetParentName() {
		return petParentName;
	}

	public void setPetParentName(String petParentName) {
		this.petParentName = petParentName;
	}

	public String getPetParentCellNo() {
		return petParentCellNo;
	}

	public void setPetParentCellNo(String petParentCellNo) {
		this.petParentCellNo = petParentCellNo;
	}

	public String getPetParentAddress() {
		return petParentAddress;
	}

	public void setPetParentAddress(String petParentAddress) {
		this.petParentAddress = petParentAddress;
	}

	public String getIsPetVaccinated() {
		return isPetVaccinated;
	}

	public void setIsPetVaccinated(String isPetVaccinated) {
		this.isPetVaccinated = isPetVaccinated;
	}

	public Pets(long petId, String petName, String petBreed, String petParentName, String petParentCellNo,
			String petParentAddress, String isPetVaccinated) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.petBreed = petBreed;
		this.petParentName = petParentName;
		this.petParentCellNo = petParentCellNo;
		this.petParentAddress = petParentAddress;
		this.isPetVaccinated = isPetVaccinated;
	}

	public Pets() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Pets [petId=" + petId + ", petName=" + petName + ", petBreed=" + petBreed + ", petParentName="
				+ petParentName + ", petParentCellNo=" + petParentCellNo + ", petParentAddress=" + petParentAddress
				+ ", isPetVaccinated=" + isPetVaccinated + "]";
	}

}
