package com.bskrobich.promocodesmanager.repository;

import com.bskrobich.promocodesmanager.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
