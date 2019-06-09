package guru.springframework.didemo.controllers;

import guru.springframework.didemo.services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

   private GreetingsService greetingService;

   public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingsService greetingService) {
      this.greetingService = greetingService;
   }

//   @Autowired
//   public ConstructorInjectedController(GreetingsService greetingService) {
//      this.greetingService = greetingService;
//   }

   public String sayHello(){
      return greetingService.sayGreeting();
   }

}
