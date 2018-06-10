package courses.recipe.project.demo.controller;

import courses.recipe.project.demo.services.CategoryService;
import courses.recipe.project.demo.services.RecipeService;
import courses.recipe.project.demo.services.UnitOfMeasureService;
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
    private final CategoryService categoryService;
    private final UnitOfMeasureService unitOfMeasureService;

    @Autowired
    public RecipeController(RecipeService recipeService,
                            CategoryService categoryService,
                            UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.findAllRecipes());

        System.out.println(categoryService.findByName("American"));
        System.out.println(unitOfMeasureService.findByDescription("Teaspoon"));

        return "index";
    }
}
