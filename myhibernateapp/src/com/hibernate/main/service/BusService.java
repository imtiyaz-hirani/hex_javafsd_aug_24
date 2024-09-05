package com.hibernate.main.service;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.main.dto.BusDto;
import com.hibernate.main.enums.BusTravelDays;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class BusService {

	private EntityManager entityManager;
	private EntityTransaction entityTransaction; 
	
	
	public BusService(EntityManager entityManager, EntityTransaction entityTransaction) {
		this.entityManager = entityManager;
		this.entityTransaction = entityTransaction;
	}


	public List<BusDto> getAllBusesWithRouteInfo() {
		entityTransaction.begin();
		String sql="select b.id,b.busNumber, "
				+ " r.sourceStation,r.destinationStation,r.distance, "
				+ " br.travelDays,br.travelTime,br.ticket "
				+ " from BusRoute br "
				+ " JOIN br.bus b  "
				+ " JOIN br.route r ";
		
		Query query = entityManager.createQuery(sql);
 	 
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.getResultList(); 
		List<BusDto> listDto = new ArrayList<>();
		
		 for(Object[] row : list) {
			 BusDto dto = new BusDto();
			 dto.setId((int)row[0]);
			 dto.setBusNumber((String)row[1]);
			 dto.setSourceStation((String)row[2]);
			 dto.setDestinationStation((String)row[3]);
			 dto.setDistance((int)row[4]);
			 
			 dto.setTravelDays(BusTravelDays.valueOf(row[5].toString()));
			 dto.setTravelTime((String)row[6]);
			 dto.setTicket((Double)row[7]);
			 listDto.add(dto);
		 }
		entityTransaction.commit();
		return listDto;
	}

	
}
