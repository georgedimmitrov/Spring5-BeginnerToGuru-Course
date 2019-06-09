package guru.springframework.didemo.controllers;

import guru.springframework.didemo.services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

   @Autowired
   @Qualifier("greetingsServiceImpl")
   public GreetingsService greetingService;

   public String sayHello(){
      return greetingService.sayGreeting();
   }


}
