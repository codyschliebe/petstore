package pet.store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreData.PetStoreCustomer;
import pet.store.controller.model.PetStoreData.PetStoreEmployee;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {
	@Autowired
	private PetStoreService petStoreService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData postPetStore(@RequestBody PetStoreData petStoreData) {
		log.info("Creating pet store {}", petStoreData);
		petStoreData = petStoreService.savePetStore(petStoreData);
		return petStoreService.savePetStore(petStoreData);
	}

	@PutMapping("/{petStoreId}")
	public ResponseEntity<PetStoreData> putPetStore(@PathVariable Long petStoreId,
			@RequestBody PetStoreData petStoreData) {
		log.info("Updating pet store {}", petStoreData);
		petStoreData.setPetStoreId(petStoreId);
		petStoreData = petStoreService.savePetStore(petStoreData);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(petStoreData);
	}

	//****************************WEEK15******************************************
	
	@PostMapping("/{petStoreId}/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreEmployee savePetStoreEmployee(@PathVariable Long petStoreId,
			@RequestBody PetStoreEmployee petStoreEmployee) {
		log.info("Creating employee...");
		return petStoreService.saveEmployee(petStoreId, petStoreEmployee);
	}
	
	@PostMapping("/{petStoreId}/customer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreCustomer savePetStoreCustomer(@PathVariable Long petStoreId,
			@RequestBody PetStoreCustomer petStoreCustomer) {
		log.info("Processing POST request...");
		return petStoreService.saveCustomer(petStoreId, petStoreCustomer);
	}

	//********************************LIST ALL PET STORES*********************************
	
			@GetMapping
			@ResponseStatus(code = HttpStatus.CREATED)
			public List<PetStoreData> petStoreList() {
				log.info("Retrieving all pet stores...");
				return petStoreService.retrieveAllPetStores();
			}
			
	//********************************RETRIEVEPETSTOREBYID*********************************

	@GetMapping("/{petStoreId}")		
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData retrievePetStoreById(@PathVariable Long petStoreId) {
		log.info("Retrieving pet store with id=" + petStoreId + "...");
		return petStoreService.retrievePetStoreById(petStoreId);
	}
	
	//***********************************DELETEPETSTOREBYID********************************
	
	@DeleteMapping("{petStoreId}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Map<String, String> deletePetStoreById(@PathVariable Long petStoreId) {
		log.info("Deleting pet store with id=" + petStoreId + "...");
		petStoreService.deletePetStoreById(petStoreId);
		return Map.of("Message", "Pet store with id=" + petStoreId + " has been deleted.");
	}
	
}
