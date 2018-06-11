package courses.recipe.project.demo.controller;

import courses.recipe.project.demo.model.Recipe;
import courses.recipe.project.demo.model.RecipeFactory;
import courses.recipe.project.demo.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
public class RecipeControllerTest {
    private RecipeController classUnderTest;
    @Mock
    private RecipeService recipeService;
    @Mock
    private Model model;

    @Before
    public void setUp() {
        classUnderTest = new RecipeController(recipeService);
    }

    @Test
    public void getIndexPage() {
        List<Recipe> recipes = createRecipes();
        when(recipeService.findAllRecipes()).thenReturn(recipes);

        String indexPage = classUnderTest.getIndexPage(model);

        assertThat(indexPage, is("index"));
        verify(recipeService).findAllRecipes();
        verify(model).addAttribute("recipes", recipes);
    }

    @Test
    public void getIndexPage_mockMvc() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(classUnderTest).build();

        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(view().name("index"));
    }

    private List<Recipe> createRecipes() {
        return singletonList(RecipeFactory.createRecipe());
    }
}