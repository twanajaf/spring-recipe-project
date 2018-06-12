package courses.recipe.project.demo.converters;

import courses.recipe.project.demo.commands.CategoryCommand;
import courses.recipe.project.demo.commands.IngredientCommand;
import courses.recipe.project.demo.commands.RecipeCommand;
import courses.recipe.project.demo.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeToRecipeCommandConverter {
    private CategoryToCategoryCommandConverter categoryToCategoryCommandConverter = new CategoryToCategoryCommandConverter();
    private NotesToNotesCommandConverter notesToNotesCommandConverter = new NotesToNotesCommandConverter();
    private IngredientToIngredientCommandConverter ingredientToIngredientCommandConverter = new IngredientToIngredientCommandConverter();

    public RecipeCommand convert(Recipe recipe) {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setCookTime(recipe.getCookTime());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setDifficulty(recipe.getDifficulty());
        recipeCommand.setDirection(recipe.getDirection());
        recipeCommand.setId(recipe.getId());
        recipeCommand.setImage(recipe.getImage());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setPreparationTime(recipe.getPreparationTime());
        recipeCommand.setSource(recipe.getSource());
        recipeCommand.setUrl(recipe.getUrl());
        recipeCommand.setNotes(notesToNotesCommandConverter.convert(recipe.getNotes()));

        recipeCommand.getCategories().addAll(getCategories(recipe));
        recipeCommand.getIngredients().addAll(getIngredients(recipe));

        return recipeCommand;
    }

    private List<IngredientCommand> getIngredients(Recipe recipe) {
        List<IngredientCommand> ingredientCommands = new ArrayList<>();

        recipe.getIngredients().forEach(ingredient -> ingredientCommands.add(ingredientToIngredientCommandConverter.convert(ingredient)));

        return ingredientCommands;
    }

    private List<CategoryCommand> getCategories(Recipe recipe) {
        List<CategoryCommand> categoryCommands = new ArrayList<>();
        recipe.getCategories().forEach(category -> categoryCommands.add(categoryToCategoryCommandConverter.convert(category)));

        return categoryCommands;
    }
}
