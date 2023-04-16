package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.bind.annotation.RestController;

import dto.StoreDto;
import entity.Store;
import jakarta.validation.Valid;
import service.StoreService;

@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreService service;

	@PostMapping("")
	public ResponseEntity<Store> saveStore(@Valid @RequestBody StoreDto dto) {
		var store = new Store();
		BeanUtils.copyProperties(dto, store);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(store));
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Store>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
		Optional<Store> optionalStore = service.findById(id);
		if (!optionalStore.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Store not Found!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(optionalStore.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid StoreDto dto) {
		Optional<Store> optionalStore = service.findById(id);
		if (!optionalStore.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Store not found");
		}
		var store = new Store();
		BeanUtils.copyProperties(dto, store);
		store.setId(optionalStore.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(service.save(store));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteStore(@PathVariable(value = "id") Long id) {
		Optional<Store> newStore = service.findById(id);
		if (!newStore.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Store not found");
		}
		service.delete(newStore.get());
		return ResponseEntity.status(HttpStatus.OK).body("Store deleted successfully");
	}
}
