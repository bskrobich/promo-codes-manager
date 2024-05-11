package com.bskrobich.promocodesmanager.Repository;

import com.bskrobich.promocodesmanager.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
