package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	 
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	// Tudo que estiver dentro dessa método será iniciado quando a aplicaçao for iniciada
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		Order o1 = new Order(null, Instant.parse("2024-01-12T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2024-01-12T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2024-01-12T15:21:22Z"), u1);
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));

	}
	
	
}
