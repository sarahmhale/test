package com.example.SpringPrototyp.Components;

public class Kostnad {
	private Integer year;
	private Integer kostnad;
	
	
	public Kostnad() {
	}
	public Kostnad(Integer year, Integer kostnad) {
		this.year = year;
		this.kostnad = kostnad;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getKostnad() {
		return kostnad;
	}
	public void setKostnad(Integer kostnad) {
		this.kostnad = kostnad;
	}

}
