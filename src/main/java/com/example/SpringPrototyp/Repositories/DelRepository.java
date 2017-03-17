package com.example.SpringPrototyp.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.SpringPrototyp.Components.Del;



public interface DelRepository extends MongoRepository<Del,String> {
	public Del findByName(String namn);
}
