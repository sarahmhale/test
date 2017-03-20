package com.example.SpringPrototyp.Controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.SpringPrototyp.Components.BasketItem;
import com.example.SpringPrototyp.Components.Typ;
import com.example.SpringPrototyp.Repositories.TypRepository;


@Controller

@RequestMapping("/delar/typer")
public class TypController {

	@Autowired
	private TypRepository typRepository;

	@RequestMapping("")
	@ResponseBody
	public String fetchTyper(Model model){
		model.addAttribute("typer", typRepository.findAll());
		return "/delar";

	}
	@RequestMapping( value = "/{typNamn}", method = RequestMethod.GET)
	public String getInfoForTyp(@PathVariable("typNamn") String typNamn, Model model,HttpSession session){
		
		model.addAttribute("basketitem", new BasketItem());
		if(typRepository.findByName(typNamn)!= null){
			model.addAttribute("typer",typRepository.findByName(typNamn));
			session.setAttribute("typInfo", typRepository.findByName(typNamn) );
			session.setAttribute("typ", typNamn );
			
		}
		
		return "/delar";

	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.PUT)
	public @ResponseBody Typ updateTyp(@PathVariable("name") String name,
			@RequestBody Typ typ){

		typRepository.insert(typ);

		return typ;		
	}

}
