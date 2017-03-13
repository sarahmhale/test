package com.example.SpringPrototyp.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringPrototyp.Components.Typ;
import com.example.SpringPrototyp.Components.TypRepository;


@Controller
@RequestMapping("/typer")
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
	public HttpEntity<Typ> getInfoForTyp(@PathVariable("typNamn") String typNamn){
		
		Typ typ = typRepository.findByName(typNamn);
		return new ResponseEntity<>(typ, HttpStatus.OK);
		
	}
	@RequestMapping(value = "/{name}", method = RequestMethod.PUT)
	public @ResponseBody Typ updateTyp(@PathVariable("name") String name,
			@RequestBody Typ typ){

		typRepository.insert(typ);
		
		return typ;		
	}
	
}
