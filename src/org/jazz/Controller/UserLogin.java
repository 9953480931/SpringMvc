package org.jazz.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import orh.jazz.Model.UserLog;

@Controller

public class UserLogin {
	
	
	@RequestMapping(value="/Log" , method=RequestMethod.GET)
	public ModelAndView showform()
	{

	      ModelAndView mv = new ModelAndView("Login");
	      return mv;
	}

	@RequestMapping(value="/success", method=RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute("login1") UserLog login1 , BindingResult result)
	{
		ModelAndView mv = null;
		String uname=login1.getUsername();
		String pwd=login1.getPassword();
		System.out.println(uname+" "+pwd);
		
		if(uname.equals("test")&& pwd.equals("ABC"))
				{
			       mv = new ModelAndView("Success");
			    
			    }
		else
		{
			 System.out.println("USERNAME IS"+login1.getUsername()+" and pass word is : "+login1.getPassword());
			  mv = new ModelAndView("Failed");
		    
			
		}
			
		return mv;
	}
}
