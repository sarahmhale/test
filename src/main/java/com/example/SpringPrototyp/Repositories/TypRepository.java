package com.example.SpringPrototyp.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.SpringPrototyp.Components.Typ;


public interface TypRepository extends MongoRepository<Typ,String> {
	
	public Typ findByName(String name);
	
}
