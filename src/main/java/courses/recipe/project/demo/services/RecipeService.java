package courses.recipe.project.demo.services;

import courses.recipe.project.demo.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> findAllRecipes();

    Recipe findById(Long id);
}
