package courses.recipe.project.demo.services;

import courses.recipe.project.demo.model.Ingredient;
import courses.recipe.project.demo.model.Recipe;
import courses.recipe.project.demo.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceImplTest {
    @Mock
    private RecipeRepository recipeRepository;

    private RecipeServiceImpl classUnderTest;

    @Before
    public void setup() {
        classUnderTest = new RecipeServiceImpl(recipeRepository);
    }
    @Test
    public void findAllRecipes() {
        when(recipeRepository.findAll()).thenReturn(singletonList(new Recipe(1234L,singletonList(new Ingredient(1234L)))));

        List<Recipe> actual = classUnderTest.findAllRecipes();

        assertThat(actual.size(), is(1));
        Recipe recipe = actual.get(0);
        assertThat(recipe.getId(), is(1234L));
        assertThat(recipe.getIngredients().size(), is(1));
        Ingredient ingredient = recipe.getIngredients().get(0);
        assertThat(ingredient.getId(), is(1234L));
    }

}