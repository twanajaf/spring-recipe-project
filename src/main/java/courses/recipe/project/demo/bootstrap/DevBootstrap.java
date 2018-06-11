package courses.recipe.project.demo.bootstrap;

import courses.recipe.project.demo.model.Category;
import courses.recipe.project.demo.model.Difficulty;
import courses.recipe.project.demo.model.Ingredient;
import courses.recipe.project.demo.model.Notes;
import courses.recipe.project.demo.model.Recipe;
import courses.recipe.project.demo.model.UnitOfMeasure;
import courses.recipe.project.demo.repositories.CategoryRepository;
import courses.recipe.project.demo.repositories.IngredientRepository;
import courses.recipe.project.demo.repositories.RecipeRepository;
import courses.recipe.project.demo.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private static final String TABLESPOON = "Tablespoon";
    private static final String DASH = "dash";
    private static final String EMPTY = "";

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public DevBootstrap(CategoryRepository categoryRepository,
                        UnitOfMeasureRepository unitOfMeasureRepository,
                        RecipeRepository recipeRepository,
                        IngredientRepository ingredientRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Recipe recipe = new Recipe();
        recipe.getIngredients().addAll(createIngredients(recipe));
        int preparationTime = 10;
        recipe.setPreparationTime(preparationTime);
        recipe.setCookTime(0);
        recipe.setDifficulty(Difficulty.EASY);
        recipe.getCategories().add(createCategory("Mexican"));
        recipe.setServings(4);
        recipe.setSource("Simply recipes");
        recipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        String notes = "Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.";
        recipe.setNotes(createNotes(recipe, notes));
        recipe.setDescription("Guacamole recipe");
        recipe.setDirection("go to the website for the direction!");

        recipeRepository.save(recipe);
    }

    private Notes createNotes(Recipe recipe, String notes) {
        Notes newNotes = new Notes();
        newNotes.setRecipe(recipe);
        newNotes.setRecipeNotes(notes);

        return newNotes;
    }

    private List<Ingredient> createIngredients(Recipe recipe) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(createIngredient(recipe, new BigDecimal("2"), "ripe avocados", findUnitOfMeasure(EMPTY)));
        ingredients.add(createIngredient(recipe, new BigDecimal("1.5"), "Kosher salt", findUnitOfMeasure(TABLESPOON)));
        ingredients.add(createIngredient(recipe, new BigDecimal("1"), "of fresh lime juice or lemon juice", findUnitOfMeasure(TABLESPOON)));
        ingredients.add(createIngredient(recipe, new BigDecimal("2"), "cup of minced red onion or thinly sliced green onion", findUnitOfMeasure(TABLESPOON)));
        ingredients.add(createIngredient(recipe, new BigDecimal("2"), "serrano chiles, stems and seeds removed, minced", findUnitOfMeasure(EMPTY)));
        ingredients.add(createIngredient(recipe, new BigDecimal("2"), "cilantro (leaves and tender stems), finely chopped", findUnitOfMeasure(TABLESPOON)));
        ingredients.add(createIngredient(recipe, new BigDecimal("2"), "of freshly grated black pepper", findUnitOfMeasure(DASH)));
        ingredients.add(createIngredient(recipe, new BigDecimal("1.5"), "ripe tomato, seeds and pulp removed, chopped", findUnitOfMeasure(EMPTY)));
        return ingredients;
    }

    private Optional<UnitOfMeasure> findUnitOfMeasure(String unitOfMeasureDescription) {
        return unitOfMeasureRepository.findByDescription(unitOfMeasureDescription);
    }

    private Ingredient createIngredient(Recipe recipe,
                                        BigDecimal amount,
                                        String description,
                                        Optional<UnitOfMeasure> unitOfMeasure) {
        Ingredient ingredient = new Ingredient();
        ingredient.setRecipe(recipe);
        ingredient.setAmount(amount);
        ingredient.setDescription(description);
        ingredient.setUnitOfMeasure(unitOfMeasure.orElse(null));
        return ingredient;
    }

    private Category createCategory(String categoryName) {
        Optional<Category> findByName = categoryRepository.findByName(categoryName);
        return findByName.orElse(null);

    }
}
