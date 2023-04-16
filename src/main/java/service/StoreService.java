package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Store;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import repository.StoreRepository;

@Service
public class StoreService {

	@Autowired
	private StoreRepository repo;

	public Store save(Store store) {
		return repo.saveAndFlush(store);
	}

	public Optional<Store> findById(Long id) {
		return repo.findById(id);
	}

	public List<Store> findAll() {
		return repo.findAll();
	}

	public Store update(Store store) {
		return repo.saveAndFlush(store);
	}

	@Transactional
	public void delete(Store store) {
		repo.delete(store);
	}
	
}
