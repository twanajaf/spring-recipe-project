package courses.recipe.project.demo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RecipeFactory {
    private static final String TABLESPOON = "Tablespoon";
    private static final String DASH = "Dash";

    public static Recipe createRecipe() {
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

        return recipe;
    }

    private static Notes createNotes(Recipe recipe, String notes) {
        Notes newNotes = new Notes();
        newNotes.setRecipe(recipe);
        newNotes.setRecipeNotes(notes);

        return newNotes;
    }

    private static List<Ingredient> createIngredients(Recipe recipe) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(createIngredient(recipe, new BigDecimal("2"), "ripe avocados", createUnitOfMeasure("")));
        ingredients.add(createIngredient(recipe, new BigDecimal("1.5"), "Kosher salt", createUnitOfMeasure(TABLESPOON)));
        ingredients.add(createIngredient(recipe, new BigDecimal("1"), "of fresh lime juice or lemon juice", createUnitOfMeasure(TABLESPOON)));
        ingredients.add(createIngredient(recipe, new BigDecimal("2"), "cup of minced red onion or thinly sliced green onion", createUnitOfMeasure(TABLESPOON)));
        ingredients.add(createIngredient(recipe, new BigDecimal("2"), "serrano chiles, stems and seeds removed, minced", createUnitOfMeasure("")));
        ingredients.add(createIngredient(recipe, new BigDecimal("2"), "cilantro (leaves and tender stems), finely chopped", createUnitOfMeasure(TABLESPOON)));
        ingredients.add(createIngredient(recipe, new BigDecimal("2"), "of freshly grated black pepper", createUnitOfMeasure(DASH)));
        ingredients.add(createIngredient(recipe, new BigDecimal("1.5"), "ripe tomato, seeds and pulp removed, chopped", createUnitOfMeasure("")));
        return ingredients;
    }

    private static UnitOfMeasure createUnitOfMeasure(String unitOfMeasureDescription) {
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription(unitOfMeasureDescription);
        return unitOfMeasure;
    }

    private static Ingredient createIngredient(Recipe recipe,
                                               BigDecimal amount,
                                               String description,
                                               UnitOfMeasure unitOfMeasure) {
        Ingredient ingredient = new Ingredient();
        ingredient.setRecipe(recipe);
        ingredient.setAmount(amount);
        ingredient.setDescription(description);
        ingredient.setUnitOfMeasure(unitOfMeasure);
        return ingredient;
    }

    private static Category createCategory(String categoryName) {
        Category category = new Category();
        
        category.setName(categoryName);
        return category;
    }
}
