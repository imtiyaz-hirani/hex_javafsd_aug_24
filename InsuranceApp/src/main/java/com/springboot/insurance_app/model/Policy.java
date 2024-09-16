package com.springboot.insurance_app.model;

import java.util.List;

import com.springboot.insurance_app.PolicyOfferDto;
 

public interface Policy {
	public List<PolicyOffer> computePremium(PolicyOffer offer);	
}

/*
 * POlicy:
 * Type: COMPREHENSIVE 
 * PREMIUM/annum: ___
 * 
 * Type: Third PArty
 * PREMIUM/annum: ___
 * 
 */