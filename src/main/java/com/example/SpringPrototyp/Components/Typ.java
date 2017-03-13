package com.example.SpringPrototyp.Components;


public class Typ {

	private String name;
	private Integer hantverkareInklMoms;
	private Integer materialInklMoms;
	private String enhet;
	private Integer intervallAr;
	private String kommentar;
	
	public Typ() {
		
	}
	public Typ(String name,Integer hantverkareInklMoms, Integer materialInklMoms, String enhet, Integer intervallAr,
			String kommentar) {
		this.name = name;
		this.hantverkareInklMoms = hantverkareInklMoms;
		this.materialInklMoms = materialInklMoms;
		this.enhet = enhet;
		this.intervallAr = intervallAr;
		this.kommentar = kommentar;
	}
	public Integer getHantverkareInklMoms() {
		return hantverkareInklMoms;
	}
	public void setHantverkareInklMoms(Integer hantverkareInklMoms) {
		this.hantverkareInklMoms = hantverkareInklMoms;
	}
	public Integer getMaterialInklMoms() {
		return materialInklMoms;
	}
	public void setMaterialInklMoms(Integer materialInklMoms) {
		this.materialInklMoms = materialInklMoms;
	}
	public String getEnhet() {
		return enhet;
	}
	public void setEnhet(String enhet) {
		this.enhet = enhet;
	}
	public Integer getIntervallAr() {
		return intervallAr;
	}
	public void setIntervallAr(Integer intervallAr) {
		this.intervallAr = intervallAr;
	}
	public String getKommentar() {
		return kommentar;
	}
	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
