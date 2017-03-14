package com.example.SpringPrototyp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.SpringPrototyp.Components.Del;
import com.example.SpringPrototyp.Components.DelRepository;



@Controller
@RequestMapping("/delar")
@SessionAttributes("del")
public class DelarController {
	
	@Autowired
	private DelRepository repository;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String listDelar(Model model){
		model.addAttribute("delar", repository.findAll());
		return "/delar";	
	}
	@RequestMapping(value = "/{name}", method = RequestMethod.PUT)
	public @ResponseBody Del updateDel(@PathVariable("name") String name,
			@RequestBody List<String> typNamn){
		
		Del del = new Del(name, typNamn);
		repository.insert(del);
		
		return del;
		
	}
	
	@RequestMapping(value = "/{delNamn}",method = RequestMethod.GET)
	public String getDelTypes(@PathVariable("delNamn") String delNamn,Model model){
		System.out.println("here");
		
		if(repository.findByName(delNamn)!=null){
		model.addAttribute("del", repository.findByName(delNamn));
		}
		System.out.println(model.containsAttribute("del"));
		
		return "/delar";
	}

}
