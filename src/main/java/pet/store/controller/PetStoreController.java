package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {
	@Autowired
	private PetStoreService petStoreService;
	//private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PetStoreService.class);

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData postPetStore(@RequestBody PetStoreData petStoreData) {
		log.info("Processing POST request...");
		petStoreData = petStoreService.savePetStore(petStoreData);
		return petStoreService.savePetStore(petStoreData);
	}

	@PutMapping("/{petStoreId}")
	public ResponseEntity<PetStoreData> putPetStore(@PathVariable Long petStoreId,
			@RequestBody PetStoreData petStoreData) {
		log.info("Processing PUT request...");
		petStoreData.setPetStoreId(petStoreId);
		petStoreData = petStoreService.savePetStore(petStoreData);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(petStoreData);
	}

}
