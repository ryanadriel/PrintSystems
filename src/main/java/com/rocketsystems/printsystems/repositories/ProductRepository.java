package com.rocketsystems.printsystems.repositories;

import com.rocketsystems.printsystems.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
