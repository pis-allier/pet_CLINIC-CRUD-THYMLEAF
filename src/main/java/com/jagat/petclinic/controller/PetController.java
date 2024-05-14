package com.jagat.petclinic.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jagat.petclinic.model.Pets;
import com.jagat.petclinic.service.PetService;
import com.razorpay.*;

@Controller
public class PetController {

	@Autowired
	private PetService petService;

	// method to get home page
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, model);

	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
		// TODO Auto-generated method stub
		int pageSize = 4;
		Page<Pets> page = petService.findPaginated(pageNo, pageSize);
		List<Pets> listOfPets = page.getContent();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listOfPets", listOfPets);
		return "index";

	}

	// method to show pet Form
	@GetMapping("/showPetForm")
	private String shoiwPetForm(Model model) {
		Pets pets = new Pets();
		model.addAttribute("pets", pets);
		return "new_form";

	}

	// method to save pets data to database
	@PostMapping("/savePetData")
	public String savePetData(@ModelAttribute("pets") Pets pets) {
		petService.saveNewPetData(pets);
		return "redirect:/";
	}

	// method to update pet data
	@GetMapping("/showUpdateForm/{petId}")
	public String showUpdateForm(@PathVariable(value = "petId") long petId, Model model) {
		// long Id = Long.parseLong(petId);

		Pets pets = petService.getPetByPetId(petId);
		model.addAttribute("pets", pets);
		return "update_pet";
	}

	// method to delete pet
	@GetMapping("/deletePet/{petId}")
	public String deletePet(@PathVariable("petId") long petId) {
		this.petService.deletePetDataBypetId(petId);
		return "redirect:/";
	}

	// for payement gatweay
	@PostMapping("/users/create_order")
	@ResponseBody
	public String createOrder(@RequestBody Map<String, Object> data) throws RazorpayException {
		System.out.println("order function excuted");
		System.out.println(data);
		int amt = Integer.parseInt(data.get("amount").toString());
        RazorpayClient razorpayClient = new RazorpayClient("rzp_test_aHlBaemyMYgYm4", "d78osLPimkiYNEJ3DJfSbXcR");
	    JSONObject ob =  new JSONObject();
	    ob.put("amount", amt * 100);
	    ob.put("currency", "INR");
	   // ob.put("reciept", "txn_4587");
       //creating  new order
	    Order order = razorpayClient.orders.create(ob);
	    System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println(order);
        return order.toString();
	}
}
