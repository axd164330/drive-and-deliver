package com.driveanddeliver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
/**
 * 
 * @author asdhammu
 *
 */
@Controller
public class HomepageController{
 
   @RequestMapping(value="/",method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Welcome to Drive and Deliver");

      return "index";
   }
   
   @RequestMapping(value="/login", method =RequestMethod.GET)
   public String login(ModelMap model){
	   
	   return "login";
   }
   
   @RequestMapping(value="/accountSummary",method=RequestMethod.GET)
   public String getAccountDetails(ModelMap model){
	   
	   
	   return "account";
   }

}


