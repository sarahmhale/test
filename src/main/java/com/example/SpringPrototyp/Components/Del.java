	package com.example.SpringPrototyp.Components;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "del")
public class Del {
	
	private String name;
	private List<String> typNamn;
	
	
	public Del(){
		}
	
	public Del(String name, List<String> typNamn) {
		this.name = name;
		this.typNamn = typNamn;
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
	