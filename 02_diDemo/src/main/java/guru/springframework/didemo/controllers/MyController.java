package guru.springframework.didemo.controllers;

import guru.springframework.didemo.services.GreetingsService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

   private GreetingsService greetingsService;

   public MyController(GreetingsService greetingsService) {
      this.greetingsService = greetingsService;
   }

   public String hello() {
      System.out.println("Hello - my controller!");

      return greetingsService.sayGreeting();
   }
}
