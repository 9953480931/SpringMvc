package org.jazz.Controller;

import org.jazz.Service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import orh.jazz.Model.Person;

@Controller
public class PersonController {
PersonService ps;

public void setPs(PersonService ps) {
	this.ps = ps;
}
@RequestMapping(value="/person")
public String showlist(Model model )
{
	model.addAttribute("person", new Person());
	model.addAttribute("listofPerson", this.ps.showList());
	return "Person";
}
@RequestMapping(value="/delete/{id}")
public String showlist(@PathVariable("id") int id )
{
	this.ps.delete(id);
	return "redirect:/Person";
}
@RequestMapping(value="/add")
public String addPerson(@ModelAttribute("person") Person P)
{
	if(P.getId()==0)
	this.ps.add(P);
	else
	this.ps.update(P);
	return "redirect:/Person";
}

@RequestMapping("/edit/{id}")
public String editPerson(@PathVariable("id") int id, Model model){
    model.addAttribute("person", this.ps.getPersonById(id));
    model.addAttribute("listPersons", this.ps.showList());
    return "person";
}

}
