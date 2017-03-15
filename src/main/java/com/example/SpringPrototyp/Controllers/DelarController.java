package com.example.SpringPrototyp.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringPrototyp.Components.BasketItem;
import com.example.SpringPrototyp.Components.Del;
import com.example.SpringPrototyp.Components.DelRepository;



@Controller
@RequestMapping("")
public class DelarController {

	@Autowired
	private DelRepository repository;
	

	@RequestMapping(value="/delar", method = RequestMethod.GET)
	public String listDelar(Model model, HttpSession session){
		model.addAttribute("basketitem", new BasketItem());
		session.setAttribute("delar", repository.findAll());
		
	

		return "/delar";	
	}
	@RequestMapping(value = "/delar/{name}", method = RequestMethod.PUT)
	public @ResponseBody Del updateDel(@PathVariable("name") String name,
			@RequestBody List<String> typNamn){

		Del del = new Del(name, typNamn);
		repository.insert(del);

		return del;

	}

	@RequestMapping(value = "/delar/{delNamn}",method = RequestMethod.GET)
	public String getDelTypes(@PathVariable("delNamn") String delNamn,HttpSession session,Model model){
		model.addAttribute("basketitem", new BasketItem());
		

		if(repository.findByName(delNamn) !=null ){
			model.addAttribute("del", repository.findByName(delNamn));
			session.setAttribute("del", delNamn);
		}

		return "/delar";
	}


	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String addToBasket(@RequestParam("yta") String yta, @RequestParam(value="chbox" , required=false) boolean checkbox,HttpSession session) {

	

			// check if basketitems already in session. if not create empty list and add to session
			if (session.getAttribute("basketitems") == null ) {

				List<BasketItem> basketItems = new ArrayList<BasketItem>();
				session.setAttribute("basketitems", basketItems);
			}

			// create the basket item from the form values
			BasketItem item = new BasketItem();
			item.setChbox(checkbox);
			item.setDelNamn((String)session.getAttribute("del"));
			item.setTypNamn((String)session.getAttribute("typ"));
			item.setYta(yta);
			session.removeAttribute("del");
			session.removeAttribute("typ");
			// item.setTypNamn(typNamn);


			//add the basket item to the list in the session
			List<BasketItem> basketItems = (List<BasketItem>) session.getAttribute("basketitems") ;
			basketItems.add(item);

		
		return "redirect:/delar";
	}


}
