package com.example.SpringPrototyp.Components;

public class Grunddata {
	private String adress;
	private String fastighetsbetckning;
	private Integer byggAr;
	private String husTyp;
	private Integer rum;
	private Integer antalPlaneradeAr;
	
	public Grunddata(){
		
	}
	public Grunddata(String adress, String fastighetsbetckning, Integer byggAr, String husTyp, Integer rum,
			Integer antalPlaneradeAr) {
		super();
		this.adress = adress;
		this.fastighetsbetckning = fastighetsbetckning;
		this.byggAr = byggAr;
		this.husTyp = husTyp;
		this.rum = rum;
		this.antalPlaneradeAr = antalPlaneradeAr;
	}
	
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getFastighetsbetckning() {
		return fastighetsbetckning;
	}
	public void setFastighetsbetckning(String fastighetsbetckning) {
		this.fastighetsbetckning = fastighetsbetckning;
	}
	public Integer getByggAr() {
		return byggAr;
	}
	public void setByggAr(Integer byggAr) {
		this.byggAr = byggAr;
	}
	public String getHusTyp() {
		return husTyp;
	}
	public void setHusTyp(String husTyp) {
		this.husTyp = husTyp;
	}
	public Integer getRum() {
		return rum;
	}
	public void setRum(Integer rum) {
		this.rum = rum;
	}
	public Integer getAntalPlaneradeAr() {
		return antalPlaneradeAr;
	}
	public void setAntalPlaneradeAr(Integer antalPlaneradeAr) {
		this.antalPlaneradeAr = antalPlaneradeAr;
	}
}
