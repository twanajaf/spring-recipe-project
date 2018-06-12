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
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceImplTest {
    @Mock
    private RecipeRepository recipeRepository;

    private RecipeServiceImpl classUnderTest;
    private Recipe recipe;

    @Before
    public void setup() {
        classUnderTest = new RecipeServiceImpl(recipeRepository);
        recipe = new Recipe(1234L, singletonList(new Ingredient(1234L, "meant")));
    }
    @Test
    public void findAllRecipes() {
        when(recipeRepository.findAll()).thenReturn(singletonList(recipe));

        List<Recipe> actual = classUnderTest.findAllRecipes();

        assertThat(actual.size(), is(1));
        Recipe actualRecipe = actual.get(0);
        assertThat(actualRecipe.getId(), is(1234L));
        assertThat(actualRecipe.getIngredients().size(), is(1));
        Ingredient ingredient = actualRecipe.getIngredients().get(0);
        assertThat(ingredient.getId(), is(1234L));
    }

    @Test
    public void findById() {
        when(recipeRepository.findById(recipe.getId())).thenReturn(Optional.of(recipe));

        Recipe actual = classUnderTest.findById(recipe.getId());

        assertThat(actual.getId(), is(recipe.getId()));

        verify(recipeRepository).findById(recipe.getId());
    }
}