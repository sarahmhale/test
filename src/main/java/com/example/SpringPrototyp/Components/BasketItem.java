package com.example.SpringPrototyp.Components;

public class BasketItem {
	private Integer id;
	String delNamn;
    String typNamn;
    Integer yta;
    Boolean chbox = false;
    Typ typ;
    Integer aPris;
    Integer kostnad;
    Business business = new Business();
    
    public Integer getId() {
 		return id;
 	}

 	public void setId(Integer id) {
 		this.id = id;
 	}
    
    public BasketItem(){
    	
    }
    
    public BasketItem(String delNamn, String typNamn, Integer yta,  Typ typ ) {

		this.delNamn = delNamn;
		this.typNamn = typNamn;
		this.yta = yta;
		this.typ = typ;

	}

    public Integer getApris(){
    	
    	if(this.chbox){
    		this.aPris= business.SumAPrisWithHantverkare(typ);
    	}
    	else{
    		this.aPris = business.SumAPrisWithoutHantverkare(typ);
    	}
    	return this.aPris;
    }
    
    public Integer getKostnad(){
    	if(this.chbox){
    	this.kostnad=this.business.SumTotalKostnadWithHantverkare(yta, typ);
    	}
    	else{
    		this.kostnad=this.business.SumTotalKostnadWithoutHantverkare(yta, typ);
    	}
    	return this.kostnad;
    }
    public Typ getTyp() {
		return typ;
	}
	public void setTyp(Typ typ) {
		this.typ = typ;
	}
	public Boolean getChbox() {
		return chbox;
	}
	public void setChbox(Boolean chbox) {
		this.chbox = chbox;
	}
	public Integer getYta() {
		return yta;
	}
	public void setYta(Integer yta) {
		this.yta = yta;
	}
	Boolean checkbox;
    
    public String getDelNamn() {
        return delNamn;
    }
    public void setDelNamn(String delNamn) {
        this.delNamn = delNamn;
    }
    public String getTypNamn() {
        return typNamn;
    }
    public void setTypNamn(String typNamn) {
        this.typNamn = typNamn;
    }
    public Boolean getCheckbox() {
        return checkbox;
    }
    public void setCheckbox(Boolean checkbox) {
        this.checkbox = checkbox;
    }
    

}
