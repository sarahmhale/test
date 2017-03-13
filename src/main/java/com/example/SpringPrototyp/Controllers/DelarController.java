package com.example.SpringPrototyp.Controllers;

import java.util.List;

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

import com.example.SpringPrototyp.Components.Del;
import com.example.SpringPrototyp.Components.DelRepository;


@Controller
@RequestMapping("/delar")
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
	@ResponseBody
	public HttpEntity<Del> getDelTypes(@PathVariable("delNamn") String delNamn){
		return new ResponseEntity<>(repository.findByName(delNamn), HttpStatus.OK);
	}

}
