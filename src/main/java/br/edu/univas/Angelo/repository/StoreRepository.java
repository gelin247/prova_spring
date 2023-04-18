package br.edu.univas.Angelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.Angelo.entity.Store;

@Repository

public interface StoreRepository extends JpaRepository<Store, Long> {

}
