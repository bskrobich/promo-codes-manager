package com.bskrobich.promocodesmanager.Repository;

import com.bskrobich.promocodesmanager.Model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
