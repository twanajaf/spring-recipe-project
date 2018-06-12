package courses.recipe.project.demo.controller;

import courses.recipe.project.demo.model.Recipe;
import courses.recipe.project.demo.model.RecipeFactory;
import courses.recipe.project.demo.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
public class RecipeControllerTest {
    private RecipeController classUnderTest;

    private MockMvc mockMvc;
    @Mock
    private RecipeService recipeService;

    @Before
    public void setUp() {
        classUnderTest = new RecipeController(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(classUnderTest).build();
    }

    @Test
    public void getRecipeById() throws Exception {
        Recipe recipe = RecipeFactory.createRecipe();
        when(recipeService.findById(ArgumentMatchers.anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/show/1"))
               .andExpect(status().isOk())
               .andExpect(view().name("recipe/show"));
    }
}