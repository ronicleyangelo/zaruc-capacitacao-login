package com.example.demo;

import com.example.demo.core.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//
//		List <User> users = new ArrayList<>();
//
//		users.add(new User("Ronicley","Angelo"));
//		users.add(new User("Amanda", "loyola"));
//		users.add(new User("Sofia", "Alaska"));
//		users.stream()
//				.sorted(Comparator.comparing(User::getNome))
//				.forEach(System.out::println);
//		System.out.println("-----------------------------------------");
//		users.stream().filter(x -> x.getNome().toLowerCase().contains("o"))
//				.collect(Collectors.toList())
//				.forEach(System.out::println);
//		System.out.println("-----------------------------------------");
//
//		users.stream().map(x -> x.getLogin())
	}

}
