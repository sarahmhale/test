package com.example.SpringPrototyp.Components;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface TypRepository extends MongoRepository<Typ,String> {
	
	public Typ findByName(String name);
	
}
