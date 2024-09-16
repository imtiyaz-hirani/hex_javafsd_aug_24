package com.springboot.insurance_app.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.insurance_app.PolicyOfferDto;
import com.springboot.insurance_app.enums.OfferStatus;
import com.springboot.insurance_app.enums.PolicyType;
import com.springboot.insurance_app.enums.VehicleType;
import com.springboot.insurance_app.model.Policy;
import com.springboot.insurance_app.model.PolicyOffer;
 

@Component
public class PolicyUtility implements Policy{

	List<PolicyOffer> list = new ArrayList<>();
	 
	@Override
	public List<PolicyOffer> computePremium(PolicyOffer dto) {
		
		
		if(dto.getVehicleType().equals(VehicleType.CAR)) {
			PolicyOffer dtoCar = new PolicyOffer();
			//do calculation of premium
			dtoCar.setVehicle(dto.getVehicle());
			dtoCar.setActualPrice(dto.getActualPrice());
			dtoCar.setMileage(dto.getMileage());
			dtoCar.setVehicleOwnership(dto.getVehicleOwnership());
			dtoCar.setVehicleType(dto.getVehicleType());
			dtoCar.setYearOfManufacturing(dto.getYearOfManufacturing());
			double premium = 12000; 
			dtoCar.setPremiumAmount(premium);
			dtoCar.setPolicyType(PolicyType.COMPREHENSIVE);
			dtoCar.setOfferStatus(OfferStatus.OFFER_GIVEN);
			list.add(dtoCar);
			
			//for Third Party 
			dtoCar = new PolicyOffer();
			dtoCar.setVehicle(dto.getVehicle());
			dtoCar.setActualPrice(dto.getActualPrice());
			dtoCar.setMileage(dto.getMileage());
			dtoCar.setVehicleOwnership(dto.getVehicleOwnership());
			dtoCar.setVehicleType(dto.getVehicleType());
			dtoCar.setYearOfManufacturing(dto.getYearOfManufacturing());
			premium = 4500; 
			dtoCar.setPremiumAmount(premium);
			dtoCar.setPolicyType(PolicyType.THIRD_PARTY);
			dtoCar.setOfferStatus(OfferStatus.OFFER_GIVEN);
			list.add(dtoCar);
			
		}
		return list;
	}
}
