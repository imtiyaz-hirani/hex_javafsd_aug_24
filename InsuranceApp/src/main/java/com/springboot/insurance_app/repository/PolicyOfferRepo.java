package com.springboot.insurance_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springboot.insurance_app.enums.OfferStatus;
import com.springboot.insurance_app.model.PolicyOffer;

import jakarta.transaction.Transactional;

public interface PolicyOfferRepo extends JpaRepository<PolicyOffer, Integer>{

	@Transactional
	@Modifying
	@Query("update PolicyOffer po SET po.offerStatus=?2 where po.id=?1")
	void updateStatus(int offerId, OfferStatus offerStatus);

}
