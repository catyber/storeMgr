package com.catdev.storeMgr.repository;

import com.catdev.storeMgr.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByStoreId(Long storeId, Pageable pageable);
    Optional<Product> findByIdAndStoreId(Long id, Long storeId);
}