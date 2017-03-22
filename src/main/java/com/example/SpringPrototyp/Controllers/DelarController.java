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

import com.example.SpringPrototyp.Components.Typ;
import com.example.SpringPrototyp.Repositories.DelRepository;


@Controller
@RequestMapping("")
public class DelarController {

	private Integer counterID= 0;

	@Autowired
	private DelRepository repository;

	@RequestMapping(value="/delar", method = RequestMethod.GET)
	public String listDelar(Model model, HttpSession session){

		model.addAttribute("basketitem", new BasketItem());
		session.setAttribute("delar", repository.findAll());


		return "/delar";	
	}

	@RequestMapping(value = "/delar/{name}", method = RequestMethod.PUT)
	public @ResponseBody Del addDel(@PathVariable("name") String name,
			@RequestBody List<String> typNamn){

		Del del = new Del(name, typNamn);
		repository.insert(del);

		return del;

	}

	//Deletes basketitem from the list of basketitems in the session. 

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteDel(@PathVariable("id") String id,HttpSession session){

		@SuppressWarnings("unchecked")
		List<BasketItem> basketItems = (List<BasketItem>) session.getAttribute("basketitems");

		for (BasketItem basketItem : basketItems) {
			if(basketItem.getId()==Integer.parseInt(id)){
				basketItems.remove(basketItem);
				session.setAttribute("basketitems", basketItems);
				break;
			}

		}

		return "redirect:/delar";

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

	//Creates a session with a list of all the "basketitems" the user has created.
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String addToBasket(@RequestParam("yta") Integer yta, @RequestParam(value="chbox" , required=false) boolean checkbox,
			@RequestParam("senasteAtgard") Integer senasteAtgard,HttpSession session) {

		// check if basketitems already in session. if not create empty list and add to session
		if (session.getAttribute("basketitems") == null ) {

			List<BasketItem> basketItems = new ArrayList<BasketItem>();
			session.setAttribute("basketitems", basketItems);
		}
		Typ typ= (Typ) session.getAttribute("typInfo");

		// create the basket item from the form values
		BasketItem item = new BasketItem((String)session.getAttribute("del"),typ.getName(),yta,typ);
		item.setSenasteAtgard(senasteAtgard);
		item.setChbox(checkbox);	
		item.setId(counterID);
		session.removeAttribute("del");
		session.removeAttribute("typ");
		counterID++;

		//add the basket item to the list in the session
		@SuppressWarnings("unchecked")
		List<BasketItem> basketItems = (List<BasketItem>) session.getAttribute("basketitems");
		basketItems.add(item);


		return "redirect:/delar";
	}
	
	//Delete from mongo, for future use.
	
	/**@RequestMapping(value = "/delete/{name}", method = RequestMethod.GET)
	public @ResponseBody void deleteDel(@PathVariable("name") String name){
		Del del = repository.findByName(name);
		repository.delete(del.getId());

	}*/

}
