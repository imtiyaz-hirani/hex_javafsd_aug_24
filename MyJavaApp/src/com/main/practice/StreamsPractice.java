package com.main.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.main.model.Customer;

public class StreamsPractice {
	public static void main(String[] args) {
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