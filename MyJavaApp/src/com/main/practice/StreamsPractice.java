package com.main.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import com.main.model.Customer;
import com.main.model.Product;

public class StreamsPractice {
	public static void main(String[] args) {
		Product p1 = new Product(1,"apple",200,10,5);
		Product p2 = new Product(2,"oppo",150,8,2);
		Product p3 = new Product(3,"nokia",100,12,3);
		
		List<Product> list = Arrays.asList(p1,p2,p3); 
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		//map.put(3, 1);
		
		/* Filter product list that has only those products whose id is in the map */
		//create a list having only product IDs using map operation of stream
		
		List<Integer> listIds = list.stream().map(p->p.getId()).toList();
		System.out.println(listIds);
		
		System.out.println(map.keySet());
		List<Integer> filteredIds = new ArrayList<>();
		
		for(int id : map.keySet()) {
			if(listIds.contains(id)) {
				filteredIds.add(id);
			}
		}
		System.out.println(filteredIds);
		
		filteredIds.stream().forEach(i->{
			
		});
		
		
	}
	public static  void task() {
		List<Integer> list = Arrays.asList(2,1,5,9,3,7,4); 
		//filter the list to keep only element 9 in it 
		
		System.out.println("Unfiltered List " + list);
		Stream<Integer> stream = list.stream().filter(e-> e%2 == 1); //Discarded:  1 5 9 3
		stream.forEach(e-> System.out.println(e));
		
		Customer c1 = new Customer(1,"harry", "767676" , null); 
		Customer c2 = new Customer(2,"ronald", "121212" , null); 
		
		List<Customer> cList = Arrays.asList(c1,c2);
		System.out.println(cList);
		int id = 1; 
		
		Stream<Customer> cstream = cList.stream().filter(c-> c.getId() == id);
		Optional<Customer> optional =  cstream.findFirst(); 
		if(optional.isEmpty()) {
			System.out.println("Invalid id");
		}
		else {
			Customer cObj = optional.get();
			System.out.println(cObj.getName());
		}
	}
}
//stays: 2 4