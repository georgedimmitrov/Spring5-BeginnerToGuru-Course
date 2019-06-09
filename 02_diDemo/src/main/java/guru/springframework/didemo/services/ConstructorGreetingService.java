package guru.springframework.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingService implements GreetingsService {

   @Override
   public String sayGreeting() {
      return "Hello - I was injected via the constructor.";
   }
}
