package com.bskrobich.promocodesmanager.Repository;

import com.bskrobich.promocodesmanager.Model.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoCodeRepository extends JpaRepository<PromoCode, String> {
}
