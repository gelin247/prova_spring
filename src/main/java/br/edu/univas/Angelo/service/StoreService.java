package br.edu.univas.Angelo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univas.Angelo.entity.Store;
import br.edu.univas.Angelo.repository.StoreRepository;
import jakarta.transaction.Transactional;

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
