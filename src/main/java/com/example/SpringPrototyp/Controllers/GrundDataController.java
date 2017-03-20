package com.example.SpringPrototyp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class GrundDataController {
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String getInmatning(){
		return"/grunddata";
	}


}
