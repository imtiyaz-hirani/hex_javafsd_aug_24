package com.springboot.insurance_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.insurance_app.enums.OfferStatus;
import com.springboot.insurance_app.model.PolicyOffer;
import com.springboot.insurance_app.service.PolicyService;

@RestController
public class PolicyController {

	@Autowired
	private PolicyService policyService;
	
	@PostMapping("/policy/offer/{vid}")
	public List<PolicyOffer> getPolicyOffer(@RequestBody PolicyOffer policyOffer, @PathVariable int vid) {
		
		return policyService.getPolicyOffer(policyOffer, vid);
		
	}
	
	@PutMapping("/policy/update/{offerId}/{status}")
	public void updateStatus(@PathVariable int offerId, @PathVariable String status) {
		OfferStatus offerStatus = OfferStatus.valueOf(status.toUpperCase()); 
		policyService.updateStatus(offerId,offerStatus); 
		
	}
}
