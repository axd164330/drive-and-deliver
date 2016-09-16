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
@RequestMapping("/")
public class WelcomeController{
 
   @RequestMapping(method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Welcome to Drive and Deliver");

      return "index";
   }

}


