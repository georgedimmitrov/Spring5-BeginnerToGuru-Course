package guru.springframework.spring5recipeapp.bootstrap;

import guru.springframework.spring5recipeapp.domain.Category;
import guru.springframework.spring5recipeapp.domain.Difficulty;
import guru.springframework.spring5recipeapp.domain.Ingredient;
import guru.springframework.spring5recipeapp.domain.Notes;
import guru.springframework.spring5recipeapp.domain.Recipe;
import guru.springframework.spring5recipeapp.domain.UnitOfMeasure;
import guru.springframework.spring5recipeapp.repositories.CategoryRepository;
import guru.springframework.spring5recipeapp.repositories.RecipeRepository;
import guru.springframework.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

   private final CategoryRepository categoryRepository;
   private final RecipeRepository recipeRepository;
   private final UnitOfMeasureRepository unitOfMeasureRepository;

   @Autowired
   public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
      this.categoryRepository = categoryRepository;
      this.recipeRepository = recipeRepository;
      this.unitOfMeasureRepository = unitOfMeasureRepository;
   }

   @Override
   public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
      recipeRepository.saveAll(getRecipes());
   }

   private List<Recipe> getRecipes() {
      List<Recipe> recipes = new ArrayList<>(2);

      Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

      if (!eachUomOptional.isPresent()) {
         throw new RuntimeException("Expected UOM Not Found");
      }

      Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

      if (!tablespoonUomOptional.isPresent()) {
         throw new RuntimeException("Expected UOM Not Found");
      }

      Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

      if (!teaspoonUomOptional.isPresent()) {
         throw new RuntimeException("Expected UOM Not Found");
      }

      Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

      if (!dashUomOptional.isPresent()) {
         throw new RuntimeException("Expected UOM Not Found");
      }

      Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

      if (!pintUomOptional.isPresent()) {
         throw new RuntimeException("Expected UOM Not Found");
      }

      Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");

      if (!cupsUomOptional.isPresent()) {
         throw new RuntimeException("Expected UOM Not Found");
      }

      UnitOfMeasure eachUom = eachUomOptional.get();
      UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
      UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();
      UnitOfMeasure dashUom = dashUomOptional.get();
      UnitOfMeasure pintUom = pintUomOptional.get();
      UnitOfMeasure cupsUom = cupsUomOptional.get();

      Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

      if (!americanCategoryOptional.isPresent()) {
         throw new RuntimeException("Expected Category not found");
      }

      Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

      if (!mexicanCategoryOptional.isPresent()) {
         throw new RuntimeException("Expected Category not found");
      }

      Category americanCategory = americanCategoryOptional.get();
      Category mexicanCategory = mexicanCategoryOptional.get();


      // Guac Recipe
      Recipe guacRecipe = new Recipe();
      guacRecipe.setDescription("Perfect Guacamole");
      guacRecipe.setPrepTime(10);
      guacRecipe.setCookTime(0);
      guacRecipe.setDifficulty(Difficulty.EASY);
      guacRecipe.setDescription("Cut Avocado... lorem ipsum");
      Notes guacNotes = new Notes();
      guacNotes.setRecipeNotes("Some notes");
      guacRecipe.setNotes(guacNotes);

      guacRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), eachUom));
      guacRecipe.getIngredients().add(new Ingredient("kosher salt", new BigDecimal(.5), teaspoonUom));
      guacRecipe.getIngredients().add(new Ingredient("lime juice", new BigDecimal(2), tablespoonUom));

      guacRecipe.getCategories().add(americanCategory);
      guacRecipe.getCategories().add(mexicanCategory);

      recipes.add(guacRecipe);


      // Taco Recipe
      Recipe tacosRecipe = new Recipe();
      tacosRecipe.setDescription("Perfect Taco");
      tacosRecipe.setPrepTime(20);
      tacosRecipe.setCookTime(9);
      tacosRecipe.setDifficulty(Difficulty.MODERATE);
      tacosRecipe.setDescription("Prepare grill for medium-high... lorem ipsum");
      Notes tacoNotes = new Notes();
      tacoNotes.setRecipeNotes("Some notes again");
      tacoNotes.setRecipe(tacosRecipe);
      tacosRecipe.setNotes(tacoNotes);

      tacosRecipe.getIngredients().add(new Ingredient("Chili Powder", new BigDecimal(2), tablespoonUom, tacosRecipe));
      tacosRecipe.getIngredients().add(new Ingredient("Tortillas", new BigDecimal(8), eachUom, tacosRecipe));
      tacosRecipe.getIngredients().add(new Ingredient("Garlic", new BigDecimal(1), eachUom, tacosRecipe));

      tacosRecipe.getCategories().add(americanCategory);
      tacosRecipe.getCategories().add(mexicanCategory);

      recipes.add(tacosRecipe);

      return recipes;
   }
}
