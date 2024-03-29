package guru.springframework.spring5recipeapp.services;

import guru.springframework.spring5recipeapp.domain.Recipe;
import guru.springframework.spring5recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

   private final RecipeRepository recipeRepository;

   @Autowired
   public RecipeServiceImpl(RecipeRepository recipeRepository) {
      this.recipeRepository = recipeRepository;
   }

   @Override
   public Set<Recipe> getRecipes() {
      log.debug("Service Impl Log Debug");

      Set<Recipe> recipeSet = new HashSet<>();
      recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
      return recipeSet;
   }
}
