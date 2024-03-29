package guru.springframework.spring5recipeapp.controllers;

import guru.springframework.spring5recipeapp.domain.Category;
import guru.springframework.spring5recipeapp.domain.UnitOfMeasure;
import guru.springframework.spring5recipeapp.repositories.CategoryRepository;
import guru.springframework.spring5recipeapp.repositories.UnitOfMeasureRepository;
import guru.springframework.spring5recipeapp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

   private final RecipeService recipeService;

   @Autowired
   public IndexController(RecipeService recipeService) {
      this.recipeService = recipeService;
   }

   @RequestMapping({"", "/", "/index"})
   public String getIndexPage(Model model) {

      model.addAttribute("recipes", recipeService.getRecipes());

      return "index";
   }
}
