package guru.springframework.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingsServiceImpl implements GreetingsService {

   public static final String HELLO_GURUS = "Hello Gurus - Original GreetingsServiceImpl.";

   @Override
   public String sayGreeting() {
      return HELLO_GURUS;
   }

}
