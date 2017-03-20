package com.example.SpringPrototyp.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringPrototyp.Components.BasketItem;
import com.example.SpringPrototyp.Components.Grunddata;
import com.example.SpringPrototyp.Components.Typ;

@Controller
@RequestMapping("")
public class GrundDataController {
	

	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String getInmatning(Model model){
		model.addAttribute("grunddata",new Grunddata());
		return"/grunddata";
	}

	@RequestMapping(value="/nyGrunddata", method = RequestMethod.GET)
	public String listDelar(@RequestParam("adress") String adress,@RequestParam("byggAr") Integer byggAr,
			@RequestParam("fastighetsbetckning") String fastighetsbetckning,@RequestParam("husTyp") String husTyp,
			@RequestParam("rum") Integer rum, @RequestParam("antalPlaneradeAr") Integer antalPlaneradeAr,Model model, HttpSession session){
		Grunddata grunddata= new Grunddata();
		grunddata.setAdress(adress);
		grunddata.setFastighetsbetckning(fastighetsbetckning);
		grunddata.setByggAr(byggAr);
		grunddata.setHusTyp(husTyp);
		grunddata.setRum(rum);
		grunddata.setAntalPlaneradeAr(antalPlaneradeAr);
		session.setAttribute("grunddata", grunddata);

		return "redirect:/delar";	
	}
}
