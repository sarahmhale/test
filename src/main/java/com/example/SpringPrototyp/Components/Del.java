package com.example.SpringPrototyp.Components;

import java.util.List;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "del")
public class Del {
	@Id
	private String Id;
	
	private String name;
	private List<String> typNamn;
	public Del(){
		
	}
	
	public Del(String name, List<String> typNamn) {
		super();
		this.name = name;
		this.typNamn = typNamn;
	}
	public String getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getTypNamn() {
		return typNamn;
	}
	public void setTypNamn(List<String> typNamn) {
		this.typNamn = typNamn;
	}

}
	