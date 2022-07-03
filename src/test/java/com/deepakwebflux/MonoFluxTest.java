package com.deepakwebflux;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.deepakwebflux.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class MonoFluxTest {
	
	public static List<Customer> customerList;

//	@Test
//	public void testMono() {
//		System.out.println("=================================");
//		Mono<String> myMono1 = Mono.just("javanerd").log();
//		// As soon as we call the subscribe() method, it will immediately start emitting the event
//		myMono1.subscribe(System.out::println);
//		
//		System.out.println("=================================");
//		
////		Mono<?> myMono2 = Mono.just("reactive")
////								   .then(Mono.error(new RuntimeException("Exception occured in Mono")))
////								   .log();
////		myMono2.subscribe(System.out::println, e -> System.out.println(e.getMessage()));
//	}
	
	@Test
	public void testFlux() {
//		System.out.println("=================================");
//		Flux<String> myFlux1 = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservice")
//								  .concatWithValues("AWS")
//								  .log();
//		myFlux1.subscribe(System.out::println);
//		System.out.println("=================================");
//		
//		Flux<String> myFlux2 = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservice")
//								   .concatWithValues("AWS")
//								   .concatWith(Flux.error(new RuntimeException("Exception occured in Flux")))
//								   .concatWithValues("Cloud")
//								   .log();
//		myFlux2.subscribe(System.out::println, e -> System.out.println(e.getMessage()));
//		System.out.println("=================================");
		
		Flux<String> myFlux3 = Flux.just("Hi");
		myFlux3.concatWithValues("Hello!!!");
		myFlux3.subscribe(System.out::println);
		
	}
	
	@BeforeEach
	public void setup() {
		customerList = new ArrayList<>();
		customerList.add(new Customer(1, "AAA"));
		customerList.add(new Customer(2, "BBB"));
		customerList.add(new Customer(3, "CCC"));
		customerList.add(new Customer(4, "DDD"));
		customerList.add(new Customer(5, "EEE"));
		customerList.add(new Customer(6, "FFF"));
	}
	
	@Test
	public void testFlux2() {
		Flux<Customer> customerFlux = Flux.fromIterable(customerList);
		Flux<GroupedFlux<Object, Customer>> c = customerFlux.groupBy(cust -> cust.getId() <= 3);
		c.subscribe(System.out::println);
	} 
}