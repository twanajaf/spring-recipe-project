package courses.recipe.project.demo.controller;

import courses.recipe.project.demo.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class is used to retrieve a recipe
 */
@Controller
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(path = "/recipes")
    public String getRecipes(Model model) {
        model.addAttribute("recipes", recipeService.findAllRecipes());

        return "recipes";
    }
}
