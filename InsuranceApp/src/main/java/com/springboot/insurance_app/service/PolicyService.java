package com.springboot.insurance_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.insurance_app.enums.OfferStatus;
import com.springboot.insurance_app.model.PolicyOffer;
import com.springboot.insurance_app.model.Vehicle;
import com.springboot.insurance_app.repository.PolicyOfferRepo;
import com.springboot.insurance_app.repository.VehicleRepo;
import com.springboot.insurance_app.utility.PolicyUtility;

@Service
public class PolicyService {

	@Autowired
	private PolicyUtility policyUtility;
	
	@Autowired
	private PolicyOfferRepo policyOfferRepo;
	
	@Autowired
	private VehicleRepo vehicleRepo;
	
	public List<PolicyOffer> getPolicyOffer(PolicyOffer policyOffer, int vid) {
		
		Vehicle vehicle = vehicleRepo.findById(vid).get();
		policyOffer.setVehicle(vehicle);
		
		List<PolicyOffer> list =  policyUtility.computePremium(policyOffer);
		//insert list in DB -- Spring batch processing
		 
		policyOfferRepo.saveAll(list);
		return list;
	}

	public void updateStatus(int offerId, OfferStatus offerStatus) {
		 policyOfferRepo.updateStatus(offerId,offerStatus); 
		
	}

}
