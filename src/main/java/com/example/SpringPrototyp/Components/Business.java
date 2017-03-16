package com.example.SpringPrototyp.Components;


public class Business {
	private Integer thisYear= 2017;
	
	public Business(){
		
	}

	public Integer SumAPrisWithHantverkare( Typ typ){
		return (typ.getHantverkareInklMoms()+typ.getMaterialInklMoms());
	}

	public Integer SumAPrisWithoutHantverkare( Typ typ){
		return (typ.getMaterialInklMoms());
	}

	public Integer SumTotalKostnadWithHantverkare(int yta, Typ typ){
		return(yta*SumAPrisWithHantverkare(typ));

	}

	public Integer SumTotalKostnadWithoutHantverkare(int yta, Typ typ){
		return(yta*SumAPrisWithoutHantverkare(typ));

	}

	public Integer nextAtgardsAr(Integer lastAtgarsAr, Typ typ){

		if((lastAtgarsAr + typ.getIntervallAr()) < thisYear)
			return (thisYear+1);

		return (lastAtgarsAr + typ.getIntervallAr());
	}

}
