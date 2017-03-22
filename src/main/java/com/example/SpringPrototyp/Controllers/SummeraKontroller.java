package com.example.SpringPrototyp.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.SpringPrototyp.Components.BasketItem;
import com.example.SpringPrototyp.Components.Kostnad;

@RequestMapping("/summera")
@Controller
public class SummeraKontroller {

	private Integer highestYear = 0;
	private Integer thisYear=2017;
	private List<Kostnad> listOfYears;
	private Integer totalKostnad= 0;
private Integer tillskjutetKapital=0;

	@RequestMapping(value="", method = RequestMethod.GET)
	public String summeraKostnad(HttpSession session ){
		@SuppressWarnings("unchecked")
		List<BasketItem> basketItems = (List<BasketItem>) session.getAttribute("basketitems");
		session.removeAttribute("sum");
		listOfYears=null;
		//Finds the highest year
		findHighestYear(basketItems);

		//set up list of all the years
		createList();
		addKostnadPerArTillLista(basketItems);

		session.setAttribute("sum", listOfYears);
		session.setAttribute("tillskjutSum", tillskjutetKapital);
		
		return"/summera";
	}


	private void findHighestYear(List<BasketItem> basketItems) {
		for (BasketItem basketItem : basketItems) {
			if(this.highestYear < basketItem.getPlaneradAtgard()){
				this.highestYear= basketItem.getPlaneradAtgard();
			}
			if(basketItem.getPlaneradAtgard()==(this.thisYear+1)){
				this.tillskjutetKapital= basketItem.getKostnad();
			}
			else{
			this.totalKostnad=basketItem.getKostnad();
			}
		}
	}


	private void createList() {
		for(int i = 2017; i <= highestYear; i++){
			if(listOfYears== null){
				listOfYears=new ArrayList<Kostnad>();
			}
			Kostnad kostnad = new Kostnad(i,0);
			listOfYears.add(kostnad);

		}

	}

	private void addKostnadPerArTillLista(List<BasketItem> basketItems) {
		
			int kostnadPerAr=this.totalKostnad/(this.highestYear-this.thisYear);
			int index= 0;
			for (Kostnad kostnad : listOfYears) {
				listOfYears.get(index).setKostnad(kostnadPerAr);
				index++;
				
			}
		
		

	}

}
