package courses.recipe.project.demo.controller;

import courses.recipe.project.demo.model.Recipe;
import courses.recipe.project.demo.model.RecipeFactory;
import courses.recipe.project.demo.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RecipeControllerTest {
    private RecipeController recipeController;
    @Mock
    private RecipeService recipeService;
    @Mock
    private Model model;

    @Before
    public void setUp() {
        recipeController = new RecipeController(recipeService);
    }

    @Test
    public void test() {
        List<Recipe> recipes = createRecipes();
        when(recipeService.findAllRecipes()).thenReturn(recipes);
        String indexPage = recipeController.getIndexPage(model);

        assertThat(indexPage, is("index"));
        verify(recipeService).findAllRecipes();
        verify(model).addAttribute("recipes", recipes);
    }

    private List<Recipe> createRecipes() {
        return singletonList(RecipeFactory.createRecipe());
    }
}